package com.app.controller.other;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LogoutController {

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ModelAndView logout(HttpSession httpSession, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {

		httpSession.removeAttribute("currentUser");
		httpSession.removeAttribute("currentPartner");

		Cookie cookie[] = httpServletRequest.getCookies();

		if (cookie != null) {
			for (int x = 0; x < cookie.length; x++) {
				cookie[x].setMaxAge(0);
				httpServletResponse.addCookie(cookie[x]);
			}

		}

		return new ModelAndView("/index");

	}

}
