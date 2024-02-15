package com.hw4.vo;

public class Member {
	
	// 속성(필드)
	private String userId; // 아이디
	private String userPwd; // 비밀번호
	private String name; // 이름
	private int age; //나이
	private char gender; // 성별
	private String email; // 이메일
	
	// 기능
	
	// 기본생성자
	public Member() {
		
	}

	// 매개변수 생성자
	public Member(String userId, String userPwd, String name, int age, char gender, String email) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
	}
	
	// getter/setter
	public String getUserId() {
		
		return userId;
	}
	
	public void setUserId(String userId) {
		
		this.userId = userId;
	}
	
	public String getUserPwd() {
		
		return userPwd;
	}
	
	public void setUserPwd(String userPwd) {
		
		this.userPwd = userPwd;
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
	
	public char getGender() {
		
		return gender;
	}
	
	public void setGender(char gender) {
		
		this.gender = gender;
	}
	
	public String getEmail() {
		
		return email;
	}
	
	public void setEmail(String email) {
		
		this.email = email;
	}
	
	// 메서드
	public String information() {
		
		return "";
	}
}
