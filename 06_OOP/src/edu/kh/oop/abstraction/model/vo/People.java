package edu.kh.oop.abstraction.model.vo;

/* MVC패턴(Model View Controller) : 하는 역할 별로 나누는 것
 * 
 * Model - 프로그램, 어플리케이션의 데이터, 비즈니스로직 담당
 * View - 사용자에게 데이터를 시각적으로 표현
 * Controller - model, view 간의 상호작용을 조정, 제어하는역할의 담당
 *            - 사용자의 입력 처리하고 대응하는 작업 담당
 * */

// VO(Value Object) : 값 저장용 객체를 만들기 위한 클래스를 모아두는 패키지

public class People {
	
	/* 클래스란? 객체의 특성(속성, 기능)을 정의한 것 
	 * == 객체를 만들기 위한 설계도
	 */ 
	
	/* 속성 == 값 == data
	 * 값을 저장하기 위한 변수 선언
	 * -> 국민이라면 공통적으로 가지고 있는 속성만 작성(추상화)
	 * ex) 이름, 성별, 주민번호, 주소, 전화번호, 나이
	 * */
	
	// 필드 == 필드변수 == 멤버변수 == 클래스 변수
	
	/* 캡슐화
	 * - 데이터와 기능을 하나로 묶어서 관리하는 기법
	 * - 데이터의 직접적인 접근을 제한 하는 것이 원칙이다.
	 * -> 직접 접근을 못하기 때문에
	 *    클래스 내부에 간접 접근 방법을 제공하는 기능을 작성해둔다.
	 *    -> getter/setter : 기능
	 * */
	
	/* **데이터 직접 접근 제한
	 * public(공공의) -> private(사적인, 개인적인) 변경 */
	
	/* public : 접근 제한자
	 * int : 자료형
	 * age : 변수명
	 * */
	
	// 국민(사람) 클래스
	
	// 속성
	//public String name; 
	//public char gender;
	//public String pNo; // "123456-1234567"
	//public String address;
	//public String phone; // "010-1234-1234"
	//public int age;
	// public double bitCoin; // 비트코인은 국민에게 꼭 필요한 것이 아니고, 공통점이 아니므로 제거
	
	private String name; // The value of the field People.name is not used
	private char gender;
	private String pNo; // "123456-1234567"
	private String address;
	private String phone; // "010-1234-1234"
	private int age;
	
	
	
	// 기능 == 행동 == mehod(메서드)
	public void tax() {
		System.out.println("세금을 냅니다...");
	}
	
	public void vote() {
		System.out.println("투표를 합니다... 꼭하세요!");
	}
	
	// 캡슐화에서 사용할 간접 접근 가눙(getter/setter)
	/* public      String   getName() 
	 * 접근제한자   반환형    메소드명
	 * 
	 * void, String... : 반환형 
	 * void : 반환형 값이 없을 때 (ex. return)
	 * String : String을 반환해줄 때
	 * */
	
	/* public String getName() {
		return name;
	}
	
	public void setName(String name) {
		
		// this.name : 필드에 있는 name을 가져오기 위해
		this.name = name;
	} */
	
	/* alt + shift + s 또는 상단 메뉴 Sorce 
	 * -> Generate Getters and Setters... 클릭
	 * -> selectAll -> generate
	 * */
	
	
	/* void : 반환할 값이 없다(반환형이 없다).
	 * <-> 반환할 값이 있을 경우 그 값의 자료형을 작성(반환형)
	 * */
	
	// name 변수의 값을 돌려 보내주는 간접 접근 기능
	public String getName() {
		return name;
	}

	/* name 변수에 값을 세팅하는 간접접근 기능*/
	public void setName(String name) {
		/* 매개변수 String name
		 * -> String 타입의 데이터를 전달받아 저장하고 있는 변수
		 * ** this : 현재 객체
		 * 맴버변수 name에 매개변수 name을 대입시키는 역할을 함
		 * */
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getpNo() {
		return pNo;
	}

	public void setpNo(String pNo) {
		this.pNo = pNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
