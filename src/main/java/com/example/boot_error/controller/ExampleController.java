package com.example.boot_error.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
	
	@GetMapping("/error-example")
	public String triggerError() {
		System.out.println("trigger 1");
		throw new RuntimeException("에러 테스트1");
	}
	
	@GetMapping("/error-example2")
	public String triggerError2() {
		System.out.println("trigger 2");
		throw new RuntimeException("에러 테스트2");
	}
	
	@GetMapping("/error-example3")
	public String triggerError3(@RequestParam String name) {
		System.out.println("trigger 3");
		throw new RuntimeException("에러 테스트3");
	}
	
	@GetMapping("/error-example4")
	public String triggerError4() throws Exception {
		System.out.println("trigger 4");
		throw new RuntimeException("에러 테스트4");
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<String> handleRequestParameterException(
			MissingServletRequestParameterException ex) {
		System.out.println( "handleRequestParameterException" );
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("에러 발생 :" + ex.getMessage());
	}
	
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
		System.out.println("handler");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("에러 발생 :" + ex.getMessage());
	}
}
