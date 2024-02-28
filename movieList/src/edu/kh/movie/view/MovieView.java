package edu.kh.movie.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

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
				System.out.println("8. 장르 등록");
				System.out.println("9. 장르 삭제");
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
				case 8 : genreInsert(); break;
				case 9 : genreDelete(); break;
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
		
		for(Movie movie : list) {
			
			System.out.printf("[%d]   %-25s%-25s\n", movie.getMovieNum(), 
					movie.getTitile(), movie.getGenre());
		}
		
	}
	
	/**
	 * 2. 영화 상세 조회
	 */
	public void movieDetail() throws Exception {
		
		System.out.println("[2. 영화 상세 조회]\n");
		
		//List<Movie> list = service.movieList();
		
		System.out.print("영화제목 입력 : ");
		String title = br.readLine();
		
		System.out.println();
		
		service.movieDetail(title, 1);
	}
	
	/**
	 * 3. 영화 등록
	 */
	public void movieInsert() throws Exception {
		
		System.out.println("\n[3. 영화 등록]");
		
		System.out.print("영화 제목 : ");
		String title = br.readLine();
		
		Set<String> genres = new HashSet<String>(); // 재료 저장할 컬렉션
		List<Movie> list = service.movieList();
		
		System.out.println("----------------[장르 목록]--------------\n");
		
		// 장르 목록
		System.out.println(service.genreSelect()); 
		
		System.out.println("-------------------------------------------");
		
		while(true) {
			
			System.out.print("장르(종료키 'exit') : ");
			String genre = br.readLine();
			
			int yn = service.genreNmYn(genre); // 장르명 등록 여부
			
			if(yn == 0) {
			
				if( genre.equals("exit") ) {
					break;
				}
			
				genres.add(genre);
			} else System.out.println("등록되지 않은 장르입니다.");
			
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
		
		String introduce = "";
		
		while(true) {
			
			System.out.print("소개(입력 종료키 'exit') : ");
			String InputIntroduce = br.readLine();
			
			if( InputIntroduce.equals("exit") ) break;
		    else introduce += InputIntroduce;
			
		}
		
		int index = service.movieInsert(list.size()+1,title, genres, director, produce, country, 
				releaseDate, time, rating, introduce);
		
		if( index != -1  ) {
			System.out.println(title + "영화가 정상적으로 등록되었습니다.");
		}
		
	}

	/**
	 * 4. 영화 수정
	 */
	public void movieUpdate() throws Exception {
		
		System.out.println("\n[ 4. 영화 수정]");
		
		System.out.print("수정할 영화번호 입력 : ");
		int movieNum = Integer.parseInt(br.readLine());
		
		System.out.println();
		
		int num = service.movieDetail2(movieNum);
		
		if(num == -1) return;
		
		System.out.println("-------------------------------------------");
		
		System.out.print("수정할 영화 제목 : ");
		String title = br.readLine();
		
		Set<String> genres = new HashSet<String>(); // 재료 저장할 컬렉션
		
		System.out.println("----------------[장르 목록]--------------\n");
		
		// 장르 목록
		System.out.println(service.genreSelect()); 
		
		System.out.println("-------------------------------------------");
		
		while(true) {
			System.out.print("수정할 장르(종료키 'exit') : ");
			String genre = br.readLine();
			
			int yn = service.genreNmYn(genre); // 장르명 등록 여부
			
			if(yn == 0) {
			
				if( genre.equals("exit") ) {
					break;
				}
			
				genres.add(genre);
			} else System.out.println("등록되지 않은 장르입니다.");

		}
		
		System.out.print("수정할 감독 : ");
		String director = br.readLine();
		
		System.out.print("수정할 제작사 : ");
		String produce = br.readLine();
		
		System.out.print("수정할 나라 : ");
		String country = br.readLine();
		
		System.out.print("수정할 개봉일 : ");
		String releaseDate = br.readLine();
		
		System.out.print("수정할 시간 : ");
		int time = Integer.parseInt(br.readLine());
		
		String introduce = "";
		
		while(true) {
			
			System.out.print("소개(입력 종료키 'exit') : ");
			String InputIntroduce = br.readLine();
			
			if( InputIntroduce.equals("exit") ) break;
		    else introduce += InputIntroduce;
			
		}
		
		int index = service.movieUpdate(movieNum,title, genres, director, produce, country, 
				releaseDate, time, num, introduce);
		
		if( index != -1  ) {
			System.out.println(movieNum + "번 " + title + "영화가 정상적으로 변경되었습니다.");
		}
	
	}
	
	/**
	 * 5. 영화 삭제
	 */
	public void movieDelete() throws Exception {
		
		System.out.println("\n[5. 영화 삭제]");
		
		System.out.print("삭제할 영화번호 입력 : ");
		int movieNum = Integer.parseInt(br.readLine());
		
		String title = service.movieDelete(movieNum);
		
		if( !title.equals(null) ) {
			System.out.println(movieNum + "번 " + title + "영화가 정상적으로 삭제되었습니다.");
		}
	}
	
	/**
	 * 6. 영화 장르별 검색
	 */
	public void movieSearch() throws Exception {
		
		System.out.println("\n[6. 영화 장르별 검색]");
		
		System.out.print("영화장르 입력 : ");
		String genre = br.readLine();
		
		System.out.println();
		
		service.movieDetail(genre, 2);
	}
	
	/**
	 * 7. 평점 수정
	 */
	public void ratingUpdate() throws Exception {
		
		System.out.println("\n[7. 평점 수정]");
		
		System.out.print("수정할 영화번호 입력 : ");
		int movieNum = Integer.parseInt(br.readLine());
		
		System.out.println();
		
		int num = service.movieDetail2(movieNum);
		
		if(num == -1) return;
		
		System.out.println("-------------------------------------------");
		
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
		
		String title = service.ratingUpdate(movieNum,rating);
		
		if( !title.equals(null)  ) {
			System.out.println(movieNum + "번 " + title + "영화가 정상적으로 변경되었습니다.");
		}
	}
	
	/**
	 * 8. 장르 등록
	 */
	public void genreInsert() throws Exception {
		
		System.out.println("\n[8. 장르 등록]\n");
		
		System.out.println("----------------[장르 목록]--------------\n");
		
		// 장르 목록
		System.out.println(service.genreSelect()); 
		
		System.out.println("-------------------------------------------");
		
		System.out.print("장르번호 입력 : ");
		int genreKey = Integer.parseInt(br.readLine());
		
		System.out.print("장르명 입력 : ");
		String genreNm = br.readLine();
		
		int index = service.genreYn(genreKey);
		
		if(index != -1) {
			
			System.out.println("이미 해당 장르 번호에 등록되어있습니다.");
			System.out.print("덮어쓰시겠습니까?(Y/N) : ");
			String input = br.readLine();
			
			if(input.equalsIgnoreCase("Y")) System.out.println(service.genreInsert(1, genreKey, genreNm));
			
			else System.out.println("장르 등록 취소");
			
		} else System.out.println(service.genreInsert(2, genreKey,genreNm));
			
	}
	
	/**
	 * 9. 장르 삭제
	 */
	public void genreDelete() throws Exception {
		
		System.out.println("\n[9. 장르 삭제]");
		
		System.out.println("----------------[장르 목록]--------------\n");
		
		// 장르 목록
		System.out.println(service.genreSelect()); 
		
		System.out.println("-------------------------------------------");
		
		System.out.print("장르번호 입력 : ");
		int genreKey = Integer.parseInt(br.readLine());
		
		int index = service.genreYn(genreKey);
		
		if(index != -1) {
			
			System.out.println(service.genreDelete(genreKey));
			
		} else System.out.println("해당 장르번호는 등록되지 않았습니다.");
		
		
	}
}
