package com.hw2.model.dto;

public class Prisoner extends Person {
	
	// 속성(필드)
	private String crime; // 죄목
	
	// 기능(생성자+메서드)
	
	// 매개변수 생성자
	public Prisoner(String id, String name, String crime) {
		super(id, name);
		this.crime = crime;
	}
	
	public String getCrime() {
		return crime;
	}

	public void setCrime(String crime) {
		this.crime = crime;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return String.format("ID : %s , 이름 : %s , 죄목 : %s"
				, id, name, crime);
	}
}
