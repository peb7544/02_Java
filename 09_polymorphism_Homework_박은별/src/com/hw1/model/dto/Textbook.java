package com.hw1.model.dto;

public class Textbook extends Book {

	// 속성(필드)
	private String subject; // 교육
	
	// 기능(생성자+메서드)
	
	// 기본 생성자
	public Textbook() {}
	
	// 매개변수 생성자
	public Textbook(String title, String author, String subject) {
		super(title, author);
		this.subject = subject;
	}

	// getter/setter
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public void displayinfo() {
		// TODO Auto-generated method stub
		System.out.printf("[전문 서적] 제목 : %s / 저자 : %s / 과목 : %s\n"
				, getTitle(), getAuthor(), subject);
	}
}
