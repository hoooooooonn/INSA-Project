package com.min.edu.repository;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.EmpVo;

public interface IEmpSelectDao {
	
	public Integer selectEmpId(String id);
	public String selectEmpName(String id);
	public String selectJob(String id);
	public String selectTeam(String id);
	public String selectPosition(String id);
	public String selectEdu(String id);
	public Integer selectHireY(String id);
	public Integer selectBirth(String id);
	public List<EmpVo> selId_Name(EmpVo vo);
	public EmpVo selId_Bank(Map<String, Object> map);
	
	public EmpVo select02(String id);


}
