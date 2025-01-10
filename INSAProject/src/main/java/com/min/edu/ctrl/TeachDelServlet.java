package com.min.edu.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.min.edu.repository.ILoginDao;
import com.min.edu.repository.LoginDaoImpl;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class TeachDelServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		log.info("TeachDelServlet 삭제");
		
		String delid = req.getParameter("id");
		ILoginDao dao = new LoginDaoImpl();
		int row = dao.delTeacher(delid);
		
		if (row == 1) {
			resp.sendRedirect("./teachListServlet.do");
		}
		else {
			log.info("강사 삭제 실패");
		}

	}

}
