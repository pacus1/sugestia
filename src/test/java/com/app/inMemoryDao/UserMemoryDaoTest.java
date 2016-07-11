package com.app.inMemoryDao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.app.domain.user.User;
import com.app.inMemoryDao.user.UserMemoryDao;

public class UserMemoryDaoTest {

	@Test
	public void testAddUser() {
		UserMemoryDao userMemoryDao = new UserMemoryDao();
		User user = new User();
		user.setUserLastName("T");
		user.setUserFirstName("A");
		user.setUserHomeTown("PC");
		user.setUserMobilePhone("00000");
		user.setUserEmail("alex.timis95@gmail.com");
		user.setUserPassword("aaaa");
		user.setUserRole("USER");

		userMemoryDao.addUser(user);

		assertTrue(userMemoryDao.getUsers().size() > 0);

		assertEquals("alex.timis95@gmail.com", userMemoryDao.getUsers().get(0).getUserEmail());
	}

	@Test
	public void testCheckEmailFalse() {
		UserMemoryDao userMemoryDao = new UserMemoryDao();

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
		user3.setUserLastName("T");
		user3.setUserFirstName("A");
		user3.setUserHomeTown("PC");
		user3.setUserMobilePhone("00000");
		user3.setUserEmail("alex.timis95@gmail.com");
		user3.setUserPassword("aaaa");
		user3.setUserRole("USER");

		userMemoryDao.addUser(user0);
		userMemoryDao.addUser(user1);
		userMemoryDao.addUser(user2);

		assertFalse(userMemoryDao.checkUserEmail(user3));

		assertTrue(userMemoryDao.getUsers().size() < 4);

	}

	@Test
	public void testCheckEmailTrue() {
		UserMemoryDao userMemoryDao = new UserMemoryDao();
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

		userMemoryDao.addUser(user);

		assertTrue(userMemoryDao.checkUserEmail(user1));

		assertTrue(userMemoryDao.getUsers().size() > 1);

	}

	@Test
	public void testCheckEmailWhitoutAdd() {
		UserMemoryDao userMemoryDao = new UserMemoryDao();
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

		assertTrue(userMemoryDao.checkUserEmail(user1));

		assertTrue(userMemoryDao.getUsers().size() > 0);

	}

	@Test
	public void testCheckLoginWithoutAdd() {

		UserMemoryDao userMemoryDao = new UserMemoryDao();
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

		assertFalse(userMemoryDao.checkLogin("alex.timis659@outlook.com", "asdasd"));

	}

	@Test
	public void testCheckLoginFalse() {

		UserMemoryDao userMemoryDao = new UserMemoryDao();
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

		userMemoryDao.addUser(user);
		userMemoryDao.addUser(user1);

		assertFalse(userMemoryDao.checkLogin("alex.timis659@outlook.com", "asdasd"));

	}

	@Test
	public void testCheckLoginTrue() {

		UserMemoryDao userMemoryDao = new UserMemoryDao();
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

		userMemoryDao.addUser(user);
		userMemoryDao.addUser(user1);

		assertTrue(userMemoryDao.checkLogin("alex.timis95@gmail.com", "aaaa"));

	}

}
