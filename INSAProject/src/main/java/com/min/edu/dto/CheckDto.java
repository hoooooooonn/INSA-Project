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

public class CheckDto implements Serializable{

	private static final long serialVersionUID = -4553102852310424655L;

	private int SEQ;
	private String teach_conf, stu_conf, confirm;
	
	
}
