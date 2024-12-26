package com.min.edu.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class EduDto implements Serializable {

	private static final long serialVersionUID = 1868787723689064327L;

	private int seq, lec_code, stu_id, hour, lec_cnt;
	private String day;

	private String teach_conf, stu_conf, confirm;

	private int teach_id;

	private String lec_name;

	private String teach_name, teach_phone;

	private int age;

	private String stu_name, stu_phone, gen, pref, note;
}
