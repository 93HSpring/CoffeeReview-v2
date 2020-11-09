package com.coffeereview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coffeereview.service.CafeService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
* @packageName   : com.coffeereview.controller
* @fileName      : CafeController.java
* @author        : SeongPyo Jo
* @date          : 2020.10.29
* @description   : Cafe 기능과 관련된 컨트롤러
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.10.29        SeongPyo Jo       최초 생성
* 2020.11.10        SeongPyo Jo       카페 메뉴 조회를 위한 getCafeMenu 추가
*/

@Controller
@Log4j
@RequestMapping("/cafe/*")
@AllArgsConstructor
public class CafeController {
	
	private CafeService service;
	
	@GetMapping("/list")
	public void getCafeList(Model model) {
		
		log.info("/list");
		model.addAttribute("list", service.getCafeList());
		
	}
	
	@GetMapping("/menu")
	public void getCafeMenu(@RequestParam("cno") Long cno, Model model) {
		
		log.info("/menu");
		model.addAttribute("menu", service.getCafeMenu(cno));
		
	}
	
}
