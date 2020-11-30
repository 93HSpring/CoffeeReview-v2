package com.coffeereview.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coffeereview.domain.UserVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.coffeereview.config.RootConfig.class})
@Log4j
public class UserMapperTests {

	@Setter(onMethod_ = @Autowired)
	private UserMapper mapper;
	
	@Test
	public void testRead() {
		
		UserVO vo = mapper.readUser("admin00");
		
		log.info(vo);
		
		vo.getAuthList().forEach(authVO -> log.info(authVO));
	}
}
