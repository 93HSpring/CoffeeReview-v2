package com.coffeereview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coffeereview.domain.Criteria;
import com.coffeereview.domain.ReplyPageDTO;
import com.coffeereview.domain.ReplyVO;
import com.coffeereview.mapper.MenuMapper;
import com.coffeereview.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/**
* @packageName   : com.coffeereview.service
* @fileName      : ReplyServiceImpl.java
* @author        : SeongPyo Jo
* @date          : 2020.11.26
* @description   :
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.26        SeongPyo Jo       최초 생성
* 2020.11.26        SeongPyo Jo       CRUD 기능 구현
* 2020.11.26        SeongPyo Jo       리뷰 페이징과 댓글 수 처리 메쏘드 추가(getListPage)
* 2020.11.29        SeongPyo Jo       리뷰 개수 처리를 위한 mapper 추가(menuMapper)
* 2020.11.29        SeongPyo Jo       리뷰 개수 처리를 위한 register, remove 트랜잭션 추가 및 리뷰 수를 수정하는 기능 추가
* 2020.11.30        SeongPyo Jo       별점 평균을 수정하는 메쏘드 추가(updateStar)
* 2020.11.30        SeongPyo Jo       getListPage에 별점 평균 파라미터 추가
*/
@Service
@Log4j
public class ReplyServiceImpl implements ReplyService {
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private MenuMapper menuMapper;
	
	@Transactional
	@Override	
	public int register(ReplyVO vo) {

		log.info("register......" + vo);
		
		// 리뷰 수 증가
		menuMapper.updateReplyCnt(vo.getMno(), 1);
		
		return mapper.insert(vo);

	}

	@Override
	public ReplyVO get(Long rno) {

		log.info("get......" + rno);
		
		return mapper.read(rno);
		
	}

	@Transactional
	@Override
	public int modify(ReplyVO vo) {

		log.info("modify......" + vo);	
		
		return mapper.update(vo);

	}
	
	@Transactional
	@Override
	public int remove(Long rno) {

		log.info("remove......" + rno);
		
		ReplyVO vo = mapper.read(rno);
		
		// 리뷰 수 감소
		menuMapper.updateReplyCnt(vo.getMno(), -1);		
		
		return mapper.delete(rno);
		
	}	

	@Override
	public List<ReplyVO> getList(Criteria cri, Long mno) {

		log.info("get Reply List of a Menu " + mno);
		
		return mapper.getListWithPaging(cri, mno);

	}
	
	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long mno) {
		
		return new ReplyPageDTO(mapper.getCountByMno(mno), mapper.getListWithPaging(cri, mno), mapper.getStarAvgByMno(mno));
		
	}
	
	@Transactional
	@Override
	public void updateStar(Long mno) {
		
		// 별점 평균 업데이트
		Double starAvg =  mapper.getStarAvgByMno(mno);
		menuMapper.updateReplyStar(mno, starAvg);
		
	}

}
