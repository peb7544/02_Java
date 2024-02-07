package edu.kh.oop.basic;

public class Account {

	/* 이름 name
	 * 계좌번호 accountNumber
	 * 잔액 balance
	 * 비밀번호 password
	 * 
	 * (추상화/캡슐화)
	 * 
	 * 메서드
	 * getter/setter
	 * deposit(amount) : 전달받은 금액을 잔액에 누적한 후,
	 *             현재 잔액을 콘솔에 출력
	 * wihdraw(pw, amount) : 비밀번호와 출금할 금액을 전달받아와,
	 *             조건에 맞으면 현재 잔액 출력
	 *             1) 비밀번호 일치 X "비밀번호 불일치" 출력
	 *             2) 출금할 금액이 잔액보다 크면 "잔액 부족" 출력
	 * */
	
	// 속성(값)
	private String name;
	private String accountNumber;
	private long balance;
	private String password;
	
	// 기능
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// 입금
	public void deposit(long amount) {
		
		balance += amount;
		System.out.println("현재 잔액 : " + balance);
		
//		long balance = getBalance();
//		
//		long result = balance += amount;
//		
//		setBalance(result);
//		
//		System.out.println(result);
	}
	
	// 출금
	public void wihdraw(String pw, long amount) {
//		String password = getPassword();
//		long balance = getBalance();
		
		if(!password.equals(pw)) {
			System.out.println("비밀번호 불일치");
			
			return; // 메서드 종료 -> 호출한 곳으로 돌아감
		} 
		
		// 출금한 금액이 잔액보다 큰 경우
		if(balance < amount) {
			System.out.println("잔액 부족");
			
			return;
		} 
		
		// 잔액을 출금할 금액 만큼 차감
		balance -= amount;
		
		System.out.println("현재 잔액 : " + balance);
	}
}
