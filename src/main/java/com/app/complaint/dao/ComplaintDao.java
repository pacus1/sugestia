package com.app.complaint.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringEscapeUtils;

import com.app.partner.domain.Partner;
import com.app.user.domain.User;
import com.app.complaint.domain.Complaint;
import com.app.other.dao.ConnectDBS;
import com.app.other.domain.TransferObject;

@Service
public class ComplaintDao {

	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Connection connection = null;
	
	//public boolean update(Complaint complaint, User user) {
	public boolean update(TransferObject transferObject) {
	
	connection = ConnectDBS.connectDatabase();

			try {
				
				preparedStatement = connection.prepareStatement("INSERT INTO complaint (senderEmailAddress,statusType,type,timestamp,complaintTitle,"
						+ "complaintBody,partner_id) " + "VALUES(?,?,?,?,?,?,?)");			
				
//				preparedStatement.setString(1, user.getUserEmail());
////				preparedStatement.setString(2, complaint.getComplaintStatusType());
////				preparedStatement.setString(3, complaint.getComplaintType());
////				preparedStatement.setString(4, Date());
//				preparedStatement.setString(5, user.getUserHomeTown());
//				preparedStatement.setString(6, user.getUserPassword());
//				preparedStatement.setString(7, user.getUserRole());
				
				preparedStatement.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return true;
		}

	public Collection<Complaint> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Complaint findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

