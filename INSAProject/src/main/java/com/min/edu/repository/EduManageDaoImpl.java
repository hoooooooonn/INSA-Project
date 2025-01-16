package com.min.edu.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.EduDto;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class EduManageDaoImpl implements IEduManageDao {

	Logger log = Logger.getLogger(this.getClass());
	SqlSessionFactory factory = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.repository.EduManageDaoImpl.";
	
	
	@Override
	public List<EduDto> getAllProcess() {
		log.info("진행중인 수업 전체조회");
		SqlSession session = factory.openSession();
		return session.selectList(NS + "getAllProcess");
	}

	@Override
	public List<EduDto> getProcessInfo(String stu_name) {
		log.info("진행중인 수업 상세조회");
		SqlSession session = factory.openSession();
		return session.selectOne(NS + "getProcessInfo", stu_name);
	}

	@Override
	public boolean updateConf(Map<String, Object> map) {
		SqlSession session = factory.openSession(true);
		int n = session.update(NS + "updateConf" , map);
		return (n>0)?true:false;
	}
	
	@Override
	public List<EduDto> getNotConfirm(String name) {
		SqlSession session = factory.openSession();
		return session.selectList(NS + "getNotConfirm",name);
	}
	
	@Override
	public List<EduDto> getAllPay() {
		SqlSession session = factory.openSession();
		return session.selectList(NS + "getAllPay");
	}
	
	@Override
	public List<EduDto> getPayInfo(String stu_name) {
		SqlSession session = factory.openSession();
		return session.selectList(NS + "getPayInfo", stu_name);
	}
	
	@Override
	public List<EduDto> getAllCheck(Map<String, Object> map) {
		SqlSession session = factory.openSession();
		return session.selectList(NS + "getAllCheck", map);
	}
	
	@Override
	public EduDto getCheckInfo(String seq) {
		SqlSession session = factory.openSession();
		return session.selectOne(NS + "getCheckInfo", seq);
	}

	@Override
	public int DelCheck(String seq) {
		SqlSession session = factory.openSession();
		return session.delete(NS + "DelCheck", seq);
	}

	@Override
	public int insertProcess(Map<String, Object> map) {
		SqlSession session = factory.openSession(true);
		return session.insert(NS + "insertProcess", map);
	}
	
}
