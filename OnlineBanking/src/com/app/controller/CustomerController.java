package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService cs;
	
	@RequestMapping("/login")
	public String showLoginForm() {
		System.out.println("showLoginForm() called");
		return "/customer/login";
	}
}
