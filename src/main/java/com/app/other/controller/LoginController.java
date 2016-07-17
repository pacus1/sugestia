package com.app.other.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.user.dao.DatabaseDao;

@Controller
@RequestMapping("/")
public class LoginController {

	// true if email and password exists
	@Autowired
	DatabaseDao databaseDao;

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest httpServletRequest) {
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

				modelAndView = new ModelAndView("/logged/loggedIndex");

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
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = null;

		if (databaseDao.checkUserLogin(email, password)) {

			if (request.getParameter("rememberMe") != null) {

				Cookie emailCookie = new Cookie("cookieCurrentUser", email);
				Cookie passwordCookie = new Cookie("cookieCurrentUserPassword", password);

				emailCookie.setMaxAge(3600);
				emailCookie.setPath("/");

				passwordCookie.setMaxAge(3600);
				passwordCookie.setPath("/");

				response.addCookie(emailCookie);
				response.addCookie(passwordCookie);

				request.getSession().setAttribute("currentUser", databaseDao.getCurrentUser(email, password));

				modelAndView = new ModelAndView("/logged/loggedIndex");

			}
			if (request.getParameter("rememberMe") == null) {

				modelAndView = new ModelAndView("/logged/loggedIndex");

				request.getSession().setAttribute("currentUser", databaseDao.getCurrentUser(email, password));
			}

		} else if (databaseDao.checkPartnerLogin(email, password)) {

			if (request.getParameter("rememberMe") != null) {

				Cookie emailCookie = new Cookie("cookieCurrentUser", email);
				Cookie passwordCookie = new Cookie("cookieCurrentUserPassword", password);

				emailCookie.setMaxAge(3600);
				emailCookie.setPath("/");

				passwordCookie.setMaxAge(3600);
				passwordCookie.setPath("/");

				response.addCookie(emailCookie);
				response.addCookie(passwordCookie);

				request.getSession().setAttribute("currentPartner", databaseDao.getCurrentPartner(email, password));

				modelAndView = new ModelAndView("/logged/loggedIndex");

			}

			if (request.getParameter("rememberMe") == null) {
				modelAndView = new ModelAndView("/logged/loggedIndex");

				request.getSession().setAttribute("currentPartner", databaseDao.getCurrentPartner(email, password));
			}

		}

		else {
			modelAndView = new ModelAndView("/login");
			modelAndView.addObject("message", "Invalid User or Password!");
		}

		return modelAndView;

	}

}
