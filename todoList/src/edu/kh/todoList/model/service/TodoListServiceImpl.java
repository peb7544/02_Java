package edu.kh.todoList.model.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.todoList.model.dao.TodoListDAO;
import edu.kh.todoList.model.dao.TodoListDAOImpl;
import edu.kh.todoList.model.dto.Todo;

public class TodoListServiceImpl implements TodoListService {

	// 필드
	private TodoListDAO dao = null;
	
	// 기본 생성자
	public  TodoListServiceImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		/* TodoListServiceImpl 객체가 생성될 때 
		 * TodoListDaoImple 객체 생성
		 * */
		dao = new TodoListDAOImpl();
		// 부모타입참조변수 = 자식객체(다형성 업캐스팅)
	}

	/**
	 * todoListFullView
	 */
	@Override
	public Map<String, Object> todoListFullView() {
		
		// 1. 할 일 목록 DAO에서 얻어오기
		List<Todo> todoList = dao.todoListFullView();
		
		// 2. 할 일 목록에서 완료(complete 필드 값이 true)인 요소가 몇 개인지 카운트
		int completeCount = 0;
		
		for(Todo todo : todoList) { // TodoList 순차 접근
			
			// isComplete() == getComplete()
			if(todo.isComplete()) { // true인 경우
				completeCount++;
			}
			
		}
		
		/* 3. todoList, completeCount를 저장할 Map 생성 
		 * -> 메서드는 반환을 하나 밖에 못해서
		 *    여러개를 반환해야 하는 경우 Map 같은 컬렉션에 묶어서 반환
		 * */
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("todoList", todoList);
		map.put("completeCount", completeCount);
		
		// 4. map 반환
		return map;
	}

	/**
	 * dateFormat
	 */
	@Override
	public String dateFormat(LocalDateTime regDate) {
		
		// yyyy-MM-dd HH:mm:ss 형태 날짜 반환
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		/* regDate에 저장되어 있는 날짜 데이터를 
		 * formatter에 지정된 형식으로 변경
		 * */
		
		String fomattedDateTime = regDate.format(formatter);
		
		return fomattedDateTime;
	}

	/**
	 * 할일 상세 조회 서비스
	 */
	@Override
	public String todoDetilView(int index) {
		/* 1. DAO에 있는 todoList에서 index번째 요소(Todo) 반환 받기
		 *    없으면 null 반환
		 * */
		
		Todo  todo = dao.todoDetailView(index);
		
		return "";
		
	}

	/**
	 * 할 일 완료 여부 서비스
	 */
	@Override
	public boolean todoComplete(int index) throws Exception {
		// TODO Auto-generated method stub
		return dao.todoComplete(index);
	}
	/* service 메서드가 별도 처리를 하는게 업음
	 * -> 마우것도 안한다고 대개 서비스를 사용하지 않으면 안된다.
	 * */
	
	/**
	 *수정 서비스 호출 후 결과 반환 받기
	 */
	@Override
	public boolean todoUpdate(int index, String title, String content) {
		// TODO Auto-generated method stub
		boolean result =  dao.todoUpdate(index, title, content);
		
		if(result) {
			System.out.println("수정");
		} else {
			
			System.out.println("### 수정 실패 ###");
				
		}
		return result;
	}

	@Override
	public String todoDeleteList(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
