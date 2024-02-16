package com.hw2.model.dto;

public class Employee extends Person {

	// 속성(필드)
	private String position; // 직책

	// 기능(생성자+메서드)
	
	// 매개변수 생성자
	public Employee(String id, String name, String position) {
		super(id, name);
		this.position = position;
	}
	
	

	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return String.format("ID : %s , 이름 : %s , 직책 : %s"
				, id, name, position);
	}
}
