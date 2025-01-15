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
		
	// 강사 이름 조회
		public List<LoginDto> selectTeacher(String name);
	

	//강사추가
		public int insertTeacher(LoginDto dto);

//		사용자 상세정보	getUserInfo
		public LoginDto getUserInfo(String id);
//		사용자 정보 수정	pudateUserInfo
		public int updateTeachInfo(LoginDto dto);

		//강사 삭제 
		public int delTeacher(String teach_id);
}
