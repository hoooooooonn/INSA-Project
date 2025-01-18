package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.min.edu.dto.EduDto;
import com.min.edu.model.ILoginDao;
import com.min.edu.model.ITeacherDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

	private final ILoginDao loginDao;
	private final ITeacherDao teacherDao;
	
	@Override
	public EduDto getLogin(Map<String, Object> map) {
		log.info("UserServiceImpl getLogin : {}",map);
		return loginDao.getLogin(map);
	}

	@Override
	public List<EduDto> getAllTeacher() {
		log.info("강사 전체 목록 조회");
		return teacherDao.getAllTeacher();
	}

	@Override
	public List<EduDto> selectTeacher(String name) {
		log.info("강사 추가 : {}", name);
		return teacherDao.selectTeacher(name);
	}

	@Override
	public List<EduDto> searchId(Map<String, Object> map) {
		log.info("특정 강사 조회 {}", map);
		return teacherDao.searchId(map);
	}

	@Override
	public List<EduDto> searchName(Map<String, Object> map) {
		log.info("특정 강사 정보 수정 {}", map);
		return teacherDao.searchName(map);
	}

	@Override
	public List<EduDto> searchPhone(Map<String, Object> map) {
		log.info("강사 삭제 {}", map);
		return teacherDao.searchPhone(map);
	}

	@Override
	public int insertTeacher(EduDto dto) {
		log.info("searchId : 강사 ID 검색 {}" , dto);
		return teacherDao.insertTeacher(dto);
	}

	@Override
	public EduDto getUserInfo(String id) {
		log.info("searchId : 강사 이름 검색 {}" , id);
		return teacherDao.getUserInfo(id);
	}

	@Override
	public int updateTeachInfo(EduDto dto) {
		log.info("searchId : 강사 폰 검색 {}" , dto);
		return teacherDao.updateTeachInfo(dto);
	}

	@Override
	public int delTeacher(String teach_id) {
		log.info("강사 이름 검색");
		return teacherDao.delTeacher(teach_id);
	}
	
	
	
	
}
