package edu.kh.control.practice;

import java.util.Scanner;

// 기능 작성 클래스
public class ConditionPractice {
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		/* 키보드로 입력 받은 정수가 양수이면서 짝수일 때만 "짝수입니다." 출력
		 * 짝수가 아니면 "홀수입니다." 출력
		 * 양수가 아니면 "양수만 입력해주세요" 출력
		 * 
		 * [ 실행 화면 ]
		 * 숫자를 한 개 입력하세요 : 8
		 * 짝수입니다.
		 * 
		 * 숫자를 한 개 입력하세요 : 17
		 * 홀수입니다.
		 * 
		 * 숫자를 한 개 입력하세요 : -3
		 * 양수만 입력해주세요.
		 * */
		
		System.out.print("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();
		
		String result = "";
		
		if(num % 2 == 0 && num > 0) {
			System.out.println("짝수입니다.");
		} else if(num % 2 == 1) {
			System.out.println("홀수입니다.");
		} else if(num < 0) {
			System.out.println("양수만 입력해주세요");
		}
	}
	
	public void practice2() {
		
		/* 국어, 영어, 수학 세 과목의 점수를 키보드로 입력 받고 합계와 평균을 계산하고
		 * 합계와 평균을 이용하여 합격 / 불합격 처리하는 기능을 구현
		 * 
		 * 합격 조건 : 세 과목의 점수가 각각 40점이상 평균 60점 이상일 경우
		 * 
		 * 합격 했을 경우 과목 별 점수와 합계, 평군, "축하합니다.합격입니다!" 출력
		 * 불합격인 경우 "불합격입니다." 출력
		 * 
		 * [ 실행 화면 ]
		 * 국어점수 : 88
		 * 수학점수 : 50
		 * 영어점수 : 40
		 * 불합격입니다.
		 * 
		 * 국어점수 : 88
		 * 수학점수 : 50
		 * 영어점수 : 45
		 * 국어 : 88
		 * 수학 : 50
		 * 영어 : 45
		 * 합계 : 183
		 * 평균 : 61.0 
		 * 축하합니다, 합격입니다!
		 * */
		
		System.out.print("국어 점수 : ");
		int kScore = sc.nextInt();
		
		System.out.print("수학 점수 : ");
		int mScore = sc.nextInt();
		
		System.out.print("영어 점수 : ");
		int eScore = sc.nextInt();
		
		int sum = kScore + mScore + eScore;
		double avg = sum / 3;
		
		if(kScore >= 40 && mScore >= 40 && eScore >= 40 && avg >= 60) {
			System.out.println("국어 점수 : " + kScore);
			System.out.println("수학 점수 : " + mScore);
			System.out.println("영어 점수 : " + eScore);
			System.out.println("합계 : " + sum);
			System.out.printf("평군 : %.1f\n", avg);
			System.out.println("축하합니다, 합격입니다!");
		} else {
			System.out.println("불합격입니다.");
		}
	}
	
	public void practice3() {
		
		/* 1-12 사이의 수를 입력받아 해당 달의 일수를 출력
		 * (2월 윤달은 생각하지 않습니다.)
		 * 잘못 입력한 경우 "OO월은 잘못 입력된 달입니다."를 출력 (switch문 사용)
		 * 
		 * [ 실행화면 ]
		 * 1~12 사이의 정수 입력 : 8
		 * 8월은 31일까지 있습니다.
		 * 
		 * 1~12 사이의 정수 입력 : 99
		 * 99월은 잘못 입력된 달입니다.*/
		
		/* 31 : 1 3 5 7 8 10 12  
		 * 30 : 4 6 9 11 
		 * 29 : 2 */
		
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		
		String result = "";
		
		switch(month) {
			case 1 :
			case 3 :
			case 5 :
			case 7 :
			case 8 :
			case 10 :
			case 12 :
				result = " 31일까지 있습니다.";
				break;
			case 4 :
			case 6 :
			case 9 :
			case 11 :
				result = " 30일까지 있습니다.";
				break;
			case 2 :
				result = " 29일까지 있습니다.";
				break;
			default : 
				result = " 잘못 입력된 달입니다.";
				break;
		}
		
		System.out.println(month + "월은" + result);
	}
	
	public void practice4() {
		
		/* 키, 몸무게를 double로 입력받고 BMI 지수를 계산하여 계산 결과에 따라
		 * 저체중/정상체중/과체중/비만을 출력
		 * 
		 * BMI = 몸무게 / 키(m) + 키(m)
		 * BMI가 18.5미만일 경우 저체중 / 18.5이상 23미만일 경우 정상체중
		 * BMI가 23이상 25미만일 경우 과체중 / 25이상 30미만일 경우 비만
		 * BMI가 30이상일 경우 고도 비만
		 * 
		 * [ 실행화면 ]
		 * 키(m)를 입력해 주세요 : 1.65
		 * 몸무게(kg)를 입력해 주세요 : 58.4
		 * BMI 지수 : 21.45087235996327
		 * 정상체중
		 * */
		
		System.out.print("키(m)를 입력해 주세요 : ");
		double m = sc.nextDouble();
		
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double kg = sc.nextDouble();
		
		double bmi = kg / (m * m);
		String result = "";
		
		if(bmi < 18.5) {
			result = "저체중";
		} else if(bmi >= 18.5 && bmi < 23) {
			result = "정상체중";
		} else if(bmi >= 23 && bmi < 25) {
			result = "과체중";
		} else if(bmi >= 25 && bmi < 30) {
			result = "비만";
		} else {
			result = "고도비만";
		}
		
		System.out.println("BMI 지수 : " + bmi);
		System.out.println(result);
	}
	
	public void practice5() {
		
		/* 중간고사, 기말고사, 과제점수, 출석횟수를 입력하고 Pass 또는 Fail을 출력
		 * 평가 비율은 중간고사 20% 기말고사 30% 과제 30% 출석 20%
		 * 출석 횟수는 총 강의 횟수 20 중에서 출석한 날만 따신 값으로 계산
		 * 70점 이상일 경우 Pass 70점 미만이거나 전체 강의에 30%이상 결석 시 Fail 출력
		 * 
		 * [ 실행 화면 ]
		 * 중간 고사 점수 : 80
		 * 기말 고사 점수 : 30
		 * 과제 점수 : 60
		 * 출석 횟수 : 18
		 * ==================== 결과 ====================
		 * 중간 고사 점수(20) : 16.0
		 * 기말 고사 점수(30) : 9.0
		 * 과제 점수 (30) : 18.0
		 * 출석 점수 (20) : 18.0
		 * 총점 : 61.0
		 * Fail [점수미달]
		 * 
		 * 중간 고사 점수 : 80
		 * 기말 고사 점수 : 90
		 * 과제 점수 : 50
		 * 출석 횟수 : 15
		 * ==================== 결과 ====================
		 * 중간 고사 점수(20) : 16.0
		 * 기말 고사 점수(30) : 27.0
		 * 과제 점수 (30) : 15.0
		 * 출석 점수 (20) : 15.0
		 * 총점 : 73.0
		 * PASS
		 * 
		 * 중간 고사 점수 : 100
		 * 기말 고사 점수 : 80
		 * 과제 점수 : 40
		 * 출석 횟수 : 10
		 * ==================== 결과 ====================
		 * Fail [출석 횟수 부족 (10/20)]
		 * */
		
		System.out.print("중간 고사 점수 : ");
		int score1 = sc.nextInt();
		
		System.out.print("기말 고사 점수 : ");
		int score2 = sc.nextInt();
		
		System.out.print("과제 점수 : ");
		int score3 = sc.nextInt();
		
		System.out.print("출석 횟수 : ");
		int score4 = sc.nextInt();
		
		double reScore1= score1 * 0.2;
		double reScore2= score2 * 0.3;
		double reScore3= score3 * 0.3;
		double reScore4= score4 * 1.0;
		double sum = reScore1 + reScore2 + reScore3 + reScore4;
		
		System.out.println("==================== 결과 ====================");
		
		if(reScore4 <= (20*0.3)) {
			System.out.println("Fail [출석 횟수 부족 ("+ score4 +"/20)]");
		} else {
			System.out.println("중간 고사 점수(20) : " + reScore1);
			System.out.println("기말 고사 점수(30) : " + reScore2);
			System.out.println("과제 점수(30) : " + reScore3);
			System.out.println("출석 점수(30) : " + reScore4);
			System.out.println("총점 : " + sum);
			
			if(sum >= 70) {
				System.out.println("PASS");
			}
			else {
				System.out.println("Fail [점수미달]");
			}
		}
	}
}
