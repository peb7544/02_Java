package edu.kh.movie.model.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.kh.movie.model.dto.Movie;

// 데이터 가공, 로직 처리 등의 기능을 제공하는 역할
public interface MovieService {

	List<Movie> movieList();

	String dateFormat(String releaseDate);
	
	void movieDetail(String title, int num);

	int movieInsert(int movieNum, String title, Set<String> genres, String director, String produce, String country,
			String releaseDate, int time, int rating, String introduce) throws Exception; // 영화 등록

	int movieDetail2(int movieNum); // 영화 단일 검색

	int movieUpdate(int movieNum, String title, Set<String> genres, String director, String produce, String country,
			String releaseDate, int time, int num, String introduce) throws Exception; // 영화 수정

	String movieDelete(int movieNum) throws Exception; // 영화 삭제

	String ratingUpdate(int movieNum, int rating) throws Exception;

	String genreSelect(); // 장르 조회

	int genreYn(int genreKey); // 장르 여부

	String genreInsert(int i, int genreKey, String genreNm) throws Exception;

	String genreDelete(int genreKey) throws Exception; // 장르삭제

	int genreNmYn(String genre);
	
}
