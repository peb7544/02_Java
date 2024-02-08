package edu.kh.oop.cls.run;

import edu.kh.oop.cls.model.service.ClsService;

public class ClsRun {

	public static void main(String[] args) {
		
		/* 매개변수 없는 생성자=> 기본생성자 
		 * ClsService의 기본생성자가 작성지 않지만
		 * 문제 없이 사용 가능하다.
		 * 
		 * */
		ClsService service = new ClsService();
		
		// service.ex1();
		// service.ex2();
		// service.ex3();
		service.ex4();
	}
}
