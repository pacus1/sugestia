package com.app.complaint.domain;

import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.util.Date;

import com.app.partner.domain.Partner;
import com.app.user.domain.User;
import com.app.user.domain.UserRole;

public class Complaint extends AbstractModel{

		private long complaintId;
		private ComplaintStatusType complaintStatusType;
		private ComplaintType complaintType;
		private java.sql.Timestamp complaintTimeStamp;
		private String complaintTitle;
		private String complaintBody;
		private String complaintPicture;
		private String complaintPartnerAsigneeName;
		private String complaintPartnerType;
		private User user;
		private Partner partner;
		private ComplaintHistory complaintHistory;
		private String senderEmailAddress;
		
		
		public String getSenderEmailAddress() {
			return senderEmailAddress;
		}
		public void setSenderEmailAddress(String senderEmailAddress) {
			this.senderEmailAddress = senderEmailAddress;
		}
		public String getComplaintPartnerType() {
			return complaintPartnerType;
		}
		public void setComplaintPartnerType(String complaintPartnerType) {
			this.complaintPartnerType = complaintPartnerType;
		}
		public long getComplaintId() {
			return complaintId;
		}
		public void setComplaintId(long complainId) {
			this.complaintId = complainId;
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
		public void setComplaintType(ComplaintType complainType) {
			this.complaintType = complainType;
		}
		public java.sql.Timestamp getComplaintTimeStamp() {
			return complaintTimeStamp;
		}
		public void setComplaintTimeStamp(java.sql.Timestamp localDateTime) {
			this.complaintTimeStamp = localDateTime;
		}
		public String getComplaintTitle() {
			return complaintTitle;
		}
		public void setComplaintTitle(String complainTitle) {
			this.complaintTitle = complainTitle;
		}
		public String getComplaintBody() {
			return complaintBody;
		}
		public void setComplaintBody(String complainBody) {
			this.complaintBody = complainBody;
		}
		public Object getComplaintPicture() {
			return complaintPicture;
		}
		public void setComplaintPicture(String complainPicture) {
			this.complaintPicture = complainPicture;
		}
		public String getComplaintPartnerAsigneeName() {
			return complaintPartnerAsigneeName;
		}
		public void setComplaintPartnerAsigneeName(String complainPartnerAsigneeName) {
			this.complaintPartnerAsigneeName = complainPartnerAsigneeName;
		}
	
		
		@Override
		public String toString() {
			return "Complain Id: " + complaintId + 
					", Status Type: " + complaintStatusType + 
					", Type" + complaintType + 
					", TimeStamp:" + complaintTimeStamp + 
					", Title: " + complaintTitle + 
					", Body: " + complaintBody + 
					", Picture: " + complaintPicture + 
					", Asignee Name:" + complaintPartnerAsigneeName;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((complaintStatusType == null) ? 0 : complaintStatusType.hashCode());
			result = prime * result + ((complaintType == null) ? 0 : complaintType.hashCode());
			result = prime * result + ((complaintTimeStamp == null) ? 0 : complaintTimeStamp.hashCode());
			result = prime * result + ((complaintTitle == null) ? 0 : complaintTitle.hashCode());
			result = prime * result + ((complaintBody == null) ? 0 : complaintBody.hashCode());
			result = prime * result + ((complaintPicture == null) ? 0 : complaintPicture.hashCode());
			result = prime * result + ((complaintPartnerAsigneeName == null) ? 0 : complaintPartnerAsigneeName.hashCode());
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
		
			Complaint other = (Complaint) obj;
			
			if (complaintStatusType == null) {
				if (other.complaintStatusType != null)
					return false;
			} else if (!complaintStatusType.equals(other.complaintStatusType))
				return false;
			
		if (complaintType == null) {
			if (other.complaintType != null)
				return false;
		} else if (!complaintType.equals(other.complaintType))
			return false;

		if (complaintTimeStamp == null) {
			if (other.complaintTimeStamp != null)
				return false;
		} else if (!complaintTimeStamp.equals(other.complaintTimeStamp))
			return false;

		if (complaintTitle == null) {
			if (other.complaintTitle != null)
				return false;
		} else if (!complaintTitle.equals(other.complaintTitle))
			return false;

		if (complaintBody == null) {
			if (other.complaintBody != null)
				return false;
		} else if (!complaintBody.equals(other.complaintBody))
			return false;

		if (complaintPicture == null) {
			if (other.complaintPicture != null)
				return false;
		} else if (!complaintPicture.equals(other.complaintPicture))
			return false;

		if (complaintPartnerAsigneeName != other.complaintPartnerAsigneeName)
			return false;
		return true;
	}

}
}
