package com.min.edu.login;

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

/**
 * Servlet implementation class TeachAddServlet
 */
@WebServlet("/TeachAddServlet")
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
		
		String id = request.getParameter("id");
		String password = request.getParameter("name");
		String name = request.getParameter("name");
	}

}
