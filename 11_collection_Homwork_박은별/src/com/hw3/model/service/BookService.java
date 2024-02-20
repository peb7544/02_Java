package com.hw3.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hw3.model.dto.Book;

public class BookService {

	private List<Book> books = new ArrayList<Book>();
	
	private Scanner sc = new Scanner(System.in);
	
	char bookmark = 'N';
	
	public BookService() {
		
		books.add( new Book(1111, "세이노의 가르침", "세이노", 6480, "데이원", bookmark) );
		books.add( new Book(2222, "문과남자의 과학공부", "유시민", 15750, "돌베개", bookmark) );
		books.add( new Book(3333, "역행자", "자청", 17550, "웅진지식하우스", bookmark) );
		books.add( new Book(4444, "꿀벌의 예언", "베르나르 베르베르", 15120, "열린책들", bookmark) );
		books.add( new Book(5555, "도둑맞은 집중력", "요한 하리", 16920, "어크로스", bookmark) );
	}
	
	public void displayMenu() {
		
		int num = 0;
		
		do {
			
			System.out.println("=== 도서 목록 프로그램 ===");
			
			System.out.println("1. 도서 등록\n");
			System.out.println("2. 도서 조회\n");
			System.out.println("3. 도서 수정\n");
			System.out.println("4. 도서 삭제\n");
			System.out.println("5. 즐겨찾기 추가\n");
			System.out.println("6. 즐겨찾기 삭제\n");
			System.out.println("7. 즐겨찾기 조회\n");
			System.out.println("8. 추천도서 뽑기\n");
			System.out.println("0. 프로그램 종료\n");
			
			System.out.print("메뉴를 입력하세요 : ");
			num = sc.nextInt();
			
			sc.nextLine();
			
			switch(num) {
			case 1: addBook(); break;
			case 2: selBook(); break;
			case 3: updBook(); break;
			case 4: delBook(); break;
			case 5: System.out.println(ynBookmark('Y', "추가")); break;
			case 6: System.out.println(ynBookmark('N', "삭제")); break;
			case 7: selBookmark(); break;
			case 8: randomBook(); break;
			case 0: System.out.println("프로그램을 종료하겠습니다."); break;
			default: System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
			}
			
		} while(num != 0);
	}
	
	/**
	 * 1. 도서 등록
	 */
	public void addBook() {
		
		System.out.println("\n===== 도서 등록 =====");
		
		System.out.print("\n도서 번호 : ");
		int bookNo = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("\n도서 제목 : ");
		String title = sc.nextLine();
		
		System.out.print("\n도서 저자 : ");
		String author = sc.nextLine();
		
		System.out.print("\n도서 가격 : ");
		int price = sc.nextInt();
		
		System.out.print("\n도서 출판사 : ");
		String publisher = sc.next();
		
		books.add( new Book(bookNo, title, author, price, publisher, bookmark) );
		
		System.out.println("\n등록완료");
	}
	
	/**
	 * 2. 도서 조회
	 */
	public void selBook() {
		
		System.out.println("\n===== 도서 조회 =====\n");
		
		if(books.isEmpty()) {
			System.out.println("등록된 책이 없습니다.");
			
			return;
		}
		
		for(Book book : books) {
			System.out.println(book);
		}
	}
	
	
	/**
	 * 3. 도서 수정
	 * 
	 */
	public void updBook() {
		
		System.out.println("\n===== 도서 수정 =====\n");
		
		System.out.print("수정할 도서 번호를 입력하세요 : ");
		int bookNum = sc.nextInt();
		
		if(books.isEmpty()) {
			
			System.out.println("등록된 책이 없습니다.");
			return;
		}
		
		boolean flag = false;
		int index = 0;
		for( Book book : books ) {
			
			if( book.getBookNo() == bookNum ) {
				
				int num = 0;
				String result = "수정 완료";
				
				do {
					System.out.println("\n1. 도서명");
					System.out.println("\n2. 도서 저자");
					System.out.println("\n3. 도서 가격");
					System.out.println("\n4. 도서 출판사");
					System.out.println("\n0. 수정 종료");
					
					System.out.print("\n어떤 정보를 수정하시겠습니까? ");
					num = sc.nextInt();
					
					sc.nextLine();
					
					System.out.println("\n===== 도서 가격 수정 =====\n");
					
					switch(num) {
					case 1: 
						System.out.print("수정할 도서명을 입력하세요 : ");
						String title = sc.nextLine();
						
						book.setTitle(title);
						
						break;
					case 2: 
						System.out.print("수정할 도서 저자를 입력하세요 : ");
						String author = sc.nextLine();
						
						book.setAuthor(author);
						
						break;
					case 3: 
						System.out.print("수정할 도서 가격을 입력하세요 : ");
						int price = sc.nextInt();
						
						book.setPrice(price);
						
						break;
					case 4: 
						System.out.print("수정할 도서 출판사를 입력하세요 : ");
						String publisher = sc.next();
						
						book.setPublisher(publisher);
						
						break;
					case 0: result = "수정을 종료하겠습니다."; break;
					default: result = "잘못입력하셨습니다. 다시 입력해주세요.";
					}
					
					System.out.println(result);
					
				} while(num != 0);
				
				flag = true;
				
				
			}
			
			index++;
		}
		
		if(!flag) {
			
			System.out.println(bookNum + "번 도서로 등록된 책이 없습니다.");
		}
	}
	
	/**
	 * 4. 도서 삭제
	 */
	public void delBook() {
		
		System.out.println("\n===== 도서 삭제 =====\n");
		
		if(books.isEmpty()) {
			System.out.println("등록된 책이 없습니다.");
			
			return;
		}
		
		System.out.print("삭제할 도서 번호를 입력하세요 : ");
		int bookNum = sc.nextInt();
		
		int index = 0;
		boolean flag = false;
		
		for(Book book : books) {
			
			if(book.getBookNo() == bookNum) {
				
				System.out.print("도서번호 " + book.getBookNo() + "을 삭제하시겠습니까?(Y/N) : ");
				char yn = sc.next().toUpperCase().charAt(0);
				
				if(yn == 'Y' ) {
					
					books.remove(index);
					
					System.out.println("삭제완료");
				} 
				
				flag = true;
				
				return;
			}
			
			index++;
		}
		
		if(!flag) {
			System.out.println(bookNum + "번 도서로 등록된 책이 없습니다.");
		}
	}
	
	/**
	 * 5. 즐겨찾기 추가 / 6. 즐겨찾기 삭제
	 */
	public String ynBookmark(char yn, String mark) {
		System.out.println("\n===== 즐겨찾기 " + mark + " =====\n");
		
		if(books.isEmpty()) {
			
			return "등록된 책이 없습니다.";
		}
		
		System.out.print("즐겨찾기 " + mark + "할 도서 번호를 입력하세요 : ");
		int bookNum = sc.nextInt();
		
		int index = 0;
		boolean flag = false;
		
		for(Book book : books) {
			
			if(book.getBookNo() == bookNum) {
				
				if(yn == 'N') {
					if(book.getBookmark() == 'N') {
						return bookNum + "번 도서로 즐겨찾기로 등록된 책이 없습니다.";
					}
				}
				
				book.setBookmark(yn);
				
				return "즐겨찾기 " + mark + " 완료";
			}
			
			index++;
		}
		
		if(!flag) {
			
			return bookNum + "번 도서로 등록된 책이 없습니다.";
		}
		
		return "";
	}
	
	/**
	 * 7. 즐겨찾기 조회
	 */
	public void selBookmark() {
		
		System.out.println("\n===== 즐겨찾기 조회 =====\n");
		
		if(books.isEmpty()) {
			System.out.println("등록된 책이 없습니다.");
			
			return;
		}
		
		boolean flag = false;
		for(Book book : books) {
			if(book.getBookmark() == 'Y') {
				System.out.println(book);
				
				flag = true;
			}
		}
		
		if(!flag) {
			System.out.println("즐겨찾기에 등록된 책이 없습니다.");
		}
	}
	
	/**
	 * 8. 추천도서 뽑기
	 */
	public void randomBook() {
		
		System.out.println("\n===== 추천도서 뽑기 =====\n");
		
		if(books.isEmpty()) {
			
			System.out.println("등록된 책이 없습니다.");
			return;
		}
		
		int random = (int)(Math.random() * (books.size() - 1) );
		
		Book book = books.get(random);
		
		System.out.println(book);
	}
}
