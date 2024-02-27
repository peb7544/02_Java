package edu.kh.movie.run;

import edu.kh.movie.view.MovieView;

/**
 * 프로젝제트 실행 (Run <-> View <-> Service <-> DAO <-> DB <-> File)
 */
public class MovieRun {
	
	/* 컬렉션을 한번이라도 이용할 것
	 * 파일 입출력 등을 이용하여 데이터를 저장할 수 있도록 할 것
	 * CRUD가 전부 포함될 것
	 * MVC 패턴이 적용된 프로젝트 일 것
	 * 만든 프로젝트에 대해 클래스 다이어그램 작성할 것
	 * */

	public static void main(String[] args) {
		
		MovieView view = new MovieView();
		view.displayMenu();
	}
}
