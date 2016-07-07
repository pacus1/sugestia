package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AboutUsController {

	@RequestMapping("/aboutUs")
	public ModelAndView aboutUs() {
		return new ModelAndView("/aboutUs");
	}

}
