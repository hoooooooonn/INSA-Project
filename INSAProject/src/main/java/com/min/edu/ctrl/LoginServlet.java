package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dto.LoginDto;
import com.min.edu.repository.ILoginDao;
import com.min.edu.repository.LoginDaoImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 7025409100267403911L;

	// 로그아웃
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("LoginServlet GET 로그아웃");
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect("./"); // ./는 첫화면

	}

	// 로그인
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("LoginServlet Get 로그인");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		ILoginDao dao = new LoginDaoImpl();

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", pw);

		log.info("전달받은 요청 값 :" + map);
		LoginDto logindto = dao.getLogin(map);
		log.info("로그인된 사용자 정보 : " + logindto);
	
		
	
		

		if (logindto != null) {
			HttpSession session = req.getSession();
			session.setAttribute("loginDto", logindto);
			log.info("로그인성공" + logindto);
			req.setAttribute("dto", logindto);
			req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
			
		}else {
			resp.getWriter().print("<script>alert('회원이 존재하지 않습니다.'); location.href='./' </script>");
		}

	}

}
