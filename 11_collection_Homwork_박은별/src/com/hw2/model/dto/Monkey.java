package com.hw2.model.dto;

public class Monkey extends Animal {

	public Monkey() {}

	public Monkey(String name) {
		super(name);
	}
	
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println( getName() + "가 우끼끼 소리를 냅니다." );
	}
	
	
}
