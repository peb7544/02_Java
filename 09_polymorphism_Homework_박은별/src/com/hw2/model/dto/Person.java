package com.hw2.model.dto;

public abstract class Person {
	
	// 속성(필드)
	protected String id; // 고유번호
	protected String name; // 이름
	
	// 기능(생성자+메서드)
	
	// 매개변수 생성자
	public Person(String id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	// Person 정보를 문자열로 리턴
	public abstract String getInfo(); 
}
