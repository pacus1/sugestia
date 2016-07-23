package com.app.complaint.service;


import java.util.Arrays;

public class ValidationException extends Exception {
	
	private String[] causes;
//	public Object getCauses;

	public ValidationException(String... causes) {
		super();
		this.causes = causes;
	}

	@Override
	public String getMessage() {

		return causes != null ? Arrays.toString(causes) : "No CAUSE!";
	}

	public String[] getCauses() {
		return causes;
	}

	public void setCauses(String[] causes) {
		this.causes = causes;
	}

}