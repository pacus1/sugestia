package com.app.complaint.controller;

import java.time.LocalDateTime;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.app.complaint.dao.SuggestionDao;
import com.app.complaint.domain.Complaint;
import com.app.complaint.domain.ComplaintStatusType;
import com.app.complaint.domain.ComplaintType;
import com.app.user.dao.DatabaseDao;

@Controller
@RequestMapping("/")
public class SuggestionController {

	@Autowired
	private DatabaseDao databaseDao;

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

				if (databaseDao.checkUserLogin(currentUserEmail, currentUserPassword))

					httpServletRequest.getSession().setAttribute("currentUser",
							databaseDao.getCurrentUser(currentUserEmail, currentUserPassword));

				if (databaseDao.checkPartnerLogin(currentUserPassword, currentUserPassword)) {
					httpServletRequest.getSession().setAttribute("currentPartner",
							databaseDao.getCurrentPartner(currentUserEmail, currentUserPassword));

				}

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
			return modelAndView;
		}
		return new ModelAndView("/suggestion");
	}

	// from this line down, added code from Ovi's SuggestionController class
	@RequestMapping("/logged/loggedSuggestion/submit")
	public ModelAndView submit(@Valid @ModelAttribute("suggestion") Complaint complaint, BindingResult bindingResult) {
		ModelAndView modelAndView = null;
		boolean hasErros = false;
		if (!bindingResult.hasErrors()) {
			ComplaintType complaintType = ComplaintType.SUGGESTION;
			complaint.setComplaintType(complaintType);
			ComplaintStatusType complaintStatusType = ComplaintStatusType.PENDING;
			complaint.setComplaintStatusType(complaintStatusType);
			complaint.setComplaintTimeStamp(LocalDateTime.now());
// T changes
			suggestionDao.save(complaint);
			modelAndView = new ModelAndView();
			modelAndView.setView(new RedirectView("/listall"));
		} else {
			hasErros = true;
		}

		if (hasErros) {
			modelAndView = new ModelAndView("/suggestion");
			modelAndView.addObject("complaint", complaint);
			modelAndView.addObject("errors", bindingResult.getAllErrors());
		}

		return modelAndView;
	}

	@RequestMapping("/listall")
	public ModelAndView list(Complaint complaint) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/listall");
		modelAndView.addObject("complaints", suggestionDao.listAll());
		return modelAndView;
	}
}
