package edu.kh.oop.cls.model.vo;

public class User {
	/*속성(필드)
	 * 아이디, 비번, 이름, 나이, 성령 (추상화진행)
	 * 데이터 직접접근 불가원칙 -> 필드는 기본적으로 모두 priveate(캡츌화 지정)
	 */
	private String userId;
	private String userPw;
	private String userName;
	private int userAge;
	private char userGender;
	
	/*기능 (생성자 메서드)
	 * 
	 * 생성자 : new 연산자를 통해서 객체가 생성될 대
	 *          생성된 객체의 필드값 + 초기촤 기능수행 역할
	 * */
	
	//기본 생성자
	public User() {
		// 기능
		System.out.println("기본 생성자로 User 객체 생성");
		
		// 필드초기화
		userId = "user01";
		userPw = "pass01";
		userName = "홍길동";
		userAge = 20;
		userGender = '남';
				
	}
	
	
	/* 매개변수 생성자 
	 * ** 사용되는 기술, 변수 : 매개변수, Overloading(오버로딩), this
	 * 
	 * ** 매개변수 : 생성자나 메서드 호출 시 () 안에 작성되어
	 *               전달되어지는 값을 저장하고 있는 변수
	 * */
	
	public User(String userId, String userPw) {
		System.out.println("매개변수 생성자를 이용해서 User 객체 생성");
		System.out.println(userId + "/" + userPw);
		
		// 필드 = 매개변수
		
		/* this 참조변수
		 * - 객체가 자기 자신을 참조할 수 있도록하는 변수
		 * - 모든 객체 내부에 숨겨져 있다.
		 * 
		 * 왜 사용?
		 * -> 필드명과 매개변수명이 같은 경우
		 *    이를 구분하기 위해서 사용한다.
		 * */
		this.userId = userId;
		this.userPw = userPw;
	}
	
	
	// 필드를 전부 초기화하는 목적의 매개변수 생성자
	public User(String userId, String userPw, String userName,
			int userAge, char userGender) {
		
		/* this() 생성자
		 * 같은 클래스의 다른 생성자를 호출
		 * 생성자 내에서 반드시 첫째 줄에 작성해야만 한다! 위에 다른 코드 쓰면 에러
		 * Constructor call must be the first statement in a constructor
		 * 
		 * 왜 사용?
		 * 중복 코드 제거, 코드 길이 감소, 재사용성 증가....
		 * 가독성이 좀 떨어지는 경우가 있다(단점).
		 * */
		
		//this.userId = userId;
		
		this(userId, userPw);
		
		//this.userId = userId;
		//this.userPw = userPw;
		this.userName = userName;
		this.userAge = userAge;
		this.userGender = userGender;
	}
	

	/* 자바는 기본적으로 필드명, 생성자명, 매서드명, 변수명의
	 * 중복을 허용하지 않음.
	 * 
	 * ** 오버로딩(Overloading)
	 * - 클래스 내에 동일한 이름의 메서드(생성자)를
	 * 여러개 작성하는 기법
	 * 
	 * -> 하나의 이름으로 여러 기능을 수행할 수 있게 하는 것
	 * 
	 * [ 오버로딩 조건 ]
	 * 1) 메서드의 이름이 동일
	 * 2) 매개변수의 개수, 타입, 순서 중 1개라도 달라야 함.
	 * 
 	 * */
	
	 //public User() {} // 기본 생성자가 이미 작성되어있어서 중복상태
	
	 /* 매개변수의 개수가 같은 생성자 없음
	  * 오버로딩 성립
	  * */
	 public User(String userId) {} 
	 
	 /* 매개변수의 개수는 같지만 타입이 다름
	  * 오버로딩 성립
	  * */
	 public User(int userAge) {}
	 
	 // 매개변수의 개수가 동일한 것이 있으나 하나의 타입이 다름
	 public User(String userId, int userAge) {}
	 
	 // 매개변수의 개수, 타입은 같지만 순서가 다름
	 public User(int userAge, String userId) {}
	 
	 /* 매개변수의 개수, 타입, 순서가 모두 같아서 오버로딩 불가
	  * -> 변수명은 신경쓰지 않는다.
	  * */
	 //public User(int userAge, String userName) {}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public char getUserGender() {
		return userGender;
	}

	public void setUserGender(char userGender) {
		this.userGender = userGender;
	}
}
