package com.hw2.model.dto;

public abstract class Animal {

	// 필드
	protected String name;
	
	// 기본생성자
	public Animal() {}
	
	// 매개변수생성자
	public Animal(String name) {
		super();
		this.name = name;
	}

	// getter + setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void sound();
}
