package com.coffeereview.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.extern.log4j.Log4j;

/**
* @packageName	: com.coffeereview.security
* @fileName		: CustomAccessDeniedHandler.java
* @author		: Goonoo Jang
* @date			: 2020.11.29
* @description	:
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.29        Goonoo Jang       최초 생성
*/

// 접근 제한이 된 경우에 다양한 처리를 하기 위해 AccessDeniedHandler 인터페이스를 직접 구현
@Log4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
	
	@Override
	public void handle(HttpServletRequest request,
			HttpServletResponse response, AccessDeniedException accessException) throws IOException, ServletException{
		
		log.error("Access Denied Handler");
		
		log.error("Redirect....");
		
		response.sendRedirect("/accessError");
	}
			
}
