package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.LoginDto;
import com.min.edu.repository.ILoginDao;
import com.min.edu.repository.LoginDaoImpl;

public class TeachAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(this.getClass());
	
	//폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info(" TeachAddServlet GET 강사등록 화면");
		ILoginDao dao = new LoginDaoImpl();
		List<LoginDto> lists = dao.getAllTeacher();

		request.setAttribute("teacherList", lists);
		request.getRequestDispatcher("/WEB-INF/views/TeacherAdd.jsp").forward(request, response);
	}

	//입력
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("TeachAddServlet POST 강사등록");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		String params = String.format("%s,%s,%s", id,name,phone);
		log.info("요청받은 Parameters : " + params);
		
		ILoginDao dao = new LoginDaoImpl();
		LoginDto dto = new LoginDto(name, id, phone);
		
		int row = dao.insertTeacher(dto);
		if(row==1) {
			response.sendRedirect("./teachListServlet.do");
		}
		else {
			log.info("강사추가실패");
		}

		
	}

}
