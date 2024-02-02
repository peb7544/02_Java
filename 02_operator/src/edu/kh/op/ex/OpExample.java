package edu.kh.op.ex;

import java.util.Scanner;

// 예제 코드 작성용 클래스
public class OpExample {
	
	/* ex1() method : 객체 지향 프로그래밍에서 OpExample 객체와 관련된 함수
	 * -> OpExample이 가지고 있는 기능 중 ex1()이라는 기능
	 * */
	public void ex1() {
		// System.out.println("ex1() 호출 중");
		
		// 증감(증가, 감소) 연산자
		int iNum1 = 10;
		int iNum2 = 10;
		
		iNum1++; // iNum1 증가
		iNum2--; // iNum2 감소
		
		System.out.println("iNum1 : " + iNum1);
		System.out.println("iNum2 : " + iNum2);
		
		// 전위연산
		
		int temp1 = 5;
		System.out.println( ++temp1 + 5 ); // 11
		
		// 후위 연산
		int temp2 = 3;
		System.out.println( temp2-- + 2 ); //5
		
		System.out.println("temp2 : " + temp2);
		
		// 최종적으로 a, b, c는 얼마인가?
		int a= 3;
		int b = 5;
		int c = a++ + --b;
		
		System.out.printf("%d / %d / %d\n", a, b, c);
	}
	
	public void ex2() {
		/* 비교 연산자 : >, <, >=, ==, != 
		 * - 비교 연산자의 결과는 항상 논리값(true/false) 
		 * */
		
		int a =10;
		int b =20;
		
		System.out.println( a > b);
		
		/*() 괄호 안에 있는 것 먼저 연산
		 * false == false true*/
		System.out.println((a == b) == false);
		
		int c = 4;
		int d = 5;
		
		System.out.println( (++c != d) == (--c != d)) ;
	}
	
	public void ex3() {
		// 논리 연산자 : &&(AND), ||(OR)
		
		/* &&(AND) : 둘다 true면 true, 나머지는 false
		 * 와, 그리고, ~면서, ~이면서, ~부터, ~까지, ~사이
		 * */
		
		int a = 101;
		
		// a는 100 이상이면서 짝수인가?
		System.out.println( (a >= 100) && (a % 2 == 0) ); // false
		
		int b = 5;
		// b는 1부터 10까지 숫자 범위에 포함되어 있는가?
		System.out.println( (1 <= b) && (b <= 10) );
		
		System.out.println("-----------------------------------------------");
		
		/* ||(OR) : 둘다 false면 false, 나머지는 true(AND 반대)
		 * 또는, ~거나, ~이거나, ...*/
		
		int c = 10;
		
		// c는 10을 초과하거나 짝수인가?
		System.out.println( (c > 10) || (c % 2 == 0) );
		
	}
	
	public void ex4() {
		
		// 삼항 연산자 : 조건식 ? true 수행될 값 : false 수행될 값
		
		// * 조건식 : 연산 결과가 true/false인 식
		
		int num = 30;
		
		/* num이 30보다 크면(초과) "num은 30보다 큰 수이다."
		 * 아니면 "num은 30 이하의 수이다" 출력 */
		
		String reuslt = num > 30 ? "num은 30보다 큰 수이다." : "num은 30 이하의 수이다";
		
		System.out.println(reuslt);
		
		System.out.println("-----------------------------------------------");
		
		/* 입력 받은 정수가 음수인지 양수인지 구분
		 * 단, 0은 양수로 처리
		 * 
		 * ex) 
		 * 정수 입력 : 4
		 * 양수 입니다.
		 * 
		 * 정수 입력 : -5
		 * 음수 입니다.*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input1 = sc.nextInt();
		
		String result2 = input1 >= 0 ? "양수 입니다." : "음수 입니다.";
		System.out.printf(result2);
	}
}
