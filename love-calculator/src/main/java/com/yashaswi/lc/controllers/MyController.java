package com.yashaswi.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	public MyController() {
		System.out.println("MyController detected");
	}
	
	@RequestMapping("/test")
	public String sayHello() {
		return "hello";
	}
}
