package br.com.springaplication.exception.message;

import javax.ws.rs.core.Response.Status;

public interface Message {

	String getMessage();
	
	Status getStatus();
}
