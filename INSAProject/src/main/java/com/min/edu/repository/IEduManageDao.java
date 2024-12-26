package com.min.edu.repository;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.EduDto;

public interface IEduManageDao {
	
	public List<EduDto> getAllProcess();
	
	public List<EduDto> getProcessInfo(String name);
	
	public int updateConf(Map<String, Object> map);
	
	public List<EduDto> getNotConfirm(String name);

	public List<EduDto> getAllPay();
	
	public List<EduDto> getPayInfo(String name);
	
	public List<EduDto> getAllCheck(Map<String, Object> map);
	
	public List<EduDto> getCheckInfo(String name);

}