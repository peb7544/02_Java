package edu.kh.todoList.model.service;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Service :
 * 데이터 가공, 로직 처리 등의 기능을 제공하는 역할
 */
public interface TodoListService {

	/**
	 * 할 일 목록 반환 서비스
	 * @return toList + 완료개수
	 */
	/* public abstract */ Map<String, Object> todoListFullView();

	/**
	 * 날짜 포맷을 변환해서 반환
	 * @param regDate
	 * @return yyyy-MM-dd HH:mm:ss 형태 날짜 반환
	 */
	String dateFormat(LocalDateTime regDate);

	/**
	 * 전달받은 index번째 todo 반환
	 * @param index
	 * @return index번째 todo 상세정보, 없으면 null 반환
	 */
	String todoDetilView(int index);

	/**
	 * 할 일 완료 여부 변경( O <-> X)
	 * @return 해당 index 요소의 완료 여부가 변경되면 true
	 *         index 요소가 없으면 false
	 * @throws Exception 
	 */
	boolean todoComplete(int index) throws Exception;

	/**
	 * 할 일 수정 서비스
	 * @param index
	 * @param title
	 * @param content
	 * @return 수정 성공 true 실
	 */
	boolean todoUpdate(int index, String title, String content);

	String todoDeleteList(int index);
	

}
