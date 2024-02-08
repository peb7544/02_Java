package edu.kh.oop.practice.model.vo;

public class Hero {
	
	/* 영웅클래스
	 * 
	 * edu.kh.oop.practice.model.vo.Hero
	 * 
	 * 기능제공용 클래스 : edu.kh.oop.practice.model.service.HeroService
	 * 실행용  클래스 : edu.kh.oop.practice.run.PracticeRun
	 * 
	 * 닉네임 nickName
	 * 직업 job
	 * 체력 hp
	 * 마력 mp
	 * 레벨 level
	 * 경험치 exp
	 * 
	 * (추상화 / 캡슐화)
	 * 
	 * 메서드
	 * - getter/setter
	 * - attack(exp) : nick + "은/는 공격을 했다." 출력 후 
	 *                 전달받은 경험치를 현재 경험치에 누적,
	 *                 누적 경험치가 500 넘으면 레벨 1업 하기
	 * - magicJump() : 점프할 때마다 nickName + "의 점프!" 출력, 동시에 mp가 -10씩 감소됨.
	 *                 단, 현재 mp가 0이하라면 " 더 이상 매직 점프할 수 없어요!" 출력
	 * */

	// 속성
	// 필드 == 멤버 변수
	private String nickName; // 닉네임
	private String job; // 직업
	private int hp; // 체력
	private int mp; // 마력
	private int level; // 레벨
	private int exp; // 경험치
	
	// 기능
	// getter/setter
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	// 경험치
	public void attack(int exp) {
		
		System.out.println(nickName + "은/는 공격을 했다!");
		
		// 전달받은 경험치를 현재 경험치에 누적
		this.exp += exp;
		System.out.println(nickName + "의 경험치 : " + this.exp);
		
		if(this.exp > 500) {
			level += 1;
			
			this.exp = 0;
			
			System.out.println(nickName + "의 레벨 : " + level + "로 올랐습니다.");
		}
	}
	
	// 점프
	public void magicJump() {
		
		
		if(mp <= 0) {
			System.out.println("더 이상 매직 점프할 수 없어요!");
			
			return;
		}
		
		System.out.println(nickName + "의 점프!");
		
		mp -= 10;
		System.out.println(nickName + "의 마력 : " + mp);
	}
	
	
	
}
