package com.coffeereview.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coffeereview.domain.MemberVO;
import com.coffeereview.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
* @packageName	: com.coffeereview.service
* @fileName		: MemberServiceImpl.java
* @author		: Goonoo Jang
* @date			: 2020.11.21
* @description	:
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.21        Goonoo Jang       최초 생성
* 2020.11.28		Goonoo Jang		  FindUserNickname() 생성
* 2020.12.21		Goonoo Jang		  User** -> Member** 클래스명 변경
*/

@Log4j
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{
	
	// 스프링 4.3 이상에서는 단일 파라미터를 받는 생성자의 경우에는
	// 필요한 파라미터를 자동으로 주입할 수 있다.
	// @AllArgsConstructor가 모든 파라미터를 이용하는 생성자를 만들어 준다.
	private MemberMapper mapper;
	private PasswordEncoder passwordEncoder;
	

	// CREATE : user를 새로 등록하기
	@Override
	public void insert(MemberVO vo) {
		log.info("insertUser........");
		
		if(mapper.find(vo.getUid())  == true){
			log.info("이미 존재하는 회원입니다.");
			return;
		}
		
		String encodePassword = passwordEncoder.encode(vo.getPassword());
		
		vo.setPassword(encodePassword);
		
		mapper.insert(vo);
	}
	
	// READ : Id에 해당하는 user 받아오기
	public MemberVO read(String uid) {
		
		log.info("readUser.........");
		
		return mapper.read(uid);
	}
	
	// UPDATE : user 정보를 갱신하기
	public void update(MemberVO vo) {
		log.info("updateUser.........");
		
		mapper.update(vo);
	}
	
	// DELETE : Id에 해당하는 user 삭제하기
	public int delete(String uid) {
		log.info("deleteUser.........");
		
		return mapper.delete(uid);
	}
	
	// Id에 해당하는 user가 존재하는지 확인하기
	public boolean find(String uid) {
		log.info("findUser.........");
		
		return mapper.find(uid);
	}
	
	// uid에 해당하는 user의 nickname을 반환
	public String findByNickname(String uid) {
		log.info("findUserNickname.........");
		
		return mapper.findByNickname(uid);
	}
	
	
}
