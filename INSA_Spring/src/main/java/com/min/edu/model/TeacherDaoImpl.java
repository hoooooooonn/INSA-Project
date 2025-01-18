package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.EduDto;

import lombok.RequiredArgsConstructor;



@Repository
@RequiredArgsConstructor
public class TeacherDaoImpl implements ITeacherDao {
	
	private final SqlSessionTemplate session;
	private final String NS = "com.min.edu.model.TeacherDaoImpl.";
	
	@Override
	public List<EduDto> getAllTeacher() {
		return session.selectList(NS+"AllTeacherList");
	
	}
	
	@Override
	public int insertTeacher(EduDto dto) {
		int row = session.insert(NS+"InsertTeacher",dto);
		return row;
	}
	
	@Override
	public EduDto getUserInfo(String id) {
		EduDto dto = session.selectOne(NS+"getUserInfo",id);
		return dto;
	}

	@Override
	public int updateTeachInfo(EduDto dto) {
		int cnt = session.update(NS+"updateTeacher",dto);
		return cnt;
	}
	
	@Override
	public int delTeacher(String teach_id) {
		int row = session.delete(NS+"delTeacher",teach_id);
		return row;
	}
	
	@Override
	public List<EduDto> searchId(Map<String, Object> map) {
		return session.selectList(NS+"searchId",map);
	}
	
	@Override
	public List<EduDto> searchName(Map<String, Object> map) {
		return session.selectList(NS+"searchName",map);
	}
	
	@Override
	public List<EduDto> searchPhone(Map<String, Object> map) {
		return session.selectList(NS+"searchPhone",map);
	}

	@Override
	public List<EduDto> selectTeacher(String name) {
		return session.selectList(NS + "selectTeacher", name);
	}

	
}
