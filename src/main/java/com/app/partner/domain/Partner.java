package com.app.partner.domain;

public class Partner {

	private String partnerLastName;
	private String partnerFirstName;
	private String partnerCompanyOrInstitutionName;
	private String partnerAddress;
	private String partnerCategory;
	private String partnerEmail;
	private String partnerPhone;
	private String partnerPassword;
	

	public String getPartnerLastName() {
		return partnerLastName;
	}

	public void setPartnerLastName(String partnerLastName) {
		this.partnerLastName = partnerLastName;
	}

	public String getPartnerFirstName() {
		return partnerFirstName;
	}

	public void setPartnerFirstName(String partnerFirstName) {
		this.partnerFirstName = partnerFirstName;
	}

	public String getPartnerCompanyOrInstitutionName() {
		return partnerCompanyOrInstitutionName;
	}

	public void setPartnerCompanyOrInstitutionName(String partnerCompanyOrInstitutionName) {
		this.partnerCompanyOrInstitutionName = partnerCompanyOrInstitutionName;
	}

	public String getPartnerAddress() {
		return partnerAddress;
	}

	public void setPartnerAddress(String partnerAddress) {
		this.partnerAddress = partnerAddress;
	}

	public String getPartnerCategory() {
		return partnerCategory;
	}

	public void setPartnerCategory(String partnerCategory) {
		this.partnerCategory = partnerCategory;
	}

	public String getPartnerEmail() {
		return partnerEmail;
	}

	public void setPartnerEmail(String partnerEmail) {
		this.partnerEmail = partnerEmail;
	}

	public String getPartnerPhone() {
		return partnerPhone;
	}

	public void setPartnerPhone(String partnerPhone) {
		this.partnerPhone = partnerPhone;
	}

	public String getPartnerPassword() {
		return partnerPassword;
	}

	public void setPartnerPassword(String partnerPassword) {
		this.partnerPassword = partnerPassword;
	}

	@Override
	public String toString() {
		return "Partner [partnerLastName=" + partnerLastName + ", partnerFirstName=" + partnerFirstName
				+ ", partnerCompanyOrInstitutionName=" + partnerCompanyOrInstitutionName + ", partnerAddress="
				+ partnerAddress + ", partnerCategory=" + partnerCategory + ", partnerEmail=" + partnerEmail
				+ ", partnerPhone=" + partnerPhone + ", partnerPassword=" + partnerPassword + "]";
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
