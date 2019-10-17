package com.ssafy.model.dto;

public class Product {
	
	private String id;
	private String name;
	private String company;
	private String price;
	private String description;
	
	public Product() {
		super();
	}

	public Product(String id, String name, String company, String price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
		this.price = price;
		this.description = description;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", company=" + company + ", price=" + price + ", description="
				+ description + "]";
	}
}
