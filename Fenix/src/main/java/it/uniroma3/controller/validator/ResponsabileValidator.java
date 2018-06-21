package it.uniroma3.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.model.Responsabile;

@Component
public class ResponsabileValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> aClass) {
		
		return Responsabile.class.equals(aClass);
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cf", "required");

	}

}
