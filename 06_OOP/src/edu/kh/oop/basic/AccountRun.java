package edu.kh.oop.basic;

public class AccountRun {
	
	public static void main(String[] args) {
		
		Account ac = new Account();
		
		ac.setName("홍길동");
		ac.setAccountNumber("1234-56-7890");
		ac.setBalance(10000);
		ac.setPassword("1234");
		
		ac.deposit(10000);
		ac.wihdraw("1234", 15000);
		
		ac.deposit(10000);
	}
}
