package com.app.controller.partner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class PartnerInformationController {

	@RequestMapping("/partnerInformation")
	public ModelAndView partnerInformation() {
		return new ModelAndView("/partnerInformation");
	}

}
