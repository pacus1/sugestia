package com.app.user.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.app.complaint.domain.Complaint;
import com.app.complaint.domain.ComplaintHistory;
import com.app.partner.domain.Partner;

public class User {

	@Size(min = 4, max = 10, message = "Last name minim 4 characters and maximum 10 characters.")
	private String userLastName;

	@Size(min = 4, max = 20, message = "First name minimum 4 characters and maximum 20 characters.")
	private String userFirstName;

	@Email(message = "Invalid email form.")
	private String userEmail;

	@Pattern(regexp = "^[0-9\\-\\+]{9,15}$", message = "Invalid phone number")
	private String userMobilePhone;

	@Size(min = 4, max = 30, message = "Home town minimum 4 characters maximum 30")
	private String userHomeTown;

	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!.]).{8,20})", message = "Password must contain one digit (0-9),must contains one lowercase character, must contains one uppercase character,must contains one special character (@#$%!.), must have minimum 8 characters maximum 20 ")
	private String userPassword;

	private String userRole;
	private Partner partner;
	private Complaint complaint;
	private ComplaintHistory complaintHistory; 
	

	public String getUserLastName() {
		return userLastName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserMobilePhone() {
		return userMobilePhone;
	}

	public String getUserHomeTown() {
		return userHomeTown;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserMobilePhone(String userMobilePhone) {
		this.userMobilePhone = userMobilePhone;
	}

	public void setUserHomeTown(String userHomeTown) {
		this.userHomeTown = userHomeTown;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "Welcome," + userEmail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userFirstName == null) ? 0 : userFirstName.hashCode());
		result = prime * result + ((userHomeTown == null) ? 0 : userHomeTown.hashCode());
		result = prime * result + ((userLastName == null) ? 0 : userLastName.hashCode());
		result = prime * result + ((userMobilePhone == null) ? 0 : userMobilePhone.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
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
		User other = (User) obj;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userFirstName == null) {
			if (other.userFirstName != null)
				return false;
		} else if (!userFirstName.equals(other.userFirstName))
			return false;
		if (userHomeTown == null) {
			if (other.userHomeTown != null)
				return false;
		} else if (!userHomeTown.equals(other.userHomeTown))
			return false;
		if (userLastName == null) {
			if (other.userLastName != null)
				return false;
		} else if (!userLastName.equals(other.userLastName))
			return false;
		if (userMobilePhone == null) {
			if (other.userMobilePhone != null)
				return false;
		} else if (!userMobilePhone.equals(other.userMobilePhone))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		return true;
	}
	
}
