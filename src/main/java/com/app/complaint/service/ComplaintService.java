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
	private SuggestionDao dao;

	public void saveComplaint(Complaint complaint) throws AddressException, MessagingException {
		int newAddedComplaintId;
		
		LOGGER.debug("Saving: " + complaint);
				
		newAddedComplaintId = dao.addComplaint(complaint);
				
		String emailComplaintSender = complaint.getSenderEmailAddress();
		String emailTitle = "Suggestion sent confirmation email";
		String emailBody = "Sugestia.ro confirms that sugestion with the title \"" + complaint.getComplaintTitle() +  "\" and id no. \"" + newAddedComplaintId +"\" has been saved to our databases and directed to requested partner \"" + complaint.getComplaintPartnerAsigneeName() + "\"";
		
		SendMail.SiteMailSend(emailComplaintSender, "", emailTitle, emailBody);
		
	}
	
	public Collection<Complaint> listAll() {
		return dao.getAll();
	}

	public Complaint get(Long id) {
		LOGGER.debug("Getting employee for id: " + id);
		return dao.findById(id);

	}




	
}
