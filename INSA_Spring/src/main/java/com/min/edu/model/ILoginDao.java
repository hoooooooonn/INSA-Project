package com.min.edu.model;

import java.util.Map;

import com.min.edu.dto.EduDto;

public interface ILoginDao {
	
	//로그인 진행
	public EduDto getLogin(Map<String,Object>map);
	

}
