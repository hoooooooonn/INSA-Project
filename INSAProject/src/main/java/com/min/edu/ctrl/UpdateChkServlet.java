package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.EduDto;
import com.min.edu.repository.EduManageDaoImpl;
import com.min.edu.repository.IEduManageDao;

public class UpdateChkServlet extends HttpServlet {

	private static final long serialVersionUID = 3512036514939421591L;
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("UpdateChkServlet GET 조회");
		String seq = req.getParameter("seq");
		
		IEduManageDao dao = new EduManageDaoImpl();
		EduDto dto = dao.getCheckInfo(seq);
		
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/WEB-INF/views/updateChk.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("UpdateChkServlet POST");
	
		String teach_conf = req.getParameter("teach_conf");
		String stu_conf = req.getParameter("stu_conf");
		String confirm = req.getParameter("confirm");
		String seq = req.getParameter("seq");
		
		IEduManageDao dao = new EduManageDaoImpl();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("teach_conf", teach_conf);
		map.put("stu_conf", stu_conf);
		map.put("confirm", confirm);
		map.put("seq", seq);
		
		int cnt = dao.updateConf(map);
		
		
		
	}
}
