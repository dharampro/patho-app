package com.techendear.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.techendear.api.dto.ExceptionDto;

@RestControllerAdvice
public class GenericGetRequestException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RecordNotFound.class)
	public final ResponseEntity<ExceptionDto> recordNotFoundException(RecordNotFound e) {
		return ResponseEntity.ok(ErrorResponse.convert(e, ExceptionType.NOT_FOUND, HttpStatus.NOT_FOUND));
	}

	@ExceptionHandler(UnAuthorized.class)
	public final ResponseEntity<ExceptionDto> unAuthorizedException(UnAuthorized e) {
		return ResponseEntity.ok(ErrorResponse.convert(e, ExceptionType.UNAUTHORIZED, HttpStatus.UNAUTHORIZED));
	}
	
	
	@ExceptionHandler(InvalidRequest.class)
	public final ResponseEntity<ExceptionDto> invalidRequestException(InvalidRequest e) {
		return ResponseEntity.ok(ErrorResponse.convert(e, ExceptionType.BAD_REQUEST, HttpStatus.BAD_REQUEST));
	}
	
	@ExceptionHandler(UnsupportedType.class)
	public final ResponseEntity<ExceptionDto> unSupportedTypeException(UnsupportedType e) {
		return ResponseEntity.ok(ErrorResponse.convert(e, ExceptionType.UNSUPPORTED_TYPE, HttpStatus.UNSUPPORTED_MEDIA_TYPE));
	}
	
	@ExceptionHandler(ServerError.class)
	public final ResponseEntity<ExceptionDto> serverException(ServerError e) {
		return ResponseEntity.ok(ErrorResponse.convert(e, ExceptionType.SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR));
	}
}
