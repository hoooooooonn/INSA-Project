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

public class TeachUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("강사 정보 수정화면 입력");
		String teachId = req.getParameter("id");
		//홈으로 이동할때 다시 디비 가져와야함 ,, 중간중간 바뀐 정보가 잇을수잇으니 잘못된거 가지고 다니면 안됨
		ILoginDao dao = new LoginDaoImpl();
		LoginDto info =  dao.getUserInfo(teachId);
		req.setAttribute("teacherInfo", info);
		req.getRequestDispatcher("/WEB-INF/views/TeacherUpdate.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("강사 정보 수정화면 입력");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/HTML; charset=UTF-8;");
		
		HttpSession session = request.getSession();
		String teach_id = request.getParameter("teach_id");
		String teach_name = request.getParameter("teach_name");
		String teach_phone = request.getParameter("teach_phone");
		
		log.info(String.format("%s, %s, %s",teach_id,teach_name,teach_phone));
		
		LoginDto dto = new LoginDto().builder().teach_id(teach_id).teach_name(teach_name).teach_phone(teach_phone).build();
		
		ILoginDao dao = new LoginDaoImpl();
		int cnt =  dao.updateTeachInfo(dto);
		if(cnt ==1) {
			response.sendRedirect("./teachListServlet.do");
		}else {
			response.getWriter().print("<script>alert('정보를 수정하지 못하였습니다 다시 진행해주세요 (∪.∪ )'); location.href='./teachListServlet.do'</script>");
		}
	}

}
