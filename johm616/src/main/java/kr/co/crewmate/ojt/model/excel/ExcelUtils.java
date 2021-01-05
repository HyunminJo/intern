package kr.co.crewmate.ojt.model.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    private Sheet sheet;
    private int rowIndex = 0;
    private int maxCols = 0;
    private Workbook workbook;
    private int offsetCol = 0;
    
    /**
     * 생성자
     * @param sheetName 시트명
     */
    public ExcelUtils(String sheetName) {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet(sheetName);
    }
    
    /**
     * 생성자
     * @param sheetName 시트명
     * @param rowAccessWindowSize flushRows단위
     *        * 해당 값이 NULL일경우 XSSF를 , 없을 경우 SXSSF 대용량 라이브러리를 사용
     *        * XSSF : 엑셀 2007부터 지원하는 OOXML 파일 포맷인 *.xlsx 파일을 읽고 쓰는 컴포넌트(데이터를 메모리에 담아서 한번에 처리) => 메모리 부족현상 발생
     *        * SXSSF : SXSSF는 자동으로 메모리에 일정량의 데이터가 차면 메모리를 비워줌. *.xlsx 파일 생성
     */ 
    public ExcelUtils(String sheetName, Integer rowAccessWindowSize) {
        if(rowAccessWindowSize != null) {
            workbook = new SXSSFWorkbook(rowAccessWindowSize); // row 단위 flush
            sheet = workbook.createSheet(sheetName);
        } else {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet(sheetName);
        }
    }
    
    /**
     * 엑셀의 시작점을 설정한다.
     * @param col 엑셀시작컬럼위치
     * @param row 엑셀시작로우위치
     */
    public void setOffset(int col, int row) {
        offsetCol = col;
        rowIndex = row;
    }
    
    /**
     * 엑셀에 ROW를 추가한다.
     * @param rows 엑셀에 보여줄 ROW데이터
     */
    public <T> void addRow(List<T> rows) {
        Row header = sheet.createRow(rowIndex++);
        int cellIndex = offsetCol;
        for(T value : rows) {
            Cell cell = header.createCell(cellIndex++);
            cell.setCellValue(String.valueOf(value));
        }
        if(maxCols < cellIndex) {
            maxCols = cellIndex;
        }
    }
    
    /**
     * 3일이 지난 엑셀파일을 삭제한다.
     * @param rows 엑셀에 보여줄 ROW데이터
     */
    public void deleteExcel(String filePath) {
        // Calendear 객체 생성
        Calendar cal = Calendar.getInstance();
        long today = cal.getTimeInMillis(); // 현재 날짜
        long oneDay = 24*60*60*1000; // 일 단위
        
        Calendar fileCal = Calendar.getInstance();
        Date file = null;
        
        File path = new File(filePath);
        File[] list = path.listFiles();
        
        if(list != null) {
            for(int i = 0; i < list.length; i++) {
                // 파일의 마지막 수정시간 가져오기
                Date fileDate = new Date(list[i].lastModified());
                
                // 시간차 계산
                fileCal.setTime(fileDate);
                long diffMil = today - fileCal.getTimeInMillis();
                
                // 날짜로 계산
                int diffDay = (int)(diffMil/oneDay);
                
                // 1일이 지나면 파일 삭제
                if(diffDay >= 1 && list[i].exists()) {
                    list[i].delete();
                }
            }
        }
    }
    
    /**
     * 엑셀에 ROW를 추가한다.
     * @param rsExcel 외부에서 생성한 ExcelUtils 객체
     * @param header  헤더에 보여줄 ROW 데이터 
     * @param list    본문에 보여줄 ROW데이터
     * @param fileName EXCEL에 포함시킬 FILENAME
     * @throws IOException 
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    public String write(ExcelUtils rsExcel, List<?> header, List<?> list, String fileName, String url) throws IOException, IllegalArgumentException, IllegalAccessException {
        
        // 파일명 설정
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String current = dateFormat.format(new Date());
        String fName = fileName + "_" + current + ".xlsx";
        String tempName = "../resources/static/excel/";
        String filePath = url + tempName;
        
        // 3일 이전의 excel 파일 삭제
        deleteExcel(filePath);
        
        // 엑셀 시작점 설정
        rsExcel.setOffset(0, 0);
        
        // 엑셀 헤더 추가
        rsExcel.addRow(header);
        
        SXSSFSheet st = null;
        //sheet = workbook.createSheet("sheet1");
        // List<특정Object> 형태를 List<String> 형태로 변환한 뒤 데이터를 그린다.
        for(int i = 0; i < list.size(); i++) {
//            rsExcel.addRow(converObjectToStringList((List<?>) list.get(i)));
//            int edIdx = 0;
//            for (Field field : list.getClass().getDeclaredFields()) {
//                field.setAccessible(true);
//                Object value = field.get(list);
//                if(value != null) {
//                    row.createCell(edIdx).setCellValue(value.toString());
//                }            
//                edIdx++;
//            }
            SXSSFRow row = (SXSSFRow) sheet.createRow(sheet.getLastRowNum() + 1);
            row = setRowData(row, list.get(i), 0);
        }
        
        // 실제 파일로 생성
        FileOutputStream fos = new FileOutputStream(filePath + fName);
        this.sheet.getWorkbook().write(fos);
        if (this.workbook instanceof SXSSFWorkbook) {
            ((SXSSFWorkbook) this.workbook).dispose();
        }
        this.workbook.close();
        
        return fName;
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
    
    private List<?> converObjectToStringList(List<?> list) {
        List<String> stList = new ArrayList<>(list.size());
        for (Object object : list) {
            stList.add(Objects.toString(object, null));
        }
        return stList;
    }
}
