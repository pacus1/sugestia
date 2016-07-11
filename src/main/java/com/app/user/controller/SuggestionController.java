package com.app.user.controller;

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
import com.app.complaint.service.ComplaintService;
import com.app.complaint.service.SecurityService;
import com.app.complaint.service.ValidationException;

@Controller
@RequestMapping("/")
public class SuggestionController {

//	@Autowired
//	private SecurityService securityService;
	
	@Autowired
	private ComplaintService complaintService;

	@RequestMapping("suggestion")
	public ModelAndView renderAddSuggestion() {
		ModelAndView modelAndView = new ModelAndView("/suggestion");
		modelAndView.addObject("suggestion", new Complaint());
		return modelAndView;
	}

//	@RequestMapping("edit")
//	public ModelAndView renderEdit(long id) {
//		ModelAndView modelAndView = new ModelAndView("employee/add");
//		modelAndView.addObject("employee", employeeService.get(id));
//		return modelAndView;
//	}
//
	@RequestMapping("save")
	public ModelAndView save(
			@Valid @ModelAttribute("suggestion") Complaint complaint, 
			BindingResult bindingResult) {
		ModelAndView modelAndView = null;
		boolean hasErros = false;
		if (!bindingResult.hasErrors()) {
			try {
				complaintService.save(complaint);

				modelAndView = new ModelAndView();
				modelAndView.setView(new RedirectView(""));
			} catch (ValidationException ex) {
				for (String msg : ex.getCauses()) {
					bindingResult.addError(new ObjectError("employee", msg));
				}
				hasErros = true;
			}
		} else {
			hasErros = true;
		}

		if (hasErros) {
			modelAndView = new ModelAndView("/suggestion");
			modelAndView.addObject("employee", complaint);
			modelAndView.addObject("errors", bindingResult.getAllErrors());
		}

		return modelAndView;
	}

	@RequestMapping("/listall")
	public ModelAndView list() throws Exception {
		ModelAndView modelAndView = new ModelAndView("/listall");
		modelAndView.addObject("complaint", complaintService.listAll());
//		modelAndView.addObject("currentUser", securityService.getCurrentUser());
		return modelAndView;
	}
}
