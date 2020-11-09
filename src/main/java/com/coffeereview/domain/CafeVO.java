package com.coffeereview.domain;

import lombok.Data;

/**
* @packageName   : com.coffeereview.domain
* @fileName      : CafeVO.java
* @author        : SeongPyo Jo
* @date          : 2020.10.29
* @description   :
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.10.29        SeongPyo Jo       최초 생성
*/
@Data
public class CafeVO {
	
	private Long cno;
	private String menu;
	private String cafe;
	private Integer caffeine;
	private Integer kcal;
	private Integer sodium;
	private Integer sugars;
	private Double star_avg;
	
}