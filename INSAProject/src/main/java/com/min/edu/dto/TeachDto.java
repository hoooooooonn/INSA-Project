package com.min.edu.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeachDto implements Serializable{

	private static final long serialVersionUID = 434095555780304728L;

	private int teach_id;
	private String teach_name, teach_phone;
	
	private LecDto lDto;
	private EnrollDto nDto;
	private EduDto eDto;
	private CheckDto cDto;
	
}
