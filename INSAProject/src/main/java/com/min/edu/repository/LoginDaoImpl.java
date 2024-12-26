package com.min.edu.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.LoginDto;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class LoginDaoImpl implements ILoginDao{

	private Logger log = Logger.getLogger(this.getClass());
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

}
