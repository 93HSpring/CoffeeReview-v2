package com.coffeereview.domain;

import lombok.Data;

/**
* @packageName   : com.coffeereview.domain
* @fileName      : MenuVO.java
* @author        : SeongPyo Jo
* @date          : 2020.10.29
* @description   :
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.10.29        SeongPyo Jo       최초 생성
* 2020.11.10        SeongPyo Jo       클래스 및 메쏘드 이름 변경(cafe -> menu)
* 2020.11.29        SeongPyo Jo       replyCnt 변수 추가
*/
@Data
public class MenuVO {
	
	private Long mno;
	private String menu;
	private String cafe;
	private Integer caffeine;
	private Integer kcal;
	private Integer sodium;
	private Integer sugars;
	private Double star_avg;
	private Integer replyCnt;
	
}