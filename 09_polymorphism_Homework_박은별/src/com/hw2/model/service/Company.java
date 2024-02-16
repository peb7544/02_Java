package com.hw2.model.service;

import com.hw2.model.dto.*;

public class Company implements ManagementSystem {

	private Employee[] employees; // 전체 직원 저장용
	
	private int employeeCount; // 직원 수
	
	public Company(int size) {
		employees = new Employee[size];
		
		employeeCount = 0;
	}
	
	/* 배열에 공간이 있다면, 해당 객체를
	 * employees 배열에 추가 후 추가된 객체의 정보를 출력
	 * 만약 배열에 더 이상 공간이 없다면, 인원이
	 * 모두 충원되었다는 메시지 출력
	 * */
	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		if((employeeCount+1) == employees.length ) {
			System.out.println("인원이 모두 충원되었다.");
			
			return;
		}
		
		employees[employeeCount] = (Employee) person;
		
		System.out.println("직원이 추가되었습니다. - " + employees[employeeCount].getInfo());
		
		employeeCount++;
	}

	/* 매개변수로 전달받은 id와 일치하는 직원을 찾으면,
	 * 해당 직원을 삭제하고 관련 정보를 출력.
	 * 일치하는 id가 없다면 해당 id를 가진 직원을 찾을 수 없다는
	 * 메시지 출력
	 * */
	@Override
	public void removePerson(String id) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < employeeCount; i++) {
			if( id == employees[i].getId() ) {
				
				System.out.println("직원이 삭제되었습니다. - " + employees[i].getInfo());
				
				employees[i] = null;
				
				employeeCount--;
				
				return;
			}
		}
	}

	// 전체 직원 명단을 출력하는 기능
	@Override
	public void displayAllPersons() {
		
		System.out.println("전체 수감자 명단 : ");
		
		for(int i = 0; i < employeeCount; i++) {
			
			System.out.println(employees[i].getInfo());
		}
	}

}
