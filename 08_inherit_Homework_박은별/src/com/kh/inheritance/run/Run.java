package com.kh.inheritance.run;

import com.kh.inheritance.model.dto.*;

public class Run {

	public static void main(String[] args) {
		
		// SmartPhone 객체 생성
		SmartPhone sp = new SmartPhone("Samsung", "Galaxy S20", 2020, 1200000, "Android", 128);
		
		System.out.println("Brand : " + sp.getBrand());
		System.out.println("Model : " + sp.getModel());
		System.out.println("Year : " + sp.getYear());
		System.out.println("Price : " + sp.getPrice() + "원");
		System.out.println("Operating System : " + sp.getOperatingSystem());
		System.out.println("Storage Capacity : " + sp.getStorageCapacity() + "GB");
		
		System.out.println("==================================================");
		
		// BasicPhone 객체 생성
		BasicPhone bh = new BasicPhone("Nokia", "3310", 2000, 100000, true);
		
		System.out.println("Brand : " + bh.getBrand());
		System.out.println("Model : " + bh.getModel());
		System.out.println("Year : " + bh.getYear());
		System.out.println("Price : " + bh.getPrice() + "원");
		
		bh.checkKeyboard();
		
	}
}
