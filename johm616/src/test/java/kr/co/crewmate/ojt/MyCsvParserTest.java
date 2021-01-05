package kr.co.crewmate.ojt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.jupiter.api.Test;

import kr.co.crewmate.ojt.start.CsvData;
import kr.co.crewmate.ojt.start.CsvParser;
import kr.co.crewmate.ojt.start.MyCsvParser;

public class MyCsvParserTest {

    @Test
    public void testBasic() throws IOException {
        File file = new File(
                "C:\\local\\ojt2020\\johm616\\src\\main\\java\\kr\\co\\crewmate\\ojt\\test.csv");

        CsvParser csvParser = new MyCsvParser();
        InputStreamReader fileRead = new InputStreamReader(new FileInputStream(file), "EUC-KR");
        List<CsvData> data = csvParser.parse(fileRead);
        fileRead.close();
//        System.out.println(data.get(0));
        for(int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i).getItems());
        }
        assertEquals("\"abc\"", data.get(0).getItems().get(0));
        assertEquals("\"e,d,\"\"fd,\"", data.get(0).getItems().get(1));
//        assertEquals("cfs", data.get(0).getItems().get(2));
//        assertEquals("dze'\nz", data.get(0).getItems().get(3));
//        assertEquals("e:e", data.get(1).getItems().get(0));
//        assertEquals("\"f\"", data.get(1).getItems().get(1));
//        assertEquals("g,f\"f", data.get(1).getItems().get(2));
//        assertEquals("\",\"", data.get(1).getItems().get(3));
    }
}
