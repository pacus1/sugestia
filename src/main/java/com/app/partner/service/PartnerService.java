package com.app.partner.service;

import org.springframework.stereotype.Service;

import com.app.other.domain.TransferObject;
import com.app.partner.dao.PartnerClassificationDao;
import com.app.partner.dao.PartnerDao;
import com.app.user.dao.UserDao;
import com.app.user.domain.User;

@Service
public class PartnerService {

	private UserDao userDao;
	private User user;
	private PartnerClassificationDao partnerClassificationDao;
	private PartnerDao partnerDao;
	
	
	public int addPartner (TransferObject transferObject){
		int newAddedUserId;
		int partnerClassificationId;	
		int newAddedPartnerId = -1;
		
		this.user = new User();
		this.userDao = new UserDao();
		this.partnerClassificationDao = new PartnerClassificationDao();
		this.partnerDao = new PartnerDao();
		
		user = transferObject.getUser();
				
		newAddedUserId = userDao.checkUserEmail(user);
		
		
		if(newAddedUserId != -1){
			transferObject.getPartner().setUser_id(newAddedUserId);
			partnerClassificationId = partnerClassificationDao.checkPartnerClassificationId(transferObject.getPartnerClassification());
			transferObject.getPartner().setPartnerClassificationId(partnerClassificationId);
			
			newAddedPartnerId = partnerDao.addPartner(transferObject.getPartner());
			
		}
		
		return newAddedPartnerId;
	}
	
	
}
