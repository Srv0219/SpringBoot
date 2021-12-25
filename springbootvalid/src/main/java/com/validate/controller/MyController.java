package com.validate.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.validate.entities.LoginData;

@Controller
public class MyController {
	@GetMapping("/form")
	public String openForm(Model model) {
		System.out.println("Opening form");
		model.addAttribute("LoginData", new LoginData());
		return"form";
	}
	
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("LoginData") LoginData data,BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "form";
		}
		
			System.out.println(data);
			return "success";	
	}
}
