package com.coffeereview.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
* 2020.11.23        SeongPyo Jo       메뉴 이미지 출력을 위한 getFile 추가
* 2020.11.23        SeongPyo Jo       getFile 메쏘드 파라미터 이름 변경 (fileName -> menuName)
* 2020.11.23        SeongPyo Jo       getCafeMenu 모델 파라미터 이름 변경 (menu -> menuInfo)
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
		model.addAttribute("menuInfo", service.getMenu(mno));
		
	}
	
	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String menuName) {
		
		log.info("fileName : " + menuName);
		
		File file = new File("c:\\upload\\" + menuName + ".jpg");
		
		log.info("file: " + file);
		
		ResponseEntity<byte[]> result = null;
		
		try {
			
			HttpHeaders header = new HttpHeaders();
			
			header.add("Content-type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
}
