package com.coffeereview.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		com.coffeereview.config.RootConfig.class,
		com.coffeereview.config.SecurityConfig.class })
@Log4j
public class PasswordEncoderTests {

	@Setter(onMethod_ = {@Autowired})
	private PasswordEncoder pwEncoder;
	
	@Test
	public void testEncode() {
		
		String str = "pw00";
		
		String enStr = pwEncoder.encode(str);
		
		// 패스워드 인코딩 결과는 매번 조금씩 달라질 수 있습니다.
		log.info(enStr);
	}
	
}
