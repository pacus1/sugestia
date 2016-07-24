package com.app.other.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.app.complaint.dao.SuggestionDao;
import com.app.complaint.dao.SuggestionDao_old;
import com.app.complaint.domain.Complaint;
import com.app.complaint.domain.ComplaintStatusType;
import com.app.other.service.AdminService;
import com.app.user.domain.User;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private SuggestionDao suggestionDao;
	
	private ArrayList<Complaint> complaintsList = new ArrayList<>();
	ComplaintStatusType complaintStatusType = null;
	
	@Autowired
	private AdminService adminService = new AdminService();

	@RequestMapping("/listAllSuggestions")
	public ModelAndView list(HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = null;

		User user = (User) httpServletRequest.getSession().getAttribute("currentUser");

		if (user.getUserRole().equals("ADMIN")) {
			modelAndView = new ModelAndView("/admin/listAllSuggestions");
			
			complaintsList = adminService.getAdminPendingList();
			
			modelAndView.addObject("complaints", complaintsList);
			return modelAndView;
		}
		return new ModelAndView("/");
	}

	@RequestMapping(value = "/listAllSuggestions/submit", method = RequestMethod.POST)
	public ModelAndView submit(Complaint complaint, HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = null;
		if (httpServletRequest.getParameter("complaintStatusType") != null
				&& httpServletRequest.getParameter("complainId") != null) {
		
			int id = Integer.parseInt(httpServletRequest.getParameter("complainId").toString());	
			String submitStatus = httpServletRequest.getParameter("complaintStatusType").toString();
			
			switch (submitStatus){
			case "PENDING" : complaintStatusType = ComplaintStatusType.PENDING ;break;
			case "APPROVED" : complaintStatusType = ComplaintStatusType.APPROVED ;break;
			case "REJECT" : complaintStatusType = ComplaintStatusType.REJECT ;break;
			case "SOLVED" : complaintStatusType = ComplaintStatusType.SOLVED ;break;
			}
											
			complaintsList = adminService.updateComplaintStatus(id, complaintStatusType);
			
			modelAndView = new ModelAndView(new RedirectView("/admin/listAllSuggestions"));
			modelAndView.addObject("complaints", complaintsList);
			return modelAndView;
			
//			System.out.println(httpServletRequest.getParameter("complainId"));

//			System.out.println(httpServletRequest.getParameter("complaintStatusType"));

//			modelAndView = new ModelAndView(new RedirectView("/admin/listAllSuggestions"));

		}
		return new ModelAndView(new RedirectView("/admin/listAllSuggestions"));

	}

}
