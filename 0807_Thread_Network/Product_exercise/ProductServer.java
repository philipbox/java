package com.ssafy.java;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;



public class ProductServer {
	
	class SaveThread extends Thread{
		ArrayList<Product> list = new ArrayList<Product>();
		
		public SaveThread(ArrayList<Product> list) {
			this.list = list;
		}
		
		@Override
		public void run() {
			ObjectOutputStream oos = null;
			try {
				oos = new ObjectOutputStream(new FileOutputStream("product.dat"));
				oos.writeObject(this.list);
				oos.flush();
				oos.close();
			}catch(IOException e) {
				e.printStackTrace();
			} finally {
				if(oos!=null) {
					try {
						oos.flush();
						oos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}//end run
	}//end SaveThread class 
	
	
	
	ServerSocket ss;
	
	public void go() throws ClassNotFoundException  {
		InputStream is = null;
		OutputStream os = null;
		Socket cSock= null;
		ObjectInputStream ois = null;
		try {
			ss = new ServerSocket(7000);
			while(true) {
			System.err.println("Waiting 1 ...");
			cSock = ss.accept();
			System.err.println("Connected 1 ...");
			is = cSock.getInputStream();
			os = cSock.getOutputStream();
			ArrayList<Product> readArr = new ArrayList<Product>();
			ArrayList<Product> readArr2 = new ArrayList<Product>();
			
			ois = new ObjectInputStream(new BufferedInputStream(is));
			readArr = (ArrayList<Product>) ois.readObject();
			
			for(Product p : readArr) {
				System.out.println(p.toString());
			}
			
//			SaveThread th = new SaveThread(readArr);
//			th.start();
			System.out.println("SERVER] 전송받은 데이터 수1 : " + readArr.size());
			
			
			System.err.println("Waiting 2 ...");
			cSock = ss.accept();
			System.err.println("Connected 2 ...");
			is = cSock.getInputStream();
			ois = new ObjectInputStream(new BufferedInputStream(is));
			
			readArr2 = (ArrayList<Product>) ois.readObject();

			for(Product p : readArr2) {
				System.out.println(p);
				readArr.add(p);
			}
			
			
			SaveThread th = new SaveThread(readArr);
			th.start();
			
			System.out.println("SERVER] 전송받은 데이터 수2 : " + readArr2.size());

			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
			bw.write(readArr.size());
			bw.flush();
			
//			SaveThread th = new SaveThread();
//			//start를하면 stack에 run이 만들어지니까 start먼저 해줘야해.
//			th.start();
			
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ois != null)
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//ois.close();
		}

		

		
	
	}
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		new ProductServer().go();
	}
}
