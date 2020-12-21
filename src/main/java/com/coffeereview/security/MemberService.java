package com.coffeereview.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coffeereview.domain.MemberVO;
import com.coffeereview.mapper.MemberMapper;
import com.coffeereview.security.domain.CustomUser;

import lombok.AllArgsConstructor;
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
* 2020.12.21		Goonoo Jang		  User** -> Member** 클래스명 변경
*/
@Log4j
@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService{
	// 스프링 4.3 이상에서는 단일 파라미터를 받는 생성자의 경우에는
	// 필요한 파라미터를 자동으로 주입할 수 있다.
	// @AllArgsConstructor가 모든 파라미터를 이용하는 생성자를 만들어 준다.
	// @Setter(onMethod_ = {@Autowired})
	private MemberMapper memberMapper;
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public Long joinUser() {
		return (long) 0;
	}
	
	// Username means uid
	@Override
	public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException{
		log.warn("Load User By Uid : " + uid);
		
		MemberVO vo = memberMapper.read(uid);
		
		log.warn("queried by member mapper: " + vo);
		
		// UserMapper를 이용해서 UserVO를 조회하고,
		// 만일 UserVO의 인스턴스를 얻을 수 있다면 CustomUser 타입의 객체로 변환해서 반환
		return vo == null ? null : new CustomUser(vo);
	}
	
	// CRUD
	

}
