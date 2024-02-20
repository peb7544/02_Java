package com.hw2.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hw2.model.dto.Animal;

public class Zoo {

	private List<Animal> animals = new ArrayList<Animal>();
	private Scanner sc = new Scanner(System.in);
	
	public Zoo() {};
	
	public void addAnimal(Animal animal) {
		animals.add(animal);
	}
	
	public void showAnimals() {
		
		System.out.println("동물들의 울음소리를 들어보세요 :");
		for(Animal animal : animals) {
			animal.sound();
		}
	}
	
	public void displayMenu() {
		
		int num = 2;
		
		do {
			
			System.out.println("****** KH 동물원 ******");
			
			System.out.println("원하는 작업을 선택하세요 : ");
			System.out.println("1. 동물들의 울음소리 듣기");
			System.out.println("2. 종료");
			
			System.out.print("선택 : ");
			num = sc.nextInt();
			
			//sc.nextLine();
			
			switch(num) {
			case 1 : showAnimals(); break;
			case 2 : System.out.println("프로그램을 종료합니다."); break;
			default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			
		} while(num != 2);
	}
}
