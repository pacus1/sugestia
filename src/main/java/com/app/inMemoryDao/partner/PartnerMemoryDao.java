package com.app.inMemoryDao.partner;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.app.domain.partner.Partner;

@Service
public class PartnerMemoryDao {
	private ArrayList<Partner> partners = new ArrayList<>();

	public ArrayList<Partner> getPartners() {
		return partners;
	}

	public void setPartners(ArrayList<Partner> partners) {
		this.partners = partners;
	}

	public boolean checkPartnerEmail(Partner partner) {
		if (partners.size() > 0) {
			for (int x = 0; x < partners.size(); x++) {
				if (partner.getPartnerEmail().equals(partners.get(x).getPartnerEmail())) {
					return false;
				}

			}

		}
		partners.add(partner);
		return true;

	}

	public boolean checkLogin(String email, String password) {
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

}
