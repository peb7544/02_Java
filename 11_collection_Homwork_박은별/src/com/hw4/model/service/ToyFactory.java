package com.hw4.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.hw4.model.dto.Toy;

import java.util.Scanner;
import java.util.Set;

/**
 * 장난감 공장을 모델링하고, 장난감 관리 기능을 제공하는
 * 서비스 클래스입니다.
 */
public class ToyFactory {
	
	private Scanner sc = new Scanner(System.in);
	
	Map<Integer, String> map = new HashMap<Integer, String>();
	Set<Entry<Integer, String>> entrySet = map.entrySet();
	
	List<Toy> toys = new ArrayList<Toy>();

	/**
	 * 기본 생성자
	 * 
	 * - 기본 등록된 재료
	 * - 현재 제작된 장남감 목록
	 */
	public ToyFactory() {
		
		// 기본 등록된 재료
		map.put(1, "면직물");
		map.put(2, "플라스틱");
		map.put(3, "유리");
		map.put(4, "고무");
		
		// 현재 제작된 장난감 목록
		Collections.addAll(toys, 
				new Toy("마이롱레그", 8, 36000, "분홍색", 19950805, "1,4" ),
				new Toy("허기워이", 5, 12000, "파란색", 19940312, "1,2" ),
				new Toy("키시미시", 5, 15000, "분홍색", 19940505, "1,2" ),
				new Toy("캣냅", 8, 27000, "보라색", 19960128, "1,2" ),
				new Toy("파피", 12, 57000, "빨간색", 19931225, "1,2,4")
				);
	}
	
	
	/**
	 * 장난감 메뉴
	 */
	public void displayMenu() {
		
		int num = 0;
		
		do {
			
			System.out.println("\n<<플레이타임 공장>>");
			
			System.out.println("1. 전체 장남감 조회하기");
			System.out.println("2. 새로운 장남감 만들기");
			System.out.println("3. 장남감 삭제하기");
			System.out.println("4. 장난감 제조일 순으로 조회하기");
			System.out.println("5. 연령별 사용 가능한 장난감 리스트 조회하기");
			System.out.println("6. 재료추가");
			System.out.println("7. 재료제거");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("선택 : ");
			num = sc.nextInt();
			
			switch(num) {
			case 1 : System.out.println(selToy()); break;
			case 2 : System.out.println(addToy()); break;
			case 3 : System.out.println(delToy()); break;
			case 4 : break;
			case 5 : break;
			case 6 : break;
			case 7 : break;
			case 0 : System.out.println("프로그램을 종료하겠습니다."); break;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); break;
			}
			
		} while(num != 0);
	}
	
	/**
	 * 전체 장난감 조회하기
	 */
	public String selToy() {
		
		System.out.println("\n<전체 장남감 목록>");
		
		if(toys.isEmpty()) {
			return "등록된 장난감이 없습니다.";
		}
		
		int index = 0;
		String allToy = "";
		
		for(Toy toy : toys) {
			
			index = toys.indexOf(toy);
			
			// 재료
			String ingredint = toy.getIngredient();
			String[] arr = ingredint.split(",");
			String result = "";
			
			int i = 0;
			for(String str : arr) {
				result += map.get(Integer.parseInt(str));
				
				if(i != (arr.length-1)) {
					result += ", ";
				}
					
				i++;
			}
			
			allToy += (index+1) + ". " + toy + result + "\n";
		}
		
		return allToy;
	}
	
	/**
	 * 새로운 장난감 만들기
	 * 
	 * <pre>
	 * - 똑같은 장난감을 만들 수 없다.
	 * - 장남감을 저장할 컬렉션에 중복된 장난감이 있어서는 안된다.
	 * </pre>
	 */
	public String addToy() {
		System.out.println("\n<새로운 장난감 추가>");
		
		if(toys.isEmpty()) {
			return "등록된 장난감이 없습니다.";
		}
		
		System.out.print("장난감 이름 : ");
		String toyNm = sc.next();
		
		/* 똑같은 장난감을 만들 수 없다.
		 * 장남감을 저장할 컬렉션에 중복된 장난감이 있어서는 안된다.
		 * */ 
		for(Toy toy : toys) {
			
			if(toy.getToyNm().equals(toyNm)) {
				return "똑같은 장난감을 만들수 없습니다.";
			}
		}
		
		System.out.print("사용 가능 연령 : ");
		int age = sc.nextInt();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		System.out.print("색상 : ");
		String color = sc.next();
		
		System.out.print("제조일(YYYYMMDD 형식으로 입력) : ");
		int date = sc.nextInt();
		
		String ingredientRe = "";
		
		while(true) {
			
			System.out.print("재료를 입력하세요 (종료하려면 'q'를 입력하세요.) : ");
			String ingredient = sc.next();
			
			if( ( ingredientRe.length() != 0 ) || ingredient.equals("Q") ) {
				ingredientRe += ",";
			}
			
			if(ingredient.equals("Q") || ingredient.equals("q")) {
				break;
			} else {
				
				// 등록된 재료 찾기
				for(Entry<Integer, String> entry : entrySet) {
					
					if( entry.getValue().equals(ingredient) ) {
						ingredientRe += Integer.valueOf(entry.getKey()).toString();
					} else {
						
						// 재료 추가
						
					}
				}
				
			}
		}
		
		toys.add(new Toy(toyNm, age, price, color, date, ingredientRe));
		
		return "새로운 장난감이 추가되었습니다.";
	}
	
	/**
	 * 장난감 삭제하기
	 */
	public String delToy() {
		
		System.out.println("\n<장난감 삭제하기>");
		
		if(toys.isEmpty()) {
			
			return "등록된 장난감이 없습니다.";
		}
		
		System.out.print("삭제할 장난감의 이름을 입력하세요 : ");
		String inputToyNm = sc.next();
		
		boolean flag = false;
		for(Toy toy : toys) {
			
			int index = toys.indexOf(toy);
			if(toy.getToyNm().equals(inputToyNm)) {
				
				
				System.out.println("index : " + index);
				
				toys.remove(index);
				
				flag = true;
			}
		}
		
		if(!flag) {
			
			return inputToyNm + "으로 등록된 장난감은 없습니다.";
		}
		
		return "장난감이 삭제되었습니다.";
	}
}
