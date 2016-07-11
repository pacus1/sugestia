package com.app.complaint.domain;

import java.util.Date;

public class ComplaintHistory {

	private String complainHistoryEmail;
	private String complainHistoryCommentBody;
	private Date complainHistoryTimeStamp;
	private boolean complainHistoryVote;
	public String getComplainHistoryEmail() {
		return complainHistoryEmail;
	}
	public void setComplainHistoryEmail(String complainHistoryEmail) {
		this.complainHistoryEmail = complainHistoryEmail;
	}
	public String getComplainHistoryCommentBody() {
		return complainHistoryCommentBody;
	}
	public void setComplainHistoryCommentBody(String complainHistoryCommentBody) {
		this.complainHistoryCommentBody = complainHistoryCommentBody;
	}
	public Date getComplainHistoryTimeStamp() {
		return complainHistoryTimeStamp;
	}
	public void setComplainHistoryTimeStamp(Date complainHistoryTimeStamp) {
		this.complainHistoryTimeStamp = complainHistoryTimeStamp;
	}
	public boolean isComplainHistoryVote() {
		return complainHistoryVote;
	}
	public void setComplainHistoryVote(boolean complainHistoryVote) {
		this.complainHistoryVote = complainHistoryVote;
	}

	
	

}
