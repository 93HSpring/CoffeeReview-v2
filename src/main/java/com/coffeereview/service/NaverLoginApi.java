package com.coffeereview.service;

import com.github.scribejava.core.builder.api.DefaultApi20;

/**
* @packageName	: com.coffeereview.domain
* @fileName		: NaverLoginApi.java
* @author		: Goonoo Jang
* @date			: 2020.11.26
* @description	:
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.26        Goonoo Jang       최초 생성
*/
public class NaverLoginApi extends DefaultApi20 {
	protected NaverLoginApi() {
	}

	private static class InstanceHolder {
		private static final NaverLoginApi INSTANCE = new NaverLoginApi();
	}

	/**
	 * @methodName	: instance
	 * @author		: Goonoo Jang
	 * @date		: 2020.11.26
	 * @return
	 */
	public static NaverLoginApi instance() {
		return InstanceHolder.INSTANCE;
	}

	@Override
	public String getAccessTokenEndpoint() {
		return "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code";
	}

	@Override
	protected String getAuthorizationBaseUrl() {
		return "https://nid.naver.com/oauth2.0/authorize";
	}
}
