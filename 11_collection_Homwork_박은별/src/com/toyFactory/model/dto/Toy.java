package com.toyFactory.model.dto;

import java.util.Objects;
import java.util.Set;

public class Toy {
	
	private String name;
	private int age;
	private int price;
	private String color; // 색상
	private String manufacturDate; // 제조일(문자열로 표현 -20240222)
	private Set<String> materials; // 재료(중복되지 않는 값으로 저장)
	
	public Toy() {}

	public Toy(String name, int age, int price, String color, String manufacturDate, Set<String> materials) {
		super();
		this.name = name;
		this.age = age;
		this.price = price;
		this.color = color;
		this.manufacturDate = manufacturDate;
		this.materials = materials;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getManufacturDate() {
		return manufacturDate;
	}

	public void setManufacturDate(String manufacturDate) {
		this.manufacturDate = manufacturDate;
	}

	public Set<String> getMaterials() {
		return materials;
	}

	public void setMaterials(Set<String> materials) {
		this.materials = materials;
	}
	
	//materials 안에 있는 모든 재료를 문자열 형태로 만들어 반환하는 메서드
	public String getMaterialsAsString() {
		
		StringBuilder sb = new StringBuilder();
		
		for( String material : materials ) {
			
			sb.append(material).append(", ");
		}
		
		// 마지막 쉼표와 공백 제거하기
		if(sb.length() > 0) {
			sb.setLength(sb.length() - 2);
		}
		
		return sb.toString();
	}

	@Override
	public String toString() {
		return String.format("이름 : %s / 가격 : %d / 색상 : %s / 사용가능연력 : %d / 제조년월일 : %s / 재료 : %s"
				, name, price, color, age, manufacturDate, getMaterialsAsString());
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, color, manufacturDate, materials, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Toy other = (Toy) obj;
		return age == other.age && Objects.equals(color, other.color)
				&& Objects.equals(manufacturDate, other.manufacturDate) && Objects.equals(materials, other.materials)
				&& Objects.equals(name, other.name) && price == other.price;
	}
}
