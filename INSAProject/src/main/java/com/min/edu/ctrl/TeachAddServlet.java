package com.min.edu.ctrl;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.min.edu.dto.LoginDto;
import com.min.edu.repository.ILoginDao;
import com.min.edu.repository.LoginDaoImpl;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class TeachAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info(" TeachAddServlet GET 강사등록 화면");
		ILoginDao dao = new LoginDaoImpl();
		List<LoginDto> lists = dao.getAllTeacher();

		request.setAttribute("lists", lists);
		request.getRequestDispatcher("/WEB-INF/views/TeacherAdd.jsp").forward(request, response);
	}

	//입력
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 log.info("TeachAddServlet POST 강사등록");

		    request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html; charset=UTF-8;");

		    String name = null, phone = null;

		    String id = request.getParameter("id");

		    // 이름 유효성 검사
		    if (Chkname(request.getParameter("name"))) {
		        name = request.getParameter("name");
		    } else {
		        log.info("유효하지 않은 이름 입력");
		    }


		    if (ChkPhone(request.getParameter("phone"))) {
		        phone = request.getParameter("phone");
		    } else {
		        log.info("유효하지 않은 전화번호 입력");
		    }

	
		    if (phone == null || name == null) {
		        log.info("강사추가실패");
				response.getWriter().print("<script>alert('강사추가실패');location.href='./teachListServlet.do';</script>");
		    }

		    String params = String.format("%s,%s,%s", id, name, phone);
		    log.info("요청받은 Parameters : " + params);

		    ILoginDao dao = new LoginDaoImpl();
		    LoginDto dto = new LoginDto(name, id, phone);

		    int row = dao.insertTeacher(dto);
		    if (row == 1) {
		        response.sendRedirect("./teachListServlet.do");
		    } else {
		        log.info("강사추가실패");
				response.getWriter().print("<script>alert('강사추가실패');location.href='./teachListServlet.do';</script>");
		    }

		
	}
	
	public boolean Chkname(String name) {
		
		String regex = "^[가-힣a-zA-Z]{2,20}$"; 
	    return name != null && name.matches(regex);
	}
	
	public boolean ChkPhone(String phone) {
		   String regex = "^(010-?\\d{4}-?\\d{4}|010\\d{8})$";
		    return phone != null && phone.matches(regex);
	}

}
