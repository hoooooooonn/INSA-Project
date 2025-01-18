package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.min.edu.dto.EduDto;
import com.min.edu.model.IEduManageDao;
import com.min.edu.model.service.IUserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {

	@Autowired
	private final IUserService service;

	@Autowired
	private IEduManageDao manageDao;
	

	@GetMapping(value = "/loginServlet.do")
	public String getLogin(HttpSession session) {
		log.info("UserController loginForm 로그인 화면 이동");
		session.invalidate();
		return "login";
	}

	@PostMapping(value = "/loginServlet.do")
	public String setLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		log.info("UserController loginForm 로그인 진행");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", pw);
		log.info("전달받은 요청 값 map :" + map);
		EduDto logindto = service.getLogin(map);
		log.info("전달받은 요청 값 logindto :" + logindto);
		session.setAttribute("dto", logindto);
		return "redirect:/mainpageServlet.do";
	}

	@GetMapping(value = "/mainpageServlet.do")
	public String InputMainPage(Model model,HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		log.info("UserController InputMainPage 메인화면 이동");
		response.setContentType("text/html; charset=UTF-8");

		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Expires", "0");
		
		List<EduDto> lists = manageDao.getAllCheck(null);
		model.addAttribute("lists",lists);
		
		return "main";
	}
}
