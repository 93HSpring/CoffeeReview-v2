package com.coffeereview.mapper;

import com.coffeereview.domain.MemberVO;

/**
* @packageName	: com.coffeereview.mapper
* @fileName		: MemberMapper.java
* @author		: Goonoo Jang
* @date			: 2020.11.21
* @description	:
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.21        Goonoo Jang       최초 생성
* 2020.11.28		Goonoo Jang		  FindUserNickname() 생성
* 2020.11.29		Goonoo Jang		  'password' column 추가로 인한 insertUser() 수정
* 2020.12.01		Goonoo Jang 	  Spring Security 적용으로 인한 readUser() 수정
* 2020.12.21		Goonoo Jang		  User** -> Member** 클래스명 변경
*/

public interface MemberMapper {
	
	// CREATE : user를 새로 등록하기
	public void insert(MemberVO vo);
	
	// READ : Id에 해당하는 user 받아오기
	public MemberVO read(String uid);
	
	// UPDATE : user 정보를 갱신하기
	public void update(MemberVO vo);
	
	// DELETE : Id에 해당하는 user 삭제하기
	public int delete(String uid);
	
	// Id에 해당하는 user가 존재하는지 확인하기
	public boolean find(String uid);
	
	// uid에 해당하는 user의 nickname을 반환
	public String findByNickname(String uid);
	
	
}
