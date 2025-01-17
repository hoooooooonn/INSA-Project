
package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dto.LoginDto;
import com.min.edu.dto.StudentDto;
import com.min.edu.repository.IStudentDao;
import com.min.edu.repository.StudentDaoImpl;

public class StuListServlet extends HttpServlet {


   private static final long serialVersionUID = -3394895074224635505L;
   private Logger log = Logger.getLogger(this.getClass());



   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       log.info("StuListServlet GET 요청 학생 전체보기");
       req.setCharacterEncoding("UTF-8");
       resp.setContentType("text/html; charset=UTF-8");

       IStudentDao dao = new StudentDaoImpl();
       String searchName = req.getParameter("searchName");

       HttpSession session = req.getSession(false);
       LoginDto logindto = (LoginDto) session.getAttribute("loginDto");
       req.setAttribute("dto", logindto);
       
       // 학생 목록을 조회
       List<StudentDto> lists = dao.selectAllStudents();

       // 검색어가 있을 경우 필터링
       if (searchName != null && !searchName.trim().isEmpty()) {
           lists = lists.stream()
               .filter(student -> student.getStu_name().contains(searchName))  // 이름이 포함된 학생만 필터링
               .collect(Collectors.toList());
       }

       if (lists == null) {
           log.error("학생 목록이 null입니다.");
       } else if (lists.isEmpty()) {
           log.info("학생 목록이 비어 있습니다.");
       } else {
           log.info("학생 목록이 정상적으로 조회되었습니다.");
       }
       
       req.setAttribute("lists", lists);
       req.getRequestDispatcher("/WEB-INF/views/stuList.jsp").forward(req, resp);
   }


}
