package com.coffeereview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

/**
* @packageName   : com.coffeereview.exception
* @fileName      : CommonExceptionAdvice.java
* @author        : SeongPyo Jo
* @date          : 2020.11.30
* @description   : 컨트롤러의 예외처리를 위한 컨트롤러
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.30        SeongPyo Jo       최초 생성
*/
@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	
	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		
		log.error("Exception........" + ex.getMessage());
		model.addAttribute("exception", ex);
		log.error(model);
		
		return "error_page";
		
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {
		
		return "custom404";
		
	}
	

}
