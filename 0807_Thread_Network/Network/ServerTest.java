package edu.ssafy.chap09.Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
	public void go() throws IOException {
		ServerSocket ss = new ServerSocket(7000);
		//클라이언트가 접속하기 전까지는 blocking되어있어.
		System.err.println("Waiting..");
		Socket cSock = ss.accept();
		System.out.println("Connected");
		InputStream is = cSock.getInputStream();
		OutputStream os = cSock.getOutputStream();
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String readLine = br.readLine();
		System.out.println(readLine);
		
		
		is.close();
		os.close();
		cSock.close();
	}
	
	public static void main(String[] args) throws IOException {
		new ServerTest().go();
	}
}
