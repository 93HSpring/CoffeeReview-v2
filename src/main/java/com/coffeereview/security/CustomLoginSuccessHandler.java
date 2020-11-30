package com.coffeereview.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

// 로그인 한 사용자에 부여된 권한 Authentication 객체를 이용해서
// 사용자가 가진 모든 권한을 문자열로 체크합니다. 
/**
* @packageName	: com.coffeereview.security
* @fileName		: CustomLoginSuccessHandler.java
* @author		: Goonoo Jang
* @date			: 2020.12.01
* @description	:
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.12.01        Goonoo Jang       최초 생성
*/
@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{
 
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException{
		
		log.warn("Login Success");
		
		List<String> roleNames = new ArrayList<>();
		
		auth.getAuthorities().forEach(authority -> {
			
			roleNames.add(authority.getAuthority());
			
		});
		
		log.warn("ROLE NAME: " + roleNames);

		if (roleNames.contains("ROLE_ADMIN")) {

			response.sendRedirect("/sample/admin"); // 사용자가 ROLE_ADMIN 권한을 가진 경우
			return;
		}
		
		if(roleNames.contains("ROLE_MEMBER")) {
			
			response.sendRedirect("/sample/member"); // 사용자가 ROLE_MEMBER 권한을 가진 경우
			return;
		}
		
		
		response.sendRedirect("/");
	}
}
