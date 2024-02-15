package com.kh.inheritance.model.dto;

public class SmartPhone extends Phone {

	// 속성(필드)
	private String operatingSystem; // OS
	private int storageCapacity; // 스토리지공간크기
	
	// 기능
	
	// 기본생성자
	public SmartPhone() {}

	// 매개변수 생성자
	public SmartPhone(String brand, String model, int year, int price, String operatingSystem, int storageCapacity) {
		super(brand, model, year, price);
		this.operatingSystem = operatingSystem;
		this.storageCapacity = storageCapacity;
	}
	
	// getter setter
	public String getOperatingSystem() {
		
		return operatingSystem;
	}
	
	public void setOperatingSystem(String operatingSystem) {
		
		this.operatingSystem = operatingSystem;
	}
	
	public int getStorageCapacity() {
		
		return storageCapacity;
	}
	
	public void setStorageCapacity(int storageCapacity) {
		
		this.storageCapacity = storageCapacity;
	}
	
	// 메서드
	@Override
	public void printInfo() {
		
	}
}
