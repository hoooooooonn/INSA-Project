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

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegistServlet extends HttpServlet {

	private static final long serialVersionUID = -7839115776527726264L;

	 private Logger log = Logger.getLogger(this.getClass());
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("/WEB-INF/views/stuRegist.jsp").forward(req, resp);
		}
		
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			 req.setCharacterEncoding("UTF-8");

		        // 학생 등록 폼에서 입력받은 데이터 가져오기
		        String stuName = req.getParameter("stu_name");
		        String stuPhone = req.getParameter("stu_phone");
		        String gen = req.getParameter("gen");
		        String age = req.getParameter("age");
		        String pref = req.getParameter("pref");
		        String note = req.getParameter("note");

		        // DTO 객체에 데이터 설정
		        StudentDto dto = new StudentDto();
		        dto.setStu_name(stuName);
		        dto.setStu_phone(stuPhone);
		        dto.setGen(gen);
		        dto.setAge(Integer.parseInt(age));
		        dto.setPref(pref);
		        dto.setNote(note);

		        // DAO 객체 사용하여 학생 등록
		        IStudentDao dao = new StudentDaoImpl();
		        int result = dao.insertStudent(dto);

		        if (result > 0) {
		            // 등록 성공 시 학생 목록 페이지로 리다이렉트
		            resp.sendRedirect(req.getContextPath() + "/stuListServlet.do");
		        } else {
		            // 등록 실패 시 오류 메시지 표시
		            req.setAttribute("errorMessage", "학생 등록에 실패했습니다.");
		            req.getRequestDispatcher("/WEB-INF/views/stuRegist.jsp").forward(req, resp);
		        }
		    }
		}