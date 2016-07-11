package com.app.inMemoryDao.user;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.app.domain.user.User;

@Service
public class UserMemoryDao {

	private ArrayList<User> users = new ArrayList<>();

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public void addUser(User user) {
		users.add(user);

	}

	public boolean checkUserEmail(User user) {
		if (users.size() > 0) {
			for (int x = 0; x < users.size(); x++) {
				if (user.getUserEmail().equals(users.get(x).getUserEmail())) {
					return false;
				}

			}

		}
		users.add(user);
		return true;

	}

	public boolean checkLogin(String email, String password) {
		if (users.size() > 0) {
			for (int x = 0; x < users.size(); x++) {
				if (email.equals(users.get(x).getUserEmail()) && password.equals(users.get(x).getUserPassword())) {
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

}
