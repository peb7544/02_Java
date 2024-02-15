package com.hw1.model.vo;

public class Student extends Person {

 	// 속성(필드)
	private int grade; // 학년
	private String major; // 전공
	
	// 기능
	
	// 기본 생성자
	public Student() { }

	// 매개변수 생성자
	public Student(String name, int age, double height, double weight, int grade, String major) {
		super(age, height, weight);
		
		setName(name);
		this.grade = grade;
		this.major = major;
	}
	
	// getter/setter
	public int getGrade() {
		
		return grade;
	}
	
	public void setGrade(int grade) {
		
		this.grade = grade;
	}
	
	public String getMajor() {
		
		return major;
	}
	
	public void setMajor(String major) {
		
		this.major = major;
	}
	 
	// 메서드
	@Override
	public String information() {
		
		return  super.information() 
				+ "\n학년 : " + grade 
				+ "\n반 : " + major;
	}
}
