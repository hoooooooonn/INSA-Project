package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.LoginDto;
import com.min.edu.dto.StudentDto;
import com.min.edu.dto.TeachDto;
import com.min.edu.repository.EduManageDaoImpl;
import com.min.edu.repository.IEduManageDao;
import com.min.edu.repository.ILoginDao;
import com.min.edu.repository.IStudentDao;
import com.min.edu.repository.LoginDaoImpl;
import com.min.edu.repository.StudentDaoImpl;

public class InsertLecServlet extends HttpServlet {

	private static final long serialVersionUID = -5508198509591683817L;
	private Logger log = Logger.getLogger(this.getClass());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IStudentDao dao = new StudentDaoImpl();
		List<StudentDto> lists = dao.selectAllStudents();
		ILoginDao login = new LoginDaoImpl();
		List<LoginDto> teach = login.getAllTeacher();
		req.setAttribute("teach", teach);
		req.setAttribute("lists", lists);
		req.getRequestDispatcher("/WEB-INF/views/insertLec.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/HTML; charset=UTF-8;");
		
		String stuid = req.getParameter("student");
		String teaid = req.getParameter("teacher");
		String lec = req.getParameter("lec");
		String day = req.getParameter("days");
		String hour = req.getParameter("clock");
		
		System.out.printf("%s, %s, %s, %s, %s \n",stuid,teaid,lec,day,hour);
		
		IEduManageDao dao = new EduManageDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stu_id", stuid);
		map.put("lec_code", lec);
		map.put("day", day);
		map.put("hour", hour);
		
		int n = dao.insertProcess(map);
		
		if(n == 8) {
			resp.sendRedirect("./manageLec.do");
		} else {
			log.info("수업 추가 실패");
		}
		
		
	}
	
	
	
}
