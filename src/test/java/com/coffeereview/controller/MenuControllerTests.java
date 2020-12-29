package com.coffeereview.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.coffeereview.domain.Criteria;
import com.google.gson.Gson;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/**
* @packageName   : com.coffeereview.controller
* @fileName      : CafeControllerTests.java
* @author        : SeongPyo Jo
* @date          : 2020.11.10
* @description   : CafeController 테스트를 위한 클래스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.10        SeongPyo Jo       최초 생성
*/

@RunWith(SpringJUnit4ClassRunner.class)

// Test for Controller
// Servlet의 ServletContext를 이용하기 위함
@WebAppConfiguration

@ContextConfiguration(classes = {com.coffeereview.config.RootConfig.class,
								 com.coffeereview.config.ServletConfig.class})
@Log4j
public class MenuControllerTests {
	
	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	// @Before가 적용되면 모든 테스트 전에 매번 실행된다.
	@Before
	public void setup() {
		
		// 가짜 mvc
		// 가짜로 URL과 파라미터등을 브라우저에서 사용하는 것처럼 만들어서 Controller를 실행해 볼 수 있다.
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		
	}
	
	// MockMvcRequestBuilders를 이용해서 GET 방식의 호출을 한다.
	// 이후 반환된 결과를 이용해서 Model에 어떤 데이터들이 담겨 있는지 확인
	
	/*
	@Test
	public void testGetCafeList() throws Exception {
		
		log.info("testGetCafeList..." +
				mockMvc.perform(MockMvcRequestBuilders.get("/menu/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
				);
		
	}
	*/
	
	/*
	@Test
	public void testGetCafeMenu() throws Exception {
		
		log.info("testGetCafeMenu..." +
				mockMvc.perform(MockMvcRequestBuilders.get("/menu/info").param("mno", "1"))				
				.andReturn()
				.getModelAndView()
				.getModelMap()
				);
		
	}
	*/
	
	/*
	@Test
	public void testListPagin() throws Exception {
		
		log.info(mockMvc.perform(
			MockMvcRequestBuilders.get("/menu/list")
			.param("pageNum", "2")
			.param("amount", "50")
			.param("cafe", "STARBUCKS"))
			.andReturn().getModelAndView().getModelMap());
		
	}
	*/
	
	@Test
	public void testConvert() throws Exception {
		
		Criteria cri = new Criteria();
		
		cri.setKeyword("아이스");
		cri.setOrderKeyword("caffeine");
		
		String jsonStr = new Gson().toJson(cri);
		
		log.info(jsonStr);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/list/STARBUCK/1").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andExpect(status().is(200)); 
		
	}
	
}
