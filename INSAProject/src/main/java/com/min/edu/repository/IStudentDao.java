package com.min.edu.repository;

import java.util.List;

import com.min.edu.dto.StudentDto;

public interface IStudentDao {

	public List<StudentDto> selectAllStudents();

	public StudentDto selectStudentById(int stu_id);

	public Integer updateStudent(StudentDto dto);

	public Integer insertStudent(StudentDto dto);

}
