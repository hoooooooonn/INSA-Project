package com.min.edu.dto;

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
public class EduDto {
	

	private String day;
	private String teach_conf, stu_conf, confirm;
	private String lec_name;
	private String teach_name, teach_phone;
	private String stu_name, stu_phone, gen, pref, note;

	private int teach_id;
	private int age;
	private int seq, lec_code, stu_id, hour, lec_cnt;




}
