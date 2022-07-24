package com.bridgelabz.bookstore.exception;

import java.util.Locale;

import org.springframework.web.bind.annotation.ResponseStatus;

import com.bridgelabz.bookstore.util.ErrorResponse;
import com.bridgelabz.bookstore.util.Response;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@ResponseStatus
@Data
@Slf4j
public class BookStoreException extends RuntimeException {


	public BookStoreException(int statusCode, String statusmessage) {
		super(statusmessage);
		StatusCode = statusCode;
		Statusmessage = statusmessage;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int StatusCode;
	private String Statusmessage;
	
	/**
	 * 
	 * @return error response
	 */
	public Response getErrorResponse() {
		log.error("Error msg:" + Statusmessage);
		return getErrorResponse(Locale.getDefault());
	}
	
	/**
	 * 
	 * @param locale : locale
	 * @return : Response type
	 */
	public Response getErrorResponse(Locale locale) {
		log.error("Error msg status:" + getStatusmessage());
		ErrorResponse err = new ErrorResponse(StatusCode, Statusmessage, getStackTrace());
		err.setStatusCode(getStatusCode());
		err.setStatusmessage(getStatusmessage());
		return err;
	
}
}
