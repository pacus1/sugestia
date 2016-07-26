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
import com.app.partner.dao.PartnerClassificationDao;
import com.app.partner.dao.PartnerDao;
import com.app.partner.domain.Partner;
import com.app.user.domain.User;


@Service
public class SuggestionService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SuggestionService.class);
	private PartnerDao partnerDao;
	private PartnerClassificationDao partnerClassificationDao;

	@Autowired
	private SuggestionDao dao;

	public void saveComplaint(TransferObject transferObject) throws AddressException, MessagingException {
		int newAddedComplaintId;
		int partnerId=0;
		int partnerClassificationId;
		boolean foundPartner=true;
		Partner partner;
		String emailBody;
		
		
		partnerDao = new PartnerDao();
		Complaint complaint = new Complaint();
		partnerClassificationDao = new PartnerClassificationDao();
		
//		complaint = transferObject.getComplaint();
//		LOGGER.debug("Saving: " + complaint);
		

				
		partnerId = partnerDao.findPartnerByName(transferObject.getPartner());
		
		if (partnerId == 0){
			partnerClassificationId = partnerClassificationDao.checkPartnerClassificationId(transferObject.getPartnerClassification());
			transferObject.getPartner().setPartnerClassificationId(partnerClassificationId);
			
			partnerId = partnerDao.addPartner(transferObject.getPartner());
			foundPartner = false;
		}
		 
		transferObject.getComplaint().setPartnerId(partnerId);
			
		newAddedComplaintId = dao.addComplaint(transferObject.getComplaint());
			
		String emailComplaintSender = transferObject.getComplaint().getSenderEmailAddress();
		String emailTitle = "Suggestion sent confirmation email";
		
		if (foundPartner){
			emailBody = "Sugestia.ro confirms that sugestion with the title \"" + transferObject.getComplaint().getComplaintTitle() 
				+  "\" and id no. \"" + newAddedComplaintId 
				+"\" has been saved to our databases. \n After moderator's check it will be directed to requested partner \"" 
				+ transferObject.getPartner().getPartnerCompanyName() + "\". \n Check email for updated information about your suggestion.";
		}else{			
			
			emailBody = "Sugestia.ro confirms that sugestion with the title \"" + transferObject.getComplaint().getComplaintTitle() 
				+  "\" and id no. \"" + newAddedComplaintId 
				+"\" has been saved to our databases. \n "
				+ "The partner \"" + transferObject.getPartner().getPartnerCompanyName() + "\" does not have an account on our site at the moment.\n"
				+ "The site administrator will contact the institution after moderator's check. \n" 
				+ "Check email for updated information about your suggestion.";
		}
		
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
