package edu.ssafy.dto;

public class ProductDTO {
	
	private String pnum;
	private String pname;
	private String price;
	
	public ProductDTO() {}

	public ProductDTO(String pnum, String pname, String price) {
		super();
		this.pnum = pnum;
		this.pname = pname;
		this.price = price;
	}

	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductDTO [pnum=" + pnum + ", pname=" + pname + ", price=" + price + "]";
	}
	
	
}
