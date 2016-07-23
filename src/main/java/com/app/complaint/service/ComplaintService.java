package com.app.complaint.service;


import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.app.complaint.dao.*;
import com.app.complaint.domain.Complaint;
import com.app.other.domain.TransferObject;
import com.app.other.service.SendMail;
import com.app.user.domain.User;


@Service
public class ComplaintService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ComplaintService.class);

	@Autowired
	private ComplaintDao dao;

	public Collection<Complaint> listAll() {
		return dao.getAll();
	}

//	public Collection<Complaint> search( String query) {
//		LOGGER.debug("Searching for " + query);
//		return dao.searchByName(query);
//	}
//
//	public boolean delete(Long id) {
//		LOGGER.debug("Deleting employee for id: " + id);
//		Complaint emp = dao.findById(id);
//		if (emp != null) {
//			dao.delete(emp);
//			return true;
//		}
//
//		return false;
//	}
//
	public Complaint get(Long id) {
		LOGGER.debug("Getting employee for id: " + id);
		return dao.findById(id);

	}

	public void saveComplaint(Complaint complaint) throws AddressException, MessagingException {
	
	LOGGER.debug("Saving: " + complaint);
		//validate(employee);
		//dao.update(complaint);
		
		dao.update(complaint);
		
		String emailComplaintSender = complaint.getSenderEmailAddress();
		String emailTitle = "Suggestion sent confirmation email";
		String emailBody = "Sugestia.ro confirms that your sugestion \"" + complaint.getComplaintTitle() + "\" has been saved to our databases and directed to requested partner \"" + complaint.getComplaintPartnerAsigneeName() + "\"";
		
		SendMail.SiteMailSend(emailComplaintSender, "", emailTitle, emailBody);
		
	}


	
}
