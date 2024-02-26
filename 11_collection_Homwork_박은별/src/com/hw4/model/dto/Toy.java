package com.hw4.model.dto;

import java.util.Set;

/**
 * 장난감의 정보를 저장하고 관리하는 데이터 전송
 * 객체(DTO)입니다.
 */
public class Toy {

	private String toyNm;  // 장난감 이름
	private int age; // 사용연령
	private int price; // 가격
	private String color; // 색상
	private String manufacturingDate; // 제조년월일
	private Set<String> materials; // 사용재료
	
	public Toy() {}

	public Toy(String toyNm, int age, int price, String color, 
			String manufacturingDate, Set<String> materials) {
		super();
		this.toyNm = toyNm;
		this.age = age;
		this.price = price;
		this.color = color;
		this.manufacturingDate = manufacturingDate;
		this.materials = materials;
	}

	public String getToyNm() {
		return toyNm;
	}

	public void setToyNm(String toyNm) {
		this.toyNm = toyNm;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public Set<String> getMaterials() {
		return materials;
	}

	public void setMaterials(Set<String> materials) {
		this.materials = materials;
	}
	
	// 제품
	//public String 

	@Override
	public String toString() {
		return String.format("이름 : %s / 가격 : %d / 색상 : %s / 사용가능연령 : %d / 제조년월일 : %s / 재료 : %s"
				, toyNm, price, color, age, manufacturingDate, "");
	}
	
	
}
