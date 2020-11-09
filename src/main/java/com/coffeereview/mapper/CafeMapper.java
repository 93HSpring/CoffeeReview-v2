package com.coffeereview.mapper;

import java.util.List;

//import org.apache.ibatis.annotations.Select;

import com.coffeereview.domain.CafeVO;

/**
* @packageName   : com.coffeereview.mapper
* @fileName      : CafeMapper.java
* @author        : SeongPyo Jo
* @date          : 2020.10.29
* @description   : Mybatis 처리를 위한 매핑 인터페이스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.10.29        SeongPyo Jo       최초 생성
* 2020.11.10        SeongPyo Jo       메쏘드 이름 변경(get -> getCafeMenu)
*/

public interface CafeMapper {
	
	//@Select("select * from tbl_cafe where cno > 0")
	public List<CafeVO> getCafeList();
	
	public CafeVO getCafeMenu(Long cno);

}
