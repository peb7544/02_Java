package com.hw2.run;

import com.hw2.model.dto.*;
import com.hw2.model.service.*;

public class Run {
	
	public static void main(String[] args) {
		/* Company의 생성자를 이용하여 10칸 짜리 Enployee 객체배열 생성하는 
		 * Company 객체를 생성하여 ManagementSytem 자료형의 company에 주소를 저장
		 * */
		ManagementSystem company = new Company(10);
		
		/* Prison의 생성자를 이용하여 10칸 짜리 Prison 객체배열 생성하는 
		 * Prison 객체를 생성하여 ManagementSytem 자료형의 Prison에 주소를 저장
		 * */
		ManagementSystem prison = new Prison(10);
		
		// 2명 정도 직원 새로 등록하기
		Person[] employee = new Employee[2];
		
		employee[0] = new Employee("EMP001", "유재석","기획팀");
		employee[1] = new Employee("EMP002", "정형돈","개발팀");
		
		for(int i = 0; i < employee.length; i++) {
			company.addPerson(employee[i]);
		}
		
		// 등록된 전체 직원 조회
		company.displayAllPersons();
		
		System.out.println("=========================================================================");
		
		// 2명 정도 수감자 새로 등록하기
		Person[] prisoner = new Prisoner[2];
		
		prisoner[0] = new Prisoner("1205", "정준하","밥도둑");
		prisoner[1] = new Prisoner("0705", "박명수","웃음연쇄살인");
		
		for(int i = 0; i < prisoner.length; i++) {
			prison.addPerson(prisoner[i]);
		}
		
		// 등록된 전체 수감자 조회
		prison.displayAllPersons();
		
		System.out.println("=========================================================================");
		
		// EMP001 id를 가진 직원 삭제
		company.removePerson("EMP001");
		
		// 1205 id를 가진 수감자 삭제
		
		// 현재 남은 직원 모두 조회
		
		// 현재 남은 수감자 모두 조회
	}

}
