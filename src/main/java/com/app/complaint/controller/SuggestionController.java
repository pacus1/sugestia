package com.app.complaint.controller;

import java.time.LocalDateTime;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.app.complaint.domain.Complaint;
import com.app.complaint.domain.ComplaintStatusType;
import com.app.complaint.domain.ComplaintType;
import com.app.complaint.service.ComplaintService;
import com.app.complaint.service.ValidationException;
import com.app.other.domain.TransferObject;
import com.app.partner.domain.Partner;
import com.app.user.dao.UserDao;
import com.app.user.domain.User;

@Controller
@RequestMapping("/")
public class SuggestionController {

	@Autowired
	UserDao userDao;
	ComplaintService complaintService;

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
				
				modelAndView.addObject("suggestion", new TransferObject());	//added code from Ovi's SugestionController class			
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
			@Valid @ModelAttribute("loggedSuggestion") TransferObject transferObject, //User user, //Partner partner,
			BindingResult bindingResult) {
		ModelAndView modelAndView = null;
		boolean hasErros = false;
		if (!bindingResult.hasErrors()) {
			try {
				//ComplaintType complaintType= ComplaintType.SUGGESTION;
				//complaint.setComplaintType(complaintType);
				transferObject.setComplaintType(ComplaintType.SUGGESTION);
				//ComplaintStatusType complaintStatusType= ComplaintStatusType.PENDING;
				//complaint.setComplaintStatusType(complaintStatusType);
				transferObject.setComplaintStatusType(ComplaintStatusType.PENDING);
				//complaint.setComplaintTimeStamp(LocalDateTime.now());
				transferObject.getComplaint().setComplaintTimeStamp(LocalDateTime.now());
				
				//complaintService.save(complaint);
				complaintService.save(transferObject);
				
				modelAndView = new ModelAndView();
				modelAndView.setView(new RedirectView("/listall"));
			} catch (ValidationException ex) {
				for (String msg : ex.getCauses()) {
					bindingResult.addError(new ObjectError("complaint", msg));
				}
				hasErros = true;
			}
		} else {
			hasErros = true;
		}

		if (hasErros) {
			modelAndView = new ModelAndView("/suggestion");
			//modelAndView.addObject("complaint", complaint);
			modelAndView.addObject("complaint", transferObject);//add Sergiu
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
	

}
