package edu.kh.oop.practice.snack.view;

import java.util.Scanner;

import edu.kh.oop.practice.snack.controller.SnackController;

public class SnackMenu {
	
	private Scanner sc = new Scanner(System.in);
	
	private SnackController snackController = new SnackController();
	
	// 사용자가 Snack객체에 데이터를 저장할 수 있도록 값을 받고 저장한 값을 출력하는 메소드
	public void menu() {
		System.out.println("스낵류를 입력하세요.");
		
		System.out.print("종류 : ");
		String kind = sc.next();
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("맛 : ");
		String flavor = sc.next();
		
		System.out.print("개수 : ");
		int numOf = sc.nextInt();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		System.out.println( snackController.savaData(kind, name, flavor, numOf, price) );
		
		System.out.print("저장한 정보를 확인하시겠습니까?(y/n) : ");
		String input = sc.next();
		
		if(input.equals("y")) {
			System.out.println(snackController.confirmData());
		}
	}
}
