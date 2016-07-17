package com.app.complaint.controller;
//package com.app.complaint.controller;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Enumeration;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.swing.AbstractButton;
//import javax.swing.ButtonGroup;
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.ObjectError;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.view.RedirectView;
//
//import com.app.complaint.domain.Complaint;
//import com.app.complaint.domain.ComplaintStatusType;
//import com.app.complaint.domain.ComplaintType;
//import com.app.complaint.service.ComplaintService;
//import com.app.complaint.service.SecurityService;
//import com.app.complaint.service.ValidationException;
//
//@Controller
//@RequestMapping("/")
//public class SuggestionController {
//
////	@Autowired
////	private SecurityService securityService;
//	
//	@Autowired
//	private ComplaintService complaintService;
//
//
//	@RequestMapping("suggestion")
//	public ModelAndView renderAddSuggestion() {
//		ModelAndView modelAndView = new ModelAndView("/suggestion");
//		modelAndView.addObject("suggestion", new Complaint());
//		return modelAndView;
//	}
//
//
//	@RequestMapping("/suggestion/submit")
//	public ModelAndView submit(
//			@Valid @ModelAttribute("suggestion") Complaint complaint, 
//			BindingResult bindingResult) {
//		ModelAndView modelAndView = null;
//		boolean hasErros = false;
//		if (!bindingResult.hasErrors()) {
//			try {
//				ComplaintType complaintType= ComplaintType.SUGGESTION;
//				complaint.setComplaintType(complaintType);
//				ComplaintStatusType complaintStatusType= ComplaintStatusType.PENDING;
//				complaint.setComplaintStatusType(complaintStatusType);
//				complaint.setComplaintTimeStamp(LocalDateTime.now());
//				complaintService.save(complaint);
//				modelAndView = new ModelAndView();
//				modelAndView.setView(new RedirectView("/listall"));
//			} catch (ValidationException ex) {
//				for (String msg : ex.getCauses()) {
//					bindingResult.addError(new ObjectError("complaint", msg));
//				}
//				hasErros = true;
//			}
//		} else {
//			hasErros = true;
//		}
//
//		if (hasErros) {
//			modelAndView = new ModelAndView("/suggestion");
//			modelAndView.addObject("complaint", complaint);
//			modelAndView.addObject("errors", bindingResult.getAllErrors());
//		}
//
//		return modelAndView;
//	}
//
//
//
//	
//	@RequestMapping("/listall")
//	public ModelAndView list(Complaint complaint) throws Exception {
//		ModelAndView modelAndView = new ModelAndView("/listall");
//		modelAndView.addObject("complaints", complaintService.listAll());
//		//modelAndView.addObject("currentUser", securityService.getCurrentUser());
//		return modelAndView;
//	}
//	
//	
//	@RequestMapping("/save")
//	public ModelAndView save(Complaint complaint) throws Exception {
//		ModelAndView modelAndView = new ModelAndView("/listall");
//		modelAndView.addObject("complaints", complaintService.listAll());
//		//modelAndView.addObject("currentUser", securityService.getCurrentUser());
//		return modelAndView;
//	}
//	
//
//
//	
//	
//}
