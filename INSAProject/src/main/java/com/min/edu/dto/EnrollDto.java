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
public class EnrollDto implements Serializable{

	private static final long serialVersionUID = -4987900346965943934L;

	private int teach_id, lec_code;
	
}
