package kr.co.crewmate.ojt.start;



import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

public interface CsvParser {
    
    List<CsvData> parse(Reader reader) throws IOException;
}
