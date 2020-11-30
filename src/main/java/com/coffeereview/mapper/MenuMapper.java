package com.coffeereview.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.coffeereview.domain.Criteria;

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
* 2020.11.23        SeongPyo Jo       페이징 처리를 위한 메쏘드 추가 (getMenuListWithPaging)
* 2020.11.23        SeongPyo Jo       각 카페별 메뉴들의 총 개수를 구하는 메쏘드 추가 (getTotalCount)
* 2020.11.29        SeongPyo Jo       메뉴별 리뷰의 개수를 수정할 수 있는 메쏘드 추가 (updateReplyCnt)
* 2020.11.30        SeongPyo Jo       별점 평균을 수정하는 메쏘드 추가(updateReplyStar)
*/

public interface MenuMapper {
	
	//@Select("select * from tbl_cafe where cno > 0")
	public List<MenuVO> getMenuList(String cafe);
	
	public List<MenuVO> getMenuListWithPaging(Criteria cri);
	
	public MenuVO getMenu(Long mno);
	
	public int getTotalCount(Criteria cri);
	
	public void updateReplyCnt(@Param("mno") Long mno, @Param("amount") int amount);
	
	public void updateReplyStar(@Param("mno") Long mno, @Param("star_avg") Double star_avg);
	
}
