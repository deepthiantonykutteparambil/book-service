package com.book.controller.advice;


import com.book.exception.BookException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(value = BookException.class)
	public ResponseEntity<String> handleBookException(BookException exception) {
		log.error("BookException occurred {}", exception.getMessage(), exception);
		return ResponseEntity.badRequest().body(exception.getMessage());
	}


	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> handleException(Exception exception) {
		log.error("Exception occurred {}", exception.getMessage(), exception);
		return ResponseEntity.internalServerError()
				.body(exception.getMessage());
	}

}
