package com.app.complaint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ComplaintController {

	@RequestMapping("/complaint")
	public ModelAndView partnerInformation() {
		return new ModelAndView("/complaint");
	}

}
