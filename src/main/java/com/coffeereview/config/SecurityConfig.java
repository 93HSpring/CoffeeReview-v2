package com.coffeereview.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.coffeereview.security.CustomLoginSuccessHandler;
import com.coffeereview.security.CustomUserDetailsService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/**
* @packageName	: com.coffeereview.config
* @fileName		: SecurityConfig.java
* @author		: Goonoo Jang
* @date			: 2020.11.29
* @description	:
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.29        Goonoo Jang       최초 생성
* 2020.12.01		Goonoo Jang		  Spring Security 설정 적용
*/
@Configuration
@EnableWebSecurity // 스프링 MVC와 스프링 시큐리티를 결합하는 용도
@Log4j
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Setter(onMethod_ = { @Autowired })
	private DataSource dataSource; // 라이브러리 맞는지 확인
	
	@Bean
	public UserDetailsService customUserService() {
		return new CustomUserDetailsService();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(customUserService()).
			passwordEncoder(passwordEncoder());
		
		/*
		log.info("configure.........................................");
		auth.inMemoryAuthentication()
		.withUser("admin").password("{noop}admin").roles("ADMIN");
		
		auth.inMemoryAuthentication()
		.withUser("member").password("$2a$10$QYs3vq4dljdsaJC8Sl4i../59c7X8p.M9Chkd/OgqjoAvJRNC72jK").roles("MEMBER");
		*/
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		
		http.authorizeRequests()
		.antMatchers("/menu/**").permitAll() //로그인을 하지 않은 사용자도 접근 가능한 URI
		.antMatchers("/user/**").permitAll() //로그인을 하지 않은 사용자도 접근 가능한 URI
		.antMatchers("/sample/all").permitAll() //로그인을 하지 않은 사용자도 접근 가능한 URI
		.antMatchers("/sample/admin").access("hasRole('ROLE_ADMIN')") // 로그인 한 사용자들만이 접근할 수 있는 URI
		.antMatchers("/sample/member").access("hasRole('ROLE_MEMBER')"); // 로그인 한 사용자들 중에서 관리자 권한을 가진 사용자만이 접근할 수 있는 URI
		
		http.formLogin()
		.loginPage("/customLogin")
		.loginProcessingUrl("/login") // Access Denied 되었을 때 로그인 페이지로 이동
		.successHandler(loginSuccessHandler());
		
		http.logout()
		.logoutUrl("/customLogout")
		.invalidateHttpSession(true)
		.deleteCookies("remember-me", "JSESSION_ID");
		// 쿠키 삭제까지
		// 로그아웃 오류 확인
		
		http.rememberMe()
		.key("coffeereview")
		.tokenRepository(persistentTokenRepository())
		.tokenValiditySeconds(604800);
	}
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		return repo;
	}


	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	// JDBC나 복잡한 구성을 사용하기 위해서 PasswordEncoder를 미리 준비
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
