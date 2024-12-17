package com.min.edu.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.EmpVo;

public class EmpSelectDaoImpl implements IEmpSelectDao {
	
	private Logger log = Logger.getLogger(this.getClass());
	SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.repository.EmpSelectDaoImpl.";
	

	@Override
	public EmpVo select02(String id) {
		EmpVo vo = null;
		SqlSession session = manager.openSession();
		vo = session.selectOne(NS+"select02",id);
		return vo;
	}
	
	@Override
	public Integer selectEmpId(String id) {
		SqlSession session = manager.openSession();
		int result = session.selectOne(NS+"selectEmpId",id);
		return result;
	}

	@Override
	public String selectEmpName(String id) {
		SqlSession session = manager.openSession();
		String result = session.selectOne(NS+"selectEmpName",id);
		return result;
	}

	@Override
	public String selectJob(String id) {
		SqlSession session = manager.openSession();
		String result = session.selectOne(NS+"selectJob",id);
		return result;
	}

	@Override
	public String selectTeam(String id) {
		SqlSession session = manager.openSession();
		String result = session.selectOne(NS+"selectTeam",id);
		return result;
	}

	@Override
	public String selectPosition(String id) {
		SqlSession session = manager.openSession();
		String result = session.selectOne(NS+"selectPosition",id);
		return result;
	}

	@Override
	public String selectEdu(String id) {
		SqlSession session = manager.openSession();
		String result = session.selectOne(NS+"selectEdu",id);
		return result;
	}

	@Override
	public Integer selectHireY(String id) {
		SqlSession session = manager.openSession();
		int result = session.selectOne(NS+"selectHireY",id);
		return result;
	}

	@Override
	public Integer selectBirth(String id) {
		SqlSession session = manager.openSession();
		int result = session.selectOne(NS+"selectBirth",id);
		return result;
	}

	@Override
	public List<EmpVo> selId_Name(EmpVo vo) {
		SqlSession session = manager.openSession();
		List<EmpVo> lists = session.selectList(NS+"selId_Name",vo);
		return lists;
	}

	@Override
	public EmpVo selId_Bank(Map<String, Object> map) {
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"selId_Bank", map);
	}

	
	

}
