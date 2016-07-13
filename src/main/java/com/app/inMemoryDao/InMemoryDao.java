package com.app.inMemoryDao;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.app.domain.partner.Partner;
import com.app.domain.user.User;

@Service
public class InMemoryDao {
	private ArrayList<User> users = new ArrayList<>();
	private ArrayList<Partner> partners = new ArrayList<>();

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public void addUser(User user) {
		users.add(user);

	}

	public ArrayList<Partner> getPartners() {
		return partners;
	}

	public void setPartners(ArrayList<Partner> partners) {
		this.partners = partners;
	}

	public void addPartner(Partner partner) {
		partners.add(partner);

	}

	public boolean checkUserEmail(User user) {
		if (users.size() > 0) {
			for (int x = 0; x < users.size(); x++) {
				if (user.getUserEmail().equals(users.get(x).getUserEmail())) {
					return false;
				}

			}

		}
		if (partners.size() > 0) {

			for (int x = 0; x < partners.size(); x++) {
				if (user.getUserEmail().equals(partners.get(x).getPartnerEmail())) {
					return false;
				}

			}

		}
		users.add(user);
		return true;

	}

	public boolean checkPartnerEmail(Partner partner) {
		if (partners.size() > 0) {
			for (int x = 0; x < partners.size(); x++) {
				if (partner.getPartnerEmail().equals(partners.get(x).getPartnerEmail())) {
					return false;
				}

			}

		}
		if (users.size() > 0) {
			for (int x = 0; x < users.size(); x++) {
				if (partner.getPartnerEmail().equals(users.get(x).getUserEmail())) {
					return false;
				}

			}

		}
		partners.add(partner);
		return true;

	}

	public boolean checkUserLogin(String email, String password) {
		if (users.size() > 0) {
			for (int x = 0; x < users.size(); x++) {
				if (email.equals(users.get(x).getUserEmail()) && password.equals(users.get(x).getUserPassword())) {
					return true;
				}

			}
		}
		return false;
	}

	public boolean checkPartnerLogin(String email, String password) {
		if (partners.size() > 0) {
			for (int x = 0; x < partners.size(); x++) {
				if (email.equals(partners.get(x).getPartnerEmail())
						&& password.equals(partners.get(x).getPartnerPassword())) {
					return true;
				}

			}
		}
		return false;
	}

	public User getCurrentUser(String email, String password) {

		for (int x = 0; x < users.size(); x++) {
			if (email.equals(users.get(x).getUserEmail()) && password.equals(users.get(x).getUserPassword())) {

				User user = new User();
				user.setUserLastName(users.get(x).getUserEmail());
				user.setUserFirstName(users.get(x).getUserFirstName());
				user.setUserHomeTown(users.get(x).getUserHomeTown());
				user.setUserMobilePhone(users.get(x).getUserMobilePhone());
				user.setUserEmail(users.get(x).getUserEmail());
				user.setUserPassword(users.get(x).getUserPassword());
				user.setUserRole(users.get(x).getUserRole());
				return user;
			}
		}
		return null;

	}

	public Partner getCurrentPartner(String email, String password) {

		for (int x = 0; x < partners.size(); x++) {
			if (email.equals(partners.get(x).getPartnerEmail())
					&& password.equals(partners.get(x).getPartnerPassword())) {

				Partner partner = new Partner();
				partner.setPartnerLastName(partners.get(x).getPartnerLastName());
				partner.setPartnerFirstName(partners.get(x).getPartnerFirstName());
				partner.setPartnerAddress(partners.get(x).getPartnerAddress());
				partner.setPartnerCategory(partners.get(x).getPartnerCategory());
				partner.setPartnerCompanyOrInstitutionName(partners.get(x).getPartnerCompanyOrInstitutionName());
				partner.setPartnerPhone(partners.get(x).getPartnerPhone());
				partner.setPartnerEmail(partners.get(x).getPartnerEmail());
				partner.setPartnerPassword(partners.get(x).getPartnerPassword());
				return partner;

			}
		}
		return null;
	}

}
