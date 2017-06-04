package com.app.complaint.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.complaint.dao.SuggestionDao_old;
import com.app.complaint.domain.Complaint;
import com.app.complaint.domain.ComplaintType;
import com.app.complaint.service.ReportComplaintService;
import com.app.complaint.service.SuggestionService;
import com.app.other.domain.TransferObject;
import com.app.user.dao.UserDao;
import com.app.user.domain.User;

@Controller
@RequestMapping("/")
public class ReportComplaintController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	SuggestionService suggestionService;
	
	@Autowired
	ReportComplaintService reportComplaintService;

	@Autowired
	private SuggestionDao_old suggestionDao;
	
	private ArrayList<Complaint> complaintsList = new ArrayList<>();
	private User userAdded = new User();
	private TransferObject transferObject = new TransferObject();
	
	@RequestMapping("/sugestii-reclamatii")
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

				modelAndView = new ModelAndView("/logged/loggedSuggestion");

				if (userDao.checkUserLogin(currentUserEmail, currentUserPassword))

					httpServletRequest.getSession().setAttribute("currentUser",
							userDao.getCurrentUser(currentUserEmail, currentUserPassword));

				if (userDao.checkPartnerLogin(currentUserPassword, currentUserPassword)) {
					httpServletRequest.getSession().setAttribute("currentPartner",
							userDao.getCurrentPartner(currentUserEmail, currentUserPassword));

				}
				
				modelAndView.addObject("suggestion", new Complaint());

				return modelAndView;
			}

		}

		String suggestionType = "ALL";
		String suggestionCategory = "ALL";
		String sortTimestampType = "DESC";
		
		complaintsList = reportComplaintService.listComplaintsBySelection(suggestionType, suggestionCategory, sortTimestampType);
		modelAndView = new ModelAndView("/sugestii-reclamatii");
		
		modelAndView.addObject("complaints", complaintsList);
		
		return modelAndView;
		
//		User currentUser = new User();
//		currentUser = (User) httpServletRequest.getSession().getAttribute("currentUser");
		
//		if (httpServletRequest.getSession().getAttribute("currentUser") == null){
//			
//			complaintsList = suggestionService.listComplaintsForIndexPage();
//			modelAndView.addObject("complaints", complaintsList);
//			modelAndView = new ModelAndView("/sugestii-reclamatii");
////			modelAndView.addObject("message", "Please login first!");
//			return modelAndView;
//		}else{
//			if(currentUser.getUserRole().contentEquals("USER")){
//				modelAndView = new ModelAndView("/logged/loggedSuggestion");
//				return modelAndView;
//			}else{
//				modelAndView = new ModelAndView("/logged/loggedIndex");
//				modelAndView.addObject("message", "Sorry you can't add suggestions!");
//				return modelAndView;
//			}			
//		}
	
	}
}
