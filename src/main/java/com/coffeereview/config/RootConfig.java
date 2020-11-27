package com.coffeereview.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.coffeereview.service.NaverLoginBO;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
* @packageName   : com.coffeereview.config
* @fileName      : RootConfig.java
* @author        : SeongPyo Jo
* @date          : 2020.10.29
* @description   : Spring의 Root 설정
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.10.29        SeongPyo Jo       최초 생성
* 2020.10.29        SeongPyo Jo       서비스 객체 설정 (ComponentScan)
* 2020.11.27		Goonoo Jang		  String타입 Bean 설정 ( string() )
*/

@Configuration
@ComponentScan(basePackages = "com.coffeereview.service")
@MapperScan(basePackages = {"com.coffeereview.mapper"})
public class RootConfig {
	
	// 커넥션 풀 설정
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		
		// log4j2 설정
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		hikariConfig.setJdbcUrl("jdbc:log4jdbc:mariadb://localhost:3306/coview");
		
		hikariConfig.setUsername("sa");
		hikariConfig.setPassword("testsa");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		
		return dataSource;
	}
	
	// Mybatis 설정
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		return (SqlSessionFactory) sqlSessionFactory.getObject();
	}
	
	// String 타입 bean 설정 (for UserController)
	@Bean
	public String string() {
		return new String();
	}
	

	
}
