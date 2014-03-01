package com.riskvis.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.riskvis.db.service.IPlacesService;
import com.riskvis.entity.Places;

@Component
@Scope("request")
public class PlacesConverter implements Converter {

	@Autowired
	IPlacesService placesService;

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
			Places result = placesService.getPlacesById(id);
			return result;

		} catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		if (value instanceof Places) {

			Places result = (Places) value;

			return String.valueOf(result.getIdplaces());
		}

		return null;
	}

	public IPlacesService getPlacesService() {
		return placesService;
	}

	public void setPlacesService(IPlacesService placesService) {
		this.placesService = placesService;
	}
}