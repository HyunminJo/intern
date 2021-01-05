package kr.co.crewmate.ojt.start;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(9090)) {
            System.out.println("Listening...");

            while (true) {
                Socket socket = serverSocket.accept();
                Thread thread = new Thread(new HttpThread(socket));
                thread.start();
            }
        }
    }
}

class HttpThread implements Runnable {
    private Socket socket;
    private static final String BASE_DIR = "C:/local/ojt2020/johm616/src/main/java/kr/co/crewmate/ojt";
    HttpThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        PrintWriter pw = null;
        try (InputStream io = socket.getInputStream(); OutputStream os = socket.getOutputStream()) {
            reader = new BufferedReader(new InputStreamReader(io, "UTF-8"));
            pw = new PrintWriter(os, true);

            String line = reader.readLine();
            String[] arr = line.split(" ");
            String targetFileName = BASE_DIR + arr[1];
            System.out.println(arr[1]);
            File file = new File(targetFileName);
            long fileSize = file.length(); // 파일 사이즈 구하기
            
            for (; line != null; line = reader.readLine()) {
                System.out.println(line);
                if ("".equals(line)) {
                    break;
                }
            }
            Path path = Paths.get(targetFileName);
            String type = Files.probeContentType(path);            

            if(!arr[1].contains(".")) {
                pw.println("HTTP/1.1 301 MOVED Permanenlty");
                pw.println("Location: http://localhost:9090" + arr[1] + ".html");
            }            
            try (FileInputStream fin = new FileInputStream(file);) {
                
                pw.println("HTTP/1.1 200 OK");
                pw.println("Transfer-Encoding: chunked");
                pw.println("Connection: close");
//                pw.println("Content-Length: " + fileSize);
                if (type.contains("text")) {
                    pw.println("Content-Type: " + type + ";charset=UTF-8");
                } else {
                    pw.println("Content-Type: " + type);
                }
                
                pw.println("");
                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = fin.read(buffer)) != -1) {
                    pw.println(Integer.toHexString(bytesRead));
                    os.write(buffer, 0, bytesRead);
                    pw.println();
                }
                pw.println(0);
                pw.println();
                os.flush();
            } catch (FileNotFoundException fe) {
                pw.println("HTTP/1.1 404 Not Found");
                pw.println("Connection: close");
                pw.println("Content-Type: " + type + ";charset=UTF-8");
                pw.println("");
            }
        } catch (IOException e) {
            pw.println("HTTP/1.1 500 Server Error");
            pw.println("Connection: close");
            pw.println("Content-Type: text/html;charset=UTF-8");
            e.printStackTrace();
        } finally {
            try {
                pw.close();
                reader.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}