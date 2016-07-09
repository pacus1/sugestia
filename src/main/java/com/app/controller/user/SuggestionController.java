package com.app.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class SuggestionController {

	@RequestMapping("/suggestion")
	public ModelAndView partnerInformation() {
		return new ModelAndView("/suggestion");
	}

}
