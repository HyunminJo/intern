package kr.co.crewmate.ojt.start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(9090)) { // 서버의 포트 번호 설정
            System.out.println("Listening...");

            while (true) { // 클라이언트 요청 대기
                Socket socket = serverSocket.accept(); // 클라이언트 받음
                Thread thread = new Thread(new EchoThread(socket));
                thread.start();
            }
        }
    }
}

// Thread 클래스
//Socket을 받아서 그와 연결된 클라이언트가 보내는 글을 읽어 다시 클라이언트에 전송
class EchoThread implements Runnable {
    private Socket socket; // 소켓객체를 받을 생성자

    EchoThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream io = socket.getInputStream(); OutputStream os = socket.getOutputStream()) { // 클라이언트와 I/O 
            BufferedReader reader = new BufferedReader(new InputStreamReader(io, "UTF-8")); // Client 에서 보내온 메시지 받기
            PrintWriter pw = new PrintWriter(os, true);
            
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println(line);
                if(line.equals("exit")) { // 받아온 메시지에서 'exit'가 있으면 종료
                    System.out.println("server close");
                    break;
                }
                pw.println(line); // 보낼 내용을 읽어와서 서버로 보낸다
                pw.flush(); // 프린터 라이터 메모리를 초기화 시켜서 내부에 있던 데이터를 서버로 전송한다
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}