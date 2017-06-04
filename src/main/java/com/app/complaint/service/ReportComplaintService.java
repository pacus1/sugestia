package com.app.complaint.service;

import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.complaint.dao.SuggestionDao;
import com.app.complaint.domain.Complaint;
import com.app.other.domain.TransferObject;
import com.app.partner.dao.PartnerClassificationDao;
import com.app.partner.dao.PartnerDao;
import com.app.partner.domain.Partner;
import com.app.user.domain.User;

@Service
public class ReportComplaintService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SuggestionService.class);
	private PartnerDao partnerDao;
	private PartnerClassificationDao partnerClassificationDao;

	@Autowired
	private SuggestionDao dao;
	
	public ArrayList<Complaint> listComplaintsBySelection(String suggestionType, String suggestionCategory, String sortTimestampType) {
		
		return dao.listAllComplaintsBySelection(suggestionType, suggestionCategory, sortTimestampType);
		
		
//		return dao.listAllComplaintsByUser(user);
	}

		
			
			
			
			
			
}
