package com.coffeereview.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coffeereview.domain.Criteria;
import com.coffeereview.domain.MenuVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/**
* @packageName   : com.coffeereview.mapper
* @fileName      : MenuMapperTests.java
* @author        : SeongPyo Jo
* @date          : 2020.10.29
* @description   : Mybatis 테스트를 위한 클래스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.10.29        SeongPyo Jo       최초 생성
* 2020.11.10        SeongPyo Jo       메쏘드 이름 변경(get -> getCafeMenu)
* 2020.11.10        SeongPyo Jo       클래스 및 메쏘드 이름 변경(cafe -> menu)
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.coffeereview.config.RootConfig.class})
@Log4j
public class MenuMapperTests {

	@Setter(onMethod_ = @Autowired)
	private MenuMapper mapper;
	
	/*
	@Test
	public void testGetCafeList() {
		
		mapper.getMenuList("STARBUCKS").forEach(menu -> log.info(menu));
		
	}*/
	
	/*
	@Test
	public void testGetCafeMenu() {
		
		// 존재하는 게시물 번호로 테스트
		MenuVO menu = mapper.getMenu(1L);
		
		log.info("Read.........." + menu);
		
	}
	*/
	
	/*
	@Test
	public void testPaging() {
		
		Criteria cri = new Criteria(2, 10, "STARBUCKS");
		
		mapper.getMenuListWithPaging(cri).forEach(menu -> log.info(menu));
		
	}
	*/
	
	@Test
	public void testSearch() {
		
		Criteria cri = new Criteria(2, 10, "");
		
		cri.setKeyword("");
		
		List<MenuVO> list = mapper.getMenuListWithPaging(cri);
		
		list.forEach(menu -> log.info(menu));
		
	}
	
}
