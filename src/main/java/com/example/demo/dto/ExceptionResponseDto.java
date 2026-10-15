package com.example.demo.dto;

import java.time.LocalDateTime;

public class ExceptionResponseDto 
{
	private LocalDateTime timestamp;
	private int statuscode;
	private String error;
	private String message;
	
	private String path;

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ExceptionResponseDto(LocalDateTime timestamp, int statuscode, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.statuscode = statuscode;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	@Override
	public String toString() {
		return "ExceptionResponseDto [timestamp=" + timestamp + ", statuscode=" + statuscode + ", error=" + error
				+ ", message=" + message + ", path=" + path + "]";
	}

	public ExceptionResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
