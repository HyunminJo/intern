package kr.co.crewmate.ojt.model.excel;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import kr.co.crewmate.ojt.model.nepa.Users;

public class ExportExcelVOList {

    private HttpServletRequest req;
    private HttpServletResponse res;
    protected SXSSFSheet[] sheetArray;
    protected SXSSFSheet sheet;
    protected SXSSFWorkbook wb;
    protected DownloadExcel downloadExcel;
    protected String colN[];
    private List<Users> listUsers;
    private String[] firstRow = {"user_no", "user_id", "user_pw", "user_group", "cus_cd", "black_consumer_yn", "user_stat",
            "last_login_dt", "last_pw_change_dt", "withdraw_desc", "memo", "hp", "reg_dt", "withdraw_dt", "mod_no", "mod_dt", "sms_yn",
            "mail_yn", "add_info_yn", "marketing_yn", "user_nm", "black_consumer_type", "refund_nm", "refund_vact_bankcode",
            "refund_num", "user_pw_init_yn", "update_type", "black_consumer_desc", "m_no_npc", "m_no_ibk", "wedding_yn", "wedding_dt",
            "mail_addr", "birth_dt", "solar_yn", "sex"};
    protected CellStyle headStyle;
    protected CellStyle bodyStyle;

    public ExportExcelVOList(HttpServletRequest request, HttpServletResponse response) {
        super();
        this.req = request;
        this.res = response;
        this.sheetArray = new SXSSFSheet[1];
        this.wb = new SXSSFWorkbook();
        //this.colN = request.getParameter("colN[]").split(",");
        this.setExcelFormat();
    }

    public void setSheetArray(int index, SXSSFSheet st) {
        sheetArray[index] = st;
    }

    public void actionDownloadExcel() {
        downloadExcel.writeExcel();
    }

    private void setExcelFormat() {
        DateFormat dateFormatter = new SimpleDateFormat("yyyyMMddhhmmss");
        String currentDate = dateFormatter.format(new Date());
        this.downloadExcel = new DownloadExcel(currentDate + ".xlsx", req, res, wb);
        this.headStyle = downloadExcel.headStyle();
        this.bodyStyle = downloadExcel.bodyStyle();
    }

    private void setColumnStyle(SXSSFSheet st, SXSSFRow title, int width, int addIdx) {
        for (int i = 0; i < firstRow.length; i++) {
            title.createCell(i + addIdx).setCellValue(firstRow[i + addIdx]);
            title.getCell(i + addIdx).setCellStyle(headStyle);
            st.setColumnWidth(i + addIdx, width);
        }
    }

    public SXSSFSheet setDataToExcelList(List<Users> data, String sheetName) {
        SXSSFSheet st = null;
        try {
            st = wb.createSheet(sheetName);
            SXSSFRow titleRow = st.createRow(0);
            titleRow.setHeight((short) 400);
            setColumnStyle(st, titleRow, 6000, 0); // colN을 이용한 컬럼명 처리
            for (int i = 0; i < data.size(); i++) {
                SXSSFRow row = st.createRow(st.getLastRowNum() + 1);
                row = setRowData(row, data.get(i), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }

    private SXSSFRow setRowData(SXSSFRow row, Object data, int stIdx)
            throws IllegalArgumentException, IllegalAccessException {
        int edIdx = 0;
        for (Field field : data.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(data);
            if(value != null) {
                row.createCell(stIdx + edIdx).setCellValue(value.toString());
            }            
            edIdx++;
        }
//        for (int i = 0; i < edIdx; i++) {
//            row.getCell(stIdx + i).setCellStyle(bodyStyle);
//        }
        return row;
    }

}
