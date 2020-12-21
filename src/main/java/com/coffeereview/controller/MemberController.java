package com.coffeereview.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.coffeereview.domain.MemberVO;
import com.coffeereview.service.NaverLoginBO;
import com.coffeereview.service.MemberService;
import com.github.scribejava.core.model.OAuth2AccessToken;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
* @packageName	: com.coffeereview.controller
* @fileName		: MemberController.java
* @author		: Goonoo Jang
* @date			: 2020.11.21
* @description	:
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.21        Goonoo Jang       최초 생성
* 2020.11.27		Goonoo Jang		  네이버 로그인 API 관련 메소드 추가 (login(), callback())
* 2020.11.27		Goonoo Jang		  회원가입, 로그인, 로그아웃 메소드 추가 (register(), signup(), logout() ) 
* 2020.11.29		Goonoo Jang		  tbl_users column 추가로 인한 callback()메소드 수정
* 2020.12.21		Goonoo Jang		  User** -> Member** 클래스명 변경
*/

@Controller
@Log4j
@RequestMapping("/user/*")
@AllArgsConstructor
public class MemberController {

	private MemberService service;
	
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
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session, HttpServletRequest req)
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
		
		// tbl_users DB에 현재 로그인된 회원이 존재하면
		if (service.find(uid)) {
			// 4.파싱 닉네임 세션으로 저장
			session.setAttribute("sessionId", uid); // 세션 생성
			session.setAttribute("sessionName", name); // 웹에 띄울 사용자 이름 저장
			
			return "redirect:user_index";
		} else { // tbl_users DB에 회원정보가 없으면
			// 회원가입 페이지로 넘어가기
			FlashMap fm = RequestContextUtils.getOutputFlashMap(req);
			fm.put("uid", uid);
			fm.put("password", "asdasd");
			fm.put("name", name);
			fm.put("nickname", (String) response_obj.get("nickname"));
			fm.put("email", (String) response_obj.get("email"));
			
			
			/*
			model.addAttribute("uid", uid);
			model.addAttribute("name", name);
			model.addAttribute("nickname", (String) response_obj.get("nickname"));
			model.addAttribute("age", (String) response_obj.get("age"));
			model.addAttribute("gender", (String) response_obj.get("gender"));
			model.addAttribute("email", (String) response_obj.get("email"));
			*/
			

			return "redirect:register";
		}

	}
	
	@GetMapping("/register")
	public void registerUser(Model model, HttpServletRequest req) {
		log.info("/register");
		
		Map<String, ?> flashmap = RequestContextUtils.getInputFlashMap(req);
		if(flashmap != null) {
			model.addAllAttributes(flashmap);
		}
		
	}
	
	@RequestMapping(value = "/signup", method = { RequestMethod.GET, RequestMethod.POST })
	public String signupUser(@ModelAttribute MemberVO vo) throws IOException{
		
		service.insert(vo);
		
		return "redirect:user_index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) throws IOException{
		log.info("/logout");
		session.invalidate();
		return "redirect:user_index";
	}

	@GetMapping("/user_index")
	public void mainPage(Model model) {
		log.info("/user_index");
		//System.out.println(service.findUserNickname("6746635"));

	}
	
	@GetMapping("/insertUser")
	public String insertUser(MemberVO vo) throws IOException {
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
	public String updateUser(MemberVO vo) {
		
		
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
