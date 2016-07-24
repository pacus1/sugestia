package com.app.partner.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class Partner {

//	@Size(min = 4, max = 10, message = "Last name minim 4 characters and maximum 10 characters.")
//	private String partnerLastName;
//	@Size(min = 4, max = 20, message = "First name minimum 4 characters and maximum 20 characters.")
//	private String partnerFirstName;
	@Size(min = 6, max = 30, message = "First name minimum 6 characters and maximum 30 characters.")
	private String partnerCompanyName;
	@Size(min = 4, max = 30, message = "Home town minimum 4 characters maximum 30")
	private String partnerAddress;
	private String partnerCategory;
	@Email(message = "Invalid email form.")
	private String partnerEmail;
	@Pattern(regexp = "^[0-9\\-\\+]{9,15}$", message = "Invalid phone number")
	private String partnerPhoneNumber;
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.])[^\\s]{8,}$", message = "Password must be at least 8 characters, need to contain at least one number,at least one lowercase character uppercase character and one special characater(#,@,!)")
	private String partnerPassword;
	
	private int partnerId; 
	private int userId;
	private int partnerClassificationId;
	
	
//	public String getPartnerLastName() {
//		return partnerLastName;
//	}
//
//	public String getPartnerFirstName() {
//		return partnerFirstName;
//	}

	public String getPartnerCompanyName() {
		return partnerCompanyName;
	}

	public void setPartnerCompanyName(String partnerCompanyName) {
		this.partnerCompanyName = partnerCompanyName;
	}

	public String getPartnerPhoneNumber() {
		return partnerPhoneNumber;
	}

	public void setPartnerPhoneNumber(String partnerPhoneNumber) {
		this.partnerPhoneNumber = partnerPhoneNumber;
	}

	public int getPartner_id() {
		return partnerId;
	}

	public void setPartner_id(int partener_id) {
		this.partnerId = partener_id;
	}

	public int getUser_id() {
		return userId;
	}

	public void setUser_id(int user_id) {
		this.userId = user_id;
	}

	public int getPartnerClassificationId() {
		return partnerClassificationId;
	}

	public void setPartnerClassificationId(int partnerClassificationId) {
		this.partnerClassificationId = partnerClassificationId;
	}

	public String getPartnerCompanyOrInstitutionName() {
		return partnerCompanyName;
	}

	public String getPartnerAddress() {
		return partnerAddress;
	}

	public String getPartnerCategory() {
		return partnerCategory;
	}

	public String getPartnerEmail() {
		return partnerEmail;
	}

	public String getPartnerPhone() {
		return partnerPhoneNumber;
	}

	public String getPartnerPassword() {
		return partnerPassword;
	}

//	public void setPartnerLastName(String partnerLastName) {
//		this.partnerLastName = partnerLastName;
//	}
//
//	public void setPartnerFirstName(String partnerFirstName) {
//		this.partnerFirstName = partnerFirstName;
//	}

	public void setPartnerCompanyOrInstitutionName(String partnerCompanyOrInstitutionName) {
		this.partnerCompanyName = partnerCompanyOrInstitutionName;
	}

	public void setPartnerAddress(String partnerAddress) {
		this.partnerAddress = partnerAddress;
	}

	public void setPartnerCategory(String partnerCategory) {
		this.partnerCategory = partnerCategory;
	}

	public void setPartnerEmail(String partnerEmail) {
		this.partnerEmail = partnerEmail;
	}

	public void setPartnerPhone(String partnerPhone) {
		this.partnerPhoneNumber = partnerPhone;
	}

	public void setPartnerPassword(String partnerPassword) {
		this.partnerPassword = partnerPassword;
	}

	@Override
	public String toString() {
		return partnerEmail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + partnerId;
		result = prime * result + ((partnerAddress == null) ? 0 : partnerAddress.hashCode());
		result = prime * result + ((partnerCategory == null) ? 0 : partnerCategory.hashCode());
		result = prime * result + partnerClassificationId;
		result = prime * result + ((partnerCompanyName == null) ? 0 : partnerCompanyName.hashCode());
		result = prime * result + ((partnerEmail == null) ? 0 : partnerEmail.hashCode());
		result = prime * result + ((partnerPassword == null) ? 0 : partnerPassword.hashCode());
		result = prime * result + ((partnerPhoneNumber == null) ? 0 : partnerPhoneNumber.hashCode());
		result = prime * result + userId;
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
		Partner other = (Partner) obj;
		if (partnerId != other.partnerId)
			return false;
		if (partnerAddress == null) {
			if (other.partnerAddress != null)
				return false;
		} else if (!partnerAddress.equals(other.partnerAddress))
			return false;
		if (partnerCategory == null) {
			if (other.partnerCategory != null)
				return false;
		} else if (!partnerCategory.equals(other.partnerCategory))
			return false;
		if (partnerClassificationId != other.partnerClassificationId)
			return false;
		if (partnerCompanyName == null) {
			if (other.partnerCompanyName != null)
				return false;
		} else if (!partnerCompanyName.equals(other.partnerCompanyName))
			return false;
		if (partnerEmail == null) {
			if (other.partnerEmail != null)
				return false;
		} else if (!partnerEmail.equals(other.partnerEmail))
			return false;
		if (partnerPassword == null) {
			if (other.partnerPassword != null)
				return false;
		} else if (!partnerPassword.equals(other.partnerPassword))
			return false;
		if (partnerPhoneNumber == null) {
			if (other.partnerPhoneNumber != null)
				return false;
		} else if (!partnerPhoneNumber.equals(other.partnerPhoneNumber))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	


}
