package com.min.edu.repository;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.LoginDto;


public interface ILoginDao {
	
	//로그인 진행
	public LoginDto getLogin(Map<String,Object>map);
	
	//강사 전체 조회
		public List<LoginDto> getAllTeacher();

	// 특정 강사 조회

	//강사추가

	//강사 정보 수정

}
