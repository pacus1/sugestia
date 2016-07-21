package com.app.other.domain;

import com.app.complaint.domain.Complaint;
import com.app.complaint.domain.ComplaintHistory;
import com.app.complaint.domain.ComplaintHistoryType;
import com.app.complaint.domain.ComplaintStatusType;
import com.app.complaint.domain.ComplaintType;
import com.app.partner.domain.Partner;
import com.app.partner.domain.PartnerClassification;
import com.app.user.domain.User;

public class TransferObject {

	private User user;
	private Partner partner;
	private PartnerClassification partnerClassification;
	private Complaint complaint;
	private ComplaintHistory complaintHistory;
	private ComplaintHistoryType complaintHistoryType;
	private ComplaintStatusType complaintStatusType;
	private ComplaintType complaintType;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Partner getPartner() {
		return partner;
	}
	public void setPartner(Partner partner) {
		this.partner = partner;
	}
	public PartnerClassification getPartnerClassification() {
		return partnerClassification;
	}
	public void setPartnerClassification(PartnerClassification partnerClassification) {
		this.partnerClassification = partnerClassification;
	}
	public Complaint getComplaint() {
		return complaint;
	}
	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}
	public ComplaintHistory getComplaintHistory() {
		return complaintHistory;
	}
	public void setComplaintHistory(ComplaintHistory complaintHistory) {
		this.complaintHistory = complaintHistory;
	}
	public ComplaintHistoryType getComplaintHistoryType() {
		return complaintHistoryType;
	}
	public void setComplaintHistoryType(ComplaintHistoryType complaintHistoryType) {
		this.complaintHistoryType = complaintHistoryType;
	}
	public ComplaintStatusType getComplaintStatusType() {
		return complaintStatusType;
	}
	public void setComplaintStatusType(ComplaintStatusType complaintStatusType) {
		this.complaintStatusType = complaintStatusType;
	}
	public ComplaintType getComplaintType() {
		return complaintType;
	}
	public void setComplaintType(ComplaintType complaintType) {
		this.complaintType = complaintType;
	}
	
	
	
}
