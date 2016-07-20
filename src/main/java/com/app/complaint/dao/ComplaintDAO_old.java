package com.app.complaint.dao;

import java.util.Collection;

import com.app.complaint.domain.Complaint;

public interface ComplaintDAO_old extends BaseDAO<Complaint>{

	Collection<Complaint> searchByName(String query);
}
