package com.app.controller.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.domain.user.User;
import com.app.inMemoryDao.user.UserMemoryDao;

@Controller
@RequestMapping("/")
public class RegisterController {

	// Return true if email not exist, false if email exist aleardy.
	@Autowired
	UserMemoryDao userMemoryDao;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(HttpServletRequest httpServletRequest) {

		ModelAndView modelAndView = new ModelAndView();
		if (httpServletRequest.getSession().getAttribute("currentUser") != null
				|| httpServletRequest.getSession().getAttribute("currentPartner") != null) {

			modelAndView = new ModelAndView("/logged/loggedIndex");

			modelAndView.addObject("currentUser", httpServletRequest.getAttribute("currentUser"));
			modelAndView.addObject("currentPartner", httpServletRequest.getAttribute("currentPartner"));

			return modelAndView;
		}

		return new ModelAndView("/register", "user", new User());

	}

	@RequestMapping(value = "/register/submit", method = RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

		ArrayList<String> defaultMessage = new ArrayList<>();

		for (int x = 0; x < bindingResult.getAllErrors().size(); x++) {
			defaultMessage.add(bindingResult.getAllErrors().get(x).getDefaultMessage());
		}

		ModelAndView modelAndView = null;
		boolean hasErros = false;

		if (!bindingResult.hasErrors()) {

			if (userMemoryDao.checkUserEmail(user)) {

				modelAndView = new ModelAndView("/login");
				modelAndView.addObject("message", "Succesful registered now please login!");

			} else {
				modelAndView = new ModelAndView("/register");
				modelAndView.addObject("message", "Mail already exist");

			}

		} else {
			hasErros = true;
		}

		if (hasErros) {

			modelAndView = new ModelAndView("/register");

			modelAndView.addObject("errors", defaultMessage);

		}

		return modelAndView;

	}

}
