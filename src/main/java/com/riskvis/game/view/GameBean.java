package com.riskvis.game.view;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.riskvis.db.service.IInsurancesService;
import com.riskvis.db.service.IPlacesService;
import com.riskvis.db.service.IQuestsService;
import com.riskvis.entity.Insurances;
import com.riskvis.entity.Places;
import com.riskvis.entity.Quests;

/**
 * This bean is responsible to store application related data and methods,
 * reducing database operations by caching lists in it.
 * 
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@ApplicationScoped
@ManagedBean
public class GameBean {

	@ManagedProperty(value = "#{QuestsService}")
	IQuestsService questsService;

	@ManagedProperty(value = "#{PlacesService}")
	IPlacesService placesService;

	@ManagedProperty(value = "#{InsurancesService}")
	IInsurancesService insurancesService;

	private List<Quests> quests = new ArrayList<Quests>();
	private List<Places> places = new ArrayList<Places>();
	private List<Insurances> insurances = new ArrayList<Insurances>();

	public GameBean() {
		super();
	}

	@PostConstruct
	public void init() {
		quests = questsService.getQuestss();
		places = placesService.getPlacess();
		insurances = insurancesService.getInsurancess();
	}

	public void reloadGameData() {
		quests = questsService.getQuestss();
		places = placesService.getPlacess();
		insurances = insurancesService.getInsurancess();
	}

	public StreamedContent getStreamedInsuranceIcon() {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {
			String id = context.getExternalContext().getRequestParameterMap()
					.get("id");
			byte[] image = null;
			for (Insurances in : insurances) {
				if (in.getIdinsurances().toString().equals(id)) {
					image = in.getIcon();
					break;
				}
			}
			if (image != null) {
				return new DefaultStreamedContent(new ByteArrayInputStream(
						image));
			} else {
				return new DefaultStreamedContent(FacesContext
						.getCurrentInstance().getExternalContext()
						.getResourceAsStream("/static/img/default-image.png"));
			}
		}
	}

	public List<Quests> getQuests() {
		return quests;
	}

	public void setQuests(List<Quests> quests) {
		this.quests = quests;
	}

	public List<Places> getPlaces() {
		return places;
	}

	public void setPlaces(List<Places> places) {
		this.places = places;
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

	public IInsurancesService getInsurancesService() {
		return insurancesService;
	}

	public void setInsurancesService(IInsurancesService insurancesService) {
		this.insurancesService = insurancesService;
	}

	public List<Insurances> getInsurances() {
		return insurances;
	}

	public void setInsurances(List<Insurances> insurances) {
		this.insurances = insurances;
	}
}
