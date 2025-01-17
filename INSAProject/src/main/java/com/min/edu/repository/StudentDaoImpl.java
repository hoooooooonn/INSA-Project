package com.min.edu.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.StudentDto;
import com.min.edu.mybatis.SqlSessionFactoryManager;


public class StudentDaoImpl implements IStudentDao {

	
	private Logger log = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.repository.StudentDaoImpl.";
	
	@Override
	public List<StudentDto> selectAllStudents() {
		log.info("전체학생 조회");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"selectAllStudents");
	}

	@Override
	public StudentDto selectStudentById(int i) {
		log.info("학생 상세정보 : " + i);
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"selectStudentById",i);
	}

	@Override
	public Integer updateStudent(StudentDto dto) {
		log.info("학생 정보수정 : " + dto);
		SqlSession session = manager.openSession(true);
		session.commit();
		return session.update(NS+"updateStudent",dto);
	}

	@Override
	public Integer insertStudent(StudentDto dto) {
		log.info("학생 입력 : " + dto);
		SqlSession session = manager.openSession(true);
		return session.insert(NS+"insertStudent",dto);
	}

	@Override
	public List<StudentDto> selectStudentByName(String name) {
		log.info("학생 이름 검색 : " + name);
		SqlSession session = manager.openSession();
		return session.selectList(NS + "selectStudentByName", name);
	}

}
