package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ContactController {

	@RequestMapping("/contact")
	public ModelAndView login() {
		return new ModelAndView("/contact");
	}

}
