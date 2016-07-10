package com.app.controller.other;

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
	public ModelAndView login() {
		return new ModelAndView("/login");
	}

	@RequestMapping(value = "/login/submit", method = RequestMethod.POST)
	public ModelAndView validateLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
		ModelAndView modelAndView = null;

		if (userMemoryDao.checkLogin(email, password) || partnerMemoryDao.checkLogin(email, password)) {

			modelAndView = new ModelAndView("/index");
			modelAndView.addObject("currentUser", email);

		} else {
			modelAndView = new ModelAndView("/login");
			modelAndView.addObject("message", "Invalid User or Password!");
		}

		return modelAndView;

	}

}
