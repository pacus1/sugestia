package com.app.controller.other;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.inMemoryDao.InMemoryDao;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	InMemoryDao inMemoryDao;

	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = null;

		if ((httpServletRequest.getCookies() != null && httpServletRequest.getCookies().length > 1)
				&& (httpServletRequest.getSession().getAttribute("currentUser") == null
						|| httpServletRequest.getSession().getAttribute("currentPartner") == null)) {
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

				if (inMemoryDao.checkUserLogin(currentUserEmail, currentUserPassword))

					httpServletRequest.getSession().setAttribute("currentUser",
							inMemoryDao.getCurrentUser(currentUserEmail, currentUserPassword));

				if (inMemoryDao.checkPartnerLogin(currentUserPassword, currentUserPassword)) {
					httpServletRequest.getSession().setAttribute("currentPartner",
							inMemoryDao.getCurrentPartner(currentUserEmail, currentUserPassword));

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

		return new ModelAndView("/index");
	}

}
