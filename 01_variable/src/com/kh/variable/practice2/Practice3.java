package com.kh.variable.practice2;

import java.util.Scanner;

public class Practice3 {
	public void ex2() {
		
		/* 실수형으로 국어, 영어, 수학
		 * 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
		 * 이 때 총점과 평균은 정수형으로 처리하세요.
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수 : ");
		double input1 = sc.nextDouble();
		
		System.out.print("영어 점수 : ");
		double input2 = sc.nextDouble();
		
		System.out.print("수학 점수 : ");
		double input3 = sc.nextDouble();
		
		double result = input1 + input2 + input3;
		
		System.out.printf("총점 : %d\n", (int)result);
		System.out.printf("평균 : %d\n", (int)(result/3));
		
//		System.out.printf("총점 : %.0f\n", result);
//		System.out.printf("평균 : %.0f\n", result/3);
	}
	
	public void ex3() {
		
		/* sc.Next() 와 sc.NextLine()의 차이
		 * 
		 * next() : 띄어쓰기 입력 불가,띄어쓰기를 구분인자로 생각하여 각각 저장
		 * nextLine() : 문자열에 띄어쓰기 가능, 줄구분까지 저장
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 입력 1 : ");
		String input1 = sc.nextLine();
		
		System.out.print("문자열 입력 2 : ");
		String input2 = sc.next();
		
		System.out.println(input1);
		System.out.println(input2);
	}
	
	public void ex4( ) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input1 = sc.nextInt();
		
		System.out.println(input1);
		
		/* 입력 버퍼에서 '\n' 개행이 남아있기 때문에 오류 
		 * 그래서 개행문자 남은 문자를 제거해야 한다.
		 **/
		
		// 입력 버퍼에 남은 개행문자 제거
		sc.nextLine(); 
		
		System.out.print("문자열 입력 : ");
		String input2 = sc.nextLine();
		
		System.out.println(input2);
	}
}
