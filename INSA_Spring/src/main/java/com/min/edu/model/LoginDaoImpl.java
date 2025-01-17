package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.dto.EduDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginDaoImpl implements ILoginDao{

	private final String NS = "com.min.edu.model.LoginDaoImpl.";
	
	@Override
	public EduDto getLogin(Map<String, Object> map) {
		log.info("사용자 로그인 : " + map);
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getLogin",map);
	}
	
	@Override
	public List<EduDto> getAllTeacher() {
		log.info("강사 전체 목록 조회");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"AllTeacherList");
	
	}
	
	@Override
	public int insertTeacher(EduDto dto) {
		log.info("강사 추가");
		SqlSession session = manager.openSession(true);
		int row = session.insert(NS+"InsertTeacher",dto);
		return row;
	}
	
	@Override
	public EduDto getUserInfo(String id) {
		log.info("특정 강사 조회");
		SqlSession session = manager.openSession();
		EduDto dto = session.selectOne(NS+"getUserInfo",id);
		
		return dto;
	}

	@Override
	public int updateTeachInfo(EduDto dto) {
		log.info("특정 강사 정보 수정");
		SqlSession session = manager.openSession(true);
		int cnt = session.update(NS+"updateTeacher",dto);
		return cnt;
	}
	
	@Override
	public int delTeacher(String teach_id) {
		log.info("강사 삭제");
		SqlSession session = manager.openSession(true);
		int row = session.delete(NS+"delTeacher",teach_id);
		return row;
	}
	
	@Override
	public List<EduDto> searchId(Map<String, Object> map) {
		log.info("searchId : 강사 ID 검색 {}" , map);
		SqlSession session = manager.openSession();
		return session.selectList(NS+"searchId",map);
	}
	
	@Override
	public List<EduDto> searchName(Map<String, Object> map) {
		log.info("searchId : 강사 이름 검색 {}" , map);
		SqlSession session = manager.openSession();
		return session.selectList(NS+"searchName",map);
	}
	
	@Override
	public List<EduDto> searchPhone(Map<String, Object> map) {
		log.info("searchId : 강사 폰 검색 {}" , map);
		SqlSession session = manager.openSession();
		return session.selectList(NS+"searchPhone",map);
	}

	@Override
	public List<EduDto> selectTeacher(String name) {
		log.info("강사 이름 검색");
		SqlSession session = manager.openSession();
		return session.selectList(NS + "selectTeacher", name);
	}

}
