package kr.co.crewmate.ojt.web.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import freemarker.template.utility.StringUtil;
import kr.co.crewmate.ojt.model.excel.ExcelUtils;
import kr.co.crewmate.ojt.model.excel.ExportExcelVOList;
import kr.co.crewmate.ojt.model.nepa.Users;
import kr.co.crewmate.ojt.model.nepa.UsersExcelExporter;
import kr.co.crewmate.ojt.service.nepa.JoinService;

@Controller
public class PoiExerciseController {

    @Autowired
    private JoinService joinService;
    private SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/sample/poiExercise")
    public String getPoiForm() {
        return "/sample/poiExercise";
    }

    @RequestMapping("/sample/exportExcel1")
    public void exportExcel1(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDate = dateFormatter.format(new Date());
        String fileName = "users_" + currentDate + ".xlsx";
        String headerValue = "attachement; filename=" + fileName;

        response.setHeader(headerKey, headerValue);

        List<Users> listUsers = joinService.selectUsersList();

        UsersExcelExporter excelExporter = new UsersExcelExporter(listUsers);
        excelExporter.export(response);
    }

    @RequestMapping("/sample/exportExcel2")
    public void exportExcel2(HttpServletRequest req, HttpServletResponse res) {

        // 파라메터로 받아온 key 값 (조회 조건)
        // String key = req.getParameter("key").replaceAll("&quot;", "");

        try {
            // DB에 key 값에 일치하는 데이터 리스트 조회
            List<Users> list = joinService.selectUsersList();

            // 생성자함수로 생성 후 초기 세팅
            ExportExcelVOList exl = new ExportExcelVOList(req, res);

            // 파라메터 : 조회한 리스트. 시트명
            SXSSFSheet st = exl.setDataToExcelList(list, "sheet1");
            exl.setSheetArray(0, st);
            exl.actionDownloadExcel();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/sample/exportExcel3")
    public void exportExcel3(HttpServletResponse response) {
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = null;
        // 메모리에 100개의 행을 유지합니다. 행의 수가 넘으면 디스크에 적습니다.
        SXSSFWorkbook wb = new SXSSFWorkbook(100);
        Sheet sheet = wb.createSheet();

        try {
            System.out.println("1");
            sqlSession.select("selectUsersList", new ResultHandler<Users>() {

                @Override
                public void handleResult(ResultContext<? extends Users> context) {
                    System.out.println("2");
                    Users user = context.getResultObject();
                    Row row = sheet.createRow(context.getResultCount() - 1);
                    Cell cell = null;
                    cell = row.createCell(0);
                    cell.setCellValue(user.getUserNo());
                    cell = row.createCell(1);
                    cell.setCellValue(user.getUserId());
                    cell = row.createCell(2);
                    cell.setCellValue(user.getUserPw());
                    System.out.println("3");
                }
            });
            System.out.println("4");
            response.setHeader("Set-Cookie", "fileDownload=true; path=/");
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"test.xlsx\""));
            System.out.println("5");
            wb.write(response.getOutputStream());
            
        } catch (Exception e) {
            System.out.println("6");
            response.setHeader("Set-Cookie", "fileDownload=false; path=/");
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Content-Type", "text/html; charset=utf-8");
            
            OutputStream out = null;
            
            try {
                System.out.println("7");
                out = response.getOutputStream();
                byte[] data = new String("fail..").getBytes();
                out.write(data, 0, data.length);
            } catch (IOException ignore) {
                System.out.println("8");
                ignore.printStackTrace();
            }finally {
                System.out.println("9");
                if(out != null) {
                    try {
                        out.close();
                    } catch(Exception ignore) {
                        
                    }
                }
            }
        } finally {
            System.out.println("10");
            if(sqlSession != null) {
                System.out.println("11");
                sqlSession.close();
            }
            
            // 디스크 적었던 임시파일을 제거합니다.
            wb.dispose();
            try {
                System.out.println("12");
                wb.close();
            } catch(Exception e) {
            }
        }
    }
    
    @RequestMapping("/sample/exportExcel4")
    public void exportExcel1(HttpServletRequest req, Users user) throws IllegalArgumentException, IllegalAccessException {
        //ErrorInfo = errInfo = new ErrorInfo();
        ExcelUtils excel = new ExcelUtils("Excel download", 100);
        
        // 헤더 지정 (domain의 getter/setter 순서)
        List<String> header = Arrays.asList("user_no", "user_id", "user_pw", "user_group", "cus_cd", "black_consumer_yn", "user_stat",
                "last_login_dt", "last_pw_change_dt", "withdraw_desc", "memo", "hp", "reg_dt", "withdraw_dt", "mod_no", "mod_dt", "sms_yn",
                "mail_yn", "add_info_yn", "marketing_yn", "user_nm", "black_consumer_type", "refund_nm", "refund_vact_bankcode",
                "refund_num", "user_pw_init_yn", "update_type", "black_consumer_desc", "m_no_npc", "m_no_ibk", "wedding_yn", "wedding_dt",
                "mail_addr", "birth_dt", "solar_yn", "sex");
        
        // 유저 조회
        List<Users> list = joinService.selectUsersList();
        
        // 로컬테스트시 아래 path를 로컬경로로 수정
        String filePath = StringUtil.replace(req.getSession().getServletContext().getRealPath("/"), "ROOT", "");
        try {
            String returnfileName = excel.write(excel, header, list, "users", filePath);
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
