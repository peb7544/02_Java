package edu.kh.oop.practice.snack.controller;

import edu.kh.oop.practice.snack.model.vo.Snack;

public class SnackController {
	
	private Snack snack = new Snack();
	
	// 기본 생성자
	public SnackController() { }
	
	// 데이터를 setter를 이용해 저장하고 저장완료되었다는 결과를 반환하는 메서드
	public String savaData(String kind, String name, String flavor, int numOf, int price) {
		
		snack.setKind(kind);
		snack.setName(name);
		snack.setFlavor(flavor);
		snack.setNumOf(numOf);
		snack.setPrice(price);
		
		//System.out.println("저장 완료되었습니다.");
		
		return "저장 완료되었습니다.";
	}
	
	// 저장된 데이터를 반환하는 메소드
	public String confirmData() {
		
		return snack.getKind() 
				+ "(" + snack.getName() + " - "+ snack.getFlavor() + ") " 
				+ snack.getNumOf() + "개 "
				+ snack.getPrice() + "원";
	}
}
