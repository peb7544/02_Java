package edu.kh.todoList.model.dao;

import java.util.List;

import edu.kh.todoList.model.dto.Todo;

/**
 * DAO(Data Access Object) :
 * 데이터가 저장된 파일/DB/외부 장치에 접근하는 역할
 */
public interface TodoListDAO {
	
	/**
	 * TodoList를 파일로 저장하는 메서드
	 * @throws Exception 
	 */
	void saveFile() throws Exception;

	/**
	 * 할 일 목록 반환 DAO
	 * @return todoList
	 */
	List<Todo> todoListFullView();

	/**
	 * 전달받은 index번째 todo를 반환 DAO
	 * @param index
	 * @return index 번째 todo, 없으면 null
	 */
	Todo todoDetailView(int index);

	/**
	 * 할 일 여부 변경 DAO
	 * @param index
	 * @return 해당 index 요소의 완료 여부가 변경되면 true
	 * @throws Exception 
	 */
	boolean todoComplete(int index) throws Exception;

	
	/**
	 * 할 일 수정 DAO
	 * @param index
	 * @param title
	 * @param content
	 * @return
	 */
	boolean todoUpdate(int index, String title, String content);

}