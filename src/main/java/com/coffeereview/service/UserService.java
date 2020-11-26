package com.coffeereview.service;

import com.coffeereview.domain.UserVO;

/**
* @packageName	: com.coffeereview.service
* @fileName		: UserService.java
* @author		: Goonoo Jang
* @date			: 2020.11.21
* @description	:
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.21        Goonoo Jang       최초 생성
*/
public interface UserService {

	// CREATE : user를 새로 등록하기
	public void insertUser(UserVO vo);
	
	// READ : Id에 해당하는 user 받아오기
	public UserVO readUser(String uid);
	
	// UPDATE : user 정보를 갱신하기
	public void updateUser(UserVO vo);
	
	// DELETE : Id에 해당하는 user 삭제하기
	public int deleteUser(String uid);
	
	// Id에 해당하는 user가 존재하는지 확인하기
	public boolean findUser(String uid);
}
