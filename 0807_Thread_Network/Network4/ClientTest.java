package edu.ssafy.chap09.Network4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;






public class ClientTest {
	
	private void START() {
		new ClientThread().start();
	}
	
	
	private class ClientThread extends Thread{
		@Override
		public void run() {
			go();
		}
	}
	
	private void go()  {
		Socket sSock = null;
		try {
			sSock = new Socket("localhost", 7000);
			//Output - Input 순서 주의!!!!
			OutputStream os = sSock.getOutputStream();
			InputStream is = sSock.getInputStream();
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
			// \n을 보내는 이유는 서버에서 Line으로 받아서 \n이 올때까지 받기로했으니께!
			System.out.println("서버로 보낼 문자열 : Hello Server >_<");
			bw.write("Hello Server >_<\n"); 
			bw.flush();
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String readLine = br.readLine();
			System.out.println(readLine);
			
			br.close();
			bw.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sSock !=null)
				try {
					sSock.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	
	public static void main(String[] args) {
		ClientTest clientTest = new ClientTest();
		
		clientTest.START();
		System.out.println("aaaa");
	}
}
