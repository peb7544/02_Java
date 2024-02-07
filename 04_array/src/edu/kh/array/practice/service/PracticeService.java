package edu.kh.array.practice.service;

import java.util.Scanner;

import java.util.Arrays;

public class PracticeService {
	
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		
		/* 길이가 9인 배열을 선언 및 할당하고, 1부터 9까지의 값을 반복문을 이용하여
		 * 순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
		 * 짝수 번째 인덱스 값의 합을 출력하세요. (0번째 인덱스는 짝수로 취급)
		 * 
		 * [ 실행화면 ]
		 * 1 2 3 4 5 6 7 8 9
		 * 짝수 번째 인덱스 합 : 25
		 * */
		
		int[] arr = new int[9];
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			arr[i] = (i+1);
			
			if((i == 0) || (i % 2 == 0)) {
				sum += arr[i];
			}
			
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		System.out.println("짝수 번째 인덱스 합 : " + sum);
	}
	
	public void practice2() {
		
		/* 길이가 9인 배열을 선언 및 할당하고, 1부터 9까지의 값을 반복문을 이용하여
		 * 순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
		 * 홀수 번째 인덱스 값의 합을 출력하세요. (0번째 인덱스는 짝수로 취급)
		 * 
		 * [ 실행화면 ]
		 * 1 2 3 4 5 6 7 8 9
		 * 홀수 번째 인덱스 합 : 20
		 * */
		
		int[] arr = new int[9];
		int sum = 0;
		
		for(int i = arr.length; i > 0; i--) {
			
			arr[i-1] = i;
		
			
			if((i == 0) || (i % 2 == 0)) {
				sum += arr[i-1];
			}
			
			System.out.print(arr[i-1] + " ");
		}
		
		System.out.println();
		System.out.println("홀수 번째 인덱스 합 : " + sum);
	}
	
	public void practice3() {
		
		/* 사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
		 * 1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요.
		 * 
		 * [ 실행화면 ]
		 * 양의 정수 : 5
		 * 1 2 3 4 5
		 * */
		
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		
		int[] arr = new int[input];
		
		for(int i = 0; i < arr.length; i++ ) {
			arr[i] = (i+1);
			
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice4() {
		
		/* 정수 5개를 입력 받아 배열을 초기화하고
		 * 검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력
		 * 배열에 같은 수가 없을 경우 "일치하는 값이 존재하지 않습니다." 출력
		 * 
		 * [ 실행화면 ]
		 * 입력 0 : 5
		 * 입력 1 : 8
		 * 입력 2 : 9
		 * 입력 3 : 10
		 * 입력 4 : 4
		 * 검색할 값 : 8
		 * 인덱스 : 1
		 * 
		 * 입력 0 : 5
		 * 입력 1 : 8
		 * 입력 2 : 9
		 * 입력 3 : 10
		 * 입력 4 : 4
		 * 검색할 값 : 1
		 * 인덱스 : 일치하는 값이 존재하지 않습니다.
		 * */
		
		int[] arr = new int[5];
		
		for(int i = 0; i < arr.length; i++) {
			
			System.out.printf("입력 %d : ", i);
			int input = sc.nextInt();
			
			arr[i] = input;
		}
		
		System.out.print("\n검색할 값 : ");
		int num = sc.nextInt();
		
		String result = null;
		boolean flag = false;
		
		for(int i = 0; i < arr.length; i++) {
			
			if(num == arr[i]) {
				System.out.println("인덱스 : " + i);
				
				flag = true;
			}
		}
		
		if(!flag) {
			System.out.println("일치하는 값이 존재하지 않습니다.");
		}
	}
	
	public void practice5() {
		
		/* 문자열을 입력 받아 문자 하나하나를 배열에 넣고 검색할 문자가 문자열에 몇 개 들어가 있는지
		 * 개수와 몇 번째 인덱스에 위치하는지 인덱스를 출력하세요.
		 * 
		 * [ 실행화면 ]
		 * 문자열 : application
		 * 문자 : i
		 * 		  
		 * application에 i가 존재하는 위치(인덱스) : 4 8
		 * i 개수 : 2
		 * */
		
		System.out.print("문자열 : ");
		String str = sc.next();
		
		System.out.print("문자 : ");
		char str2 = sc.next().charAt(0);
		
		char[] arr = new char[str.length()];
		String result = "";
		int cnt = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			arr[i] = str.charAt(i);
			
			if(str2 == arr[i]) {
				result += i + " ";
				cnt++;
			}
		}
		
		System.out.printf("%s에 i가 존재하는 위치(인덱스) : %s\n", str, result);
		System.out.println("i 개수 : " + cnt);
	}
	
	public void practice6() {
		/* 사용자 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고
		 * 배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화하세요.
		 * 그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값을 출력하세요.
		 * 
		 * [ 실행화면 ]
		 * 정수 : 5
		 * 배열 0번째 인덱스에 넣을 값 : 4
		 * 배열 1번째 인덱스에 넣을 값 : -4
		 * 배열 2번째 인덱스에 넣을 값 : 3
		 * 배열 3번째 인덱스에 넣을 값 : -3
		 * 배열 4번째 인덱스에 넣을 값 : 2
		 * 4 -4 3 -3 2
		 * 총합 : 2
		 * */
		
		System.out.print("정수 : ");
		int input = sc.nextInt();
		
		int[] arr = new int[input];
		
		String result = "";
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			int index = sc.nextInt();
			
			arr[i] = index;
			
			result += arr[i] + " ";
			sum += arr[i];
			
			
		}
		
		System.out.println(result);
		System.out.println("총합 : " + sum);
	}
	
	public void practice7() {
		/* 주민등록번호 번호를 입력 받아 성별을 나타내는 숫자 이후로부터 *로 가리고 출력하세요.
		 * 
		 * [ 실행화면 ]
		 * 주민등록번호(-포함) : 123456-1234567
		 * */
		
		System.out.print("주민등록번호(-포함) : ");
		String input = sc.next();
		
		char[] arr = new char[input.length()];
		
		String result = "";
		
		for(int i = 0; i < arr.length; i++) {
			
			if(i > 7) {
				arr[i] = '*';
			} else {
				arr[i] = input.charAt(i);
			}
		}
		
		System.out.println(arr);
	}
	
	public void practice8() {
		
		/* 3이상인 홀수를 입력받아 배열의 중간가지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
		 * 중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
		 * 단, 입력한 정수가 홀수가 아니거나 3미만일 경우 "다시 입력하세요"를 출력하고
		 * 다시 정수를 받도록 하세요.
		 * 
		 * [ 실행화면 ]
		 * 정수 : 4
		 * 다시 입력하세요.
		 * 정수 : -6
		 * 다시 입력하세요.
		 * 정수 5
		 * 1, 2, 3, 2, 1
		 * */
		
		int input = 2;
		
		do { 
			System.out.print("정수 : ");
			input = sc.nextInt();
			
			if( input % 2 == 0 || input < 3 ) {
				System.out.println("다시 입력하세요.");
			}
		} while( input % 2 == 0 || input < 3 );
		
		int[] arr = new int[input];
		
		int cnt = 0;
		String result = "";
		
		for(int i = 0; i < arr.length; i++) {
			
			if(i <= (arr.length/2) ) {
				arr[i] = ++cnt;
			} else {
				arr[i] = --cnt;
			}
			
			result += arr[i] + ", ";
		}
		
		System.out.println(result);
	}
	
	public void practice9() {
		
		/* 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
		 * 1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요.
		 * 
		 * [ 실행화면 ]
		 * 발생한 난수 : 9 7 6 2 5 10 7 2 9 6*/
		
		int[] arr = new int[10];
		
		String result = "";
		
		for(int i = 0; i < arr.length; i++) {
			
			int random = (int)((Math.random() * 10) + 1 );
			
			arr[i] = random;
			result += arr[i] + " ";
 		}
		
		System.out.println(result);
	}
	
	public void practice10() {
		
		/* 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
		 * 1 ~ 10 사이의 난수를 발생시켜 배열에 초기화 후
		 * 배열 전체 값과 그 값 중에서 최대값과 최소값을 출력하세요.
		 * 
		 * [ 실행화면 ]
		 * 발생한 난수 : 5 3 2 7 4 8 6 10 9 10
		 * 최대값 : 10
		 * 최소값 : 2
		 * */
		
		int[] arr = new int[10];
		
		int max = 0;
		int min = arr.length;
		
		String result = "";
		
		for(int i = 0; i < arr.length; i++) {
			int random = (int)((Math.random() * 10) + 1);
			arr[i] = random;
			
			result += arr[i] + " ";
			
			if(max < arr[i]) {
				max = arr[i];
			}
			
			if(min > arr[i]) {
				min = arr[i];
			}
		}
		
		System.out.println("발생한 난수 : " + result);
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	}
	
	public void practice11() {
		
		/* 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
		 * 1 ~ 10 사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후 출력하세요.
		 * */
		
		int[] arr = new int[10];
		
		String result = "";
		char yn = 'n';
		
		for(int i = 0; i < arr.length; i++) {
			
			int random = (int)( (Math.random() * 10) + 1 );
			
			arr[i] = random;
			
			
			for(int x = 0; x < i; x++) {
				if(random == arr[x]) {
					i--;
					
					yn = 'y';
					
					break;
				}
				else {
					yn = 'n';
				}
			}
			
			if(yn == 'n') {
				result += arr[i] + " ";
			}
		}
		
		System.out.println(result);
	}
	
	public void practice12() {
		
		/* 로또 번호 자동 생성기 프로그램을 만들기
		 * (중복 값 없이 오름차순으로 정렬하여 출력하세요
		 * */
		
		int[] lotto = new int[6];
		boolean flag = false;
		
		String result = "";
		
		for(int i = 0; i < lotto.length; i++) {
			
			int random = (int)( (Math.random() * 45) + 1);
			
			lotto[i] = random;
			
			for(int x = 0; x < i; x++) {
				
				if(random == lotto[x]) {
					i--;
					flag = true;
					
					break;
				} else {
					flag = false;
				}
			}
		}
		
		Arrays.sort(lotto);
		
		for(int i = 0; i < lotto.length; i++) {
			result += lotto[i] + " ";
		}
		
		System.out.println( result );
	}
	
	public void practice13() {
		
		/* 문자열을 입력 받아 문자열에 어떤 문자가 들어갔는지 배열에 저장하고
		 * 문자의 개수와 함께 출력하세요.
		 * 
		 * [ 실행문자 ]
		 * 문자열 : application
		 * 문자열에 있는 문자 : a, p, l, i ,c, t, o, n
		 * 문자 개수 : 8
		 * */
		
		System.out.print("문자열 : ");
		String input = sc.next();
		String result = "";
		for(int i = 0; i < input.length(); i++) {
			if(input.indexOf(input.charAt(i)) == i) {
				result += input.charAt(i);
			}
		}
		
		System.out.println(result);
		
//		char[] arr = new char[input.length()];
//		
//		for(int i = 0; i < arr.length; i++) {
//			
//			arr[i] = input.charAt(i);
//			char input2 = arr[i];
//			
//			for(int x = 0; x < i; x++) {
//				
//				if(input2 == arr[x]) {
//					System.out.println(arr[x]);
//					
//					arr[i] = input.charAt(i+1);
//					//arr[i] = input.charAt(i+1);
//					
//					break;
//				}
//			}
//		}
//		
//		System.out.println(Arrays.toString(arr));
	}
}
