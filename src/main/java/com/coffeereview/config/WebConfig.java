package com.coffeereview.config;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
* @packageName   : com.coffeereview.config
* @fileName      : WebConfig.java
* @author        : SeongPyo Jo
* @date          : 2020.11.23
* @description   :
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.10.29        SeongPyo Jo       최초 생성
* 2020.11.23        SeongPyo Jo       한글 처리를 위한 인코딩 추가
* 2020.11.29		Goonoo Jang		  Spring Security 적용을 위한 RootConfigClasses() 메소드 변경
* 2020.11.29		Goonoo Jang		  에러 처리를 위한 throwExceptionIfNoHandlerFound 추가
*/
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	// Spring Security 적용을 위한 RootConfigClasses() 메소드 변경
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootConfig.class, SecurityConfig.class};
		// Spring이 로딩될 때 SecurityConfig 클래스가 같이 로딩되도록 수정
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		
		return new Class[] { ServletConfig.class };
		
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		
		return new String[] { "/" };
		
	}
	
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		// TODO Auto-generated method stub

		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
		
	}

	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		
		return new Filter[] { characterEncodingFilter };
		
	}

}
