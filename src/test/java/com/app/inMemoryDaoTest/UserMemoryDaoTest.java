package com.app.inMemoryDaoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.app.domain.partner.Partner;
import com.app.domain.user.User;
import com.app.inMemoryDao.InMemoryDao;

public class UserMemoryDaoTest {

	@Test
	public void testAddUser() {
		InMemoryDao inMemoryDao = new InMemoryDao();
		User user = new User();
		user.setUserLastName("T");
		user.setUserFirstName("A");
		user.setUserHomeTown("PC");
		user.setUserMobilePhone("00000");
		user.setUserEmail("alex.timis95@gmail.com");
		user.setUserPassword("aaaa");
		user.setUserRole("USER");

		inMemoryDao.addUser(user);

		assertTrue(inMemoryDao.getUsers().size() > 0);

		assertEquals("alex.timis95@gmail.com", inMemoryDao.getUsers().get(0).getUserEmail());
	}

	@Test
	public void testCheckEmailFalse() {
		InMemoryDao inMemoryDao = new InMemoryDao();

		User user0 = new User();
		user0.setUserLastName("T");
		user0.setUserFirstName("A");
		user0.setUserHomeTown("PC");
		user0.setUserMobilePhone("00000");
		user0.setUserEmail("alex.timis95@gmail.com");
		user0.setUserPassword("aaaa");
		user0.setUserRole("USER");

		User user1 = new User();
		user1.setUserLastName("T");
		user1.setUserFirstName("A");
		user1.setUserHomeTown("PC");
		user1.setUserMobilePhone("00000");
		user1.setUserEmail("alex.timis695@outlook.com");
		user1.setUserPassword("aaaa");
		user1.setUserRole("USER");

		User user2 = new User();
		user2.setUserLastName("T");
		user2.setUserFirstName("A");
		user2.setUserHomeTown("PC");
		user2.setUserMobilePhone("00000");
		user2.setUserEmail("asdasd@asdasd.com");
		user2.setUserPassword("aaaa");
		user2.setUserRole("USER");

		User user3 = new User();
		user3.setUserLastName("TASD");
		user3.setUserFirstName("AASD");
		user3.setUserHomeTown("PCASD");
		user3.setUserMobilePhone("00000");
		user3.setUserEmail("alex.timis95@gmail.com");
		user3.setUserPassword("aaaaaASDASD");
		user3.setUserRole("USER");

		inMemoryDao.addUser(user0);
		inMemoryDao.addUser(user1);
		inMemoryDao.addUser(user2);

		assertFalse(inMemoryDao.checkUserEmail(user3));

		assertTrue(inMemoryDao.getUsers().size() < 4);

	}

	@Test
	public void testCheckEmailTrue() {
		InMemoryDao inMemoryDao = new InMemoryDao();
		User user = new User();
		user.setUserLastName("T");
		user.setUserFirstName("A");
		user.setUserHomeTown("PC");
		user.setUserMobilePhone("00000");
		user.setUserEmail("alex.timis95@gmail.com");
		user.setUserPassword("aaaa");
		user.setUserRole("USER");

		User user1 = new User();
		user1.setUserLastName("T");
		user1.setUserFirstName("A");
		user1.setUserHomeTown("PC");
		user1.setUserMobilePhone("00000");
		user1.setUserEmail("alex.timis659@outlook.com");
		user1.setUserPassword("aaaa");
		user1.setUserRole("USER");

		inMemoryDao.addUser(user);

		assertTrue(inMemoryDao.checkUserEmail(user1));

		assertTrue(inMemoryDao.getUsers().size() > 1);

	}

	@Test
	public void testCheckEmailWhitoutAdd() {
		InMemoryDao inMemoryDao = new InMemoryDao();

		User user = new User();
		user.setUserLastName("T");
		user.setUserFirstName("A");
		user.setUserHomeTown("PC");
		user.setUserMobilePhone("00000");
		user.setUserEmail("alex.timis95@gmail.com");
		user.setUserPassword("aaaa");
		user.setUserRole("USER");

		User user1 = new User();
		user1.setUserLastName("T");
		user1.setUserFirstName("A");
		user1.setUserHomeTown("PC");
		user1.setUserMobilePhone("00000");
		user1.setUserEmail("alex.timis659@outlook.com");
		user1.setUserPassword("aaaa");
		user1.setUserRole("USER");

		assertTrue(inMemoryDao.checkUserEmail(user1));

		assertTrue(inMemoryDao.getUsers().size() > 0);

	}

	@Test
	public void testCheckLoginWithoutAdd() {

		InMemoryDao inMemoryDao = new InMemoryDao();
		User user = new User();
		user.setUserLastName("T");
		user.setUserFirstName("A");
		user.setUserHomeTown("PC");
		user.setUserMobilePhone("00000");
		user.setUserEmail("alex.timis95@gmail.com");
		user.setUserPassword("aaaa");
		user.setUserRole("USER");

		User user1 = new User();
		user1.setUserLastName("T");
		user1.setUserFirstName("A");
		user1.setUserHomeTown("PC");
		user1.setUserMobilePhone("00000");
		user1.setUserEmail("alex.timis659@outlook.com");
		user1.setUserPassword("aaaa");
		user1.setUserRole("USER");

		assertFalse(inMemoryDao.checkUserLogin("alex.timis659@outlook.com", "asdasd"));

	}

	@Test
	public void testCheckLoginFalse() {

		InMemoryDao inMemoryDao = new InMemoryDao();
		User user = new User();
		user.setUserLastName("T");
		user.setUserFirstName("A");
		user.setUserHomeTown("PC");
		user.setUserMobilePhone("00000");
		user.setUserEmail("alex.timis95@gmail.com");
		user.setUserPassword("aaaa");
		user.setUserRole("USER");

		User user1 = new User();
		user1.setUserLastName("T");
		user1.setUserFirstName("A");
		user1.setUserHomeTown("PC");
		user1.setUserMobilePhone("00000");
		user1.setUserEmail("alex.timis659@outlook.com");
		user1.setUserPassword("aaaa");
		user1.setUserRole("USER");

		inMemoryDao.addUser(user);
		inMemoryDao.addUser(user1);

		assertFalse(inMemoryDao.checkUserLogin("alex.timis659@outlook.com", "asdasd"));

	}

	@Test
	public void testCheckLoginTrue() {

		InMemoryDao inMemoryDao = new InMemoryDao();
		User user = new User();
		user.setUserLastName("T");
		user.setUserFirstName("A");
		user.setUserHomeTown("PC");
		user.setUserMobilePhone("00000");
		user.setUserEmail("alex.timis95@gmail.com");
		user.setUserPassword("aaaa");
		user.setUserRole("USER");

		User user1 = new User();
		user1.setUserLastName("T");
		user1.setUserFirstName("A");
		user1.setUserHomeTown("PC");
		user1.setUserMobilePhone("00000");
		user1.setUserEmail("alex.timis659@outlook.com");
		user1.setUserPassword("aaaa");
		user1.setUserRole("USER");

		inMemoryDao.addUser(user);
		inMemoryDao.addUser(user1);

		assertTrue(inMemoryDao.checkUserLogin("alex.timis95@gmail.com", "aaaa"));

	}

	@Test
	public void testCheckEmailUserRegistered() {

		InMemoryDao inMemoryDao = new InMemoryDao();

		User user = new User();
		user.setUserLastName("T");
		user.setUserFirstName("A");
		user.setUserHomeTown("PC");
		user.setUserMobilePhone("00000");
		user.setUserEmail("alex.timis95@gmail.com");
		user.setUserPassword("aaaa");
		user.setUserRole("USER");

		User user1 = new User();
		user1.setUserLastName("T");
		user1.setUserFirstName("A");
		user1.setUserHomeTown("PC");
		user1.setUserMobilePhone("00000");
		user1.setUserEmail("alex.timis659@outlook.com");
		user1.setUserPassword("aaaa");
		user1.setUserRole("USER");

		Partner partner = new Partner();
		partner.setPartnerLastName("A");
		partner.setPartnerFirstName("B");
		partner.setPartnerAddress("C");
		partner.setPartnerCategory("D");
		partner.setPartnerPhone("00000");
		partner.setPartnerEmail("alex.timis95@gmail.com");
		partner.setPartnerPassword("ASD651651");

		inMemoryDao.addUser(user);
		inMemoryDao.addUser(user1);

		assertFalse(inMemoryDao.checkPartnerEmail(partner));

	}

	@Test
	public void testCheckEmailPartnerRegistered() {

		InMemoryDao inMemoryDao = new InMemoryDao();

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

		inMemoryDao.addPartner(partner);

		assertFalse(inMemoryDao.checkUserEmail(user));

	}

}
