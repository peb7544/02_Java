package com.hw3.model.dto;

public class Book {

	// 필드
	private int bookNo; // 도서번호
	private String title; // 도서제목
	private String author; // 저자
	private int price; // 가격
	private String publisher; // 출판사
	private char bookmark; // 즐겨찾기
	
	// 기본생성자
	public Book() {}
	
	// 매개변수생성자
	public Book(int bookNo, String title, String author, int price, String publisher, char bookmark) {
		super();
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
		this.bookmark = bookmark;
	}

	// getter/setter
	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public char getBookmark() {
		return bookmark;
	}

	public void setBookmark(char bookmark) {
		this.bookmark = bookmark;
	}

	@Override
	public String toString() {
		return bookNo + "번 도서 : [도서제목 : " + title + " / 도서저자 : " + author + " / 도서가격 : " + price
				+ " / 출판사 : " + publisher + "]\n";
	}
}
