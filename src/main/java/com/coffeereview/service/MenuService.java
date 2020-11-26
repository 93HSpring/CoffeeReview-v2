package com.coffeereview.service;

import java.util.List;

import com.coffeereview.domain.Criteria;
import com.coffeereview.domain.MenuVO;

/**
* @packageName   : com.coffeereview.service
* @fileName      : MenuService.java
* @author        : SeongPyo Jo
* @date          : 2020.10.29
* @description   : SQL을 처리하기 위한 요청을 하기위한 인터페이스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.10.29        SeongPyo Jo       최초 생성
* 2020.11.10        SeongPyo Jo       메쏘드 이름 변경(get -> getCafeMenu)
* 2020.11.10        SeongPyo Jo       클래스 및 메쏘드 이름 변경(cafe -> menu)
* 2020.11.23        SeongPyo Jo       getMenuList 파라미터 추가 (cafe)
* 2020.11.23        SeongPyo Jo       getMenuList 페이징 처리 메쏘드로 변환
* 2020.11.23        SeongPyo Jo       각 카페별 메뉴들의 총 개수를 구하는 메쏘드 추가 (getTotal)
*/

public interface MenuService {
	
	public MenuVO getMenu(Long cno);
	
	//public List<MenuVO> getMenuList(String cafe);
	
	public List<MenuVO> getMenuList(Criteria cri);
	
	public int getTotal(Criteria cri);

}
