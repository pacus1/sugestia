package com.app.databaseDaoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.app.partner.domain.Partner;
import com.app.user.dao.UserDao;
import com.app.user.domain.User;

public class DatabaseDaoTest {

	@Test
	public void testRegister() {

		UserDao databaseDao = new UserDao();

		User user = new User();
		user.setUserLastName("T");
		user.setUserFirstName("A");
		user.setUserHomeTown("PC");
		user.setUserMobilePhone("00000");
		user.setUserEmail("alex.timis95@gmail.com");
		user.setUserPassword("aaaa");
		user.setUserRole("USER");

		Partner partner = new Partner();
		partner.setPartnerLastName("A");
		partner.setPartnerFirstName("B");
		partner.setPartnerAddress("C");
		partner.setPartnerCategory("D");
		partner.setPartnerPhone("00000");
		partner.setPartnerEmail("alex.timis95@gmail.com");
		partner.setPartnerPassword("ASD651651");

		User user1 = new User();
		user1.setUserLastName("T");
		user1.setUserFirstName("A");
		user1.setUserHomeTown("PC");
		user1.setUserMobilePhone("00000");
		user1.setUserEmail("asdasdasd@asd.com");
		user1.setUserPassword("aaaa");
		user1.setUserRole("USER");

		Partner partner1 = new Partner();
		partner1.setPartnerLastName("A");
		partner1.setPartnerFirstName("B");
		partner1.setPartnerAddress("C");
		partner1.setPartnerCategory("D");
		partner1.setPartnerPhone("00000");
		partner1.setPartnerEmail("asdasdasd@asd.com");
		partner1.setPartnerPassword("ASD651651");

		assertFalse(databaseDao.checkUserEmail(user1));
		assertFalse(databaseDao.checkPartnerEmail(partner1));

	}

	@Test
	public void testLogin() {

		UserDao databaseDao = new UserDao();

		assertTrue(databaseDao.checkUserLogin("alex.timis95@gmail.com", "aaaa"));

		assertFalse(databaseDao.checkUserLogin("asd", "asd"));

		assertTrue(databaseDao.checkPartnerLogin("asd", "asd"));

		assertFalse(databaseDao.checkPartnerLogin("alex.timis95@gmail.com", "aaaa"));
	}

	@Test
	public void returnCurrentUser() {
		UserDao databaseDao = new UserDao();
		System.out.println(databaseDao.getCurrentUser("alex.timis95@gmail.com", "aaaa"));
		System.out.println(databaseDao.getCurrentPartner("asd", "asd"));

	}

}
