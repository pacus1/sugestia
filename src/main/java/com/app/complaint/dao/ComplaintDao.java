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
	
	//public boolean update(TransferObject transferObject) {
	public boolean update(Complaint complaint) {
	
	connection = ConnectDBS.connectDatabase();

			try {
				
//				preparedStatement = connection.prepareStatement("INSERT INTO Complaint (senderEmailAddress,statusType,type,timestamp,complaintTitle,"
//						+ "complaintBody,partner_id) " + "VALUES(?,?,?,?,?,?,?)");			
								
				
				preparedStatement = connection.prepareStatement("INSERT INTO complaint (sender_email_address,status_type,type,timestamp,"
						+ "complaint_title,complaint_body,partner_assign_name) VALUES(?,?,?,?,?,?,?)");
				
				preparedStatement.setString(1, complaint.getSenderEmailAddress());
				preparedStatement.setString(2, complaint.getComplaintStatusType().toString());
				preparedStatement.setString(3, complaint.getComplaintType().toString());
				
				//java.sql.Timestamp complainTime = complaint.getComplaintTimeStamp();
				
				preparedStatement.setTimestamp(4, complaint.getComplaintTimeStamp());
				preparedStatement.setString(5, complaint.getComplaintTitle());
				preparedStatement.setString(6, complaint.getComplaintBody());
				preparedStatement.setString(7, complaint.getComplaintPartnerAsigneeName());
				
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

