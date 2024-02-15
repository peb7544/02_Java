package edu.kh.objarray.practice.model.vo;

public class Employee {

	// 속성(필드)
	private int empNo; // 사번
	private String empName; // 이름
	private String empDept; // 부서
	private String empJob; // 직급
	private int empSalary; // 급여
	
	
	// 기능
	
	// 기본생성자
	public Employee() { }
	
	// 매개변수 생성자
	public Employee(int empNo, String empName, String empDept, String empJob, int empSalary) {

		this.empNo = empNo;
		this.empName = empName;
		this.empDept = empDept;
		this.empJob = empJob;
		this.empSalary = empSalary;
	}

	// getter, setter
	public int getEmpNo() {
		return empNo;
	}

	

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public String getEmpJob() {
		return empJob;
	}

	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	// 메서드
	@Override
	public String toString() {
		return "사번 : " + empNo + ", 이름 : " + empName
				+ ", 부서 : " + empDept + ", 직급 : " + empJob
				+ ", 급여 : " + empSalary + "\n";
	}
}
