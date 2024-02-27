package edu.kh.movie.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.kh.movie.model.dto.Movie;
import edu.kh.movie.model.service.MovieService;
import edu.kh.movie.model.service.MovieServiceImpl;

// : 보여지는 부분(내용 출력/키보드 입력) 역할
public class MovieView {

	private BufferedReader br = null;
	private MovieService service = null;
	
	//private 
	
	public MovieView() {
		
		try {
			
			service = new MovieServiceImpl(); // 키보드 입력 스트림 참조 변수
			br = new BufferedReader(new InputStreamReader(System.in));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	/**
	 * 메뉴화면
	 */
	public void displayMenu() {
		
		int menuNum = 0;
		
		do {
			
			try {
				
				System.out.println("\n====== 영화 목록 메뉴 ======\n");
				
				System.out.println("1. 영화 목록 조회");
				System.out.println("2. 영화 상세 조회");
				System.out.println("3. 영화 등록");
				System.out.println("4. 영화 수정");
				System.out.println("5. 영화 삭제");
				System.out.println("6. 영화 장르별 검색");
				System.out.println("7. 평점 수정");
				System.out.println("0. 프로그램 종료");
				
				System.out.print("메뉴 선택 >> ");
				menuNum = Integer.parseInt(br.readLine());
				System.out.println();
				
				switch(menuNum) {
				case 1 : movieList(); break;
				case 2 : movieDetail(); break;
				case 3 : movieInsert(); break;
				case 4 : movieUpdate(); break;
				case 5 : movieDelete(); break;
				case 6 : movieSearch(); break;
				case 7 : ratingUpdate(); break;
				case 0 :  System.out.println("프그로그램 종료합니다."); break;
				default : System.out.println("잘못입력하셨습니다. 메뉴에 있는 번호만 입력해주세요.");
				
				}
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("숫자만 입력해주세요.");
				
				menuNum = -1;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		} while(menuNum != 0);
	}
	
	/**
	 * 1. 영화 목록 조회
	 */
	public void movieList() {
		
		System.out.println("[1. 영화 목록 조회]\n");
		
		List<Movie> list = service.movieList();
		
		System.out.println("--------------------------------------------------------------");
		System.out.printf("%-3s %15s   %20s\n", "번호", "제목", "장르");
		System.out.println("--------------------------------------------------------------");
		
		int idx = 0;
		for(Movie movie : list) {
			
			idx++;
			
			System.out.printf("[%d]   %-25s%-25s\n", idx, 
					movie.getTitile(), movie.getGenre());
		}
		
	}
	
	/**
	 * 2. 영화 상세 조회
	 */
	public void movieDetail() throws Exception {
		
		System.out.println("[2. 영화 상세 조회]\n");
		
		List<Movie> list = service.movieList();
		
		System.out.print("제목 입력 : ");
		String title = br.readLine();
		
		System.out.println();
		
		boolean flag = false;
		int idx = 1;
		
		for(Movie movie : list) {
			
			if(movie.getTitile().contains(title)) {
				
				String releaseDate = service.dateFormat(movie.getReleaseDate());
				
				// 장르
				StringBuilder sb = new StringBuilder();
				
				for( String genre : movie.getGenre() ) {
					
					sb.append(genre).append(", ");
				}
				
				// 마지막 쉼표와 공백 제거하기
				if(sb.length() > 0) {
					sb.setLength(sb.length() - 2);
				}
				
				System.out.println();
				
				
				// 평점
				String rating = "";
			
				for(int i = 0; i < movie.getRating(); i++) {
					
					rating += "★";
				}
				
				
				System.out.printf("제목 : %s\n장르 : %s\n감독 : %s\n제작사 : %s\n나라 : %s\n개봉일 : %s\n시간 : %s분\n평점 : %s\n",
						movie.getTitile(), sb, movie.getDirector(), movie.getProduce(), 
						movie.getCountry(), releaseDate, movie.getTime(), rating);
				
				if(idx >= 2) System.out.println("-------------------------------------------");
				
				flag = true;
				idx++;
			}
		}
		
		if(!flag) System.out.println("등록된 영화가 없습니다.");
	}
	
	/**
	 * 3. 영화 등록
	 */
	public void movieInsert() throws Exception {
		
		System.out.println("\n[3. 영화 등록]");
		
		System.out.print("영화 제목 : ");
		String title = br.readLine();
		
		Set<String> genres = new HashSet<String>(); // 재료 저장할 컬렉션
		
		while(true) {
			System.out.print("장르(종료키 'exit') : ");
			String genre = br.readLine();
			
			if( genre.equals("exit") ) {
				break;
			}
			
			genres.add(genre);
		}
		
		System.out.print("감독 : ");
		String director = br.readLine();
		
		System.out.print("제작사 : ");
		String produce = br.readLine();
		
		System.out.print("나라 : ");
		String country = br.readLine();
		
		System.out.print("개봉일 : ");
		String releaseDate = br.readLine();
		
		System.out.print("시간 : ");
		int time = Integer.parseInt(br.readLine());
		
		int rating = 0;
		
		while(true) {
			System.out.print("평점(0~5) : ");
			int InputRating = Integer.parseInt(br.readLine());
			
			if( InputRating >=0 && InputRating <=5 ) {
				
				rating = InputRating;
				
				break;
			} else {
				System.out.println("평점은 0~5점까지 입력이 가능합니다. 다시 입력해주세요.");
			}
			
		}
		
		int index = service.movieInsert(title, genres, director, produce, country, 
				releaseDate, time, rating);
		
	}

	/**
	 * 4. 영화 수정
	 */
	public void movieUpdate() {
		
		System.out.println("\n[ 4. 영화 수정]");
	
	}
	
	/**
	 * 5. 영화 삭제
	 */
	public void movieDelete() {
		
		System.out.println("\n[5. 영화 삭제]");
		
	}
	
	/**
	 * 6. 영화 장르별 검색
	 */
	public void movieSearch() {
		
		System.out.println("\n[6. 영화 장르별 검색]");
		
	}
	
	/**
	 * 7. 평점 수정
	 */
	public void ratingUpdate() {
		
		System.out.println("\n[7. 평점 수정]");
		
	}
}
