package edu.kh.movie.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import edu.kh.movie.model.dto.Movie;

public class MovieDAOImpl implements MovieDAO {

	// 객체 입/출력 보조 스트림
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	private ObjectInputStream ois2 = null;
	private ObjectOutputStream oos2 = null;
	
	private final String FILE_PATH = "/io_test/movie.dat";
	private final String FILE_PATH2 = "/io_test/movieGenre.dat";
	
	// 파일 입출력 리스트
	private Map<Integer, String> company = null;
	private List<Movie> movies = null;
	
	public MovieDAOImpl() throws Exception {
		
		// 파일 내용 읽어오기
		File file2 = new File(FILE_PATH2);
		
		// 파일 존재 여부
		if(file2.exists()) {
			
			try {
				
				ois2 = new ObjectInputStream(new FileInputStream(FILE_PATH2));
				company = (HashMap<Integer, String>)ois2.readObject();
				
			} finally {
				
				if(ois2 != null) ois2.close();
			}
			
		} else {
			
			// 폴더, 파일 생성
			File directory = new File("/io_test/");
			
			if(!directory.exists()) directory.mkdir(); // 폴더 생성
			
			company = new HashMap<Integer, String>();
			
			company.put(1, "판타지");
			company.put(2, "드라마");
			company.put(3, "액션");
			company.put(4, "미스터리");
			company.put(5, "공포");
			company.put(6, "범죄");
			
			try {
				
				// 객체 출력 스트림 생성
				oos2 = new ObjectOutputStream(new FileOutputStream(FILE_PATH2));
				oos2.writeObject(company);
				
			} finally {
				
				if(oos2 != null) oos2.close();
				
			}
			
			//System.out.println("파일 생성");
			
		}
		
		// 파일 내용 읽어오기
		File file = new File(FILE_PATH);
		
		// 파일 존재 여부
		if(file.exists()) {
			
			try {
				
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				movies = (ArrayList<Movie>)ois.readObject();
				
			} finally {
				
				if(ois != null) ois.close();
			}
			
		} else {
			
			// 폴더, 파일 생성
			File directory = new File("/io_test/");
			
			if(!directory.exists()) directory.mkdir(); // 폴더 생성
			
			movies = new ArrayList<Movie>();
			
			movies.add(new Movie(1, "웡카", gemreAdd(1,2), "폴킹", "헤이데이 필름스,빌리지 로드쇼 픽처스", "미국", "20240131", 116, 4,"세상에서 가장 달콤한 여정 좋은 일은 모두 꿈에서부터 시작된다!"));
			movies.add(new Movie(2, "용감한 시민", gemreAdd(2,3), "박진표", "㈜마인드마크", "대한민국", "20231025", 112, 3,""));
			movies.add(new Movie(3, "검은사제들", gemreAdd(2,4), "장재현", "CJ엔터테인먼트", "대한민국", "20151105", 108, 4,""));
			movies.add(new Movie(4, "파묘", gemreAdd(4,5), "장재현", "쇼박스", "대한민국", "20240222", 134, 4,""));
			movies.add(new Movie(5, "사운드 오브 프리덤", gemreAdd(6), "알레한드로 고메즈 몬테베르드", "(주)NEW", "미국", "20240221", 131, 4,""));
			
			try {
				
				// 객체 출력 스트림 생성
				oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
				oos.writeObject(movies);
				
			} finally {
				
				if(oos != null) oos.close();
				
			}
			
			//System.out.println("파일 생성");
			
		}
	}
	
	// Map으로 저장된 값 Movie에 넣기
	@Override
	public Set<String> gemreAdd(Integer...gemreNew) {
		
		Set<String> gemresAdd = new HashSet<String>();
		
		for(Integer gemreKey : gemreNew) {
			
			String gemre = company.get(gemreKey);
			
			if(gemre != null) {
				gemresAdd.add(gemre);
			}
		}
		
		return gemresAdd;
	}

	/**
	 * 1. 영화 목록 조회
	 */
	@Override
	public List<Movie> movieList() {
		// TODO Auto-generated method stub
		
		return movies;
	}
	
	/**
	 * 2. 영화 상세
	 */
	@Override
	public List<Movie> movieDetail(String title) {
		// TODO Auto-generated method stub
		
		List<Movie> movies2 = new ArrayList<Movie>();
		
		boolean flag = false;
		for(Movie movie : movies) {
			if(movie.getTitile().contains(title)) {
				
				flag = true;
				
				movies2.add(movie);
			}
			
		}
		
		if(!flag) return null;
		
		return movies2;
		
	}
	
	
	/**
	 * 파일 저장
	 */
	@Override
	public void savaFile() throws Exception {
		
		// 파일과 연결된 객체 출력 스트림 생성
		oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
		oos.writeObject(movies);
	}

	/**
	 * 3. 영화 등록
	 * @throws Exception 
	 */
	@Override
	public int movieAdd(Movie movie) throws Exception {
		// TODO Auto-generated method stub
		
		if(movies.add(movie)) {
			
			// 파일 저장
			savaFile();
			
			return movies.size();
			
		}
		
		return -1;
	}

	/**
	 * 영화 단일 검색
	 */
	@Override
	public Movie movieDetail2(int movieNum) {
		// TODO Auto-generated method stub
		
		for(Movie movie : movies) {
			if(movie.getMovieNum() == movieNum) return movie;	
		}
		
		return null;
	}

	/**
	 * 영화 수정
	 */
	@Override
	public int movieUpdate(int movieNum, String title, Set<String> genres, String director, String produce,
			String country, String releaseDate, int time, int num, String introduce) throws Exception {
		// TODO Auto-generated method stub
		
		Movie newMovie = new Movie(movieNum, title, genres, director, produce, country, releaseDate, time, num, introduce);
		
		int idx = 0;
		for(Movie movie : movies) {
			
			if(movie.getMovieNum() == movieNum) {
				
				if(movies.set(idx, newMovie) != null ) {
					
					savaFile();
					
					return 0;
				}
			}
			
			++idx;
			
		}
		
		return -1;
	}

	@Override
	public String movieDelete(int movieNum) throws Exception {
		// TODO Auto-generated method stub
		int idx = 0;
		
		for(Movie movie : movies) {
			if(movie.getMovieNum() == movieNum) {
				
				String title = movie.getTitile();
				
				if( movies.remove(idx) != null ) {
					
					savaFile();
					
					return title;	
				}
				
			}
			
			idx++;
		}
		
		return null;
	}

	/**
	 * 7. 평점 수정
	 */
	@Override
	public String ratingUpdate(int movieNum, int rating) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		int idx = 0;
		for(Movie movie : movies) {
			
			if(movie.getMovieNum() == movieNum) {
				
				movie.setRating(rating);
				String title = movie.getTitile();
				
				if(movies.set(idx, movie) != null ) {
					
					savaFile();
					
					return title;
				}
			}
			
			idx++;
			
		}
		
		return null;
	}

	@Override
	public List<Movie> movieSearch(String genreSearch) {
		// TODO Auto-generated method stub
		List<Movie> movies2 = new ArrayList<Movie>();
		
		boolean flag = false;
		for(Movie movie : movies) {
			if(movie.getGenre().contains(genreSearch)) {
				
				flag = true;
				
				movies2.add(movie);
			}
			
		}
		
		if(!flag) return null;
		
		return movies2;
	}

	/**
	 * 장르 조회
	 */
	@Override
	public Map<Integer, String> genreSelect() {
		// TODO Auto-generated method stub
		
		return company;
	}

	/**
	 * 장르 여부
	 */
	@Override
	public int genreYn(int genreKey) {
		// TODO Auto-generated method stub
		
		if(company.containsKey(genreKey)) {
			return 0;
		}
		
		return -1;
	}
	
	/**
	 * 장르 파일 저장
	 */
	@Override
	public void savaFile2() throws Exception {
		
		// 파일과 연결된 객체 출력 스트림 생성
		oos2 = new ObjectOutputStream(new FileOutputStream(FILE_PATH2));
		oos2.writeObject(company);
	}

	/**
	 * 장르 추가
	 */
	@Override
	public void genreInsert(int genreKey, String genreNm) throws Exception {
		// TODO Auto-generated method stub
		
		company.put(genreKey, genreNm);
		savaFile2(); // 파일 저장
	}

	/**
	 * 장르 삭제
	 */
	@Override
	public String genreDelete(int genreKey) throws Exception {
		// TODO Auto-generated method stub
		
		String str = "";
		
		for( Entry<Integer, String> entry : company.entrySet() ) {
			str = entry.getValue();
		}
		
		company.remove(genreKey);
		savaFile2(); // 파일 저장
		
		return str;
	}

	/**
	 * 영화 등록시 장르 확인
	 */
	@Override
	public int genreNmYn(String genre) {
		// TODO Auto-generated method stub
		
		for( Entry<Integer, String> entry : company.entrySet() ) {
			
			if(entry.getValue().equals(genre) || genre.equals("exit")) {
				
				return 0;
			}
		}
		return -1;
	}
	
}
