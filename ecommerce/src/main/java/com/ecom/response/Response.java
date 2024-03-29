package com.ecom.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class Response<T> implements Serializable
{
	private static final long serialVersionUID = 1L;	
	protected LocalDateTime timeStamp;
	protected int statusCode;
	protected T data; //
	protected HttpStatus httpStatus;
	protected String reason;
	protected String message;
	protected String devloperMessage;
	protected Map<?,?> dataMap;
	
	public Response(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.timeStamp = LocalDateTime.now();
        this.data = data;
    }

}
