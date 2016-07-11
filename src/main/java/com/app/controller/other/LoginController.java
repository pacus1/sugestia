package com.app.controller.other;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.inMemoryDao.partner.PartnerMemoryDao;
import com.app.inMemoryDao.user.UserMemoryDao;

@Controller
@RequestMapping("/")
public class LoginController {

	// true if email and password exists
	@Autowired
	UserMemoryDao userMemoryDao;

	@Autowired
	PartnerMemoryDao partnerMemoryDao;

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView;

		if (httpServletRequest.getSession().getAttribute("currentUser") != null
				|| httpServletRequest.getSession().getAttribute("currentPartner") != null) {

			modelAndView = new ModelAndView("/logged/loggedIndex");

			modelAndView.addObject("currentUser", httpServletRequest.getAttribute("currentUser"));
			modelAndView.addObject("currentPartner", httpServletRequest.getAttribute("currentPartner"));

			return modelAndView;
		}
		return new ModelAndView("/login");
	}

	@RequestMapping(value = "/login/submit", method = RequestMethod.POST)
	public ModelAndView validateLogin(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpServletRequest request) {
		ModelAndView modelAndView = null;

		if (userMemoryDao.checkLogin(email, password)) {

			modelAndView = new ModelAndView("/logged/loggedIndex");

			request.getSession().setAttribute("currentUser", userMemoryDao.getCurrentUser(email, password));

		} else if (partnerMemoryDao.checkLogin(email, password)) {

			modelAndView = new ModelAndView("/logged/loggedIndex");

			request.getSession().setAttribute("currentPartner", partnerMemoryDao.getCurrentPartner(email, password));

		}

		else {
			modelAndView = new ModelAndView("/login");
			modelAndView.addObject("message", "Invalid User or Password!");
		}

		return modelAndView;

	}

}
