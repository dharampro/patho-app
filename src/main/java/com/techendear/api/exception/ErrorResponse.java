package com.techendear.api.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.techendear.api.dto.ExceptionDto;

@Component
public class ErrorResponse {

	@Autowired
	private static ExceptionDto exceptionDto;

	public static ExceptionDto convert(Throwable e, ExceptionType type, HttpStatus status) {
		exceptionDto.setTitle(e.getCause().toString());
		exceptionDto.setDetails(e.getMessage().toString());
		exceptionDto.setType(type.toString());
		exceptionDto.setStatus(status.toString());
		return exceptionDto;
	}

}
