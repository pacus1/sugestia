package com.app.partner.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.user.dao.UserDao;
import com.app.user.domain.User;


@Controller
@RequestMapping("/")
public class PartnerInformationController {

	@Autowired
	UserDao databaseDao;

	@RequestMapping("/partnerInformation")
	public ModelAndView partnerInformation(HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = null;

		if (httpServletRequest.getCookies() != null && httpServletRequest.getCookies().length > 1
				&& (httpServletRequest.getSession().getAttribute("currentUser") == null
						&& httpServletRequest.getSession().getAttribute("currentPartner") == null)) {
			Cookie cookie[] = httpServletRequest.getCookies();

			Cookie cook;
			String currentUserEmail = "", currentUserPassword = "";
			if (cookie != null) {
				for (int x = 0; x < cookie.length; x++) {
					cook = cookie[x];
					if (cook.getName().equalsIgnoreCase("cookieCurrentUser"))
						currentUserEmail = cook.getValue();
					if (cook.getName().equalsIgnoreCase("cookieCurrentUserPassword"))
						currentUserPassword = cook.getValue();
				}

				modelAndView = new ModelAndView("/logged/loggedPartnerInformation");

				if (databaseDao.checkUserLogin(currentUserEmail, currentUserPassword))

					httpServletRequest.getSession().setAttribute("currentUser",
							databaseDao.getCurrentUser(currentUserEmail, currentUserPassword));

				if (databaseDao.checkPartnerLogin(currentUserPassword, currentUserPassword)) {
					httpServletRequest.getSession().setAttribute("currentPartner",
							databaseDao.getCurrentPartner(currentUserEmail, currentUserPassword));

				}

				return modelAndView;
			}

		}
		
		User currentUser = new User();
		currentUser = (User) httpServletRequest.getSession().getAttribute("currentUser");

		if (httpServletRequest.getSession().getAttribute("currentUser") != null 
				&& currentUser.getUserRole().contentEquals("PARTNER")) {

			modelAndView = new ModelAndView("/logged/loggedPartnerInformation");

			modelAndView.addObject("currentUser", httpServletRequest.getAttribute("currentUser"));
			modelAndView.addObject("currentPartner", httpServletRequest.getAttribute("currentPartner"));

			return modelAndView;
		}

		return new ModelAndView("/partnerInformation");
	}
}
