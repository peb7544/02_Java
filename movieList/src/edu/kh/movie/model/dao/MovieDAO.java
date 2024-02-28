package edu.kh.movie.model.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.kh.movie.model.dto.Movie;

// 데이터가 저장된 파일/DB/외부 장치에 접근하는 역할
public interface MovieDAO {

	List<Movie> movieList(); // 영화 목록
	
	Set<String> gemreAdd(Integer...gemreNew); // 영화 목록 - 장르 추가

	int movieAdd(Movie movie) throws Exception; // 영화 등록
	
	void savaFile() throws Exception; // 파일 저장

	List<Movie> movieDetail(String title); // 영화 상세

	Movie movieDetail2(int movieNum); // 영화 단일 검색

	int movieUpdate(int movieNum, String title, Set<String> genres, String director, String produce, String country,
			String releaseDate, int time, int num, String introduce) throws Exception; // 영화 수정

	String movieDelete(int movieNum) throws Exception; // 영화 삭제

	String ratingUpdate(int movieNum, int rating) throws Exception;

	List<Movie> movieSearch(String genreSearch); // 영화 장르

	Map<Integer, String> genreSelect(); // 장르 조회

	int genreYn(int genreKey); // 장르 여부

	void genreInsert(int genreKey, String genreNm) throws Exception;

	void savaFile2() throws Exception; //  장르 파일 저장

	String genreDelete(int genreKey) throws Exception; // 장르 삭제

	int genreNmYn(String genre); // 영화 등록시 장르 확인
	

}
