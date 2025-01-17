package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.StudentDto;
import com.min.edu.repository.IStudentDao;
import com.min.edu.repository.StudentDaoImpl;

public class StuModifyServlet extends HttpServlet {

private static final long serialVersionUID = 6584978428592087610L;

private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest  req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("StuModifyServlet GET 조회");
		String seq = req.getParameter("stu_id");
		
		IStudentDao dao = new StudentDaoImpl();
		StudentDto dto =dao.selectStudentById(Integer.parseInt(seq));
		
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/WEB-INF/views/stuModify.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 log.info("StuModifyServlet POST 수정 처리");
		  req.setCharacterEncoding("UTF-8");
		 // 수정된 데이터 가져오기
		    String stuId = req.getParameter("stu_id");
		    String stuName = req.getParameter("stu_name");
		    String stuPhone = req.getParameter("stu_phone");
		    String gen = req.getParameter("gen");
		    String age = req.getParameter("age");
		    String pref = req.getParameter("pref");
		    String note = req.getParameter("note");

		    // DTO 객체에 수정된 값들 세팅
		    StudentDto dto = new StudentDto();
		    dto.setStu_id(Integer.parseInt(stuId));
		    dto.setStu_name(stuName);
		    dto.setStu_phone(stuPhone);
		    dto.setGen(gen);
		    dto.setAge(Integer.parseInt(age));
		    dto.setPref(pref);
		    dto.setNote(note);

		    // DAO 객체 사용하여 데이터베이스에서 업데이트
		    IStudentDao dao = new StudentDaoImpl();
		    int result = dao.updateStudent(dto); // 데이터베이스 업데이트 처리

		    if (result > 0) {
		        // 수정이 성공하면 목록 페이지로 리다이렉트
		        resp.sendRedirect(req.getContextPath() + "/stuListServlet.do");
		    } else {
		        // 수정 실패 시 오류 메시지 표시 또는 다시 수정 페이지로 이동
		        req.setAttribute("errorMessage", "수정 실패, 다시 시도해주세요.");
		        req.getRequestDispatcher("/WEB-INF/views/stuModify.jsp").forward(req, resp);
		    }
	}
}

	

