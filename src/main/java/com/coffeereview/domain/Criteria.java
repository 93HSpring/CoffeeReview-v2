package com.coffeereview.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* @packageName   : com.coffeereview.domain
* @fileName      : Criteria.java
* @author        : SeongPyo Jo
* @date          : 2020.11.23
* @description   : 검색의 기준 이라는 의미 즉, pageNum과 amount 값을 같이 전달하는 용도
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.23        SeongPyo Jo       최초 생성
* 2020.11.23        SeongPyo Jo       검색 키워드 추가
*/

@Getter
@Setter
@ToString
public class Criteria {

	// 어떤 카페의 목록을 불러올지 설정
	private String cafe;
	// 페이지 번호
	private int pageNum;
	// 한 페이지당 몇 개의 데이터인지 설정
	private int amount;
	
	// 검색 타입
	private String type;
	// 검색 키워드
	private String keyword;
	
	public Criteria() {
		
		// 기본 페이지는 1페이지, 12개의 데이터를 보여줌
		// this(1, 12, "STARBUCKS");
		
	}
	
	public Criteria(int pageNum, int amount, String cafe) {
		
		if (pageNum <= 0) {
			this.pageNum = 1;
		}
		else {
			this.pageNum = pageNum;
		}
		
		if (amount <= 0) {
			this.amount = 10;
		}
		else {
			this.amount = amount;
		}
		
		this.cafe = cafe;
		
	}
	
	// 시작 페이지를 반환해준다.
	// MenuMapper.xml 에서 pageStart를 변수로 쓸 수 있다.
	public int getPageStart() {
		
		return (this.pageNum - 1) * this.amount;
		
	}
}
