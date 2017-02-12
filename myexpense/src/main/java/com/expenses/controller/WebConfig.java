package com.expenses.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebConfig {

	@RequestMapping(value="/greeting")
	public String hello(Model model) {
		model.addAttribute("greeting", "Hello Anudeep");
		return "hello";
	}

}
