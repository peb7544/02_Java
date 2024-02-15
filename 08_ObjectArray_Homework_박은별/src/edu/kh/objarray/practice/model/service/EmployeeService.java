package edu.kh.objarray.practice.model.service;

import edu.kh.objarray.practice.model.vo.Employee;
import java.util.Scanner;

public class EmployeeService {

	// 사원 정보를 저장할 Employee 배열
	private Employee[] employees = new Employee[3]; 
	
	private Scanner sc = new Scanner(System.in);
	
	public void displayMenu() {
		
		int sel = 0;
		
		do {
			
			System.out.println("=== 직원 관리 프로그램 ===");
			
			System.out.println("1. 직원 정보 입력(3명)");
			System.out.println("2. 모든 직원 정보 출력");
			System.out.println("3. 특정 직원 정보 출력(이름 검색)");
			System.out.println("4. 특정 직원 급여/연봉 출력(사번 검색)");
			System.out.println("5. 모든 직원 급여 합/연봉 합 출력");
			System.out.println("6. 모든 직원 중 급여가 가장 높은 직원의 이름, 부서, 급여 출력");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 선택 >>> ");
			sel = sc.nextInt();
			
			sc.nextLine();
			
			switch(sel) {
			
			case 1: initEmployee(); break;
			case 2: System.out.println( allEmployeesInformation() ); break;
			case 3: System.out.println( searchEmployee() ); break;
			case 4: System.out.println( salaryCheck() ); break;
			case 5: 
				System.out.println("=== 급여/연봉 조회 ===");
				System.out.println( "전 직원 급여 합 : " + allSalryCheck() );
				System.out.println( "전 직원 연봉 합 : " + (allSalryCheck() * 12) ); 
				break;
			case 6: topSalaryEmployee(); break;
			case 0: System.out.println("프로그램 종료.."); break;
			default: System.out.println("잘못 입력하셨습니다.");
			
			}
			
		} while(sel != 0);
	}
	
	// 3명의 직원 정보를 입력받아 배열에 각 요소에 초기화
	public void initEmployee() {
		
		// 사번, 이름, 부서, 직급, 급여 순서로 입력받기
		for(int i = 0; i < employees.length; i++) {
			
			System.out.println("=== " + (i+1) + "번째 사원 정보 입력 ===");
			
			System.out.print("사번 : ");
			int empNo = sc.nextInt();
			
			System.out.print("이름 : ");
			String empName = sc.next();
			
			System.out.print("부서 : ");
			String empDept = sc.next();
			
			System.out.print("직급 : ");
			String empJob = sc.next();
			
			System.out.print("급여 : ");
			int empSalary = sc.nextInt();
			
			employees[i] = new Employee(empNo, empName, empDept, empJob, empSalary);
		}
	}
	
	// 모든 직원 정보를 하나의 문자열로 반환
	public String allEmployeesInformation() {
		
		boolean flag = false;
		String result = "";
		
		for(int i = 0; i < employees.length; i++) {
			
			if( employees[i] != null ) {
				
				result += employees[i].toString();
				
				flag = true;
			}
		}
		
		if(!flag) return "등록된 직원이 없습니다.";
		
		return result;
	}
	
	/* 특정 사원 정보 반환 메소드(이름 검색)
	 * 일치하는 이름이 없을 경우 "일치하는 이름의 사원이 없습니다." 반환
	 * */
	public String searchEmployee() {
		
		System.out.println("=== 특정 사원 정보 출력(이름 검색) ===");
		
		System.out.print("이름 입력 : ");
		String inputName = sc.next();
		
		boolean flag = false;
		String result = "";
		
		for(int i = 0; i < employees.length; i++) {
			
			if( employees[i] != null ) {
				
				if(inputName.equals(employees[i].getEmpName())) {
					result = employees[i].toString();
					
					flag = true;
					
					return result;
				}
			}
		}
		
		if(!flag) return "일치하는 이름의 사원이 없습니다.";
		
		return null;
	}
	
	/* 입력받은 사번과 일치하는 직원의 급여, 연봉 정보 반환(연봉 == 급여 * 12)
	 * 일치하지 않는 경우 "사번이 일치하는 직원 없습니다." 반환
	 * */
	public String salaryCheck() {
		
		System.out.println("=== 급여/연봉 조회 ===");
		
		System.out.print("사번 입력 : ");
		int inputNo = sc.nextInt();
		
		boolean flag = false;
		String result = "";
		
		for(int i = 0; i < employees.length; i++) {
			
			if( employees[i] != null ) {
				
				if(inputNo == employees[i].getEmpNo() ) {
					
					result = "급여 : " + employees[i].getEmpSalary() + 
							" / 연봉 : " + ( employees[i].getEmpSalary() * 12 );
					
					flag = true;
					
					return result;
				}
			}
		}
		
		if(!flag) return "사번이 일치하는 직원 없습니다.";
		
		return null;
	}
	
	// 모든 사원 급여 합 반환
	public int allSalryCheck() {
		
		boolean flag = false;
		
		int sum = 0;
		
		for(int i = 0; i < employees.length; i++) {
			
			if( employees[i] != null ) {
				sum += employees[i].getEmpSalary();
			
				flag = true;
			}
		}
		
		if(flag) return sum;
			
		return 0;
	}
	
	/* 모든 직원 중 급여가 가장 높은 직원 출력
	 * (동일한 급여인 경우 사번이 낮은 사람이 출력)
	 * */
	public void topSalaryEmployee() {
		
		boolean flag = false;
		int max = 0;
		
		for(int i = 0; i < employees.length; i++) {
			
			if( employees[i] != null ) {
				
				flag = true;
				
				if(max < employees[i].getEmpSalary()) {
					
					System.out.printf("이름 : %s, 부서 : %s, 급여 : %d\n",
							employees[i].getEmpName(),
							employees[i].getEmpDept(),
							employees[i].getEmpSalary());
					
					return;
				}
			}
		}
		
		if(!flag) {
			
			System.out.println("등록된 직원이 없습니다.");
			return;
		}
	}
}
