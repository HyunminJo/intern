package kr.co.crewmate.ojt.start;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MyCsvParser implements CsvParser {

    @Override
    public List<CsvData> parse(Reader reader) throws IOException {
        PushbackReader backReader = new PushbackReader(reader);
        List<CsvData> list = new ArrayList<>(); // 저장할 리스트
        CsvData data = new CsvData(); // 저장할 data
        StringBuilder sb = new StringBuilder(); // 저장 돕는 builder
        boolean quotation = false;

        for (int current = backReader.read(); current != -1; current = backReader.read()) {
            if (!quotation) {
                if (current == '\n') {
                    data.add(sb.toString());
                    list.add(data);
                    sb = new StringBuilder();
                    data = new CsvData();
                } else if (current == ',') {
                    data.add(sb.toString());
                    sb = new StringBuilder();
                } else if (current == '"') {
                    quotation = true;
                } else if (current == '\r') {

                } else {
                    sb.append((char) current);
                }
            } else {
                if (current == '"' && (current = backReader.read()) != '"') {
                    quotation = false;
                    backReader.unread(current);
                    continue;
                }
                sb.append((char) current);
            }
        }
        return list;
    }
}
