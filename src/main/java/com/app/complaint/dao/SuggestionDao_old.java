package com.app.complaint.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.app.complaint.domain.Complaint;
import com.app.complaint.domain.ComplaintStatusType;

@Service
public class SuggestionDao_old{
	private ArrayList<Complaint> complaints = new ArrayList<>();

	public void save(Complaint complaint) {
		complaints.add(complaint);
	}

	public ArrayList<Complaint> listAll() {
		return complaints;
	}

	public void changeSuggestionStatus(String suggestionId, String suggestionStatus) {
		for (int x = 0; x < complaints.size(); x++) {
			if (suggestionId.equals(complaints.get(x).getComplaintId())) {

				Complaint complaint = new Complaint();
				complaint.setComplaintBody(complaints.get(x).getComplaintBody());
				//complaint.setComplaintId(suggestionId);
				complaint.setComplaintPartnerAsigneeName(complaints.get(x).getComplaintPartnerAsigneeName());
				complaint.setComplaintPartnerType(complaints.get(x).getComplaintPartnerType());
				complaint.setComplaintTimeStamp(complaints.get(x).getComplaintTimeStamp());
				complaint.setComplaintTitle(complaints.get(x).getComplaintTitle());
				complaint.setComplaintType(complaints.get(x).getComplaintType());
				ComplaintStatusType complaintStatusType = ComplaintStatusType.valueOf(suggestionStatus);
				complaint.setComplaintStatusType(complaintStatusType);

				complaints.remove(x);
				complaints.add(complaint);
			}
		}

	}

}
