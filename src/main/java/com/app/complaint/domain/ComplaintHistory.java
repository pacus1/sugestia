package com.app.complaint.domain;

import java.util.Date;

import com.app.partner.domain.Partner;
import com.app.user.domain.User;

import java.time.*;

public class ComplaintHistory {

	private String emailAddress;
	private String commentBody;
	private LocalDateTime timestamp;
	private boolean vote;
	private ComplaintHistoryType historyType;
	private User user;
	private Partner partner;
	private Complaint complaint;
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getCommentBody() {
		return commentBody;
	}
	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public boolean isVote() {
		return vote;
	}
	public void setVote(boolean vote) {
		this.vote = vote;
	}
	public ComplaintHistoryType getHistoryType() {
		return historyType;
	}
	public void setHistoryType(ComplaintHistoryType historyType) {
		this.historyType = historyType;
	}
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
	public Complaint getComplaint() {
		return complaint;
	}
	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComplaintHistory other = (ComplaintHistory) obj;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}
	
	
	

}
