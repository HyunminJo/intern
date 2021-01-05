package kr.co.crewmate.ojt.model.nepa;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UsersExcelExporter {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private List<Users> listUsers;
    private String[] firstRow = {"user_no", "user_id", "user_pw", "user_group", "cus_cd", "black_consumer_yn", "user_stat",
            "last_login_dt", "last_pw_change_dt", "withdraw_desc", "memo", "hp", "reg_dt", "withdraw_dt", "mod_no", "mod_dt", "sms_yn",
            "mail_yn", "add_info_yn", "marketing_yn", "user_nm", "black_consumer_type", "refund_nm", "refund_vact_bankcode",
            "refund_num", "user_pw_init_yn", "update_type", "black_consumer_desc", "m_no_npc", "m_no_ibk", "wedding_yn", "wedding_dt",
            "mail_addr", "birth_dt", "solar_yn", "sex"};

    public UsersExcelExporter(List<Users> listUsers) {
        this.listUsers = listUsers;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Users");
    }

    private void writeHeaderRow() {
        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(10);
        style.setFont(font);
        
        Cell cell = null;
        for(int i = 0; i < firstRow.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(firstRow[i]);
            cell.setCellStyle(style);
        }

    }

    private void writeDataRows() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(8);
        style.setFont(font);

        for (Users user : listUsers) {
            Row row = sheet.createRow(rowCount++);

            Cell cell = row.createCell(0);
            cell.setCellValue(user.getUserId());
            sheet.autoSizeColumn(0);
            cell.setCellStyle(style);
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderRow();
        writeDataRows();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
