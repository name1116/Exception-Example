package com.example.boot_error.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;




@ControllerAdvice
public class GlobalErrorHandler {

	@ExceptionHandler(RuntimeException.class)
	public String handleException (
			RuntimeException ex) {
		System.out.println("global");
		return "error/page";
		
	}
	
	
}
