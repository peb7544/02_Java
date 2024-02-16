package com.hw2.model.service;

import com.hw2.model.dto.*;

public class Prison implements ManagementSystem {
	
	private Prisoner[] prisoners; // 전체 수용자 저장용 배열
	
	private int prisonercount = 0; // 수용자수

	public Prison(int size) {
		prisoners = new Prisoner[size];
		
		prisonercount = 0;
	}
	
	/* 배열에 공간이 있다면
	 * 해당 객체를 prisoners 배열에 추가 후 
	 * 추가된 객체의 정보를 출력
	 * 만약 배열에 더 이상 곤간이 없다면,
	 * 인원이 모두 충원되었다는 메시지 출력
	 * */
	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		
		if((prisonercount+1) == prisoners.length ) {
			System.out.println("인원이 모두 충원되었다.");
			
			return;
		}
		
		prisoners[prisonercount] = (Prisoner) person;
		
		System.out.println("수감자가 추가되었습니다. - " + prisoners[prisonercount].getInfo());
	
		prisonercount++;
	}

	/* 매개변수로 전달받은 id와 일치하는 수감자를 찾으면,
	 * 해당 수감자를 삭제하고 관련 정보를 출력
	 * 일치하는 id가 없다면
	 * 해당 id를 가진 수감자를 찾을 수 없다는 메시지를 출력
	 * */
	@Override
	public void removePerson(String id) {
		// TODO Auto-generated method stub
		
	}

	// 전체 수감자 명단을 출력하는 기능
	@Override
	public void displayAllPersons() {
		// TODO Auto-generated method stub
		System.out.println("전체 수감자 명단 : ");
		
		for(int i = 0; i < prisonercount; i++) {
			
			System.out.println(prisoners[i].getInfo());
		}
	}
}
