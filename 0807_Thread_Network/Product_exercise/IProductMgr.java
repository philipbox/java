package com.ssafy.java;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface IProductMgr {

	public void add(Product p) throws DuplicateException;
	public ArrayList<Product> searchAll();
	public Product findBySerial(int serial) throws CodeNotFoundException;
	public ArrayList<Product> findByName(String name);
	public ArrayList<Product> TVAll();
	public ArrayList<Product> RefriAll();
	public ArrayList<Product> Refri400liter() throws ProductNotFoundException;
	public ArrayList<Product> TV50inch() throws ProductNotFoundException;
	public void modifyPrice(int serial, int price);
	public void deleteProduct (int serial);
	public int TotalPrice();
	public ArrayList<Product> findByName(String name, int price);
	
	public void ReadData() throws IOException, ClassNotFoundException; 
	public void StoreData() throws FileNotFoundException, IOException;
}
