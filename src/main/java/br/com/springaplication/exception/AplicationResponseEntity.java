package br.com.springaplication.exception;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class AplicationResponseEntity {

	private int status;
	private String mensage;
	private List<String> causes;

	public AplicationResponseEntity(int status, String mensage) {
		super();
		this.status = status;
		this.mensage = mensage;
	}

	public AplicationResponseEntity(int status, String mensage, List<String> causes) {
		super();
		this.status = status;
		this.mensage = mensage;
		this.causes = causes;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMensage() {
		return mensage;
	}

	public void setMensage(String mensage) {
		this.mensage = mensage;
	}

	public List<String> getCauses() {
		return causes;
	}

	public void setCauses(List<String> causes) {
		this.causes = causes;
	}

	
}
