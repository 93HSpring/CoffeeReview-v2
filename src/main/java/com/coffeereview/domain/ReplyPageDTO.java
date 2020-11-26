package com.coffeereview.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
* @packageName   : com.coffeereview.domain
* @fileName      : ReplyPageDTO.java
* @author        : SeongPyo Jo
* @date          : 2020.11.26
* @description   :
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.26        SeongPyo Jo       최초 생성
* 2020.11.26        SeongPyo Jo       댓글 페이징과 댓글 수 처리 변수 추가
*/
@Data
@AllArgsConstructor
@Getter
public class ReplyPageDTO {
	
	private int replyCnt;
	private List<ReplyVO> list;

}
