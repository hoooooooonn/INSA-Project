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
import com.min.edu.repository.ILoginDao;
import com.min.edu.repository.LoginDaoImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class mainpageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("mainpageServlet GET 메인페이지 이동");

		
	    // HttpSession에서 loginDto 가져오기
	    HttpSession session = req.getSession(false); // 세션이 없으면 null 반환
	    if (session != null) {
	        LoginDto logindto = (LoginDto) session.getAttribute("loginDto");

	        if (logindto != null) {
	            // 로그인된 사용자 정보가 있다면 Teach_id 가져오기
	            String dtoid = logindto.getTeach_id();
	            String dtoname = logindto.getTeach_name();

	            // 이후 로직...
	            ILoginDao dao = new LoginDaoImpl();
	            logindto = dao.getUserInfo(dtoid);
	            
	            IEduManageDao EduManagedao = new EduManageDaoImpl();
	            String role1 = req.getParameter("role1");
	            String role2 = req.getParameter("role2");
	            String search = req.getParameter("search");
	            
	            Map<String, Object> map = new HashMap<String, Object>();
	            if(search==null) {
	            	search=dtoname;
	            }
	            
	            log.info("search : {}",search);
	            
	            map.put("search", search);
	            map.put("role1", role1);
	            map.put("role2", role2);
	            List<EduDto> lists = EduManagedao.getAllCheck(map);
	            
	            req.setAttribute("lists", lists);
	            req.setAttribute("dto", logindto);
	            req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);

	        } else {
	            // 로그인 정보가 없으면 리다이렉트 처리
	            resp.sendRedirect("./login.jsp");
	        }
	    } else {
	        // 세션이 없으면 리다이렉트 처리
	        resp.sendRedirect("./login.jsp");
	    }
	}

}
