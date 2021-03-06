package com.app.filter.service;

import org.springframework.stereotype.Component;

import com.app.partner.domain.Partner;
import com.app.user.domain.User;

@Component
public class SecurityService {

	private ThreadLocal<User> currentUser;

	public void setCurrentUser(User user) {
		this.currentUser = new ThreadLocal<>();
		this.currentUser.set(user);
	}

	public User getCurrentUser() {
		return this.currentUser != null ? this.currentUser.get() : null;

	}

	private ThreadLocal<Partner> currentPartner;

	public void setCurrentPartner(Partner partner) {
		this.currentPartner = new ThreadLocal<>();
		this.currentPartner.set(partner);
	}

	public Partner getCurrentPartner() {
		return this.currentUser != null ? this.getCurrentPartner() : null;

	}

}
