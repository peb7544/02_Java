package edu.kh.control.loop;

import java.util.Scanner;

// 기능제공용 클래스
public class ForExample {
	
	/* for문
	 * - 끝이 정해져 있는(횟수가 지정되어 있는) 반복문
	 * 
	 * [ 작성법 ]
	 * 
	 * for(초기식; 조건식; 증감식;) {
	 * 	   조건식이 true라면 반복 수행할 코드
	 * }
	 * 
	 * - 초기식 : for 문을 제어하는 용도의 변수 선언
	 * 
	 * - 조건식 : for 문의 반복 여부를 지정하는 식.
	 *            보통 초기식에 사용되는 변수를 이용하여 조건식을 작성함.
	 *            
	 * - 증감식 : 초기식에 사용된 변수를 
	 *            for 문이 끝날 때 마다 증가 또는 감소시켜
	 *            조건식의 결과를 변하게 하는 식
	 * */
	Scanner sc = new Scanner(System.in);
	
	public void ex1() {
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}
	
	public void ex2() {
		// 1부터 입력받은 수 까지 1씩 증가하며 출력
		System.out.print("입력번호 : ");
		int input = sc.nextInt();
		
		for(int i = 1; i <= input; i++) {
			System.out.println(i);
		}
		
	}
	
	public void ex3() {
		// 영어 알파벳 A부터 Z까지 한줄로 출력
		
		// char 자료형은 문자형이지만 실제로 정수(문자표 번호를 저장한다.
		for(int i = 'A'; i <= 'Z'; i++) {
			System.out.print((char)i);
		}
		
		System.out.println();
		
		for(char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i);
		}
	}
	
	public void ex4() {
		/* 정수 5개를 입력 받아서 합계 구하기
		 * 
		 * ex)
		 * 입력 1 : 10
		 * 입력 2 : 20
		 * 입력 3 : 30
		 * 입력 4 : 40
		 * 입력 5 : 50
		 * 합계 150
		 * */
		
		int sum = 0;
		
		for(int i = 1; i <= 5; i++) {
			System.out.print("입력" + i + " : ");
			int input = sc.nextInt();
			
			// sum에 입력받은 input 값 누적
			sum += input;
		}
		
		System.out.println("합계 : " + sum);
		
	}
	
	public void ex5() {
		/* 1부터 20까지 1씩 증가하면서 출력
		 * 단, 입력받은 수의 배수는 양쪽에 () 표시
		 * 
		 * ex) 
		 * 괄호를 표시할 배수 : 3
		 * 1 2 (3) 4 5 (6) 7 .. 20
		 * */
		
		System.out.print("괄호를 표시할 배수 : ");
		int num = sc.nextInt();
		
		for(int i = 1; i <= 20; i++) {
			
			if(i % num == 0) {
				System.out.print("(" + i + ") ");
			} else {
				System.out.print(i + " ");
			}
			
		}
	}
	
	public void ex6() {
		
		/* [구구단 출력]
		 * 2~9 사이 수를 하나 입력받아
		 * 해당 단을 출력
		 * 단, 입력받은 수가 2~9 사이 숫자가 아니면
		 * "잘못 입력하셨습니다" 출력
		 * */
		
		System.out.print("단 입력 : ");
		int dan = sc.nextInt();
		
		if(dan >= 2 && dan <= 9 ) {
			for(int i = 1; i <= 9; i ++) {
				System.out.printf("%d X %d = %d \n", dan, i, (dan * i));
			}
		} else {
			System.out.println("잘못 입력하셨습니다");
		}
	}
	
	public void ex7() {
		// 구구단 모두 출력하기
		
		/*
		 * 2 X 1 =  2  2 X 2 =  4  2 X 3 =  6  2 X 4 =  8  2 X 5 = 10  2 X 6 = 12  2 X 7 = 14  2 X 8 = 16  2 X 9 = 18  
		 * 3 X 1 =  3  3 X 2 =  6  3 X 3 =  9  3 X 4 = 12  3 X 5 = 15  3 X 6 = 18  3 X 7 = 21  3 X 8 = 24  3 X 9 = 27  
		 * 4 X 1 =  4  4 X 2 =  8  4 X 3 = 12  4 X 4 = 16  4 X 5 = 20  4 X 6 = 24  4 X 7 = 28  4 X 8 = 32  4 X 9 = 36  
		 * 5 X 1 =  5  5 X 2 = 10  5 X 3 = 15  5 X 4 = 20  5 X 5 = 25  5 X 6 = 30  5 X 7 = 35  5 X 8 = 40  5 X 9 = 45  
		 * 6 X 1 =  6  6 X 2 = 12  6 X 3 = 18  6 X 4 = 24  6 X 5 = 30  6 X 6 = 36  6 X 7 = 42  6 X 8 = 48  6 X 9 = 54  
		 * 7 X 1 =  7  7 X 2 = 14  7 X 3 = 21  7 X 4 = 28  7 X 5 = 35  7 X 6 = 42  7 X 7 = 49  7 X 8 = 56  7 X 9 = 63  
		 * 8 X 1 =  8  8 X 2 = 16  8 X 3 = 24  8 X 4 = 32  8 X 5 = 40  8 X 6 = 48  8 X 7 = 56  8 X 8 = 64  8 X 9 = 72  
		 * 9 X 1 =  9  9 X 2 = 18  9 X 3 = 27  9 X 4 = 36  9 X 5 = 45  9 X 6 = 54  9 X 7 = 63  9 X 8 = 72  9 X 9 = 81 	
		 * */
		for(int x = 2; x <= 9; x++) {
			
			for(int y = 1; y <= 9; y++) {
				System.out.printf("%d X %d = %2d  ", x, y, (x * y));
			}
			
			System.out.println();
		}
		
		System.out.println("========== 역순출력 ==========");
		
		for(int x = 9; x >= 2; x--) {
			
			for(int y = 1; y <= 9; y++) {
				System.out.printf("%d X %d = %2d  ", x, y, (x * y));
			}
			System.out.println();
		}
	}
	
	public void ex8() {
		// 숫자 세기 count
		
		/* 1부터 20까지 1씩 증가하면서
		 * 입력받은 수의 배수의 총 개수 출력
		 * 입력받은 수의 배수의 합계 출력
		 * 
		 * ex)
		 * 배수 입력 : 3
		 * 3 6 9 12 15 18 : 6개
		 * 3의 배수 합계 : 63
		 * */
		
		System.out.print("배수 입력 : ");
		int num = sc.nextInt();
		
		int count = 0;
		int sum = 0;
		String result = "";
		
		for(int i = 1; i <= 20; i++) {
			
			if(i % num == 0) {
				//System.out.print(i + " ");
				result += i + " ";
				sum += i;
				
				count++;
			}
		}
		
		//System.out.println(": " + count + "개");
		System.out.printf("%s: %d개\n", result, sum);
		System.out.printf("%d의 배수 합계 : %d\n", num, sum);
	}

}
