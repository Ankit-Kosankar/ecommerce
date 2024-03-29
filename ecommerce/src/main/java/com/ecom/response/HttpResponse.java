package com.ecom.response;

import java.io.Serializable;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonInclude(content = Include.NON_DEFAULT)
public class HttpResponse implements Serializable 
{
	private static final long serialVersionUID = 1L;	
	protected String timeStamp;
	protected int statusCode;
	protected HttpStatus httpStatus;
	protected String reason;
	protected String message;
	protected String devloperMessage;
	protected Map<?,?> data;
}
