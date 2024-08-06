package com.example.boot_error.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@GetMapping("/user")
	public String error() {
		throw new RuntimeException("user");
	}
	
//	@ExceptionHandler(RuntimeException.class)
//	public String handleException(RuntimeException ex) {
//		return "error/page";
//	}
}
