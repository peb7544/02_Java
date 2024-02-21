package com.hw4.model.dto;

/**
 * 장난감의 정보를 저장하고 관리하는 데이터 전송
 * 객체(DTO)입니다.
 */
public class Toy {

	// 필드
	private String toyNm; // 장난감 이름
	private int age; // 사용연령
	private int price; // 가격
	private String color; // 색상
	private int date; // 제조년월일
	private String ingredient; // 사용재료
	
	// 기본 생성자
	public Toy() {}

	// 매개변수 생성자
	public Toy(String toyNm, int age, int price, String color, 
			int date, String ingredient) {
		super();
		this.toyNm = toyNm;
		this.age = age;
		this.price = price;
		this.color = color;
		this.date = date;
		this.ingredient = ingredient;
	}

	// getter / setter
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

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	@Override
	public String toString() {
		return String.format("이름 : %s / 가격 : %d / 색상 : %s / 사용가능연력 : %d / 제조년월일 : %s / 재료 : "
				, toyNm, price, color, age, date);
	}
}
