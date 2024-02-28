package edu.kh.movie.model.dto;

import java.io.Serializable;
import java.util.Set;

// 값 전달 역할
/**
 * 
 */
public class Movie implements Serializable {
	
	private int movieNum;
	private String titile;
	private Set<String> genre; // 장르
	private String director; // 감독
	private String produce; // 제작사
	private String country; // 나라
	private String releaseDate; // 개봉일
	private int time; // 시간
	private int rating; // 평점
	private String introduce; // 소개
	//private String reivew; // 후기
	
	public Movie() {}
	
	public Movie(int movieNum, String titile, Set<String> genre, String director, String produce, String country,
			String releaseDate, int time, int rating, String introduce) {
		super();
		this.movieNum = movieNum;
		this.titile = titile;
		this.genre = genre;
		this.director = director;
		this.produce = produce;
		this.country = country;
		this.releaseDate = releaseDate;
		this.time = time;
		this.rating = rating;
		this.introduce = introduce;
	}

	public int getMovieNum() {
		return movieNum;
	}

	public void setMovieNum(int movieNum) {
		this.movieNum = movieNum;
	}

	public String getTitile() {
		return titile;
	}

	public void setTitile(String titile) {
		this.titile = titile;
	}

	public Set<String> getGenre() {
		return genre;
	}

	public void setGenre(Set<String> genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProduce() {
		return produce;
	}

	public void setProduce(String produce) {
		this.produce = produce;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	
	
}
