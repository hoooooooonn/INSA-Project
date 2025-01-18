package com.min.edu.model;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.EduDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LoginDaoImpl implements ILoginDao {

	
	private final SqlSessionTemplate session;
	private final String NS = "com.min.edu.model.LoginDaoImpl.";
	
	@Override
	public EduDto getLogin(Map<String, Object> map) {
		return session.selectOne(NS+"getLogin",map);
	}

}
