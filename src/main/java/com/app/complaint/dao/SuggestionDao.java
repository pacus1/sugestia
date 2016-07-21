package com.app.complaint.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.app.complaint.domain.Complaint;

@Service
public class SuggestionDao {
	private ArrayList<Complaint> complaints = new ArrayList<>();

	public void save(Complaint complaint) {
		complaints.add(complaint);
	}

	public ArrayList<Complaint> listAll() {
		return complaints;
	}

}
