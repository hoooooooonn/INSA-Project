package com.min.edu.model.service;

import java.util.Map;

import com.min.edu.dto.EduDto;

public interface IUserService {

	//로그인 진행
	public EduDto getLogin(Map<String,Object>map);
}
