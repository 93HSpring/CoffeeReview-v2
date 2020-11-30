package com.coffeereview.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.coffeereview.domain.UserVO;

import lombok.Getter;

// UserVO의 인스턴스를 스프링 시큐리티의 UserDetails타입으로 변환하는 작업을 처리하는 클래스
/**
* @packageName	: com.coffeereview.security.domain
* @fileName		: CustomUser.java
* @author		: Goonoo Jang
* @date			: 2020.12.01
* @description	:
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.12.01        Goonoo Jang       최초 생성
*/
@Getter
public class CustomUser extends User {
	
	private static final long serialVersionUID = 1L;
	
	private UserVO user;
	
	public CustomUser(String uid, String password, 
			Collection<? extends GrantedAuthority> authorities) {
		super(uid, password, authorities);
	}
	
	public CustomUser(UserVO vo) {
		super(vo.getUid(), vo.getPassword(), vo.getAuthList().stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getAuth()))
				.collect(Collectors.toList()));
		
		this.user = vo;
	}

}