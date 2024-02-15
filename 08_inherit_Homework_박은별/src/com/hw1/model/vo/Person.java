package com.hw1.model.vo;

public class Person {

	// 속성(필드)
	protected String name;
	
	private int age;
	private double height;
	private double weight;
	
	// 기능
	
	// 기본생성자
	public Person() { }

	// 매개변수 생성자
	public Person(int age, double height, double weight) {
		super();
		
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	// getter/setter
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
	
	public double getHeight() {
		
		return height;
	}
	
	public void setHeight(double height) {
		
		this.height = height;
	}
	
	public double getWeight() {
		
		return weight;
	}
	
	public void setWeight(double weight) {
		
		this.weight = weight;
	}
	
	// 메서드
	public String information() {
		
		return "이름 : " + name +
				"\n나이 : " + age +
				"\n신장 : " + height +
				"\n몸무개 : " + weight;
	}
}
