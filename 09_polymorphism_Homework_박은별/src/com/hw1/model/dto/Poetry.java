package com.hw1.model.dto;

public class Poetry extends Book{
	
	// 속성(필드)
	private int numberOfPooems; //시 수
	
	// 기능(생성자+메서드)
	
	// 기본 생성자
	public Poetry() {}

	// 매개변수 생성자
	public Poetry(String title, String author, int numberOfPooems) {
		super(title, author);
		this.numberOfPooems = numberOfPooems;
	}

	// getter/setter
	public int getNumberOfPooems() {
		return numberOfPooems;
	}

	public void setNumberOfPooems(int numberOfPooems) {
		this.numberOfPooems = numberOfPooems;
	}

	@Override
	public void displayinfo() {
		// TODO Auto-generated method stub
		System.out.printf("[시집] 제목 : %s / 저자 : %s / 시 수 : %d\n"
				, getTitle(), getAuthor(), numberOfPooems);
	}
}
