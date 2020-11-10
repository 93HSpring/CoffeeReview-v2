package com.coffeereview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coffeereview.service.MenuService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
* @packageName   : com.coffeereview.controller
* @fileName      : MenuController.java
* @author        : SeongPyo Jo
* @date          : 2020.10.29
* @description   : Cafe 기능과 관련된 컨트롤러
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.10.29        SeongPyo Jo       최초 생성
* 2020.11.10        SeongPyo Jo       카페 메뉴 조회를 위한 getCafeMenu 추가
* 2020.11.10        SeongPyo Jo       클래스 및 메쏘드 이름 변경(cafe -> menu)
*/

@Controller
@Log4j
@RequestMapping("/menu/*")
@AllArgsConstructor
public class MenuController {
	
	private MenuService service;
	
	@GetMapping("/list")
	public void getCafeList(Model model) {
		
		log.info("/list");
		model.addAttribute("list", service.getMenuList());
		
	}
	
	@GetMapping("/info")
	public void getCafeMenu(@RequestParam("mno") Long mno, Model model) {
		
		log.info("/info");
		model.addAttribute("menu", service.getMenu(mno));
		
	}
	
}
