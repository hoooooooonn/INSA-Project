package com.min.edu.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.LoginDto;
import com.min.edu.repository.ILoginDao;
import com.min.edu.repository.LoginDaoImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchTeacherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("SearchTeacherServlet GET : 강사 검색");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/HTML; charset=UTF-8;");
		
		String select = req.getParameter("search");
		String searchtxt = req.getParameter("searchtext");
		log.info("검색 조건 : {}, 검색어 :{} ",select,searchtxt);
		
		//log.info("검색하려는 항목 : {}, 검색어 : {}",select, searchtxt);

		ILoginDao dao = new LoginDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		List<LoginDto> lists = new ArrayList<>();
		map.put("search", searchtxt);
		
		if(select.equals("id")) {
			lists = dao.searchId(map);
			req.setAttribute("lists", lists);
			req.getRequestDispatcher("/WEB-INF/views/teacherList.jsp").forward(req, resp);
		}else if(select.equals("name")) {
			lists = dao.searchName(map);
			req.setAttribute("lists", lists);
			req.getRequestDispatcher("/WEB-INF/views/teacherList.jsp").forward(req, resp);
		}else if(select.equals("phone")) {
			lists = dao.searchPhone(map);
			req.setAttribute("lists", lists);
			req.getRequestDispatcher("/WEB-INF/views/teacherList.jsp").forward(req, resp);
		}else {//전체
			resp.sendRedirect("./teachListServlet.do");
		}
		
		
	}
	

}
