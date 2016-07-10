package com.app.controller.partner;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.domain.partner.Partner;
import com.app.inMemoryDao.partner.PartnerMemoryDao;

@Controller
@RequestMapping("/")
public class PartnerRegisterController {

	// Return true if email not exist, false if email exist aleardy.
	@Autowired
	PartnerMemoryDao partnerMemoryDao;

	@RequestMapping(value = "/partnerRegister", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("/partnerRegister", "partner", new Partner());

	}

	@RequestMapping(value = "/partnerRegister/submit", method = RequestMethod.POST)
	public ModelAndView registerPartner(@Valid @ModelAttribute("partner") Partner partner,
			BindingResult bindingResult) {

		System.out.println(partner.getPartnerLastName());
		System.out.println(partner.getPartnerFirstName());
		System.out.println(partner.getPartnerCompanyOrInstitutionName());
		System.out.println(partner.getPartnerEmail());
		System.out.println(partner.getPartnerPhone());
		System.out.println(partner.getPartnerCategory());
		System.out.println(partner.getPartnerEmail());
		System.out.println(partner.getPartnerPassword());

		ArrayList<String> defaultMessage = new ArrayList<>();

		for (int x = 0; x < bindingResult.getAllErrors().size(); x++) {
			defaultMessage.add(bindingResult.getAllErrors().get(x).getDefaultMessage());
		}

		ModelAndView modelAndView = null;
		boolean hasErros = false;

		if (!bindingResult.hasErrors()) {

			if (partnerMemoryDao.checkPartnerEmail(partner)) {

				modelAndView = new ModelAndView("/login");
				modelAndView.addObject("message", "Succesful registered now please login!");

			} else {
				modelAndView = new ModelAndView("/partnerRegister");
				modelAndView.addObject("message", "Mail already exist");

			}

		} else {
			hasErros = true;
		}

		if (hasErros) {

			modelAndView = new ModelAndView("/partnerRegister");

			modelAndView.addObject("errors", defaultMessage);

		}

		return modelAndView;

	}

}
