package com.hw4.view;

import com.hw4.controller.MemberController;
import com.hw4.vo.Member;

import java.util.Scanner;

public class MemberMenu {
	
	MemberController mc = new MemberController();
	
	Scanner sc = new Scanner(System.in);
	
	/* 반복문을 이용하여 메인 메뉴를 반복적으로 실행
	 * (각 메뉴 별 서브메뉴 호출)
	 * */
	public void mainMenu() {
		
		// 메뉴 출력 > 반복 실행 처리함
		int menu = 0;
		
		do {
			
			System.out.println("====== 회원 관리 메뉴 ======");
			
			System.out.println("1. 신규 회원 등록");
			System.out.println("2. 회원 정보 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 정보 삭제");
			System.out.println("5. 회원 정보 출력");
			System.out.println("6. 회원 정보 정렬");
			System.out.println("0. 프로그램 종료");
			
			switch(menu) {
			
			case 1: insertMember(); break;
			case 2: searchMember(); break;
			case 3: updateMember(); break;
			case 4: deleteMember(); break;
			case 5: printAllMember(); break;
			case 6: sortMember(); break;
			case 0: System.out.println("프로그램 종료..") ;break;
			default: System.out.println("잘못 입력하였습니다.");
			
			}
			
		} while( menu != 0 );
	}
	
	/* 메인 메뉴에서 1번 선택시 실행되는 메소드
	 * 등록할 회원에 대한 정보를 입력받고
	 * 동일한 아이디가 없는 경우 MemberController의 insertMember 메소드 실행
	 * */
	public void insertMember() {
		
		// 1. 현재 회원 수(memberCount)가 최대 회원 수(SIZE)를 넘어설 경우 return 처리
		if(mc.memberCount < mc.SIZE) return;
		
		// 2. 아이디를 입력받아 MemberController의 checkId() 메소드로 전달 >> 결과 값
		System.out.print("아이디 입력 : ");
		String userId = sc.next();
		
		if( mc.checkId(userId) != null ) {
			
			/* 2-1. 결과 값이 null이 아닌 경우 즉, 동일한 아이디가 존재하는 경우
			 * "동일한 아이디가 존재합니다. 회원등록 실패" 출력
			 * */
			
			System.out.println("동일한 아이디가 존재합니다. 회원등록 실패");
		} else {
			
			/* 2-2 결과값이 null인 경우 즉, 동일한 아이디가 존재하지 않는 경우
			 * 나머지 회원 정보 입력 받도록(비밀번호, 이름, 나이, 성별, 이메일)
			 * 입력 받은 정보를 Member의 매개변수 생성자를 이용하여 객체 생성 후
			 * MemberController의 insertMember() 메소드로 전달
			 * "성골적으로 회원 등록이 되었습니다." 출력
			 * */
			
			System.out.print("비밀번호 입력 : ");
			String userPwd = sc.next();
			
			System.out.print("이름 입력 : ");
			String name = sc.next();
			
			System.out.print("나이 입력 : ");
			int age = sc.nextInt();
			
			System.out.print("성별 입력 : ");
			char gender = sc.next().charAt(0);
			
			System.out.print("이메일 입력 : ");
			String email = sc.next();
			
			
		}
	}
	
	
	/* 메인 메뉴에서 2번 선택시 실행되는 서브베뉴 -> 반복실행
	 * 각 서브메뉴에 해당하는 검색 내용을 입력받고
	 * MemberController의 serchMember 메소드 실행
	 * */
	public void searchMember() {
		
		// 메뉴 출력 > 반복 실행 처리함
		int input = 9;
		
		do {
			
			System.out.println("====== 회원 정보 검색 ======");
			
			System.out.println("1. 아이디로 검색하기");
			System.out.println("2. 이름으로 검색하기");
			System.out.println("3. 이메일로 검색하기");
			System.out.println("9. 이전메뉴로");
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			
			System.out.print("검색 내용 : ");
			String search = sc.next();
			
			// 1. MemberControll의 serchMember() 메소드로 menu와 search 문자열 전달 >> 결과 값
			
			// 1-1. 결과값이 null인 경우 즉, 검색 결과가 없는 경우 >> "검색된 결과가 없습니다." 출력
			
			// 1-2. 결과 값이 null이 아닌 경우 즉, 검색 결과가 존재하는 경우 >> 회원 정보 출력
			
			
		} while( input != 9 );
		
	}
	
	/* 메인 메뉴에서 3번 선택시 실행되는 서브베뉴 -> 반복실행
	 * 각 서브메뉴에 해당하는 수정할 내용을 입력받고
	 * MemberController의 updateMember 메소드 실행
	 * */
	public void updateMember() {
		
		// 메뉴 출력 > 반복 실행 처리함
		int input = 9;
		
		do {
			
			System.out.println("====== 회원 정보 선택 ======");
			
			System.out.println("1. 비밀번호 수정");
			System.out.println("2. 이름 수정");
			System.out.println("3. 이메일 수정");
			System.out.println("9. 이전메뉴로");
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			
			System.out.print("검색 내용 : ");
			String search = sc.next();
			
			// 1. MemberControll의 checkId로 userId 전달 >> 결과 값(m : Member)
			
			// 1-2. 결과값이 null인 경우 >> "변경할 회원이 존재하지 않습니다.." 출력
			
			/* 1-2. 결과 값이 null이 아닌 경우 기존 정보 출력 후 
			 * 변경내용(update) 입력 받고
			 * MemberController의 updateMembeR()에 m, menu, update 전달
			 * >> "회원의 정보가 변경되었습니다." 출력
			 * */
			
		} while( input != 9 );
		
	}
	
	/* 메인 메뉴에서 4번 선택시 실행되는 메소드
	 * 각 서브메뉴에 해당하는 삭제할 회원아이디를 입력받고
	 * MemberController의 deleteMember 메소드 실행
	 * */
	public void deleteMember() {
		
		System.out.print("삭제할 회원 아이디 : ");
		String userId = sc.next();
		
		// 1. MemberControll의 checkId()에 userId 전달 >> 결과 값(m : Member)
		
		// 1_1. 결과 값이 null인 경우 "삭제할 회원이 존재하지 않습니다." 출력
		
		/* 1_2. 결과 값이 null이 아닌 경우 기존 정보 출력
		 * "정말 삭제하시겠습니까?(y/n) : " >> 키보드로 입력 받기
		 * 대소문자 구분 없이 'Y'인 경우 MemberController의 deleteMember()에 userId 전달
		 * "회원의 정보가 삭제되었습니다." 출력
		 * */
		
	}
	
	/* 메인 메뉴에서 5번 선택시 실행되는 메소드
	 * MemberController의 getMem 메소드 실행의 결과 값을
	 * 반복문을 통해 출력
	 * */
	public void printAllMember() {
		
		/* MemberController의 getMem() 메소드 호출 >> 결과 값(mem : Member[]) 
		 * 반복문을 통해 결과 값이 안의 존재하는 회원들 정보 출력
		 * */
	}
	
	/* 메인 메뉴에서 6번 선택시 실행되는 서브베뉴 -> 반복실행
	 * 각 서브메뉴에 해당하는 MemberController의 정렬 메소드들을 실행함으로써
	 * 그 결과값으로 반복문을 통해 출력
	 * */
	public void sortMember() {
		Member[] sortMem = null; // 정렬 결과를 받아 줄 객체배열 초기화
		
		// 메뉴 출력 > 반복 실행 처리함
		int input = 9;
		
		do {
			
			System.out.println("====== 회원 정보 정렬 ======");
			
			System.out.println("1. 아이디 오름차순 정렬"); // MemberController의 sortIdAsc() 결과 sortMem에 대입
			System.out.println("2. 아이디 내림차순 정렬"); // sortIdDesc() 결과 sortMem에 대입
			System.out.println("3. 나이 오름차순 정렬"); // sortAgeAsc() 결과 sortMem에 대입
			System.out.println("4. 나이 내림차순 정렬"); // sortAgeDesc() 결과 sortMem에 대입
			System.out.println("5. 성별 내림차순 정렬(남여순)"); // sortGenderDesc() 결과 sortMem에 대입
			System.out.println("9. 이전메뉴로");
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			
			// 반복문을 통해 sortMem 객체 배열 출력
			
		} while( input != 9 );
	}
}
