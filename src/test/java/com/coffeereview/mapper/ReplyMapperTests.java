package com.coffeereview.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.coffeereview.domain.Criteria;
import com.coffeereview.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {com.coffeereview.config.RootConfig.class})
@Log4j
public class ReplyMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	// 테스트 전에 해당 번호의 게시물이 존재하는지 반드시 확인
	private Long[] mnoArr = {1L, 2L, 3L, 4L, 5L};
	
	/*
	@Test
	public void testCreate() {
		
		IntStream.rangeClosed(1, 10).forEach(i -> {
			
			ReplyVO vo = new ReplyVO();
			
			// 게시물의 번호
			vo.setMno(mnoArr[i % 5]);
			vo.setReply("댓글 테스트" + i);
			vo.setReplyer("replyer" + i);
			
			mapper.insert(vo);
			
		});
		
	}
	*/
	
	/*
	@Test
	public void testRead() {
		
		Long targetRno = 5L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		log.info(vo);
		
	}
	*/
	
	/*
	@Test
	public void testDelete() {
		
		Long targetRno = 1L;
		
		mapper.delete(targetRno);
		
	}
	*/
	
	/*
	@Test
	public void testUpdate() {
		
		Long targetRno = 10L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		vo.setReply("Update Reply ");
		
		int count = mapper.update(vo);
		
		log.info("UPDATE COUNT : " + count);
		
	}
	*/
	
	/*
	@Test
	public void testList() {
		
		Criteria cri = new Criteria();
		
		// mno가 1인 게시글
		List<ReplyVO> replies = mapper.getListWithPaging(cri, mnoArr[0]);
		
		replies.forEach(reply -> log.info(reply));
		
	}
	*/
	
	// 페이징 테스트
	@Test
	public void testList2() {
		
		Criteria cri = new Criteria(0, 10);
		
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 1L);
		
		replies.forEach(reply -> log.info(reply));
		
	}
	
	@Test
	public void testMapper() {
		
		log.info(mapper);
		
	}

}
