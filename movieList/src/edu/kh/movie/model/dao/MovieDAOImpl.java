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

import edu.kh.movie.model.dto.Movie;

public class MovieDAOImpl implements MovieDAO {

	// 객체 입/출력 보조 스트림
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	private final String FILE_PATH = "/io_test/movie.dat";
	
	// 파일 입출력 리스트
	private Map<Integer, String> company = null;
	private List<Movie> movie = null;
	
	public MovieDAOImpl() throws Exception {
		
		company = new HashMap<Integer, String>();
		
		company.put(1, "판타지");
		company.put(2, "드라마");
		company.put(3, "액션");
		company.put(4, "미스터리");
		company.put(5, "공포");
		company.put(6, "범죄");
		
		
		// 파일 내용 읽어오기
		File file = new File(FILE_PATH);
		
		// 파일 존재 여부
		if(file.exists()) {
			
			try {
				
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				movie = (ArrayList<Movie>)ois.readObject();
				
			} finally {
				
				if(ois != null) ois.close();
			}
			
		} else {
			
			// 폴더, 파일 생성
			File directory = new File("/io_test/");
			
			if(!directory.exists()) directory.mkdir(); // 폴더 생성
			
			movie = new ArrayList<Movie>();
			
			movie.add(new Movie("웡카", gemreAdd(1,2), "폴킹", "헤이데이 필름스,빌리지 로드쇼 픽처스", "미국", "20240131", 116, 4));
			movie.add(new Movie("용감한 시민", gemreAdd(2,3), "박진표", "㈜마인드마크", "대한민국", "20231025", 112, 3));
			movie.add(new Movie("검은사제들", gemreAdd(2,4), "장재현", "CJ엔터테인먼트", "대한민국", "20151105", 108, 4));
			movie.add(new Movie("파묘", gemreAdd(4,5), "장재현", "쇼박스", "대한민국", "20240222", 134, 4));
			movie.add(new Movie("사운드 오브 프리덤", gemreAdd(6), "알레한드로 고메즈 몬테베르드", "(주)NEW", "미국", "20240221", 131, 4));
			
			try {
				
				// 객체 출력 스트림 생성
				oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
				oos.writeObject(movie);
				
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
		
		return movie;
	}
	
	
	/**
	 * 파일 저장
	 */
	@Override
	public void savaFile() {
		
		// 파일과 연결된 객체 출력 스트림 생성
		try {
			
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			
		} catch (FileNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 3. 영화 등록
	 */
	@Override
	public int movieAdd(Movie movie) {
		// TODO Auto-generated method stub
		
		if(this.movie.add(movie)) {
			
			// 파일 저장
			savaFile();
			
			return this.movie.size()-1;
			
		}
		
		return -1;
	}
	
}
