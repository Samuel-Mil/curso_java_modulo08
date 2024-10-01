package com.br.samuel.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	private Date timestamps;
	private String message;
	private String details;
	public ExceptionResponse(Date timestamps, String message, String details) {
		this.timestamps = timestamps;
		this.message = message;
		this.details = details;
	}
	
	public Date getTimestamps() {
		return timestamps;
	}
	public void setTimestamps(Date timestamps) {
		this.timestamps = timestamps;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
}
