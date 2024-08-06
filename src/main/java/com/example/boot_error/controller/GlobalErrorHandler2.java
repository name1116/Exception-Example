package com.example.boot_error.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice // rest컨트롤러 대상
//@ControllerAdvice //컨트롤러 대상
public class GlobalErrorHandler2 {

	@ExceptionHandler(RuntimeException.class)
	public String handleException (
			RuntimeException ex) {
		System.out.println("global");
		return "error 발생";
		
	}
	
	
}
