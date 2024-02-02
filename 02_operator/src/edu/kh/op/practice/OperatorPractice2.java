package edu.kh.op.practice;

import java.util.Scanner;

public class OperatorPractice2 {
	
	public void practice1() {
		/* 키보드로 나이를 입력받아
		 * 20세 이상이면 "저는 성인입니다", 아니면 "저는 미성년 입니다" 출력
		 * 입력받은 값이 13세 이상이면서 19세 이하면 "청소년입니까? true" 출력 아니면 false 출력
		 * 입력받은 값이 65세 이상이거나 12세 이하이면 
		 * "노인이거나 어린이 입니까? true" 출력 아니면 false 출력
		 * 
		 * ex)
		 * 당신의 나이는 ? : 20
		 * 저는 성인입니다.
		 * 청소년 입니까? false
		 * 노인이거나 어린이 입니까? false
		 * 
		 * 당신의 나이는 ? : 13
		 * 저는 미성년입니다.
		 * 청소년 입니까? true
		 * 노인이거나 어린이 입니까? false
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("당신의 나이는 ? : ");
		int input1 = sc.nextInt();
		
		String result1 =  input1 >= 20 ? "성인" : "미성년";
		
		System.out.println("저는 " + result1 + " 입니다.");
		
		boolean result2 =  input1 >= 13 && input1 <= 19;
		
		System.out.printf("청소년입니까? %b\n", result2);
		
		boolean result3 =  input1 >= 65 || input1 <= 12;
		
		System.out.printf("노인이거나 어린이 입니까? %b\n", result3);
	}
}

