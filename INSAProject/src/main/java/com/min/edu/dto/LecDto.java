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

public class LecDto implements Serializable {

	private static final long serialVersionUID = -670682505801076481L;

	private int lec_code;
	private String lec_name;
	
}
