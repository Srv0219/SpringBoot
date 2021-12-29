package com.smart.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.dao.UserRepository;
import com.smart.entities.Contact;
import com.smart.entities.User;
import com.smart.helper.Message;

@Controller
public class HomeController {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String home(Model model) {

		return "home";
	}

	@GetMapping("/about")
	public String about(Model model) {

		return "about";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user", new User());

		return "signup";
	}

	// do_register
	@PostMapping("/do_register")
	public String registerUser(
			@Valid @ModelAttribute("user") User user,
			BindingResult result1,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement,
			Model model,
			HttpSession session) {

		try {

			if (!agreement) {
				throw new Exception("You have not agreed terms and condition");
			}
			if (result1.hasErrors()) {
				System.out.println("Error : "+result1.toString());
				model.addAttribute("user", user);
				return "signup";
			}
			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setPassword(passwordEncoder.encode(user.getPassword()));

			System.out.println("Agreement : " + agreement);
			System.out.println("User : " + user);

			User result = this.repository.save(user);
			model.addAttribute("user", new User());
			session.setAttribute("message", new Message("Successfully Registered" , "alert-success"));

			return "signup";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("Something went wrong !!" + e.getMessage(), "alert-danger"));
			return "signup";
		}

	}
	
	@GetMapping("/login")
	public String customLogin(Model model) {
		model.addAttribute("title","Login Page");
		return "login";
	}

	/*
	 * @GetMapping("/test")
	 * 
	 * @ResponseBody public String test() { User user = new User();
	 * user.setName("Sourav Adak"); user.setEmail("adak.sourav2@gmail.com");
	 * 
	 * Contact contact = new Contact(); user.getContact().add(contact);
	 * 
	 * repository.save(user); return "working"; }
	 */
}
