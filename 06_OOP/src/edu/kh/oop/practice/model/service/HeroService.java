package edu.kh.oop.practice.model.service;

import edu.kh.oop.practice.model.vo.Hero;

// 기능제공용 클래스
public class HeroService {
	
	public void ex1() {
		
		Hero hero1 = new Hero();
		
		hero1.setNickName("난용사임");
		hero1.setJob("전사");
		hero1.setHp(100);
		hero1.setMp(50);
		hero1.setLevel(1);
		hero1.setExp(100);
		
		System.out.println("닉네임 : " + hero1.getNickName());
		System.out.println("직업 : " + hero1.getJob());
		System.out.println("체력 : " + hero1.getHp());
		System.out.println("마력 : " + hero1.getMp());
		System.out.println("레벨 : " + hero1.getLevel());
		System.out.println("경험치 : " + hero1.getExp());
		
		System.out.println("==============================");
		
		// 경험치
		hero1.attack(100);
		hero1.attack(100);
		hero1.attack(100);
		hero1.attack(100);
		hero1.attack(100);
		
		System.out.println("==============================");
		
		// 점프
		hero1.magicJump();
		hero1.magicJump();
		hero1.magicJump();
		hero1.magicJump();
		hero1.magicJump();
		hero1.magicJump();
		
		System.out.println("==============================");
		System.out.println("==============================");
		
		Hero hero2 = new Hero();
		
		hero2.setNickName("힐링");
		hero2.setJob("성직자");
		hero2.setHp(100);
		hero2.setMp(150);
		hero2.setLevel(2);
		hero2.setExp(150);
		
		System.out.println("닉네임 : " + hero2.getNickName());
		System.out.println("직업 : " + hero2.getJob());
		System.out.println("체력 : " + hero2.getHp());
		System.out.println("마력 : " + hero2.getMp());
		System.out.println("레벨 : " + hero2.getLevel());
		System.out.println("경험치 : " + hero2.getExp());
		
		System.out.println("==============================");
		
		// 경험치
		hero2.attack(100);
		hero2.attack(100);
		hero2.attack(100);
		hero2.attack(100);
		hero2.attack(100);
		
		System.out.println("==============================");
		
		// 점프
		hero2.magicJump();
		hero2.magicJump();
		hero2.magicJump();
		hero2.magicJump();
		hero2.magicJump();
		hero2.magicJump();
		
	}
}
