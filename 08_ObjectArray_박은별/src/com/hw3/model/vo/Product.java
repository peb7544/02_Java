package com.hw3.model.vo;

import com.hw3.controller.ProductController;

public class Product {
	
	private int pId; // 제품 번호
	private String pName; // 제품명
	private int price; // 제품가격
	private double tax; // 제품세금
	
	public Product() {
		ProductController.count ++;
	}
	
	public Product(int pId, String pName, int price, double tax) {
		this.pId = pId;
		this.pName = pName;
		this.price = price;
		this.tax = tax;
		
		ProductController.count ++;
	}
	
	public String imformation() {
		return "";
	}
	
	// 제품 번호
	public int getPId() {
		
		return pId;
	}
	
	public void setPId(int pId) {
		
		this.pId = pId;
	}
	
	// 제품명
	public String getPName() {
		
		return pName;
	}
	
	public void setPName(String pName) {
		
		this.pName = pName;
	}
	
	// 제품 가격
	public int getPrice() {
		
		return price;
	}
	
	public void setPrice(int price) {
		
		this.price = price;
	}
	
	// 제품세금
	public double getTax() {
		
		return tax;
	}
	
	public void setTax(double tax) {
		
		this.tax = tax;
	}
}
