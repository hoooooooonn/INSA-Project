package com.min.edu.ctrl;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dto.LoginDto;
import com.min.edu.repository.ILoginDao;
import com.min.edu.repository.LoginDaoImpl;


public class TeachListServlet extends HttpServlet {

	private static final long serialVersionUID = -5489967526809011042L;
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("UserListServlet GET 요청 사용자 보기");
		
		HttpSession session = req.getSession();
		LoginDto dto = (LoginDto)session.getAttribute("loginDto");
		
		ILoginDao dao = new LoginDaoImpl();
		List<LoginDto> lists = dao.getAllTeacher();
		
		//정렬
		Collections.sort(lists,new Comparator<LoginDto>() {

			@Override
			public int compare(LoginDto o1, LoginDto o2) {
				
				int id1 = Integer.parseInt(o1.getTeach_id());
			    int id2 = Integer.parseInt(o2.getTeach_id());
			    
			    return Integer.compare(id1, id2);
			}
			
		});
		
		

		req.setAttribute("teacherList", lists);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/WEB-INF/views/teacherList.jsp").forward(req, resp);
	}
	
	

}
