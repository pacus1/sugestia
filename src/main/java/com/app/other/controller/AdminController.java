package com.app.other.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.app.complaint.dao.SuggestionDao;
import com.app.complaint.domain.Complaint;
import com.app.user.domain.User;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private SuggestionDao suggestionDao;

	@RequestMapping("/listAllSuggestions")
	public ModelAndView list(HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = null;

		User user = (User) httpServletRequest.getSession().getAttribute("currentUser");

		if (user.getUserRole().equals("ADMIN")) {
			modelAndView = new ModelAndView("/admin/listAllSuggestions");
			modelAndView.addObject("complaints", suggestionDao.listAll());
			return modelAndView;
		}
		return new ModelAndView("/");

	}

	@RequestMapping(value = "/listAllSuggestions/submit", method = RequestMethod.POST)
	public ModelAndView submit(Complaint complaint, HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = null;
		if (httpServletRequest.getParameter("complaintStatusType") != null
				&& httpServletRequest.getParameter("complainId") != null) {

			suggestionDao.changeSuggestionStatus(httpServletRequest.getParameter("complainId"),
					httpServletRequest.getParameter("complaintStatusType"));

			System.out.println(httpServletRequest.getParameter("complainId"));

			System.out.println(httpServletRequest.getParameter("complaintStatusType"));

			modelAndView = new ModelAndView(new RedirectView("/admin/listAllSuggestions"));

		}
		return new ModelAndView(new RedirectView("/admin/listAllSuggestions"));

	}

}
