package it.uniroma3.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.model.Centro;

@Component
public class CentroValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		
		return Centro.class.equals(aClass);
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "indirizzo", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "capienza", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "responsabile", "required");

	}

}
