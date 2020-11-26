package com.coffeereview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffeereview.domain.Criteria;
import com.coffeereview.domain.ReplyVO;
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
*/
@Service
@Log4j
public class ReplyServiceImpl implements ReplyService {
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Override	
	public int register(ReplyVO vo) {

		log.info("register......" + vo);
		
		return mapper.insert(vo);

	}

	@Override
	public ReplyVO get(Long rno) {

		log.info("get......" + rno);
		
		return mapper.read(rno);
		
	}

	@Override
	public int modify(ReplyVO vo) {

		log.info("modify......" + vo);
		
		return mapper.update(vo);

	}
	
	@Override
	public int remove(Long rno) {

		log.info("remove......" + rno);
		
		return mapper.delete(rno);
		
	}
	

	@Override
	public List<ReplyVO> getList(Criteria cri, Long mno) {

		log.info("get Reply List of a Menu " + mno);
		
		return mapper.getListWithPaging(cri, mno);

	}

}
