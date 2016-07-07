package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class RegisterController {

	@RequestMapping("/register")
	public ModelAndView partnerInformation() {
		return new ModelAndView("/register");
	}

}
