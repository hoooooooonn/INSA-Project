package com.min.edu.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dto.LoginDto;
import com.min.edu.repository.ILoginDao;
import com.min.edu.repository.LoginDaoImpl;

/**
 * Servlet implementation class TeachUpdateServlet
 */
@WebServlet("/TeachUpdateServlet")
public class TeachUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("강사 정보 수정화면 입력");
		//홈으로 이동할때 다시 디비 가져와야함 ,, 중간중간 바뀐 정보가 잇을수잇으니 잘못된거 가지고 다니면 안됨
		ILoginDao dao = new LoginDaoImpl();
		HttpSession session = req.getSession();
		LoginDto logindto = (LoginDto)session.getAttribute("loginDto");
		LoginDto info =  dao.getUserInfo(String.valueOf(logindto.getTeach_id()));
		
		
//		System.out.println("========================");
//		System.out.println(logindto.getTeach_id());
//		System.out.println(info.getTeach_id());
//		System.out.println("========================");
		req.setAttribute("teacherInfo", info);
		
		//화면 값 가져오기
		req.getRequestDispatcher(("/WEB-INF/views/TeacherUpdate.jsp")).forward(req, resp);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
