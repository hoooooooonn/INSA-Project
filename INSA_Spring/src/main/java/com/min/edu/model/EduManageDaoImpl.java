package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.EduDto;

import lombok.extern.slf4j.Slf4j;
@Repository
@Slf4j
public class EduManageDaoImpl implements IEduManageDao {

	private final String NS = "com.min.edu.model.EduManageDaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<EduDto> getAllProcess() {
		log.info("진행중인 수업 전체조회");
		
		return sqlSession.selectList(NS + "getAllProcess");
	}

	@Override
	public List<EduDto> getProcessInfo(String stu_name) {
		log.info("진행중인 수업 상세조회");
		return sqlSession.selectOne(NS + "getProcessInfo", stu_name);
	}

	@Override
	public boolean updateConf(Map<String, Object> map) {
		int n = sqlSession.update(NS + "updateConf" , map);
		return (n>0)?true:false;
	}
	
	@Override
	public List<EduDto> getNotConfirm(String name) {
		return sqlSession.selectList(NS + "getNotConfirm",name);
	}
	
	@Override
	public List<EduDto> getAllPay() {
		return sqlSession.selectList(NS + "getAllPay");
	}
	
	@Override
	public List<EduDto> getPayInfo(String stu_name) {
		return sqlSession.selectList(NS + "getPayInfo", stu_name);
	}
	
	@Override
	public List<EduDto> getAllCheck(Map<String, Object> map) {
		return sqlSession.selectList(NS + "getAllCheck", map);
	}
	
	@Override
	public EduDto getCheckInfo(String seq) {
		return sqlSession.selectOne(NS + "getCheckInfo", seq);
	}

	@Override
	public int DelCheck(String seq) {
		return sqlSession.delete(NS + "DelCheck", seq);
	}

	@Override
	public int insertProcess(Map<String, Object> map) {
		return sqlSession.insert(NS + "insertProcess", map);
	}
	
}
