package com.coffeereview.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coffeereview.domain.CafeVO;
import com.coffeereview.mapper.CafeMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
* @packageName   : com.coffeereview.service
* @fileName      : CafeServiceImpl.java
* @author        : SeongPyo Jo
* @date          : 2020.10.29
* @description   : CafeService의 SQL요청을 실질적으로 처리하는 클래스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.10.29        SeongPyo Jo       최초 생성
* 2020.11.10        SeongPyo Jo       메쏘드 이름 변경(get -> getCafeMenu)
*/

@Log4j
@Service
@AllArgsConstructor // 모든 파라미터를 이용하는 생성자를 만들어 준다.
public class CafeServiceImpl implements CafeService {
	
	// 스프링 4.3 이상에서는 단일 파라미터를 받는 생성자의 경우에는
	// 필요한 파라미터를 자동으로 주입할 수 있다.
	// @AllArgsConstructor가 모든 파라미터를 이용하는 생성자를 만들어 준다.
	private CafeMapper mapper;
	
	@Override
	public CafeVO getCafeMenu(Long cno) {
		// TODO Auto-generated method stub
		
		log.info("getCafeMenu..........");
		
		return mapper.getCafeMenu(cno);
		
	}

	@Override
	public List<CafeVO> getCafeList() {
		// TODO Auto-generated method stub
		
		log.info("getCafeList..........");
		
		return mapper.getCafeList();
		
	}

}
