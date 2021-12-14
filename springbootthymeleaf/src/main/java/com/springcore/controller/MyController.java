package com.springcore.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model) {
		model.addAttribute("name", "Sourav Adak");
		System.out.println("About handller");
		return "about";
	}

	@RequestMapping(value = "/iterate", method = RequestMethod.GET)
	public String iterateHandler(Model model) {
		List<String> names = List.of("sourav", "rahul", "adhish", "ballu", "anudeep");
		model.addAttribute("names", names);
		return "iterate";
	}
	
	@GetMapping("/condition")
	public String conditionHandler(Model model) {
		model.addAttribute("isActive", true);
		model.addAttribute("gender", 'F');
		List<Integer> list=List.of(435,3245,2354,534);
		model.addAttribute("list", list);
		return "condition";
	}
	
	@GetMapping("/service")
	public String srevicesHandler(Model model) {
		
		return "service";
	}
}
