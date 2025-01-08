package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.LoginDto;
import com.min.edu.repository.ILoginDao;
import com.min.edu.repository.LoginDaoImpl;


public class mainpageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(this.getClass());
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("mainpageServlet GET 메인페이지 이동");
	
		String dtoid = req.getParameter("id");
		ILoginDao dao = new LoginDaoImpl();
		LoginDto logindto = dao.getUserInfo(dtoid);
		
		req.setAttribute("dto", logindto);
		req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
	}

}
