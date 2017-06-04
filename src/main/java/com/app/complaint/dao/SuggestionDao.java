package com.app.complaint.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringEscapeUtils;

import com.app.partner.domain.Partner;
import com.app.user.domain.User;
import com.app.complaint.domain.Complaint;
import com.app.complaint.domain.ComplaintHistory;
import com.app.complaint.domain.ComplaintStatusType;
import com.app.complaint.domain.ComplaintType;
import com.app.other.dao.ConnectDBS;
import com.app.other.domain.TransferObject;
import java.util.ArrayList;

@Service
public class SuggestionDao {

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
	
	public int addComplaint(Complaint complaint)   {
	
	connection = ConnectDBS.connectDatabase();
	int newAddedComplaintId = 0;

			try {
				preparedStatement = connection.prepareStatement("INSERT INTO complaint (sender_email_address,status_type,suggestion_type,timestamp,"
						+ "complaint_title,complaint_body,partner_assign_name,partner_id) VALUES(?,?,?,?,?,?,?,?)", newAddedComplaintId);
				
				preparedStatement.setString(1, complaint.getSenderEmailAddress());
				preparedStatement.setString(2, complaint.getComplaintStatusType().toString());
				
				String test = complaint.getComplaintType().toString();
				preparedStatement.setString(3, complaint.getComplaintType().toString());
				
				//java.sql.Timestamp complainTime = complaint.getComplaintTimeStamp();
				
				preparedStatement.setTimestamp(4, complaint.getComplaintTimeStamp());
				preparedStatement.setString(5, complaint.getComplaintTitle());
				preparedStatement.setString(6, complaint.getComplaintBody());
				preparedStatement.setString(7, complaint.getComplaintPartnerAsigneeName());
				preparedStatement.setInt(8, complaint.getPartnerId());
				
				preparedStatement.execute();
				rs = preparedStatement.getGeneratedKeys();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				rs.next();
				newAddedComplaintId = rs.getInt("complaint_id");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return newAddedComplaintId;
		}

	public Collection<Complaint> getAll() {
		return null;
	}

	public Complaint findById(Long id) {
		return null;
	}
	
	public ArrayList<Complaint> listAllComplaintsByStatus(ComplaintStatusType complaintStatusType)   {
		
		connection = ConnectDBS.connectDatabase();
		complaintsList = new ArrayList<>();
		
				try {
					preparedStatement = connection.prepareStatement("SELECT * from complaint WHERE status_type = ? ORDER BY timestamp DESC");
					String test = complaintStatusType.toString();
					preparedStatement.setString(1, complaintStatusType.toString());
					
					rs = preparedStatement.executeQuery();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}

				complaintsList = addResultsetToArrayList(rs);
				     	
				return complaintsList;
			}	
	
public ArrayList<Complaint> listAllComplaintsByUser(User user)   {
		
		connection = ConnectDBS.connectDatabase();
		complaintsList = new ArrayList<>();
		
				try {
					preparedStatement = connection.prepareStatement("SELECT * from complaint WHERE sender_email_address = ? ORDER BY timestamp DESC ");
					
					preparedStatement.setString(1, user.getUserEmail());
					
					rs = preparedStatement.executeQuery();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}

				complaintsList = addResultsetToArrayList(rs);
				
//	        	for (int i = 0; i<complaintsList.size();i++){	        		
//	        		System.out.println(complaintsList.get(i).toString());	        		
//	        	}        		        	
				return complaintsList;
			}	
	
	
	public boolean updateComplaintStatus(int id, ComplaintStatusType complaintStatusType)   {
			
			connection = ConnectDBS.connectDatabase();	
			
					try {
						preparedStatement = connection.prepareStatement("UPDATE complaint SET status_type = ? "
								+ "WHERE complaint_id = ?");
						String test = complaintStatusType.toString();
						preparedStatement.setString(1, complaintStatusType.toString());
						preparedStatement.setInt(2, id);
						
						rs = preparedStatement.executeQuery();
						
					} catch (SQLException e) {
						e.printStackTrace();
						//return false;						
					}
	
			// check update code to be added
			return true;
	}
	
public Complaint getComplaintById(int id)   {
		
		connection = ConnectDBS.connectDatabase();	
			
		try {
			preparedStatement = connection.prepareStatement("SELECT * from complaint WHERE complaint_id = ?");
			preparedStatement.setInt(1, id);
	
			rs = preparedStatement.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

    	complaint = addResultsetToArrayList(rs).get(0);
    	
		return complaint;
}
	
public ArrayList<Complaint> listAllComplaintsOrderByTimeStamp()   {
		
		connection = ConnectDBS.connectDatabase();
		complaintsList = new ArrayList<>();
		
				try {
					preparedStatement = connection.prepareStatement("SELECT * from complaint ORDER BY timestamp");
					
					rs = preparedStatement.executeQuery();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        	
	        	complaintsList = addResultsetToArrayList(rs);
	        	
				return complaintsList;
			}	
	
	//------------------------------------------------------------------------
	//       the method below is under development
	//------------------------------------------------------------------------
	public ArrayList<Complaint> listAllComplaintsBySelection(String suggestionType, String suggestionCategory, String sortTimestampType)   {
	
	connection = ConnectDBS.connectDatabase();
	complaintsList = new ArrayList<>();
	
	
	//SELECT STATEMENT PREPARATION
	
			try {
				if (suggestionType=="ALL"){
					preparedStatement = connection.prepareStatement("SELECT * from complaint ORDER BY timestamp " + sortTimestampType);
//					preparedStatement.setString(1, sortTimestampType);
				}else{
					
					preparedStatement = connection.prepareStatement("SELECT * from complaint WHERE suggestion_type = ? ORDER BY timestamp " + sortTimestampType);
					preparedStatement.setString(1, suggestionType);
//					preparedStatement.setString(1, sortTimestampType);
				}
					
				rs = preparedStatement.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

        	try{	
        		while (rs.next()) {              				        
        			complaint = new Complaint();
	        		complaint.setComplaintId(rs.getInt("complaint_id"));
	        		complaint.setSenderEmailAddress(rs.getString("sender_email_address"));
	        		complaint.setComplaintTitle(rs.getString("complaint_title"));
	        		complaint.setComplaintBody(rs.getString("complaint_body"));
	        	
	        		statusType = rs.getString("status_type");
	        		switch (statusType){
		        		case "PENDING" : complaint.setComplaintStatusType(ComplaintStatusType.PENDING);break;
		        		case "APPROVED" : complaint.setComplaintStatusType(ComplaintStatusType.APPROVED);break;
		        		case "REJECT" : complaint.setComplaintStatusType(ComplaintStatusType.REJECT);break;
		        		case "SOLVED" : complaint.setComplaintStatusType(ComplaintStatusType.SOLVED);break;
	        		}
	        				        	
	        		complaint.setComplaintPartnerAsigneeName(rs.getString("partner_assign_name"));
	        		
	        		type = rs.getString("suggestion_type").trim();
	        		switch (type){
		        		case "SUGGESTION" : complaint.setComplaintType(ComplaintType.SUGGESTION);break;
		        		case "COMPLAINT" : complaint.setComplaintType(ComplaintType.COMPLAINT);break;
	        		}		        	
	        		
	        		timeStamp = rs.getTimestamp("timestamp");
	        		complaint.setComplaintTimeStamp(rs.getTimestamp("timestamp"));
	        		
	        		System.out.println(complaint.toString());
	        		
	        		complaintsList.add(complaint);
        		}
        	
        	} catch (SQLException e) {
				e.printStackTrace();
			}
			        		        	
			return complaintsList;
		}	
	
// this method adds a ResultSet to am ArrayList 	
	public ArrayList<Complaint> addResultsetToArrayList(ResultSet resultSet){
		ArrayList<Complaint> tempComplaintsList = new ArrayList<>();
		
		try{	
    		while (resultSet.next()) {              				        
    			complaint = new Complaint();
        		complaint.setComplaintId(rs.getInt("complaint_id"));
        		complaint.setSenderEmailAddress(rs.getString("sender_email_address"));
        		complaint.setComplaintTitle(rs.getString("complaint_title"));
        		complaint.setComplaintBody(rs.getString("complaint_body"));
        	
        		statusType = rs.getString("status_type");
        		switch (statusType){
	        		case "PENDING" : complaint.setComplaintStatusType(ComplaintStatusType.PENDING);break;
	        		case "APPROVED" : complaint.setComplaintStatusType(ComplaintStatusType.APPROVED);break;
	        		case "REJECT" : complaint.setComplaintStatusType(ComplaintStatusType.REJECT);break;
	        		case "SOLVED" : complaint.setComplaintStatusType(ComplaintStatusType.SOLVED);break;
        		}
        				        	
        		complaint.setComplaintPartnerAsigneeName(rs.getString("partner_assign_name"));
        		
        		type = rs.getString("suggestion_type").trim();
        		switch (type){
	        		case "SUGGESTION" : complaint.setComplaintType(ComplaintType.SUGGESTION);break;
	        		case "COMPLAINT" : complaint.setComplaintType(ComplaintType.COMPLAINT);break;
        		}		        	
        		
        		timeStamp = rs.getTimestamp("timestamp");
        		complaint.setComplaintTimeStamp(rs.getTimestamp("timestamp"));
        		
        		System.out.println(complaint.toString());
        		
        		tempComplaintsList.add(complaint);
    		}
    	
    	} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tempComplaintsList;
	}

}


