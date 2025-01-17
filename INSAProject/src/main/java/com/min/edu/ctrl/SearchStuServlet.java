package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.StudentDto;
import com.min.edu.repository.IStudentDao;
import com.min.edu.repository.StudentDaoImpl;

public class SearchStuServlet extends HttpServlet {

	private static final long serialVersionUID = -3511307197471106159L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/HTML; charset=UTF-8;");
		
		IStudentDao dao = new StudentDaoImpl();
		String name= req.getParameter("student");
		List<StudentDto> stu = dao.selectStudentByName(name);
	
		req.setAttribute("stu", stu);
		req.getRequestDispatcher("/WEB-INF/views/lecStuChild.jsp").forward(req, resp);
		
	}
	
	
}
