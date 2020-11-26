package com.coffeereview.service;

import java.util.List;

import com.coffeereview.domain.Criteria;
import com.coffeereview.domain.ReplyPageDTO;
import com.coffeereview.domain.ReplyVO;

/**
* @packageName   : com.coffeereview.service
* @fileName      : ReplyService.java
* @author        : SeongPyo Jo
* @date          : 2020.11.26
* @description   :
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.26        SeongPyo Jo       최초 생성
* 2020.11.26        SeongPyo Jo       CRUD 기능 구현
* 2020.11.26        SeongPyo Jo       댓글 페이징과 댓글 수 처리 메쏘드 추가(getListPage)
*/
public interface ReplyService {
	
	public int register(ReplyVO vo);
	
	public ReplyVO get(Long rno);
	
	public int modify(ReplyVO vo);
	
	public int remove(Long rno);
	
	public List<ReplyVO> getList(Criteria cri, Long mno);
	
	public ReplyPageDTO getListPage(Criteria cri, Long mno);

}
