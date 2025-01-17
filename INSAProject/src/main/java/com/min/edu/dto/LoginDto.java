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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDto implements Serializable {

	private static final long serialVersionUID = 9107647696743137201L;

	private String teach_name;
	private String teach_id;
	private String teach_phone;
}
