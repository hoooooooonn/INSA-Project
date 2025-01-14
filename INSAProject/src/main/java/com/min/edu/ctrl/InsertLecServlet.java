package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.LoginDto;
import com.min.edu.dto.StudentDto;
import com.min.edu.dto.TeachDto;
import com.min.edu.repository.ILoginDao;
import com.min.edu.repository.IStudentDao;
import com.min.edu.repository.LoginDaoImpl;
import com.min.edu.repository.StudentDaoImpl;

public class InsertLecServlet extends HttpServlet {

	private static final long serialVersionUID = -5508198509591683817L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IStudentDao dao = new StudentDaoImpl();
		List<StudentDto> lists = dao.selectAllStudents();
		ILoginDao login = new LoginDaoImpl();
		List<LoginDto> teach = login.getAllTeacher();
		req.setAttribute("teach", teach);
		req.setAttribute("lists", lists);
		req.getRequestDispatcher("/WEB-INF/views/insertLec.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
}
