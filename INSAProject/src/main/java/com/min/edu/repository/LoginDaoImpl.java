package com.min.edu.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.LoginDto;
import com.min.edu.mybatis.SqlSessionFactoryManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginDaoImpl implements ILoginDao{

	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.repository.LoginDaoImpl.";
	
	@Override
	public LoginDto getLogin(Map<String, Object> map) {
		log.info("사용자 로그인 : " + map);
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getLogin",map);
	}
	
	@Override
	public List<LoginDto> getAllTeacher() {
		log.info("강사 전체 목록 조회");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"AllTeacherList");
	
	}
	
	@Override
	public int insertTeacher(LoginDto dto) {
		log.info("강사 추가");
		SqlSession session = manager.openSession(true);
		int row = session.insert(NS+"InsertTeacher",dto);
		return row;
	}
	
	@Override
	public LoginDto getUserInfo(String id) {
		log.info("특정 강사 조회");
		SqlSession session = manager.openSession();
		LoginDto dto = session.selectOne(NS+"getUserInfo",id);
		
		return dto;
	}

	@Override
	public int updateTeachInfo(LoginDto dto) {
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
	public List<LoginDto> searchId(Map<String, Object> map) {
		log.info("searchId : 강사 ID 검색 {}" , map);
		SqlSession session = manager.openSession();
		return session.selectList(NS+"searchId",map);
	}
	
	@Override
	public List<LoginDto> searchName(Map<String, Object> map) {
		log.info("searchId : 강사 이름 검색 {}" , map);
		SqlSession session = manager.openSession();
		return session.selectList(NS+"searchName",map);
	}
	
	@Override
	public List<LoginDto> searchPhone(Map<String, Object> map) {
		log.info("searchId : 강사 폰 검색 {}" , map);
		SqlSession session = manager.openSession();
		return session.selectList(NS+"searchPhone",map);
	}

}
