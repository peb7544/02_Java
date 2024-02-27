package edu.kh.movie.model.dao;

import java.util.List;
import java.util.Set;

import edu.kh.movie.model.dto.Movie;

// 데이터가 저장된 파일/DB/외부 장치에 접근하는 역할
public interface MovieDAO {

	List<Movie> movieList(); // 영화 목록
	
	Set<String> gemreAdd(Integer...gemreNew); // 영화 목록 - 장르 추가

	int movieAdd(Movie movie); // 영화 등록
	
	void savaFile(); // 파일 저장

}
