package com.ssafy.java;

// 서버로 데이터를 전송하는 기능 추가 Thread 활용
// 단, 보낼 때 TV를 먼저 보내고나서 그다음 냉장고를 보낸다.

	// 현재 순서없이 보내기만 함. 
	// 보내는거 확인, 저장되는거 확인!

	//여기아래부터 하면됨
	// 일단 받아서 저장되는거 확인하고나서 TV - 냉장고 순으로 보내는거 구현하기.


// 그러면 Server에서는 받은 순서대로 TV를 받고, 냉장고를 받겠지 
// '출력'도 이 순서대로 하고, 파일로 저장하는것도 이 순서대로 할거고.

// Server가 모든 데이터를 받으면 전송받은 데이터 개수를 'client'로 재전송한다.
// Client는 Server로부터 전송받은 데이터 개수를 '출력'한다.



import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProductMgrImpl implements IProductMgr {
	private File file = new File("Product.dat");
	
	class ProductClient extends Thread{
		public ProductClient() {}
		
		public void go() {
			Socket sSock = null;
			try {
				sSock = new Socket("localhost", 7000);
				
				OutputStream os = sSock.getOutputStream();
				InputStream is = sSock.getInputStream();
				
				//보내는
				ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(os));
				ArrayList<Product> TVtemp = new ArrayList<Product>();
				ArrayList<Product> Refritemp = new ArrayList<Product>();
				
				for(Product p : list) {
					if ( p instanceof TV)
						TVtemp.add(p);
					else
						Refritemp.add(p);
				}
				
				oos.writeObject(TVtemp);
				oos.flush();
				
				sSock = new Socket("localhost", 7000);
				os = sSock.getOutputStream();
				oos = new ObjectOutputStream(new BufferedOutputStream(os));
				oos.writeObject(Refritemp);
				oos.flush();
				

				
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				int readFromServer = br.read();
					System.err.println("from Server] "+ readFromServer + "개 ");
//				System.out.println("data from Server : " + readFromServer);
				br.close();
				
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(sSock != null)
					try {
						sSock.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		@Override
		public void run() {
			this.go();
		}
		
	}
	
	private static ProductMgrImpl pm = new ProductMgrImpl();
	private ArrayList<Product> list = new ArrayList<Product>();
	private ArrayList<Product> temp;
	
	public static ProductMgrImpl getInstance() {
		return pm;
	}
	
	private ProductMgrImpl() {}
	
	
	public void send() {
		ProductClient pc = new ProductClient();
		pc.start();
	}
	
	
	@Override
	public void add(Product p) throws DuplicateException {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).serial==p.serial)
				throw new DuplicateException();
		}
		list.add(p);
		sorted();
	}
	
	@Override
	public ArrayList<Product> searchAll() {
		return list;
	}
	
	@Override
	public ArrayList<Product> findByName(String name) {
		temp = new ArrayList<Product>();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).name.contains(name)) {
				temp.add(list.get(i));
			}
		}
		return temp;
	}

	
	@Override
	public Product findBySerial(int serial)throws CodeNotFoundException {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).serial==serial) {
				return list.get(i);
			}
		}
		throw new CodeNotFoundException();
	}
	
	
	@Override
	public ArrayList<Product> TVAll() {
		temp = new ArrayList<Product>();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) instanceof TV) {
				temp.add(list.get(i));
			}
		}
		return temp;
//		return null;
	}
	
	@Override
	public ArrayList<Product> RefriAll() {
		temp = new ArrayList<Product>();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) instanceof Refrigerator) {
				temp.add(list.get(i));
			}
		}
		return temp;
	}
	
	@Override
	public ArrayList<Product> Refri400liter() throws ProductNotFoundException {
		temp = new ArrayList<Product>();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) instanceof Refrigerator) {
				Refrigerator tmp = (Refrigerator) list.get(i);
				if(tmp.liter >= 400)
					temp.add(list.get(i));
			}
		}
		if(temp.isEmpty())
			throw new ProductNotFoundException();
		return temp;
	}
	
	@Override
	public ArrayList<Product> TV50inch() throws ProductNotFoundException {
		temp = new ArrayList<Product>();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) instanceof TV) {
				TV tmp = (TV) list.get(i);
				if(tmp.inch >= 50)
					temp.add(list.get(i));
			}
		}
		if(temp.isEmpty())
			throw new ProductNotFoundException();
		return temp;
	}
	
	@Override
	public void modifyPrice(int serial, int price) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).serial==serial) {
				list.get(i).price = price;
			}
		}
	}
	
	@Override
	public void deleteProduct(int serial) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).serial==serial) {
				list.remove(i);
			}
		}
	}
	
	@Override
	public int TotalPrice() {
		int totalPrice=0;
		for(int i=0; i<list.size(); i++) {
			totalPrice += (list.get(i).price * list.get(i).stock);
		}
		return totalPrice;
	}
	
	@Override
	public ArrayList<Product> findByName(String name, int price) {
		temp = new ArrayList<Product>();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).name.contains(name) && (list.get(i).price<= price)) {
				temp.add(list.get(i));
			}
		}
		return temp;
	}
	
	
	@Override
	public void ReadData() throws IOException, ClassNotFoundException{
		if(!file.exists()) return;
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("product.dat"));
		list = (ArrayList<Product>) ois.readObject();
		ois.close();
	}
	
	
	public void Open() {
		ObjectInputStream ois = null ;
		try {
		ois = new ObjectInputStream(new FileInputStream("product.dat"));
		list = (ArrayList<Product>) ois.readObject();
		
		} catch (ClassNotFoundException | IOException e) {
			
		}finally{
			if(ois!=null)
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	@Override
	public void StoreData() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("product.dat"));
		oos.writeObject(list);
		oos.flush();
		oos.close();
	}
	
	
	public void close() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("dad.d"));
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
	}
	
	public void sorted() {
		Comparator<Product> comp = new Comparator<Product>() {
			
			@Override
			public int compare(Product o1, Product o2) {
				return o1.price - o2.price;
			}
			
		};	
		
		Collections.sort(list , comp);
	}
	
	
	
}
