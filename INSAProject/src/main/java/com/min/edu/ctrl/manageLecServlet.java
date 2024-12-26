package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.EduDto;
import com.min.edu.repository.EduManageDaoImpl;
import com.min.edu.repository.IEduManageDao;

public class manageLecServlet extends HttpServlet {

	private static final long serialVersionUID = 754762719332500894L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IEduManageDao dao = new EduManageDaoImpl();
		List<EduDto> lists = (List<EduDto>)dao.getAllCheck(null);
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
		
		System.out.printf("%s, %s, %s \n" , role1, role2, search);
		
		
		IEduManageDao dao = new EduManageDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("search", search);
		map.put("role1", role1);
		map.put("role2", role2);
		
		List<EduDto> lists = dao.getAllCheck(map);
		req.setAttribute("lists", lists);
		req.getRequestDispatcher("WEB-INF/views/manageLec.jsp").forward(req, resp);
		
		if(search == null) {
			resp.sendRedirect("./manageLec.do");
		}
		
	}
	
}
