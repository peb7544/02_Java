package edu.kh.poly.ex2.model.vo;

public class Person extends Animal {
	/* The type Person must implement the inherited abstract method Animal.move()
	 * Animal의 추상메서드를 오버라이딩 하지 않으면 오류 발생 -> 강제화
	 * */
	
	private String name;
	
	// 생성자
	public Person() {}
	
	
	
	public Person(String type, String eatType, String name) {
		super(type, eatType);
		this.name = name;
	}

	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("숟가락, 젓가락 등 도구를 이용해서 먹는다.");
	}

	@Override
	public void breath() {
		// TODO Auto-generated method stub
		System.out.println("코와 입으로 숨쉰다.");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("두발로 걷는다.");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person : " + super.toString() + " / " + name;
	}
}
