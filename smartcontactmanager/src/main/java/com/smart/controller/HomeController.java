package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.dao.UserRepository;
import com.smart.entities.Contact;
import com.smart.entities.User;

@Controller
public class HomeController {

	@Autowired
	private UserRepository repository;

	@GetMapping("/test")
	@ResponseBody
	public String test() {
		User user = new User();
		user.setName("Sourav Adak");
		user.setEmail("adak.sourav2@gmail.com");
		
		Contact contact = new Contact();
		user.getContact().add(contact);
	
		repository.save(user);
		return "working";
	}
}
