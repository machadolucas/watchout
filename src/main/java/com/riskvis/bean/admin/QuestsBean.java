package com.riskvis.bean.admin;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.riskvis.db.service.IPlacesService;
import com.riskvis.db.service.IQuestsService;
import com.riskvis.entity.Places;
import com.riskvis.entity.Quests;

/**
 * @author machadolucas@me.com
 * 
 */
@ManagedBean
@SessionScoped
public class QuestsBean extends AbstractEntityBean<Quests> {

	private static final long serialVersionUID = 3960687977045277086L;

	private static final String mainOutcome = "main?faces-redirect=true";
	private static final String editOutcome = "/admin/quests/edit.jsf?faces-redirect=true";

	private List<Quests> filteredList = new ArrayList<Quests>();

	private List<Places> destinationsList = new ArrayList<Places>();

	@ManagedProperty(value = "#{QuestsService}")
	IQuestsService questsService;

	@ManagedProperty(value = "#{PlacesService}")
	IPlacesService placesService;

	@Override
	void doInit() {
		this.list = questsService.getQuestss();
		filteredList = this.list;
		destinationsList = placesService.getPlacess();
	}

	@Override
	String doAdd() {
		this.bean = new Quests();
		return NavigationOutcomeTypes.ADD;
	}

	@Override
	String doEdit() {
		return editOutcome;
	}

	@Override
	String doSave() {
		questsService.addQuests(bean);
		reset();
		return mainOutcome;
	}

	@Override
	String doUpdate() {
		questsService.updateQuests(bean);
		reset();
		return mainOutcome;
	}

	@Override
	void doDelete() {
		questsService.deleteQuests(bean);
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
		this.list = questsService.getQuestss();
		filteredList = this.list;
		destinationsList = placesService.getPlacess();
		this.bean = new Quests();

	}

	/**
	 * @return the filteredList
	 */
	public List<Quests> getFilteredList() {
		return filteredList;
	}

	/**
	 * @param filteredList
	 *            the filteredList to set
	 */
	public void setFilteredList(List<Quests> filteredList) {
		this.filteredList = filteredList;
	}

	public List<Places> getDestinationsList() {
		return destinationsList;
	}

	public void setDestinationsList(List<Places> destinationsList) {
		this.destinationsList = destinationsList;
	}

	public IQuestsService getQuestsService() {
		return questsService;
	}

	public void setQuestsService(IQuestsService questsService) {
		this.questsService = questsService;
	}

	public IPlacesService getPlacesService() {
		return placesService;
	}

	public void setPlacesService(IPlacesService placesService) {
		this.placesService = placesService;
	}

}
