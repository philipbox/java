package edu.ssafy.model;

public class ProductVo {
	private String id;
	private String name;
	private int price;
	private int count;
	
	
	public ProductVo() {
		super();
	}
	
	public ProductVo(String id, String name, int price, int count) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ProductVo [id=" + id + ", name=" + name + ", price=" + price + ", count=" + count + "]";
	}
	
}
