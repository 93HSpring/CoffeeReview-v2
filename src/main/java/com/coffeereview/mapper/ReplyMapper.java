package com.coffeereview.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.coffeereview.domain.Criteria;
import com.coffeereview.domain.ReplyVO;

/**
* @packageName   : com.coffeereview.mapper
* @fileName      : ReplyMapper.java
* @author        : SeongPyo Jo
* @date          : 2020.11.26
* @description   :
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.26        SeongPyo Jo       최초 생성
* 2020.11.26        SeongPyo Jo       CRUD 기능 구현
* 2020.11.26        SeongPyo Jo       리뷰 숫자 파악하는 메쏘드 추가(getCountByMno)
* 2020.11.30        SeongPyo Jo       별점 평균을 구하는 메쏘드 추가(getStarAvgByMno)
*/
public interface ReplyMapper {
	
	public int insert(ReplyVO vo);
	
	public ReplyVO read(Long rno);
	
	public int delete(Long rno);
	
	public int update(ReplyVO reply);
	
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("mno") Long mno);
	
	public int getCountByMno(Long mno);
	
	public Double getStarAvgByMno(Long mno);

}
