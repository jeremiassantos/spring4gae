package br.com.springaplication.exception.message;

import javax.ws.rs.core.Response;

/**
 * Created by jeremias on 25/04/17.
 */
public enum AplicationMessage implements Message {

	APLICATION_ERRO("Ocorreu um erro inesperado ao processar a requisição", Response.Status.BAD_REQUEST);

	private AplicationMessage(String message, Response.Status status) {
		this.message = message;
		this.status = status;
	}

	private String message;

	private Response.Status status;

	@Override
	public String getMessage() {
		return null;
	}

	@Override
	public Response.Status getStatus() {
		return null;
	}
}
