package com.coffeereview.mapper;

import java.util.List;

//import org.apache.ibatis.annotations.Select;

import com.coffeereview.domain.MenuVO;

/**
* @packageName   : com.coffeereview.mapper
* @fileName      : MenuMapper.java
* @author        : SeongPyo Jo
* @date          : 2020.10.29
* @description   : Mybatis 처리를 위한 매핑 인터페이스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.10.29        SeongPyo Jo       최초 생성
* 2020.11.10        SeongPyo Jo       메쏘드 이름 변경(get -> getCafeMenu)
* 2020.11.10        SeongPyo Jo       클래스 및 메쏘드 이름 변경(cafe -> menu)
* 2020.11.23        SeongPyo Jo       getMenuList 파라미터 추가 (cafe)
*/

public interface MenuMapper {
	
	//@Select("select * from tbl_cafe where cno > 0")
	public List<MenuVO> getMenuList(String cafe);
	
	public MenuVO getMenu(Long mno);

}
