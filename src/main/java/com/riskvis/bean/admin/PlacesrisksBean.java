package com.riskvis.bean.admin;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.riskvis.db.service.IPlacesService;
import com.riskvis.db.service.IPlacesrisksService;
import com.riskvis.entity.Places;
import com.riskvis.entity.Placesrisks;

/**
 * @author machadolucas@me.com
 * 
 */
@ManagedBean
@SessionScoped
public class PlacesrisksBean extends AbstractEntityBean<Placesrisks> {

	private static final long serialVersionUID = 3960687977045277086L;

	private static final String mainOutcome = "main?faces-redirect=true";
	private static final String editOutcome = "/admin/placesrisks/edit.jsf?faces-redirect=true";

	private List<Placesrisks> filteredList = new ArrayList<Placesrisks>();

	private List<Places> placesList = new ArrayList<Places>();

	@ManagedProperty(value = "#{PlacesrisksService}")
	IPlacesrisksService placesrisksService;

	@ManagedProperty(value = "#{PlacesService}")
	IPlacesService placesService;

	@Override
	void doInit() {
		this.list = placesrisksService.getPlacesriskss();
		filteredList = this.list;
		placesList = placesService.getPlacess();
	}

	@Override
	String doAdd() {
		this.bean = new Placesrisks();
		return NavigationOutcomeTypes.ADD;
	}

	@Override
	String doEdit() {
		return editOutcome;
	}

	@Override
	String doSave() {
		placesrisksService.addPlacesrisks(bean);
		reset();
		return mainOutcome;
	}

	@Override
	String doUpdate() {
		placesrisksService.updatePlacesrisks(bean);
		reset();
		return mainOutcome;
	}

	@Override
	void doDelete() {
		placesrisksService.deletePlacesrisks(bean);
		reset();
	}

	@Override
	public String cancel() {
		reset();
		return mainOutcome;
	}

	@Override
	public String loadMain() {
		reset();
		return mainOutcome;
	}

	@Override
	public void reset() {
		this.list = placesrisksService.getPlacesriskss();
		filteredList = this.list;
		placesList = placesService.getPlacess();
		this.bean = new Placesrisks();

	}

	/**
	 * @return the filteredList
	 */
	public List<Placesrisks> getFilteredList() {
		return filteredList;
	}

	/**
	 * @param filteredList
	 *            the filteredList to set
	 */
	public void setFilteredList(List<Placesrisks> filteredList) {
		this.filteredList = filteredList;
	}

	public IPlacesrisksService getPlacesrisksService() {
		return placesrisksService;
	}

	public void setPlacesrisksService(IPlacesrisksService placesrisksService) {
		this.placesrisksService = placesrisksService;
	}

	public IPlacesService getPlacesService() {
		return placesService;
	}

	public void setPlacesService(IPlacesService placesService) {
		this.placesService = placesService;
	}

	public List<Places> getPlacesList() {
		return placesList;
	}

	public void setPlacesList(List<Places> placesList) {
		this.placesList = placesList;
	}

}
