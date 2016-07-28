package com.app.other.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.complaint.domain.Complaint;
import com.app.complaint.service.SuggestionService;
import com.app.user.dao.UserDao;
import com.app.user.domain.User;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	UserDao databaseDao;
	
	@Autowired
	SuggestionService suggestionService;

	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		ModelAndView modelAndView = null;

	ArrayList<Complaint> complaintsList = new ArrayList<>();

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

				if (databaseDao.checkPartnerLogin(currentUserEmail, currentUserPassword)) {
					httpServletRequest.getSession().setAttribute("currentPartner",
							databaseDao.getCurrentPartner(currentUserEmail, currentUserPassword));

				}

				complaintsList = suggestionService.listComplaintsForIndexPage();
				modelAndView.addObject("complaints", complaintsList);
				
				return modelAndView;
			}

		}

		User currentUser = new User();
		currentUser = (User) httpServletRequest.getSession().getAttribute("currentUser");
		
//		if (httpServletRequest.getSession().getAttribute("currentUser") != null
//				|| httpServletRequest.getSession().getAttribute("currentPartner") != null) {

		if (httpServletRequest.getSession().getAttribute("currentUser") != null){
			modelAndView = new ModelAndView("/logged/loggedIndex");

//			modelAndView.addObject("currentUser", httpServletRequest.getAttribute("currentUser"));
//			modelAndView.addObject("currentPartner", httpServletRequest.getAttribute("currentPartner"));
			
			complaintsList = suggestionService.listComplaintsForIndexPage();
			modelAndView.addObject("complaints", complaintsList);

			return modelAndView;
		}
			
			modelAndView = new ModelAndView("/index");
			complaintsList = suggestionService.listComplaintsForIndexPage();
			modelAndView.addObject("complaints", complaintsList);
			return modelAndView;
		
		
//		return new ModelAndView("/index");
	}

}
