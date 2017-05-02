package br.com.springaplication.exception.message;

import javax.ws.rs.core.Response.Status;

public enum AuthenticationMessage implements Message {
	
	FAIL_AUTHENTICATION("Usuário ou senha incorreta!", Status.UNAUTHORIZED),
	REQUEST_NOT_AUTHENTICADE("Requisicao nao permitida!", Status.UNAUTHORIZED);
	
	private AuthenticationMessage(String message, Status status) {
		this.message = message;
		this.status = status;
	}
	
	private String message;
	
	private Status status;

	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public Status getStatus() {
		return status;
	}

	
}
