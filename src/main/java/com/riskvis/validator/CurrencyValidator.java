package com.riskvis.validator;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class CurrencyValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		if (value == null
				|| ((BigDecimal) value).toPlainString().trim().equals("")) {
			return; // Let required="true" handle.
		}

		BigDecimal bd = (BigDecimal) value;
		if (bd.signum() <= 0 || bd.scale() > 2 || bd.intValue() > 99999999) {
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Value is not valid as currency format", null));
		}

	}

}
