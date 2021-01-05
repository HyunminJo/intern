package kr.co.crewmate.ojt.start;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CountKeyword {

    public static void main(String[] args) {
        int count = 0;
        count = countString("C:\\local\\ojt2020\\", count);
        System.out.println("갯수 : " + count);
    }

    private static int countString(String path, int count) {
        // TODO Auto-generated method stub
        File dir = new File(path);
        File files[] = dir.listFiles();

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (file.isDirectory()) {
                count = countString(file.getPath(), count);
            } else {
                if (file.getPath().contains(".java")) {
                    count += word(file.getPath());
                }
            }
        }  
        return count;
    }
    
    public static int word(String filePath) {
        File file = new File(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String st = br.readLine();
            String arr[];
            int cnt = 0;

            while (st != null) {
                arr = st.split(" ");
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].contains("String")) {
                        cnt++;
                    }
                }
                st = br.readLine();
            }
            return cnt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
