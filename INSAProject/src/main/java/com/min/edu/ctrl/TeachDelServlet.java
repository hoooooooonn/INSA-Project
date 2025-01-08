package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.DocumentationTool.Location;

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
