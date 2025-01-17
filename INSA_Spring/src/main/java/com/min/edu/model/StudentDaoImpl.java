package com.min.edu.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.dto.EduDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentDaoImpl implements IStudentDao {

	
	private final String NS = "com.min.edu.model.StudentDaoImpl.";
	
	@Override
	public List<EduDto> selectAllStudents() {
		log.info("전체학생 조회");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"selectAllStudents");
	}

	@Override
	public EduDto selectStudentById(int i) {
		log.info("학생 상세정보 : " + i);
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"selectStudentById",i);
	}

	@Override
	public Integer updateStudent(EduDto dto) {
		log.info("학생 정보수정 : " + dto);
		SqlSession session = manager.openSession(true);
		session.commit();
		return session.update(NS+"updateStudent",dto);
	}

	@Override
	public Integer insertStudent(EduDto dto) {
		log.info("학생 입력 : " + dto);
		SqlSession session = manager.openSession(true);
		return session.insert(NS+"insertStudent",dto);
	}

	@Override
	public List<EduDto> selectStudentByName(String name) {
		log.info("학생 이름 검색 : " + name);
		SqlSession session = manager.openSession();
		return session.selectList(NS + "selectStudentByName", name);
	}

}
