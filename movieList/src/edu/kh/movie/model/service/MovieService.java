package edu.kh.movie.model.service;

import java.util.List;
import java.util.Set;

import edu.kh.movie.model.dto.Movie;

// 데이터 가공, 로직 처리 등의 기능을 제공하는 역할
public interface MovieService {

	List<Movie> movieList();

	String dateFormat(String releaseDate);

	int movieInsert(String title, Set<String> genres, String director, String produce, String country,
			String releaseDate, int time, int rating);

}
