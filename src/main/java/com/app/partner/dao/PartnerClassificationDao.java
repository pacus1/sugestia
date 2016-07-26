package com.app.partner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.app.other.dao.ConnectDBS;
import com.app.other.domain.TransferObject;
import com.app.partner.domain.Partner;
import com.app.partner.domain.PartnerClassification;

public class PartnerClassificationDao {

	private Partner partner;
	private PartnerClassification partnerClassification;
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet rs;
	
	
		public int checkPartnerClassificationId(PartnerClassification partnerClassification){
			String partnerType;
			int partnerClassifId = 0;
			
//			partnerType = partnerClassification.getPartnerType();
			
			connection = ConnectDBS.connectDatabase();
					
			try {
				preparedStatement = connection.prepareStatement("SELECT * from partner_classification WHERE partner_type= ?");
				
				preparedStatement.setString(1, partnerClassification.getPartnerType());
				
				rs = preparedStatement.executeQuery();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				rs.next();
				 partnerClassifId = rs.getInt("id");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return partnerClassifId;
		}
		
		
		
	
	
}
