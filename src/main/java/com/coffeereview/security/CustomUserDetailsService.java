package com.coffeereview.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.coffeereview.domain.UserVO;
import com.coffeereview.mapper.UserMapper;
import com.coffeereview.security.domain.CustomUser;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/**
* @packageName	: com.coffeereview.security
* @fileName		: CustomUserDetailsService.java
* @author		: Goonoo Jang
* @date			: 2020.12.01
* @description	:
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.12.01        Goonoo Jang       최초 생성
*/
@Log4j
public class CustomUserDetailsService implements UserDetailsService{
	
	@Setter(onMethod_ = {@Autowired})
	private UserMapper userMapper;
	
	// Username means uid
	@Override
	public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException{
		log.warn("Load User By Uid : " + uid);
		
		UserVO vo = userMapper.readUser(uid);
		
		log.warn("queried by user mapper: " + vo);
		
		// UserMapper를 이용해서 UserVO를 조회하고,
		// 만일 UserVO의 인스턴스를 얻을 수 있다면 CustomUser 타입의 객체로 변환해서 반환
		return vo == null ? null : new CustomUser(vo);
	}

}
