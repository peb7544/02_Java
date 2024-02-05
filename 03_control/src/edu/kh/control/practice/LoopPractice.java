package edu.kh.control.practice;

import java.util.Scanner;

public class LoopPractice {
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		
		/* 사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력
		 * 단, 입력한 수는 1보다 크거나 같아야 합니다.
		 * 만일 1미만의 숫자가 입력됐다면 "1이상의 숫자를 입력해주세요"를 출력하세요.
		 * 
		 * ex)
		 * 1 이상의 숫자를 입력하세요 : 4
		 * 1 2 3 4
		 * 
		 * 1 이상의 숫자를 입력하세요 : 0
		 * 1 이상의 숫자를 입력해주세요.
		 * */
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num >= 1) {
			String result = "";
			for(int i = 1; i <= num; i++) {
				result += i + " ";
			}
			System.out.println(result);
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
	}
	
	public void practice2() {
		/* 사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요.
		 * 단, 입력한 수는 1보다 크거나 같아야 합니다.
		 * 
		 * ex)
		 * 1 이상의 숫자를 입력하세요 : 4
		 * 4 3 2 1
		 * 
		 * 1 이상의 숫자를 입력하세요 : 0
		 * 1 이상의 숫자를 입력해주세요.
		 * */
		
		System.out.print("1 이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		String result = "";
		
		if(num >= 1) {
			for(int i = num; i >= 1; i--) {
				result += i + " ";
			}
			
			System.out.println(result);
		} else {
			System.out.println("1 이상의 숫자를 입력하세요");
		}
	}
	
	public void practice3() {
		
		/* 1부터 사용자에게 입력 받은 수까지 정수들의 합을
		 * for문을 이용하여 출력하세요.
		 * 
		 * ex)
		 * 정수를 하나 입력하세요 : 8
		 * 1 + 2 + 3 + 4 + 5 + 7 + 8 = 36*/
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		String result = "";
		
		for(int i = 0; i <= num; i++) {
			result += num;
		}
	}
}
