package kr.co.crewmate.ojt.start;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekJoon {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());    

        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                
                bw.write("*");            
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
//String str = br.readLine();
//        String star = br.read("*");
//String[] strs = str.split(" ");
//            int a = Integer.parseInt(strs[0]);
//            int b = Integer.parseInt(strs[1]);
