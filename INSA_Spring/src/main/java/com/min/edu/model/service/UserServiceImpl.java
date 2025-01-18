package com.min.edu.model.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.min.edu.dto.EduDto;
import com.min.edu.model.ILoginDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

	private final ILoginDao loginDao;
	
	@Override
	public EduDto getLogin(Map<String, Object> map) {
		log.info("UserServiceImpl getLogin : {}",map);
		return loginDao.getLogin(map);
	}
}
