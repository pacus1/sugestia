package com.app.complaint.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
//import javax.validation.ValidationException;


import org.postgresql.core.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import com.app.complaint.domain.Complaint;
import com.app.complaint.domain.ComplaintStatusType;
import com.app.complaint.domain.ComplaintType;
import com.app.complaint.service.SuggestionService;
import com.app.other.domain.TransferObject;

import com.app.complaint.dao.SuggestionDao_old;

import com.app.partner.domain.Partner;
import com.app.user.dao.UserDao;
import com.app.user.domain.User;



@Controller
@RequestMapping("/")
public class SuggestionController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	SuggestionService suggestionService;

	@Autowired
	private SuggestionDao_old suggestionDao;
	
	private ArrayList<Complaint> complaintsList = new ArrayList<>();
	private User userAdded = new User();
	
	@RequestMapping("/suggestion")
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

		User currentUser = new User();
		currentUser = (User) httpServletRequest.getSession().getAttribute("currentUser");
		
		if (httpServletRequest.getSession().getAttribute("currentUser") == null){
			modelAndView = new ModelAndView("/login");
			modelAndView.addObject("message", "Please login first!");
			return modelAndView;
		}else{
			if(currentUser.getUserRole().contentEquals("USER")){
				modelAndView = new ModelAndView("/logged/loggedSuggestion");
				return modelAndView;
			}else{
				modelAndView = new ModelAndView("/logged/loggedIndex");
				modelAndView.addObject("message", "Sorry you can't add suggestions!");
				return modelAndView;
			}			
		}
			
		
//		if (httpServletRequest.getSession().getAttribute("currentUser") == null
//				&& currentUser.getUserRole() != "USER") {
//			modelAndView = new ModelAndView("/logged/loggedIndex");
//			modelAndView.addObject("message", "Sorry you can't add suggestions!");
//			return modelAndView;
//
//		} else if (httpServletRequest.getSession().getAttribute("currentUser") == null) {
//			modelAndView = new ModelAndView("/login");
//			modelAndView.addObject("message", "Please login first!");
//			return modelAndView;
//		} else if (httpServletRequest.getSession().getAttribute("currentUser") != null) {
//			modelAndView = new ModelAndView("/logged/loggedSuggestion");
//			return modelAndView;
//		}
//		return new ModelAndView("/suggestion");
	}

	@RequestMapping("/logged/loggedSuggestion/submit")
	public ModelAndView submit(
			@Valid @ModelAttribute("suggestion") TransferObject transferObject, HttpServletRequest httpServletRequest,
			BindingResult bindingResult) throws AddressException, MessagingException {
		ModelAndView modelAndView = null;
		boolean hasErros = false;
		if (!bindingResult.hasErrors()) {
				
				ComplaintType complaintType= ComplaintType.SUGGESTION;
				transferObject.getComplaint().setComplaintType(complaintType);
				ComplaintStatusType complaintStatusType= ComplaintStatusType.PENDING;
				transferObject.getComplaint().setComplaintStatusType(complaintStatusType);
				
				long time = System.currentTimeMillis();
				java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
				
				transferObject.getComplaint().setComplaintTimeStamp(timestamp);
			
				String userEmail =httpServletRequest.getSession().getAttribute("currentUser").toString();
				transferObject.getComplaint().setSenderEmailAddress(userEmail);
				
//				for testing and temporary reason only
				transferObject.getComplaint().setComplaintPartnerAsigneeName(transferObject.getPartner().getPartnerCompanyName());
				
				
				suggestionService.saveComplaint(transferObject);
				userAdded = transferObject.getUser();
				
				modelAndView = new ModelAndView();
				modelAndView.setView(new RedirectView("/logged/listUserSuggestions"));
				
		} else {
			hasErros=true;
		}
		
		if (hasErros) {
			modelAndView = new ModelAndView("/suggestion");
			modelAndView.addObject("complaint", transferObject.getComplaint());
			modelAndView.addObject("errors", bindingResult.getAllErrors());
		}
		return modelAndView;	
	}

	@RequestMapping("/logged/listUserSuggestions")
	public ModelAndView list(HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = null;

		User user = (User) httpServletRequest.getSession().getAttribute("currentUser");

		if (user.getUserRole().equals("USER")) {
			modelAndView = new ModelAndView("/logged/listUserSuggestions");
			
			complaintsList = suggestionService.listComplaintsByUser(user);
			
			modelAndView.addObject("complaints", complaintsList);
			return modelAndView;
		}
		return new ModelAndView("/");
	}
	
	
	
//	public ModelAndView list(Complaint complaint) throws Exception {
//		ModelAndView modelAndView = new ModelAndView("/logger/listUserSuggestions");
//		modelAndView.addObject("complaints", suggestionService.listAll());
//		//modelAndView.addObject("currentUser", securityService.getCurrentUser());
//		return modelAndView;
//		
//		
//		
//		ModelAndView modelAndView = null;
//
//		User user = (User) httpServletRequest.getSession().getAttribute("currentUser");
//
//		if (user.getUserRole().equals("ADMIN")) {
//			modelAndView = new ModelAndView("/admin/listAllSuggestions");
//			
//			complaintsList = adminService.getAdminPendingList();
//			
//			modelAndView.addObject("complaints", complaintsList);
//			return modelAndView;
//		}
//		return new ModelAndView("/");
//		
//	}
	
	
	@RequestMapping("/save")
	public ModelAndView save(Complaint complaint) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/listall");
//		modelAndView.addObject("complaints", suggestionService.listAll());
		//modelAndView.addObject("currentUser", securityService.getCurrentUser());
		return modelAndView;
	}
}
