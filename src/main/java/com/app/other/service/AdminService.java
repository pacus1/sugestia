package com.app.other.service;

import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.stereotype.Service;

import com.app.complaint.dao.SuggestionDao;
import com.app.complaint.domain.Complaint;
import com.app.complaint.domain.ComplaintStatusType;

@Service
public class AdminService {
	
	private SuggestionDao suggestionDao = new SuggestionDao();
	private ComplaintStatusType complaintStatusType = null;
	private ArrayList<Complaint> complaintsList = new ArrayList<>();
	private Complaint complaint;
	
	public ArrayList<Complaint> getAdminPendingList(){
		
		complaintsList = suggestionDao.listAllComplaintsByStatus(complaintStatusType.PENDING);  
		
		//tests
		//complaintsList = suggestionDao.listAllComplaintsOrderByTimeStamp();
		//complaintsList = suggestionDao.listAllComplaintsByUserEmail("vasilescu.andrei@gmail.com");
		
		return complaintsList;
		
	}
	
	public ArrayList<Complaint> updateComplaintStatus(int id, ComplaintStatusType complaintStatusType)  {
		boolean updateCheck;
		complaint = new Complaint();
		String emailBody;
		
		updateCheck = suggestionDao.updateComplaintStatus(id,complaintStatusType);
		
		if (updateCheck){			
			complaint = suggestionDao.getComplaintById(id);
			
			String emailComplaintSender = complaint.getSenderEmailAddress();
			String emailTitle = "Suggestion update status confirmation email";
			
			if(complaint.getComplaintStatusType() == ComplaintStatusType.APPROVED){
				emailBody = "The status of submitted suggestion \"" + complaint.getComplaintTitle() + "\" with id no. \"" + complaint.getComplaintId() + "\" has changed. \n" 
						+ "The suggestion has been approved by our moderators, will be published on our site and will be directed to the selected partner"; 
			} else {
				emailBody = "The status of submitted suggestion \"" + complaint.getComplaintTitle() + "\" with id no. \"" + complaint.getComplaintId() + "\" has changed. \n" 
						+ "The suggestion has been rejected due to inappropriate language.";
			}
			
			try {
				SendMail.SiteMailSend(emailComplaintSender, "", emailTitle, emailBody);
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
		}
		
		complaintsList = suggestionDao.listAllComplaintsByStatus(complaintStatusType.PENDING);
		
		return complaintsList;
		
	}

}
