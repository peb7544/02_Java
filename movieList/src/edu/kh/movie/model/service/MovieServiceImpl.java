package edu.kh.movie.model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import edu.kh.movie.model.dao.MovieDAO;
import edu.kh.movie.model.dao.MovieDAOImpl;
import edu.kh.movie.model.dto.Movie;

public class MovieServiceImpl implements MovieService {

	private MovieDAO dao = null;
	
	public MovieServiceImpl() throws Exception {
		
		dao = new MovieDAOImpl();
	}

	/**
	 * 1. 영화목록
	 */
	@Override
	public List<Movie> movieList() {
		
		// 영화 목록
		List<Movie> movie = dao.movieList();
		
		return movie;
	}

	/**
	 * 2. 영화상세 - 날짜 포맷
	 * @return "yyyy년 MM월 dd일"
	 */
	@Override
	public String dateFormat(String releaseDate) {
		// TODO Auto-generated method stub
		
		Date formatDate = null;
		String strDate = "";
		
		try {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");	
			
			// String 타입을 Date 타입으로 변환
			formatDate = dateFormat.parse(releaseDate);
			
			// 날짜포맷
			releaseDate = newDateFormat.format(formatDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return releaseDate;
	}
	
	/**
	 * 2. 영화 상세
	 */
	@Override
	public void movieDetail(String title, int num) {
		// TODO Auto-generated method stub
		
		List<Movie> movies = null;
		
		switch(num) {
		case 1 : movies = dao.movieDetail(title); break;
		case 2 : movies = dao.movieSearch(title); break;
		}
		
		if(movies == null) {
			
			System.out.println("등록된 영화가 없습니다.");
			
			return;
		}
		
		int idx = 1;
		for(Movie movie : movies) {
			
			String releaseDate = dateFormat(movie.getReleaseDate());
			
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
			
			if(idx >= 2) System.out.println("-------------------------------------------");
			
			System.out.printf("제목 : %s\n장르 : %s\n감독 : %s\n제작사 : %s\n나라 : %s\n개봉일 : %s\n시간 : %s분\n평점 : %s\n",
					movie.getTitile(), sb, movie.getDirector(), movie.getProduce(), 
					movie.getCountry(), releaseDate, movie.getTime(), rating);
			
			System.out.println("== 소개 ==");
			
			System.out.println(movie.getIntroduce());
			
			
			idx++;
		}
		
	}

	/**
	 * 3. 영화 등록
	 */
	@Override
	public int movieInsert(int movieNum, String title, Set<String> genres, String director, String produce, String country,
			String releaseDate, int time, int rating, String introduce) throws Exception {
		// TODO Auto-generated method stub
		
		Movie movie = new Movie(movieNum, title, genres, director, produce, country, releaseDate, time, rating, introduce);
		
		int index = dao.movieAdd(movie);
		
		return index;
	}

	/**
	 * 단일검색
	 */
	@Override
	public int movieDetail2(int movieNum) {
		// TODO Auto-generated method stub
		Movie movie = dao.movieDetail2(movieNum);
		
		if(movie == null) {
			
			System.out.println("등록된 영화가 없습니다.");
			
			return -1;
		}
		
		String releaseDate = dateFormat(movie.getReleaseDate());
		
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
		
		System.out.println("== 소개 ==");
		
		System.out.println(movie.getIntroduce());
		
		return movie.getRating();
	}

	/**
	 * 4. 영화 수정
	 */
	@Override
	public int movieUpdate(int movieNum, String title, Set<String> genres, String director, String produce,
			String country, String releaseDate, int time, int num, String introduce) throws Exception {
		
		// TODO Auto-generated method stub
		int index = dao.movieUpdate(movieNum, title, genres, director, produce,
				country, releaseDate, time, num, introduce);
		
		return index;
	}

	/**
	 * 5. 영화 삭제
	 */
	@Override
	public String movieDelete(int movieNum) throws Exception {
		// TODO Auto-generated method stub
		String title = dao.movieDelete(movieNum);
		
		return title;
	}

	/**
	 * 7. 평점 수정
	 */
	@Override
	public String ratingUpdate(int movieNum, int rating) throws Exception {
		// TODO Auto-generated method stub
		
		String title = dao.ratingUpdate(movieNum, rating);
		
		return title;
	}

	/**
	 * 장르 조회
	 */
	@Override
	public String genreSelect() {
		
		Map<Integer, String> map = dao.genreSelect();
		
		String str = "";
		
		if(map.isEmpty()) {
			return "등록된 장르가 없습니다.";
		}
		
		for( Entry<Integer, String> entry : map.entrySet() ) {
			str += entry.getKey() + " : " + entry.getValue() + "\n";
		}
		
		return str;
	}

	/**
	 * 장르 여부
	 */
	@Override
	public int genreYn(int genreKey) {
		int index = dao.genreYn(genreKey);
		return index;
	}

	/**
	 * 장르 추가
	 */
	@Override
	public String genreInsert(int num, int genreKey, String genreNm) throws Exception{
		
		String str = "";
		dao.genreInsert(genreKey,genreNm);
		
		if(num == 1) str = "해당 장르번호에 있는 장르명을 변경하였습니다.";
		else if(num == 2) str = "장르가 등록되었습니다.";
		
		return str;
	}

	@Override
	public String genreDelete(int genreKey) throws Exception {
		
		String value = dao.genreDelete(genreKey);
		
		return genreKey + "번 " + value + " 장르가 정상적으로 삭제되었습니다.";
	}

	/**
	 * 영화 등록시 장르 확인
	 */
	@Override
	public int genreNmYn(String genre) {
		
		int yn = dao.genreNmYn(genre);
		
		return yn;
	}
	

}
