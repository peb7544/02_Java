package com.hw1.run;

import com.hw1.model.vo.*;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		
		/* 1. 3명의 학생 정보를 기록할 수 있게
		 * 객체 배열을 할당하고 아래의
		 * 사용데이터를 참고하여 3명의 학생 객체
		 * 생성 후 반복문을 통해 출력
		 * */
		
		// 3명의 학생 정보를 기록할 수 있게 객체 배열 할당
		Student std[] = new Student[3];
		
		// 위의 사용데이터 참고하여 3명의 학생 정보 초기화
		std[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
		std[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
		std[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");
		
		for(int i = 0; i < std.length; i++) {
			
			System.out.println(std[i].information());
			
			System.out.println("---------------------");
		}
		
		/* 2. 최대 10명의 사원 정보를 기록할 수 있게
		 * 객체 배열을 할당하고 반복문을 사용하여 키보드로
		 * 사원 정보를 입력받도록 구현
		 * 2명 정도의 사원 정보를 입력받아 각 객체에 저장하고
		 * 현재까지 기록된 사원들의 정보 출력
		 * */
		
		// 최대 10명의 사원 정보를 기록할 수 있게 배열을 할당
		Employee emp[] = new Employee[10];
		
		// 사원들의 정보를 키보드로 계속 입력받고 -> while(true) 무한 반복문을 통해
		Scanner sc = new Scanner(System.in);
		
		int cnt = 0;
		
		while(true) {
			
			System.out.println("==== 사원정보 ====");
			
			System.out.print("이름 : ");
			String name = sc.next();
			
			System.out.print("나이 : ");
			int age = sc.nextInt();
			
			System.out.print("신장 : ");
			double height = sc.nextDouble();
			
			System.out.print("몸무게 : ");
			double weight = sc.nextDouble();
			
			System.out.print("급여 : ");
			int salary = sc.nextInt();
			
			System.out.print("부서 : ");
			String dept = sc.next();
			
			emp[cnt] = new Employee(name, age, height, weight, salary, dept);
			
			cnt++;
			
			System.out.print("사원정보 추가(y/n) : ");
			char empAdd = sc.next().charAt(0);
			
			if(empAdd != 'y' && empAdd != 'Y') break;
		}
		
		/* 2명 정도의 사원 정보를 입력 받아 객체 배열에 저장
		 * 현재 기록된 사원들의 정보를 모두 츨력
		 * */
		
		for(int i = 0; i < cnt; i++) {
			
			System.out.println( emp[i].information() );
			
			System.out.println("---------------------");
		}
	}
}
