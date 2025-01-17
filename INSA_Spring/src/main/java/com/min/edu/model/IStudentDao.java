package com.min.edu.model;

import java.util.List;

import com.min.edu.dto.EduDto;

public interface IStudentDao {

	public List<EduDto> selectAllStudents();

	public EduDto selectStudentById(int stu_id);
	
	public List<EduDto> selectStudentByName(String name);

	public Integer updateStudent(EduDto dto);

	public Integer insertStudent(EduDto dto);

}
