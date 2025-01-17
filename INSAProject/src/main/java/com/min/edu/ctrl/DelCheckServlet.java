package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.repository.EduManageDaoImpl;
import com.min.edu.repository.IEduManageDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DelCheckServlet extends HttpServlet {

	private static final long serialVersionUID = 7336091087565739311L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("수업체크 삭제");
		String seq = req.getParameter("seq");
		IEduManageDao dao = new EduManageDaoImpl();
		int n = dao.DelCheck(seq);

		if (n == 1) {
			resp.sendRedirect("./manageLec.do");
		} else {
			log.info("수업체크 삭제 실패");
		}
	}

}
