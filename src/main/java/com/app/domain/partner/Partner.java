package com.app.domain.partner;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class Partner {

	@Size(min = 4, max = 10, message = "Last name minim 4 characters and maximum 10 characters.")
	private String partnerLastName;
	@Size(min = 4, max = 20, message = "First name minimum 4 characters and maximum 20 characters.")
	private String partnerFirstName;
	@Size(min = 6, max = 30, message = "First name minimum 6 characters and maximum 30 characters.")
	private String partnerCompanyOrInstitutionName;
	@Size(min = 4, max = 30, message = "Home town minimum 4 characters maximum 30")
	private String partnerAddress;
	private String partnerCategory;
	@Email(message = "Invalid email form.")
	private String partnerEmail;
	@Pattern(regexp = "^[0-9\\-\\+]{9,15}$", message = "Invalid phone number")
	private String partnerPhone;
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])[^\\s]{8,}$", message = "Password must be at least 8 characters, need to contain at least one number,at least one lowercase character uppercase character and one special characater(#,@,!)")
	private String partnerPassword;

	public String getPartnerLastName() {
		return partnerLastName;
	}

	public String getPartnerFirstName() {
		return partnerFirstName;
	}

	public String getPartnerCompanyOrInstitutionName() {
		return partnerCompanyOrInstitutionName;
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
		return partnerPhone;
	}

	public String getPartnerPassword() {
		return partnerPassword;
	}

	public void setPartnerLastName(String partnerLastName) {
		this.partnerLastName = partnerLastName;
	}

	public void setPartnerFirstName(String partnerFirstName) {
		this.partnerFirstName = partnerFirstName;
	}

	public void setPartnerCompanyOrInstitutionName(String partnerCompanyOrInstitutionName) {
		this.partnerCompanyOrInstitutionName = partnerCompanyOrInstitutionName;
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
		this.partnerPhone = partnerPhone;
	}

	public void setPartnerPassword(String partnerPassword) {
		this.partnerPassword = partnerPassword;
	}

	@Override
	public String toString() {
		return "Welcome Partner : " + partnerEmail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partnerAddress == null) ? 0 : partnerAddress.hashCode());
		result = prime * result + ((partnerCategory == null) ? 0 : partnerCategory.hashCode());
		result = prime * result
				+ ((partnerCompanyOrInstitutionName == null) ? 0 : partnerCompanyOrInstitutionName.hashCode());
		result = prime * result + ((partnerEmail == null) ? 0 : partnerEmail.hashCode());
		result = prime * result + ((partnerFirstName == null) ? 0 : partnerFirstName.hashCode());
		result = prime * result + ((partnerLastName == null) ? 0 : partnerLastName.hashCode());
		result = prime * result + ((partnerPassword == null) ? 0 : partnerPassword.hashCode());
		result = prime * result + ((partnerPhone == null) ? 0 : partnerPhone.hashCode());
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
		if (partnerCompanyOrInstitutionName == null) {
			if (other.partnerCompanyOrInstitutionName != null)
				return false;
		} else if (!partnerCompanyOrInstitutionName.equals(other.partnerCompanyOrInstitutionName))
			return false;
		if (partnerEmail == null) {
			if (other.partnerEmail != null)
				return false;
		} else if (!partnerEmail.equals(other.partnerEmail))
			return false;
		if (partnerFirstName == null) {
			if (other.partnerFirstName != null)
				return false;
		} else if (!partnerFirstName.equals(other.partnerFirstName))
			return false;
		if (partnerLastName == null) {
			if (other.partnerLastName != null)
				return false;
		} else if (!partnerLastName.equals(other.partnerLastName))
			return false;
		if (partnerPassword == null) {
			if (other.partnerPassword != null)
				return false;
		} else if (!partnerPassword.equals(other.partnerPassword))
			return false;
		if (partnerPhone == null) {
			if (other.partnerPhone != null)
				return false;
		} else if (!partnerPhone.equals(other.partnerPhone))
			return false;
		return true;
	}

}
