package com.min.edu.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {

	@GetMapping (value = "/loginServlet.do")
	public String getLogin() {
		log.info("UserController loginForm 로그인 화면 이동");
		return "login";
	}
	
	@PostMapping (value = "/loginServlet.do")
	public String setLogin() {
		log.info("UserController loginForm 로그인 진행");
		return "main";
	}
	
	
	
	@GetMapping (value = "/mainpageServlet.do")
	public String InputMainPage() {
		log.info("UserController InputMainPage 메인화면 이동");
		return "main";
	}
}
