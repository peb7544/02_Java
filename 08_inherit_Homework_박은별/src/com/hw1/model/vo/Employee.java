package com.hw1.model.vo;

public class Employee extends Person {

	// 속성(필드)
	private int salary; // 급여
	private String dept; // 부서
	
	// 기능
	
	// 기본생성자
	public Employee() { }

	// 매개변수 생성자
	public Employee(String name, int age, double height, double weight, int salary, String dept) {
		super(age, height, weight);
		
		setName(name);
		this.salary = salary;
		this.dept = dept;
	}
	
	// getter/setter
	public int getSalary() {
		
		return salary;
	}
	
	public void setSalary(int salary) {
		
		this.salary = salary;
	}
	
	public String getDept() {
		
		return dept;
	}
	
	public void setDept(String dept) {
		
		this.dept = dept;
	}
	
	// 메서드
	@Override
	public String information() {
		
		return super.information()
				+ "\n급여 : " + salary
				+ "\n부서 : " + dept;
	}
}
