package edu.ssafy.chap09.Network2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import edu.ssafy.chap09.Network3.Message;

public class ServerTest {
	ServerSocket ss;
	
	public void go()  {
		InputStream is = null;
		OutputStream os = null;
		Socket cSock = null;
		try {
			ss = new ServerSocket(7000);
			while(true) {
			System.err.println("Waiting.. 서버 대기중");
			//클라이언트가 접속하기 전까지는 blocking되어있어.
			cSock = ss.accept();
//			System.out.println("Connected");
			is = cSock.getInputStream();
			os = cSock.getOutputStream();
			
			//이제 객체가 날라오니까 Object로.
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(is));
			Message m = (Message) ois.readObject();
			System.out.println(m.toString());
			
			
//			BufferedReader br = new BufferedReader(new InputStreamReader(is));
//			String readLine = br.readLine();
//			System.out.println(readLine);
//			
//			
//			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
//			bw.write(readLine + "을 전송\n");
//			bw.flush();
			}
			
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("연결실패");
		} finally {
			try {
				if(is!=null) is.close();
				if(os!=null) os.close();
				if(cSock != null) cSock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	
	}
	
	public static void main(String[] args) throws IOException {
		new ServerTest().go();
	}
}
