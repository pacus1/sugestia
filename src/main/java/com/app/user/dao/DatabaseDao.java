package com.app.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.app.partner.domain.Partner;
import com.app.user.domain.User;

@Service
public class DatabaseDao {

	//connection to local dbs
//	private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/sugestiaDB?user=postgres&password=admin";
	
//	connection to Heroku dbs
	private static final String DATABASE_URL = "jdbc:postgresql://ec2-54-228-219-2.eu-west-1.compute.amazonaws.com:5432/davlnk5ukati5r?sslmode=require&user=pxtvzlortfjhdh&password=QY9jN5mm1dMBMJqVGZ9RavILOe";

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	private Connection connectDatabase() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(DATABASE_URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Connection succesful");
		return connection;
	}

	public boolean checkUserEmail(User user) {
		connectDatabase();

		String userEmailCheck = "SELECT useremail,partneremail FROM users,partners";
		try {
			preparedStatement = connection.prepareStatement(userEmailCheck);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (resultSet.next()) {

				String userEmailResultSet = resultSet.getString("useremail");
				String partnerEmailResultSet = resultSet.getString("partneremail");

				if (user.getUserEmail().equals(userEmailResultSet)
						|| user.getUserEmail().equals(partnerEmailResultSet)) {
					return false;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String addUserQuery = String.format("INSERT INTO users VALUES('%s','%s','%s','%s','%s','%s','%s')",
				user.getUserLastName(), user.getUserFirstName(), user.getUserEmail(), user.getUserMobilePhone(),
				user.getUserHomeTown(), user.getUserPassword(), user.getUserRole());

		try {
			preparedStatement = connection.prepareStatement(addUserQuery);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;

	}

	public boolean checkPartnerEmail(Partner partner) {
		connectDatabase();

		String partnerEmailCheck = "SELECT useremail,partneremail FROM users,partners";
		try {
			preparedStatement = connection.prepareStatement(partnerEmailCheck);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (resultSet.next()) {

				String userEmailResultSet = resultSet.getString("useremail");
				String partnerEmailResultSet = resultSet.getString("partneremail");

				if (partner.getPartnerEmail().equals(userEmailResultSet)
						|| partner.getPartnerEmail().equals(partnerEmailResultSet)) {
					return false;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String addPartnerQuery = String.format("INSERT INTO partners VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s')",1,
				partner.getPartnerLastName(), partner.getPartnerFirstName(),
				partner.getPartnerCompanyOrInstitutionName(), partner.getPartnerAddress(), partner.getPartnerCategory(),
				partner.getPartnerEmail(), partner.getPartnerPhone(), partner.getPartnerPassword());

		try {
			preparedStatement = connection.prepareStatement(addPartnerQuery);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;

	}

	// if login return true
	public boolean checkUserLogin(String email, String password) {
		connectDatabase();

		String userLoginCheck = "SELECT useremail,userpassword FROM users";
		try {
			preparedStatement = connection.prepareStatement(userLoginCheck);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (resultSet.next()) {

				String userEmailResultSet = resultSet.getString("useremail");
				String userPasswordResultSet = resultSet.getString("userpassword");

				if (email.equals(userEmailResultSet) && password.equals(userPasswordResultSet)) {
					return true;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	// if login return true
	public boolean checkPartnerLogin(String email, String password) {
		connectDatabase();

		String partnerLoginCheck = "SELECT partneremail,partnerpassword FROM partners";
		try {
			preparedStatement = connection.prepareStatement(partnerLoginCheck);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (resultSet.next()) {

				String userEmailResultSet = resultSet.getString("partneremail");
				String partnerEmailResultSet = resultSet.getString("partnerpassword");

				if (email.equals(userEmailResultSet) && password.equals(partnerEmailResultSet)) {
					return true;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	public User getCurrentUser(String email, String password) {
		connectDatabase();

		String userLoginCheck = "SELECT * FROM users";
		try {
			preparedStatement = connection.prepareStatement(userLoginCheck);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (resultSet.next()) {

				String userEmailResultSet = resultSet.getString("useremail");
				String partnerEmailResultSet = resultSet.getString("userpassword");

				if (email.equals(userEmailResultSet) && password.equals(partnerEmailResultSet)) {

					User user = new User();
					user.setUserLastName(resultSet.getString("userlastname"));
					user.setUserFirstName(resultSet.getString("userfirstname"));
					user.setUserHomeTown(resultSet.getString("userhometown"));
					user.setUserMobilePhone(resultSet.getString("usermobilephone"));
					user.setUserEmail(resultSet.getString("useremail"));
					user.setUserPassword(resultSet.getString("userpassword"));
					user.setUserRole(resultSet.getString("userrole"));

					return user;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connectDatabase().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Partner getCurrentPartner(String email, String password) {
		connectDatabase();

		String userLoginCheck = "SELECT * FROM partners";
		try {
			preparedStatement = connection.prepareStatement(userLoginCheck);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (resultSet.next()) {

				String userEmailResultSet = resultSet.getString("partneremail");
				String partnerEmailResultSet = resultSet.getString("partnerpassword");

				if (email.equals(userEmailResultSet) || password.equals(partnerEmailResultSet)) {

					Partner partner = new Partner();
					partner.setPartnerLastName(resultSet.getString("partnerlastname"));
					partner.setPartnerFirstName(resultSet.getString("partnerfirstname"));
					partner.setPartnerAddress(resultSet.getString("partneraddress"));
					partner.setPartnerCategory(resultSet.getString("partnercategory"));
					partner.setPartnerCompanyOrInstitutionName(resultSet.getString("partnercompanyorinstitutionname"));
					partner.setPartnerPhone(resultSet.getString("partnerphone"));
					partner.setPartnerEmail(resultSet.getString("partneremail"));
					partner.setPartnerPassword(resultSet.getString("partnerpassword"));
					return partner;

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connectDatabase().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}