package com.coffeereview.domain;

import java.sql.Date;

import lombok.Data;

/**
* @packageName	: com.coffeereview.domain
* @fileName		: UserVO.java
* @author		: Goonoo Jang
* @date			: 2020.11.21
* @description	:
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.21        Goonoo Jang       최초 생성
*/
@Data // Lombok을 이용하여 생성자, getter/setter, toString()등을 만들어내는 Annotation
public class UserVO {
	
	private String uid;
	private String name;
	private String nickname;
	private Integer age;
	private Character gender;
	private String phonenum;
	private String email;
	private String address;
	private Date regdate;

}
