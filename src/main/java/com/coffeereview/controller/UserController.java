package com.coffeereview.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coffeereview.domain.UserVO;
import com.coffeereview.service.NaverLoginBO;
import com.coffeereview.service.UserService;
import com.github.scribejava.core.model.OAuth2AccessToken;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
* @packageName	: com.coffeereview.controller
* @fileName		: UserController.java
* @author		: Goonoo Jang
* @date			: 2020.11.21
* @description	:
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.21        Goonoo Jang       최초 생성
* 2020.11.27		Goonoo Jang		  네이버 로그인 API 관련 메소드 추가 (login(), callback()) 
*/

@Controller
@Log4j
@RequestMapping("/user/*")
@AllArgsConstructor
public class UserController {

	private UserService service;
	
	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;

	// login //
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	@GetMapping("/login")
	public void login(Model model, HttpSession session, HttpServletRequest request) {
		log.info("/login");
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		// https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		// redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		System.out.println("네이버:" + naverAuthUrl);
		// 네이버
		model.addAttribute("url", naverAuthUrl);

		// return "login.jsp";

	}

	// callback //
	@GetMapping("/callback")
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException, ParseException {

		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		// 1. 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken); // String형식의 json데이터
		/**
		 * apiResult json 구조 {"resultcode":"00", "message":"success",
		 * "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
		 **/
		// 2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
		// 3. 데이터 파싱
		// Top레벨 단계 _response 파싱
		JSONObject response_obj = (JSONObject) jsonObj.get("response");
		// response의 nickname값 파싱
		String name = (String) response_obj.get("name");
		String uid = (String) response_obj.get("id");
		model.addAttribute("result", apiResult);
		System.out.println(name);
		
		return "redirect:user_index";

	}

	@GetMapping("/user_index")
	public void mainPage(Model model) {
		log.info("/user_index");

	}
	
	@GetMapping("/insertUser")
	public String insertUser(UserVO vo) throws IOException {
		log.info("/user");
		
		return "home";
		
	}
	
	@GetMapping("/readUser")
	// READ : Id에 해당하는 user 받아오기
	public String readUser(String uid) {
		
		
		return "home";
	}
	

	
	@GetMapping("/updateUser")
	// UPDATE : user 정보를 갱신하기
	public String updateUser(UserVO vo) {
		
		
		return "home";
	}
	
	
	@GetMapping("/deleteUser")

	// DELETE : Id에 해당하는 user 삭제하기
	public String deleteUser(String uid) {
		
		
		return "home";
	}
	
	
	@GetMapping("/findUser")

	// Id에 해당하는 user가 존재하는지 확인하기
	public String findUser(String uid) {
		
		
		return "home";
	}
	
	
	
	
	
}
