package com.app.complaint.dao;

import java.util.Collection;

import com.app.complaint.domain.Complaint;

public interface ComplaintDAO extends BaseDAO<Complaint>{

	Collection<Complaint> searchByName(String query);
}
