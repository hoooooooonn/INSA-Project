package com.min.edu.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Builder
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor


public class StudentDto implements Serializable {


	private static final long serialVersionUID = 8829006345846422338L;
	
	private int stu_id, age;
	private String stu_name, stu_phone, gen, pref, note ;
	
	public StudentDto(int age, String stu_name, String stu_phone, String gen, String pref, String note) {
		super();
		this.stu_name = stu_name;
		this.age = age;
		this.stu_phone = stu_phone;
		this.gen = gen;
		this.pref = pref;
		this.note = note;
	}
	
	

}
