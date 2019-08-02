package com.ssafy.java;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProductMgrImpl implements IProductMgr {

	private static ProductMgrImpl pm = new ProductMgrImpl();
	private ArrayList<Product> list = new ArrayList<Product>();
	private ArrayList<Product> temp;
	
	public static ProductMgrImpl getInstance() {
		return pm;
	}
	
	private ProductMgrImpl() {}
	
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
