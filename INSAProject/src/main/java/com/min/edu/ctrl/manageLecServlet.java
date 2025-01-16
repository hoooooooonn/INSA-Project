package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.min.edu.dto.EduDto;
import com.min.edu.dto.LoginDto;
import com.min.edu.repository.EduManageDaoImpl;
import com.min.edu.repository.IEduManageDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class manageLecServlet extends HttpServlet {

	private static final long serialVersionUID = 754762719332500894L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		IEduManageDao dao = new EduManageDaoImpl();
		List<EduDto> lists = (List<EduDto>) dao.getAllCheck(null);

		// 화면이동시 session가져오기
		HttpSession session = req.getSession(false);
		if (session != null) {
			LoginDto logindto = (LoginDto) session.getAttribute("loginDto");
			req.setAttribute("dto", logindto);
		}

		req.setAttribute("lists", lists);
		req.getRequestDispatcher("WEB-INF/views/manageLec.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/HTML; charset=UTF-8;");
		String role1 = req.getParameter("role1");
		String role2 = req.getParameter("role2");
		String search = req.getParameter("search");

		System.out.printf("%s, %s, %s \n", role1, role2, search);

		IEduManageDao dao = new EduManageDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("search", search);
		map.put("role1", role1);
		map.put("role2", role2);

		List<EduDto> lists = dao.getAllCheck(map);

		req.setAttribute("lists", lists);
		req.getRequestDispatcher("WEB-INF/views/manageLec.jsp").forward(req, resp);

	}

}
