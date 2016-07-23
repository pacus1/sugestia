package com.app.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringEscapeUtils;

import com.app.partner.domain.Partner;
import com.app.user.domain.User;
import com.app.other.dao.ConnectDBS;

@Service
public class UserDao {

	//	connection to Heroku dbs
	//private static final String DATABASE_URL = "jdbc:postgresql://ec2-54-228-219-2.eu-west-1.compute.amazonaws.com:5432/davlnk5ukati5r?sslmode=require&user=pxtvzlortfjhdh&password=QY9jN5mm1dMBMJqVGZ9RavILOe";
	

	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Connection connection = null;
	
	public boolean checkUserEmail(User user) {
		connection = ConnectDBS.connectDatabase();

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

//		initial approach - changed due to conflicts with autoincremented fields 		
//		String addUserQuery = String.format("INSERT INTO users VALUES('%s','%s','%s','%s','%s','%s','%s')",
//				user.getUserLastName(), user.getUserFirstName(), user.getUserEmail(), user.getUserMobilePhone(),
//				user.getUserHomeTown(), user.getUserPassword(), user.getUserRole());
		
		try {
						
			preparedStatement = connection.prepareStatement("INSERT INTO users (userlastname,userfirstname,useremail,usermobilephone,userhometown,"
					+ "userpassword,userrole) " + "VALUES(?,?,?,?,?,?,?)");			
			
			preparedStatement.setString(1, user.getUserLastName());
			preparedStatement.setString(2, user.getUserFirstName());
			preparedStatement.setString(3, user.getUserEmail());
			preparedStatement.setString(4, user.getUserMobilePhone());
			preparedStatement.setString(5, user.getUserHomeTown());
			preparedStatement.setString(6, user.getUserPassword());
			preparedStatement.setString(7, user.getUserRole());
			
			preparedStatement.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	public boolean checkPartnerEmail(Partner partner) {
		connection = ConnectDBS.connectDatabase();

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
		connection = ConnectDBS.connectDatabase();

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
		connection = ConnectDBS.connectDatabase();

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
		connection = ConnectDBS.connectDatabase();

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

				if (email.equals(userEmailResultSet) || password.equals(partnerEmailResultSet)) {

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
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Partner getCurrentPartner(String email, String password) {
		connection = ConnectDBS.connectDatabase();

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
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}