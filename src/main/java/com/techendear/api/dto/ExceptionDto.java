package com.techendear.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDto {	
	
	private String type;
	private String title;
	private String status;
	private String details;
}
