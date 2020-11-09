package com.coffeereview.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coffeereview.domain.CafeVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/**
* @packageName   : com.coffeereview.mapper
* @fileName      : BoardMapperTests.java
* @author        : SeongPyo Jo
* @date          : 2020.10.29
* @description   : Mybatis 테스트를 위한 클래스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.10.29        SeongPyo Jo       최초 생성
* 2020.11.10        SeongPyo Jo       메쏘드 이름 변경(get -> getCafeMenu)
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.coffeereview.config.RootConfig.class})
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private CafeMapper mapper;
	
	@Test
	public void testGetCafeList() {
		
		mapper.getCafeList().forEach(cafe -> log.info(cafe));
		
	}
	
	@Test
	public void testGetCafeMenu() {
		
		// 존재하는 게시물 번호로 테스트
		CafeVO cafe = mapper.getCafeMenu(1L);
		
		log.info("Read.........." + cafe);
		
	}
	
}
