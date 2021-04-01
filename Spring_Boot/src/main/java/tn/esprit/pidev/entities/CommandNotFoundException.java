package tn.esprit.pidev.entities;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CommandNotFoundException extends RuntimeException{

	public CommandNotFoundException(String exception) {
		super(exception);
		
	}

	
}
