package com.app.complaint.dao;



import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.app.complaint.domain.Complaint;

@Component
public class IMComplaintDAO extends IMBaseDAO<Complaint> 
	implements ComplaintDAO {

	@Override
	public Collection<Complaint> searchByName(String query) {
		if (StringUtils.isEmpty(query)) {
			return getAll();
		}
		
		Collection<Complaint> all = new LinkedList<Complaint>(getAll());
		for (Iterator<Complaint> it = all.iterator(); it.hasNext();) {
			Complaint emp = it.next();
			String ss = emp.getComplainTitle() + " " + emp.getComplainBody();
			if (!ss.toLowerCase().contains(query.toLowerCase())) {
				it.remove();
			}
		}
		return all;
	}

	

}
