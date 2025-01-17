package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.EduDto;
import com.min.edu.repository.EduManageDaoImpl;
import com.min.edu.repository.IEduManageDao;

public class checkInfoServlet extends HttpServlet {

	private static final long serialVersionUID = -678704771095651229L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IEduManageDao dao = new EduManageDaoImpl();
		String name = req.getParameter("role");
		EduDto lists = dao.getCheckInfo(name);
		req.setAttribute("lists", lists);
		req.getRequestDispatcher("WEB-INF/views/checkInfo.jsp").forward(req, resp);
	}
	
}
