package com.app.complaint.domain;
import java.util.Date;

import com.app.user.domain.User;
import com.app.user.domain.UserRole;


public class Complaint extends AbstractModel{

		private long complaintId;
		private ComplaintStatusType complaintStatusType;
		private ComplaintType complaintType;
		private Date complaintTimeStamp;
		private String complaintTitle;
		private String complaintBody;
		private Object complaintPicture;
		private String complaintPartnerAsigneeName;
		private Long complaintId1;
	
		
		public long getComplainId() {
			return complaintId;
		}
		public void setComplainId(long complainId) {
			this.complaintId = complainId;
		}
		public ComplaintStatusType getComplaintStatusType() {
			return complaintStatusType;
		}
		public void setComplainStatusType(ComplaintStatusType complaintStatusType) {
			this.complaintStatusType = complaintStatusType;
		}
		public ComplaintType getComplainType() {
			return complaintType;
		}
		public void setComplainType(ComplaintType complainType) {
			this.complaintType = complainType;
		}
		public Date getComplainTimeStamp() {
			return complaintTimeStamp;
		}
		public void setComplainTimeStamp(Date complainTimeStamp) {
			this.complaintTimeStamp = complainTimeStamp;
		}
		public String getComplainTitle() {
			return complaintTitle;
		}
		public void setComplainTitle(String complainTitle) {
			this.complaintTitle = complainTitle;
		}
		public String getComplainBody() {
			return complaintBody;
		}
		public void setComplainBody(String complainBody) {
			this.complaintBody = complainBody;
		}
		public Object getComplainPicture() {
			return complaintPicture;
		}
		public void setComplainPicture(Object complainPicture) {
			this.complaintPicture = complainPicture;
		}
		public String getComplainPartnerAsigneeName() {
			return complaintPartnerAsigneeName;
		}
		public void setComplainPartnerAsigneeName(String complainPartnerAsigneeName) {
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
				if (other.complaintPicture!= null)
					return false;
			} else if (!complaintPicture.equals(other.complaintPicture))
				return false;
			
			
			if (complaintPartnerAsigneeName != other.complaintPartnerAsigneeName)
				return false;
			return true;
		}
		
		
}
