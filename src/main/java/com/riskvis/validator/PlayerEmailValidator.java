package com.riskvis.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.riskvis.db.service.IPlayersService;
import com.riskvis.entity.Players;

@Component
@Scope("request")
public class PlayerEmailValidator implements Validator {

	@Autowired
	IPlayersService playersService;

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		if (value == null || ((String) value).trim().equals("")) {
			return; // Let required="true" handle.
		}

		String email = (String) value;
		Players result = playersService.getPlayersByEmail(email);
		if (result != null) {
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"E-mail already in use. Please choose another", null));
		}

	}

	public IPlayersService getPlayersService() {
		return playersService;
	}

	public void setPlayersService(IPlayersService playersService) {
		this.playersService = playersService;
	}

}
