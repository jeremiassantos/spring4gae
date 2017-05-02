package br.com.springaplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by jeremiassantos on 22/04/17.
 */
@ControllerAdvice(annotations = RestController.class)
public class ExceptionsHandler {

    private Logger logger = Logger.getLogger(ExceptionsHandler.class.getName());

    @ExceptionHandler(AplicationException.class)
    public ResponseEntity<?> aplicationException(HttpServletRequest request, AplicationException e) {
        logger.log(Level.SEVERE, e.getMessage(), e);
        return ResponseEntity.status(e.getResponse().getStatus()).body(e.getResponse().getEntity());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        logger.log(Level.SEVERE, e.getMessage(), e);
        final List<String> errors = new ArrayList<>();
        for (final FieldError error : e.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(HttpServletRequest request, Exception e ) {
        logger.log(Level.SEVERE, e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocorreu um erro inesperado ao processar a requisição");
    }
}
