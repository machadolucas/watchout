package com.riskvis.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.riskvis.db.service.ITransportsService;
import com.riskvis.entity.Transports;

@Component
@Scope("request")
public class TransportsConverter implements Converter {

	@Autowired
	ITransportsService transportsService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		if (value == null) {
			return null;
		}

		Integer id = null;

		try {
			id = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new ConverterException(
					"Trying to getAsObject with a wrong id format.");
		}

		try {
			Transports result = transportsService.getTransportsById(id);
			return result;

		} catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		if (value instanceof Transports) {

			Transports result = (Transports) value;

			return String.valueOf(result.getIdtransports());
		}

		return null;
	}

	public ITransportsService getTransportsService() {
		return transportsService;
	}

	public void setTransportsService(ITransportsService transportsService) {
		this.transportsService = transportsService;
	}
}