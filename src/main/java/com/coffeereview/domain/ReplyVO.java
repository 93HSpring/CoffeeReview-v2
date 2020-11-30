package com.coffeereview.domain;

import java.util.Date;

import lombok.Data;

/**
* @packageName   : com.coffeereview.domain
* @fileName      : ReplyVO.java
* @author        : SeongPyo Jo
* @date          : 2020.11.26
* @description   :
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.26        SeongPyo Jo       최초 생성
* 2020.11.26        SeongPyo Jo       별점을 저장할 star 추가
*/
@Data
public class ReplyVO {

	private Long rno;
	private Long mno;
	
	private String reply;
	private String replyer;
	private Integer star;
	
	private Date replyDate;
	private Date updateDate;
	
}
