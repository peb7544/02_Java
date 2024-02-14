package com.hw1.model.vo;

public class Employee {
	
	// 속성(필드 == 매개변수)
	private int empNo; // 사번
	private String empName; // 사원명
	private String dept; // 소속부서
	private String job; // 직급
	private int age; // 나이
	private char gender; // 성별
	private int salary; // 급여
	private double bonusPoint; // 보너스포인트
	private String phone; // 전화번호
	private String address; // 주소
	
	// 기능(생성자, 매개변수생성자)
	
	// 기본생성자
	public Employee() { }
	
	// 매개변수생성자
	public Employee(int empNo, String empName, int age, char gender,
			String phone, String address) {
		
		this.empNo = empNo;
		this.empName = empName;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		
	}
	
	public Employee(int empNo, String empName, String dept, String job,
			int age,char gender, int salary, double bonusPoint, String phone,
			String address) {
		
		this.empNo = empNo;
		this.empName = empName;
		this.dept = dept;
		this.job = job;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.bonusPoint = bonusPoint;
		this.phone = phone;
		this.address = address;
		
	}
	
	public String information() {
		
		return "";
	}

	// setter/getter
	
	// 사번
	public int getEmpNo() {
		
		return empNo;
	}
	
	public void setEmpNo(int empNo) {
		
		this.empNo = empNo;
	}
	
	// 사원명
	public String getEmpName() {
		
		return empName;
	}
	
	public void setEmpName(String empName) {
		
		this.empName = empName;
	}
	
	// 소속부서
	public String getDept() {
		
		return dept;
	}
	
	public void setDept(String dept) {
		
		this.dept = dept;
	}
	
	// 직급
	public String getJob() {
		
		return job;
	}
	
	public void setJob(String job) {
		
		this.job = job;
	}
	
	// 나이
	public int getAge() {
		
		return age;
	}
	
	public void setAge(int age) {
		
		this.age = age;
	}
	
	// 성별
	public char getGender() {
		
		return gender;
	}
	
	public void setGender(char gender) {
		
		this.gender = gender;
	}
	
	// 급여
	public int getSalary() {
		
		return salary;
	}
	
	public void setSalary(int salary) {
		
		this.salary = salary;
	}
	
	// 보너스포인트
	public double getBonusPoint() {
		
		return bonusPoint;
	}
	
	public void setBonusPoint(double bonusPoint) {
		
		this.bonusPoint = bonusPoint;
	}
	
	// 전화번호
	public String getPhone() {
		
		return phone;
	}
	
	public void setPhone(String phone) {
		
		this.phone = phone;
	}
	
	// 주소
	public String getAddress() {
		
		return address;
	}
	
	public void setAddress(String address) {
		
		this.address = address;
	}
}
