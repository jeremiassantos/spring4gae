package br.com.springaplication.exception.message;

import javax.ws.rs.core.Response.Status;

public enum CategoriaExercicioMenssage implements Message {
	
	CAMPO_NOME_INVALIDO("O campo nome não pode ser nulo ou vazio", Status.BAD_REQUEST);
	
	private CategoriaExercicioMenssage(String message, Status status) {
		this.message = message;
		this.status = status;
	}
	
	private String message;
	
	private Status status;

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public Status getStatus() {
		return status;
	}

}
