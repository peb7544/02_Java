package com.hw3.controller;

import com.hw3.model.vo.Product;
import java.util.Scanner;

public class ProductController {
	
	// 위의 클래스 다이어그램을 보고 필드 작성

	private Product[] pro = null;
	
	public static int count = 0; // 현재 추가된 객체 수
	
	Scanner sc = new Scanner(System.in);
	
	// 초기화 블럭을 이용하여 10개의 Product 배열 크기 할당
	{ pro = new Product[10]; }
	
	/* do~while문을 이용하여
	 * 반복적으로 메뉴화면 출력
	 * 각 버튼 선택 시 각각의 메소드 호출
	 * */
	public void mainMenu() {
		int menu = 0;
		
		do {
			
			System.out.println("===== 제품 관리 메뉴 =====");
			System.out.println("1. 제품 정보 추가");
			System.out.println("2. 제품 전체 조회");
			System.out.println("3. 제품 삭제");
			System.out.println("4. 제품 수정");
			System.out.println("5. 제품 검색");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 입력 : ");
			menu = sc.nextInt();
			
			sc.nextLine();
			
			switch(menu) {
			
			case 1 : productInput(); break;
			case 2 : productPrint(); break;
			case 3 : productDelete(); break;
			case 4 : break;
			case 5 : break;
			case 0 : System.out.println("프로그램 종료.."); break;
			default : System.out.println("잘못 입력..");
			}
			
		} while(menu != 0);
	}

	/* 새로운 제품 정보 기록을 위해
	 * 키보드로 정보들을 입력받아
	 * 객체를 생성하고 현재 카운트
	 * 인덱스에 주소 저장
	 * */
	public void productInput() {
		
		// 키보드로 도서 정보를 입력 받아 객체 생성
		System.out.println("\n===== 제품 정보 추가 =====");
		
		System.out.print("제품 번호 : ");
		int pId = sc.nextInt();
		
		System.out.print("제품 명 : ");
		String pName = sc.next();
		
		System.out.print("제품 가격 : ");
		int price = sc.nextInt();
		
		System.out.print("제품 세금 : ");
		double tax = sc.nextDouble();
		
		pro[count] = new Product(pId, pName, price, tax);
	}
	
	// 현재까지 기록된 도서 정보 모두 출력
	public void productPrint() {
		
		System.out.println("\n===== 제품 정보 조회 =====");
		
		for(int i = 0; i < pro.length; i++ ) {
			
			if(pro[i] != null) {
				System.out.println("pro["+i+"]");
				System.out.println("제품번호 : " + pro[i].getPId());
				System.out.println("제품명 : " + pro[i].getPName());
				System.out.println("제품가격 : " + pro[i].getPrice());
				System.out.println("제품세금 : " + pro[i].getTax());
				
				System.out.println("==============================");
			}
		}
	}
	
	// 추가적으로 제품 삭제, 수정, 검색 등등의 메소드를 응용해서 추가

	// 제품 삭제
	public void productDelete() {
		System.out.println("\n===== 제품 삭제 =====");
		
		System.out.print("삭제할 제품번호 입력 : ");
		int inputPId = sc.nextInt();
		
		boolean flag = false;
		int pIdDel = 0;
		
		for(int i = 0; i < pro.length; i++ ) {
			
			if(pro[i] != null) {
				if(inputPId == pro[i].getPId() ) {
					
					pIdDel = pro[i].getPId();
					
					pro[i] = null;
					flag = true;
					
					System.out.println("제품 번호 " + pIdDel + "이(가) 정상적으로 삭제 되었음");
					
					count--;
					
					return;
					
				}
			}
		}
		
		if(!flag) {
			System.out.println("등록된 제품이 없음. 제품 먼저 등록...");
		}
	}
}