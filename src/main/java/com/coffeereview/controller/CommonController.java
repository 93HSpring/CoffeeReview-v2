package com.coffeereview.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

/**
* @packageName	: com.coffeereview.controller
* @fileName		: CommonController.java
* @author		: Goonoo Jang
* @date			: 2020.11.29
* @description	:
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.29        Goonoo Jang       최초 생성
*/
@Controller
@Log4j
public class CommonController {

	// 접근 제한 시 보이는 화면을 처리
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access denied : " + auth);
		
		model.addAttribute("msg", "Access Denied");
	}
	
	// 커스텀 로그인 페이지
	// 반드시 GET방식으로 접근하는 URI를 지정해야
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		
		log.info("error: " + error);
		log.info("logout: " + logout);
		
		if(error != null) {
			model.addAttribute("error", "Login Error Check Your Account");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "Logout!!");
		}
	}
	
	// 로그아웃을 결정하는 페이지에 대한 메소드
	// 로그아웃 시 추가적인 작업을 해야 한다면 logoutSuccessHandler를 정의해서 처리한다.
	@GetMapping("/customLogout")
	public void logoutGET() {
		
		log.info("custom logout");
	}
	
}
