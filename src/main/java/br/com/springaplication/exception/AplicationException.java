package br.com.springaplication.exception;

import br.com.springaplication.exception.message.Message;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.Collections;
import java.util.List;


/**
 * 
 * @author jeremiassantos
 * 
 *         AplicationException - retorna o obejto de erro da apliacação
 * @version 1.0
 *
 */
public class AplicationException extends WebApplicationException {

	private static final long serialVersionUID = 1L;

	public AplicationException() {
		this(Status.BAD_REQUEST, "Ocorreu algum problema ao processar a requisição.", Collections.<String>emptyList());
	}

	public AplicationException(Message message) {
		this(message.getStatus(), message.getMessage(), Collections.<String>emptyList());
	}

	public AplicationException(Status status, String cause) {
		this(status, cause, Collections.<String>emptyList());
	}

	public AplicationException(Status status, String cause, List<String> causes) {
		super(Response.status(status).entity(new AplicationResponseEntity(status.getStatusCode(), cause, causes))
				.type(MediaType.APPLICATION_JSON).build());
	}

}
