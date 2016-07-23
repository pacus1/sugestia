package com.app.other.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.app.complaint.dao.SuggestionDao;
import com.app.complaint.domain.Complaint;
import com.app.complaint.domain.ComplaintStatusType;

@Service
public class AdminService {
	
	SuggestionDao suggestionDao = new SuggestionDao();
	ComplaintStatusType complaintStatusType = null;
	private ArrayList<Complaint> complaintsList = new ArrayList<>();
	
	public ArrayList<Complaint> getAdminPendingList(){
		
		complaintsList = suggestionDao.listAllComplaintsByStatus(complaintStatusType.PENDING);  
		
		return complaintsList;
		
	}
	
	public ArrayList<Complaint> updateComplaintStatus(int id, ComplaintStatusType complaintStatusType){
		boolean updateCheck;
		
		updateCheck = suggestionDao.updateComplaintStatus(id,complaintStatusType);
		
		if (updateCheck){
			complaintsList = suggestionDao.listAllComplaintsByStatus(complaintStatusType.PENDING);
		}
		
//		String emailComplaintSender = complaint.getSenderEmailAddress();
//		String emailTitle = "Suggestion sent confirmation email";
//		String emailBody = "Sugestia.ro confirms that your sugestion \"" + complaint.getComplaintTitle() + "\" has been saved to our databases and directed to requested partner \"" + complaint.getComplaintPartnerAsigneeName() + "\"";
		
//		SendMail.SiteMailSend(emailComplaintSender, "", emailTitle, emailBody);
		return complaintsList;
		
	}
	
	
}
