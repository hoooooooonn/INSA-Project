package com.min.edu.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.min.edu.dto.EduDto;
import com.min.edu.model.IEduManageDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class EduManageController {
	
	@Autowired
	private IEduManageDao service;

	@GetMapping(value = "/manageLec.do")
	public String manageLec(Model model) {
		log.info("EduManageController manageLec.do GET 요청");
		List<EduDto> lists = (List<EduDto>) service.getAllCheck(null);
		model.addAttribute(lists);
		return "manageLec";
	}
	
}
