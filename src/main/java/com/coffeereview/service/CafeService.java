package com.coffeereview.service;

import java.util.List;

import com.coffeereview.domain.CafeVO;

/**
* @packageName   : com.coffeereview.service
* @fileName      : CafeService.java
* @author        : SeongPyo Jo
* @date          : 2020.10.29
* @description   : SQL을 처리하기 위한 요청을 하기위한 인터페이스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.10.29        SeongPyo Jo       최초 생성
* 2020.11.10        SeongPyo Jo       메쏘드 이름 변경(get -> getCafeMenu)
*/

public interface CafeService {
	
	public CafeVO getCafeMenu(Long cno);
	
	public List<CafeVO> getCafeList();

}
