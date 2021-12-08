package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		int a=5;
		int b=10;
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("Testing...");
		return "Swap of " +" A : "+ a+" B : "+b;
	}
}
