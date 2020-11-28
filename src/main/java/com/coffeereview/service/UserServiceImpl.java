package com.coffeereview.service;

import org.springframework.stereotype.Service;

import com.coffeereview.domain.UserVO;
import com.coffeereview.mapper.UserMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
* @packageName	: com.coffeereview.service
* @fileName		: UserServiceImpl.java
* @author		: Goonoo Jang
* @date			: 2020.11.21
* @description	:
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.21        Goonoo Jang       최초 생성
* 2020.11.28		Goonoo Jang		  FindUserNickname() 생성
*/

@Log4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	// 스프링 4.3 이상에서는 단일 파라미터를 받는 생성자의 경우에는
	// 필요한 파라미터를 자동으로 주입할 수 있다.
	// @AllArgsConstructor가 모든 파라미터를 이용하는 생성자를 만들어 준다.
	private UserMapper mapper;

	// CREATE : user를 새로 등록하기
	@Override
	public void insertUser(UserVO vo) {
		log.info("insertUser........");
		
		mapper.insertUser(vo);
	}
	
	// READ : Id에 해당하는 user 받아오기
	public UserVO readUser(String uid) {
		
		log.info("readUser.........");
		
		return mapper.readUser(uid);
	}
	
	// UPDATE : user 정보를 갱신하기
	public void updateUser(UserVO vo) {
		log.info("updateUser.........");
		
		mapper.updateUser(vo);
	}
	
	// DELETE : Id에 해당하는 user 삭제하기
	public int deleteUser(String uid) {
		log.info("deleteUser.........");
		
		return mapper.deleteUser(uid);
	}
	
	// Id에 해당하는 user가 존재하는지 확인하기
	public boolean findUser(String uid) {
		log.info("findUser.........");
		
		return mapper.findUser(uid);
	}
	
	// uid에 해당하는 user의 nickname을 반환
	public String findUserNickname(String uid) {
		log.info("findUserNickname.........");
		
		return mapper.findUserNickname(uid);
	}
	
	
}
