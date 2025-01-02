package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.LoginDto;
import com.min.edu.repository.ILoginDao;
import com.min.edu.repository.LoginDaoImpl;

public class TeachDelServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		log.info("TeachDelServlet 삭제");

		LoginDto dto = (LoginDto) req.getSession().getAttribute("loginDto");
		// req.getSession().invalidate();

		ILoginDao dao = new LoginDaoImpl();
		List<LoginDto> lists = dao.getAllTeacher();
		req.setAttribute("teacherList", lists);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(dto.getTeach_id());
//		int row = dao.delTeacher(dto.getTeach_id());
//		if (row == 1) {
//			req.getRequestDispatcher("/WEB-INF/views/teacherList.jsp").forward(req, resp);
//		}

	}

}
