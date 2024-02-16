package com.hw1.model.dto;

public class Novel extends Book {

	// 속성(필드)
	private String genre; // 장르
	
	// 기능(생성자+메서드)
	
	// 기본 생성자
	public Novel() {}

	// 매개변수 생성자
	public Novel(String title, String author, String genre) {
		super(title, author);
		this.genre = genre;
	}

	// getter/setter=
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public void displayinfo() {
		// TODO Auto-generated method stub
		System.out.printf("[소설] 제목 : %s / 저자 : %s / 장르 : %s\n"
				, getTitle(), getAuthor(), genre);
	}
}
