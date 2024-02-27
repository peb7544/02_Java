package edu.kh.movie.model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
	 * 3. 영화 등록
	 */
	@Override
	public int movieInsert(String title, Set<String> genres, String director, String produce, String country,
			String releaseDate, int time, int rating) {
		// TODO Auto-generated method stub
		
		Movie movie = new Movie(title, genres, director, produce, country, releaseDate, time, rating);
		
		int index = dao.movieAdd(movie);
		
		return 0;
	}
}
