package kr.co.crewmate.ojt.model.excel;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.crewmate.ojt.web.controller.SampleController;

public class DownloadExcel {
    private static final Logger log = LoggerFactory.getLogger(SampleController.class);
    private HttpServletResponse response;
    private SXSSFWorkbook wb;

    public DownloadExcel(String filename, HttpServletRequest request, HttpServletResponse response, SXSSFWorkbook wb) {
        this.response = response;
        this.wb = wb;
//        String browser = ""; // 브라우저 확인하는 메서드
//        String encodedFilename = null;
//            if (browser.equals("MSIE")) {
//                encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
//            } else if (browser.equals("Firefox")) {
//                encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
//            } else if (browser.equals("Opera")) {
//                encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
//            } else if (browser.equals("Chrome")) {
//                StringBuffer sb = new StringBuffer();
//                for (int i = 0; i < filename.length(); i++) {
//                    char c = filename.charAt(i);
//                    if (c > '~') {
//                        sb.append(URLEncoder.encode("" + c, "UTF-8"));
//                    } else {
//                        sb.append(c);
//                    }
//                }
//                encodedFilename = sb.toString();
//            } else {
//                throw new IOException("Not supported browser");
//            }
//        response.setHeader("Content-Disposition", "attachment; filename=" + encodedFilename);
//        if ("Opera".equals(browser)) {
//            response.setContentType("application/octet-stream;charset=UTF-8");
//        }
        try {
            response.setContentType("application/octet-stream");
            String headerKey = "Content-Disposition";
            String fileName = "users_" + filename + ".xlsx";
            String headerValue = "attachement; filename=" + fileName;

            response.setHeader("Set-Cookie", "fileDownload=true; path=/");
            response.setHeader(headerKey, headerValue);
        } catch (Exception e) {
            response.setContentType("application/octet-stream");
            response.setHeader("Set-Cookie", "fileDownload=false; path=/");
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Content-Type", "text/html; charset=utf-8");
        }
    }

    public void writeExcel() {
        ServletOutputStream sos = null;

        try {
            sos = response.getOutputStream();
            wb.write(sos);
            sos.flush();
        } catch (IOException e) {
            log.error("[Excel DownLoad Error]");
        } finally {
            if (sos != null) {
                try {
                    sos.close();
                } catch (IOException e) {
                    log.error("[Excel DownLoad Error]");
                }
            }
            if (wb != null) {
                try {
                    wb.close();
                } catch (IOException e) {
                    log.error("[Excel DownLoad Error]");
                }
            }
        }
    }

    public CellStyle headStyle() {
        CellStyle style = wb.createCellStyle();
        XSSFFont font = (XSSFFont) wb.createFont();
        font.setBold(true);
        font.setFontHeight(15);
        // font.setColor(IndexedColors.BLACK.index);
        style.setWrapText(true);
        style.setFillForegroundColor(IndexedColors.ROYAL_BLUE.index);
        style.setFont(font);

        return style;
    }

    public CellStyle bodyStyle() {
        CellStyle style = wb.createCellStyle();
        XSSFFont font = (XSSFFont) wb.createFont();
        font.setFontHeight(5);
        style.setWrapText(true);
        style.setFont(font);
        return style;
    }

}
