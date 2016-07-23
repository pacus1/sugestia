package com.app.complaint.controller;

import java.time.LocalDateTime;
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
import com.app.complaint.service.ComplaintService;
import com.app.complaint.service.ValidationException;
import com.app.other.domain.TransferObject;

import com.app.complaint.dao.SuggestionDao;

import com.app.partner.domain.Partner;
import com.app.user.dao.UserDao;
import com.app.user.domain.User;



@Controller
@RequestMapping("/")
public class SuggestionController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	ComplaintService complaintService;

	@Autowired
	private SuggestionDao suggestionDao;
	
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
				
				//modelAndView.addObject("suggestion", new TransferObject());	//added code from Ovi's SugestionController class			


				modelAndView.addObject("suggestion", new Complaint()); // added
																		// code
																		// from
																		// Ovi's
																		// SugestionController
																		// class

				return modelAndView;
			}

		}

		if (httpServletRequest.getSession().getAttribute("currentUser") == null
				&& httpServletRequest.getSession().getAttribute("currentPartner") != null) {
			modelAndView = new ModelAndView("/logged/loggedIndex");
			modelAndView.addObject("message", "Sorry you can't add suggestions!");
			return modelAndView;

		} else if (httpServletRequest.getSession().getAttribute("currentUser") == null) {
			modelAndView = new ModelAndView("/login");
			modelAndView.addObject("message", "Please login first!");
			return modelAndView;
		} else if (httpServletRequest.getSession().getAttribute("currentUser") != null) {
			modelAndView = new ModelAndView("/logged/loggedSuggestion");
//			modelAndView = new ModelAndView();
//			modelAndView.setView(new RedirectView("/logged/loggedSuggestion"));
			return modelAndView;
		}
		return new ModelAndView("/suggestion");
	}

	
// from this line down, added code from Ovi's SuggestionController class 
	@RequestMapping("/logged/loggedSuggestion/submit")
	public ModelAndView submit(
			@Valid @ModelAttribute("suggestion") Complaint complaint, HttpServletRequest httpServletRequest,
			BindingResult bindingResult) throws AddressException, MessagingException {
		ModelAndView modelAndView = null;
		boolean hasErros = false;
		if (!bindingResult.hasErrors()) {
			//try {
				ComplaintType complaintType= ComplaintType.SUGGESTION;
				complaint.setComplaintType(complaintType);
				ComplaintStatusType complaintStatusType= ComplaintStatusType.PENDING;
				complaint.setComplaintStatusType(complaintStatusType);
				
				long time = System.currentTimeMillis();
				java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
				
				complaint.setComplaintTimeStamp(timestamp);
				
				//String userEmail = httpServletRequest.getParameter("currentUser"); 
						
						//request.getParameter(userEmail creat);
				
				String userEmail =httpServletRequest.getSession().getAttribute("currentUser").toString();
				//String userEmail =(String) httpServletRequest.getSession().getAttribute("currentUser");
				userEmail = userEmail.replace("Welcome,", "");
				complaint.setSenderEmailAddress(userEmail);
				//complaintService.save(complaint);
				
				//TransferObject transferObject = new TransferObject();
				//transferObject.setComplaint(complaint);
				
//				User tempUser = new User();
//				
//				
//				userEmail = userEmail.replace("Welcome,", "");
//				
//				tempUser.setUserEmail(userEmail);
//				transferObject.setUser(tempUser);
				
				//complaintService.save(complaint);
				
				complaintService.saveComplaint(complaint);
				
				modelAndView = new ModelAndView();
				modelAndView.setView(new RedirectView("/listall"));
				
//			} catch (ValidationException ex) {
//				for (String msg : ex.getCauses()) {
//					bindingResult.addError(new ObjectError("complaint", msg));
//				}
//				hasErros=true;
//			}
		} else {
			hasErros=true;
		}
		
		if (hasErros) {
			modelAndView = new ModelAndView("/suggestion");
			//modelAndView.addObject("complaint", complaint);
			modelAndView.addObject("complaint", complaint);//add Sergiu
			modelAndView.addObject("errors", bindingResult.getAllErrors());
		}
		
		return modelAndView;	
		
	}

	@RequestMapping("/listall")
	public ModelAndView list(Complaint complaint) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/listall");
		modelAndView.addObject("complaints", complaintService.listAll());
		//modelAndView.addObject("currentUser", securityService.getCurrentUser());
		return modelAndView;
	}
	
	
	@RequestMapping("/save")
	public ModelAndView save(Complaint complaint) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/listall");
		modelAndView.addObject("complaints", complaintService.listAll());
		//modelAndView.addObject("currentUser", securityService.getCurrentUser());
		return modelAndView;
	}
//	// from this line down, added code from Ovi's SuggestionController class
//	@RequestMapping("/logged/loggedSuggestion/submit")
//	public ModelAndView submit(@Valid @ModelAttribute("suggestion") Complaint complaint, BindingResult bindingResult) {
//		ModelAndView modelAndView = null;
//		boolean hasErros = false;
//		if (!bindingResult.hasErrors()) {
//			ComplaintType complaintType = ComplaintType.SUGGESTION;
//			complaint.setComplaintType(complaintType);
//			ComplaintStatusType complaintStatusType = ComplaintStatusType.PENDING;
//			complaint.setComplaintStatusType(complaintStatusType);
//			
//			long time = System.currentTimeMillis();
//			java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
//			complaint.setComplaintTimeStamp(timestamp);
//			
//			Random random = new Random();
//			int randomValue = random.nextInt(100000) + 1;
//			//complaint.setComplaintId(Integer.toString(randomValue));
//			// T changes
//			suggestionDao.save(complaint);
//			modelAndView = new ModelAndView("/logged/loggedSuggestion");
//			modelAndView.addObject("message", "Thank you for submitting your suggestion.");
//
//		} else {
//			hasErros = true;
//		}
//
//		if (hasErros) {
//			modelAndView = new ModelAndView("/suggestion");
//			//modelAndView.addObject("complaint", complaint);
//			modelAndView.addObject("complaint", complaint);//add Sergiu
//			modelAndView.addObject("errors", bindingResult.getAllErrors());
//		}
//
//		return modelAndView;
//	}
}
