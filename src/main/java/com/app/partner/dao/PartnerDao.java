package com.app.partner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.app.complaint.domain.Complaint;
import com.app.complaint.domain.ComplaintStatusType;
import com.app.complaint.domain.ComplaintType;
import com.app.other.dao.ConnectDBS;
import com.app.other.domain.TransferObject;
import com.app.partner.domain.Partner;


public class PartnerDao {
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private Connection connection = null;
	private ArrayList<Complaint> complaintsList = new ArrayList<>();
	private ResultSet rs = null;
	private Complaint complaint = new Complaint();
	private ComplaintStatusType complaintStatusType = null;
	private String statusType;
	private ComplaintType complaintType = null;
	private String type;
	private java.sql.Timestamp timeStamp;
	
	
	public boolean addPartnerClassification(Complaint complaint)   {
		
		connection = ConnectDBS.connectDatabase();

				try {
					
					preparedStatement = connection.prepareStatement("INSERT INTO partner_classification (partner_category,partner_type,category_description,type_description)" 
							+ "VALUES('?','?','',''");

					preparedStatement.setString(1, "INSTITUTII PUBLICE");
					preparedStatement.setString(2, "Consiliul local");
					
					preparedStatement.executeQuery();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return true;
			}	

	public int addPartner(TransferObject transferObject){
		
		connection = ConnectDBS.connectDatabase();
		int newAddedComplaintId = 0;

				try {
					preparedStatement = connection.prepareStatement("INSERT INTO partners (user_id,partner_company_name,partner_address,partner_classification_id,"
							+ "phone_number,partner_email,tax_ident_number) VALUES(?,?,?,?,?,?,?)", newAddedComplaintId);
					
					preparedStatement.setInt(1, transferObject.getPartner().getUser_id());
					preparedStatement.setString(2, transferObject.getPartner().getPartnerCompanyName());
					
					preparedStatement.setString(3, transferObject.getPartner().getPartnerAddress());
					
					preparedStatement.setInt(4, transferObject.getPartner().getPartnerClassificationId());
					preparedStatement.setString(5, transferObject.getPartner().getPartnerPhoneNumber());
					preparedStatement.setString(6, transferObject.getPartner().getPartnerEmail());
					preparedStatement.setInt(7, 0);
					
					preparedStatement.execute();
					rs = preparedStatement.getGeneratedKeys();
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				try {
					rs.next();
					newAddedComplaintId = rs.getInt("partner_id");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return newAddedComplaintId;
	}
		
		
		
		
}

