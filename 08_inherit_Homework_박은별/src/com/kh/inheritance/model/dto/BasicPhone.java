package com.kh.inheritance.model.dto;

public class BasicPhone extends Phone {

	// 속성(필드)
	private boolean hasPhysixalKeyboard; //물리적 키도드 유무
	
	// 기능
	
	// 기본생성자
	public BasicPhone() {}

	// 매개변수 생성자
	public BasicPhone(String brand, String model, int year, int price, boolean hasPhysixalKeyboard) {
		super(brand, model, year, price);
		this.hasPhysixalKeyboard = hasPhysixalKeyboard;
	}
	
	// getter setter
	public boolean getHasPhysixalKeyboard() {
		
		return hasPhysixalKeyboard;
	}
	
	public void setHasPhysixalKeyboard(boolean hasPhysixalKeyboard) {
		
		this.hasPhysixalKeyboard = hasPhysixalKeyboard;
	}
	
	// 메서드
	public void checkKeyboard() {
		if( hasPhysixalKeyboard ) 
			System.out.println("이 휴대폰은 물리적 키보드가 있습니다.");
	}
	
}
