package com.coffeereview.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coffeereview.domain.UserVO;
import com.coffeereview.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
* @packageName	: com.coffeereview.controller
* @fileName		: UserController.java
* @author		: Goonoo Jang
* @date			: 2020.11.21
* @description	:
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.21        Goonoo Jang       최초 생성
*/

@Controller
@Log4j
@RequestMapping("/user/*")
@AllArgsConstructor
public class UserController {

	private UserService service;
	
	@GetMapping("/index")
	public void mainPage(Model model) {
		log.info("/index");
		
	}
	
	@GetMapping("/insertUser")
	public String insertUser(UserVO vo) throws IOException {
		log.info("/user");
		
		return "home";
		
	}
	
	@GetMapping("/readUser")
	// READ : Id에 해당하는 user 받아오기
	public String readUser(String uid) {
		
		
		return "home";
	}
	

	
	@GetMapping("/updateUser")
	// UPDATE : user 정보를 갱신하기
	public String updateUser(UserVO vo) {
		
		
		return "home";
	}
	
	
	@GetMapping("/deleteUser")

	// DELETE : Id에 해당하는 user 삭제하기
	public String deleteUser(String uid) {
		
		
		return "home";
	}
	
	
	@GetMapping("/findUser")

	// Id에 해당하는 user가 존재하는지 확인하기
	public String findUser(String uid) {
		
		
		return "home";
	}
	
	
	
	
	
}
