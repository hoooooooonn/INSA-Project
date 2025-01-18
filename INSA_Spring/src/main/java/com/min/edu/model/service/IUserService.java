package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.EduDto;

public interface IUserService {

	// 로그인 진행
	public EduDto getLogin(Map<String, Object> map);

	// -------------------------------------------강사
	// 강사 전체 조회
	public List<EduDto> getAllTeacher();

	// 특정 강사 조회

	// 강사 이름 조회
	public List<EduDto> selectTeacher(String name);

	// 아이디
	public List<EduDto> searchId(Map<String, Object> map);

	// 이름
	public List<EduDto> searchName(Map<String, Object> map);

	// 폰
	public List<EduDto> searchPhone(Map<String, Object> map);

	// 강사추가
	public int insertTeacher(EduDto dto);

//				사용자 상세정보	getUserInfo
	public EduDto getUserInfo(String id);

//				사용자 정보 수정	pudateUserInfo
	public int updateTeachInfo(EduDto dto);

	// 강사 삭제
	public int delTeacher(String teach_id);
	// -------------------------------------------강사 끝
}
