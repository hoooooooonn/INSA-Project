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

public class SearchTeaServlet extends HttpServlet {

	private static final long serialVersionUID = -7050855748804156588L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/HTML; charset=UTF-8;");
		
		ILoginDao dao = new LoginDaoImpl();
		String teacher = req.getParameter("teacher");
		List<LoginDto> teach = dao.selectTeacher(teacher);
		req.setAttribute("teach",teach);
		req.getRequestDispatcher("/WEB-INF/views/lecTeaChild.jsp").forward(req, resp);
	}
	
}
