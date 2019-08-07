package edu.ssafy.chap09.Network2;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import edu.ssafy.chap09.Network3.Message;

public class ClientTest {
	private void go() throws UnknownHostException, IOException {
		Socket sSock = new Socket("localhost", 7000);
		
		//Output - Input 순서 주의!!!!
		OutputStream os = sSock.getOutputStream();
		InputStream is = sSock.getInputStream();
		
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
//		// \n을 보내는 이유는 서버에서 Line으로 받아서 \n이 올때까지 받기로했으니께!
//		System.out.println("서버로 보낼 문자열 : Hello Server >_<");
//		bw.write("Hello Server >_<\n"); 
//		bw.flush();
//		
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(is));
//		String readLine = br.readLine();
//		System.out.println(readLine);
		
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(os));
		oos.writeObject(new Message("강사님", "태희", "빈파일 올리지마"));
		oos.flush();
		
		
		
//		br.close();
//		bw.close();
		sSock.close();
	}
	
	
	public static void main(String[] args) {
		try {
			new ClientTest().go();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
