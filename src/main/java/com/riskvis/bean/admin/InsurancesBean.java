package com.riskvis.bean.admin;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DualListModel;
import org.primefaces.model.StreamedContent;

import com.riskvis.db.service.IInsurancesHasPlacesrisksService;
import com.riskvis.db.service.IInsurancesHasTransportationrisksService;
import com.riskvis.db.service.IInsurancesService;
import com.riskvis.db.service.IPlacesrisksService;
import com.riskvis.db.service.ITransportationrisksService;
import com.riskvis.entity.Insurances;
import com.riskvis.entity.InsurancesHasPlacesrisks;
import com.riskvis.entity.InsurancesHasPlacesrisksId;
import com.riskvis.entity.InsurancesHasTransportationrisks;
import com.riskvis.entity.InsurancesHasTransportationrisksId;
import com.riskvis.entity.Placesrisks;
import com.riskvis.entity.Transportationrisks;
import com.riskvis.util.MessageUtils;

/**
 * @author machadolucas@me.com
 * 
 */
@ManagedBean
@SessionScoped
public class InsurancesBean extends AbstractEntityBean<Insurances> {

	private static final long serialVersionUID = 3960687977045277086L;

	private static final String mainOutcome = "main?faces-redirect=true";
	private static final String editOutcome = "/admin/insurances/edit.jsf?faces-redirect=true";

	private List<Insurances> filteredList = new ArrayList<Insurances>();

	@ManagedProperty(value = "#{InsurancesService}")
	IInsurancesService insurancesService;

	@ManagedProperty(value = "#{TransportationrisksService}")
	ITransportationrisksService transportationrisksService;

	@ManagedProperty(value = "#{PlacesrisksService}")
	IPlacesrisksService placesrisksService;

	@ManagedProperty(value = "#{InsurancesHasTransportationrisksService}")
	IInsurancesHasTransportationrisksService insurancesHasTransportationrisksService;

	@ManagedProperty(value = "#{InsurancesHasPlacesrisksService}")
	IInsurancesHasPlacesrisksService insurancesHasPlacesrisksService;

	private DualListModel<InsurancesHasTransportationrisks> transportationrisksDuallist = new DualListModel<InsurancesHasTransportationrisks>();
	private DualListModel<InsurancesHasPlacesrisks> placesrisksDuallist = new DualListModel<InsurancesHasPlacesrisks>();

	/**
	 * All the transportationrisks
	 */
	private List<Transportationrisks> transportationrisksList;
	/**
	 * All the placesrisks
	 */
	private List<Placesrisks> placesrisksList;

	/**
	 * All the transportationrisks in InsurancesHasTransportationrisks format
	 */
	private List<InsurancesHasTransportationrisks> ihTransportationrisksList;
	/**
	 * All the placesrisks in InsurancesHasPlacesrisks format
	 */
	private List<InsurancesHasPlacesrisks> ihPlacesrisksList;

	/**
	 * All the current InsurancesHasTransportationrisks, if they previously
	 * exist
	 */
	private List<InsurancesHasTransportationrisks> trisksRelationsList;
	/**
	 * All the current InsurancesHasPlacesrisks, if they previously exist
	 */
	private List<InsurancesHasPlacesrisks> prisksRelationsList;

	private InsurancesHasTransportationrisks triskBean;
	private InsurancesHasPlacesrisks priskBean;

	@Override
	void doInit() {
		this.list = insurancesService.getInsurancess();
		filteredList = this.list;
	}

	private void startAddEdit() {
		transportationrisksList = transportationrisksService
				.getTransportationriskss();
		placesrisksList = placesrisksService.getPlacesriskss();

		triskBean = null;
		priskBean = null;

		// Load duallists sources with risks
		reloadRelationsSources();
		transportationrisksDuallist
				.setSource(new ArrayList<InsurancesHasTransportationrisks>(
						ihTransportationrisksList));
		placesrisksDuallist.setSource(new ArrayList<InsurancesHasPlacesrisks>(
				ihPlacesrisksList));

		if (bean.getIdinsurances() != null) {
			// If Insurances already exists, load relations from database
			trisksRelationsList = insurancesHasTransportationrisksService
					.getInsurancesHasTransportationrisksByInsurancesId(bean
							.getIdinsurances());
			prisksRelationsList = insurancesHasPlacesrisksService
					.getInsurancesHasPlacesrisksByInsurancesId(bean
							.getIdinsurances());
		} else {
			trisksRelationsList = null;
			prisksRelationsList = null;
		}

		if (trisksRelationsList != null && trisksRelationsList.size() > 0) {
			// If there are existing InsurancesHasTransportationrisks, set to
			// duallist target and remove from source
			transportationrisksDuallist
					.setTarget(new ArrayList<InsurancesHasTransportationrisks>(
							trisksRelationsList));
			for (InsurancesHasTransportationrisks ihtr : trisksRelationsList) {
				transportationrisksDuallist.getSource().remove(ihtr);
			}
		} else {
			transportationrisksDuallist
					.setTarget(new ArrayList<InsurancesHasTransportationrisks>());
		}

		if (prisksRelationsList != null && prisksRelationsList.size() > 0) {
			// If there are existing InsurancesHasPlacesrisks, set to duallist
			// target and remove from source
			placesrisksDuallist
					.setTarget(new ArrayList<InsurancesHasPlacesrisks>(
							prisksRelationsList));
			for (InsurancesHasPlacesrisks ihpr : prisksRelationsList) {
				placesrisksDuallist.getSource().remove(ihpr);
			}
		} else {
			placesrisksDuallist
					.setTarget(new ArrayList<InsurancesHasPlacesrisks>());
		}

	}

	@Override
	String doAdd() {
		this.bean = new Insurances();
		startAddEdit();
		return NavigationOutcomeTypes.ADD;
	}

	@Override
	String doEdit() {
		startAddEdit();
		return editOutcome;
	}

	@Override
	String doSave() {
		insurancesService.addInsurances(bean);
		saveRelations();
		reset();
		return mainOutcome;
	}

	@Override
	String doUpdate() {
		saveRelations();
		insurancesService.updateInsurances(bean);
		reset();
		return mainOutcome;
	}

	/**
	 * Update the InsurancesHasTransportationrisks and InsurancesHasPlacesrisks
	 * data in the database. Should be called before saving or updating the
	 * Insurances bean
	 */
	private void saveRelations() {

		// === Transportationrisks management

		if (trisksRelationsList != null && trisksRelationsList.size() > 0) {
			// If there is already existing relations
			for (InsurancesHasTransportationrisks relation : transportationrisksDuallist
					.getTarget()) {
				// Set Ids
				relation.setId(new InsurancesHasTransportationrisksId(bean
						.getIdinsurances(), relation.getTransportationrisks()
						.getIdrisks()));
			}
			for (InsurancesHasTransportationrisks relation : trisksRelationsList) {
				if (!transportationrisksDuallist.getTarget().contains(relation)) {
					// If item is removed in comparison with original list,
					// delete
					insurancesHasTransportationrisksService
							.deleteInsurancesHasTransportationrisks(relation);
				} else {
					// If item still exists in comparison with original list,
					// update
					InsurancesHasTransportationrisks updated = transportationrisksDuallist
							.getTarget().get(
									transportationrisksDuallist.getTarget()
											.indexOf(relation));
					if (!updated.getCover().equals(relation.getCover())) {
						insurancesHasTransportationrisksService
								.updateInsurancesHasTransportationrisks(updated);
					}
				}
			}
			for (InsurancesHasTransportationrisks relation : transportationrisksDuallist
					.getTarget()) {
				// If item is new in comparison with original list, add
				if (!trisksRelationsList.contains(relation)) {
					insurancesHasTransportationrisksService
							.addInsurancesHasTransportationrisks(relation);
				}
			}

		} else {
			// If there is not existing relations, then just add all
			Insurances addedBean = insurancesService
					.getInsurancesByNameAndCost(bean);
			int newId = addedBean.getIdinsurances();
			for (InsurancesHasTransportationrisks relation : transportationrisksDuallist
					.getTarget()) {
				relation.setId(new InsurancesHasTransportationrisksId(newId,
						relation.getTransportationrisks().getIdrisks()));
				insurancesHasTransportationrisksService
						.addInsurancesHasTransportationrisks(relation);
			}
		}

		// === Placesrisks management

		if (prisksRelationsList != null && prisksRelationsList.size() > 0) {
			// If there is already existing relations
			for (InsurancesHasPlacesrisks relation : placesrisksDuallist
			// Set Ids
					.getTarget()) {
				relation.setId(new InsurancesHasPlacesrisksId(bean
						.getIdinsurances(), relation.getPlacesrisks()
						.getIdrisks()));
			}
			for (InsurancesHasPlacesrisks relation : prisksRelationsList) {
				if (!placesrisksDuallist.getTarget().contains(relation)) {
					// If item is removed in comparison with original list,
					// delete
					insurancesHasPlacesrisksService
							.deleteInsurancesHasPlacesrisks(relation);
				} else {
					// If item still exists in comparison with original list,
					// update
					InsurancesHasPlacesrisks updated = placesrisksDuallist
							.getTarget().get(
									placesrisksDuallist.getTarget().indexOf(
											relation));
					if (!updated.getCover().equals(relation.getCover())) {
						insurancesHasPlacesrisksService
								.updateInsurancesHasPlacesrisks(updated);
					}
				}
			}
			for (InsurancesHasPlacesrisks relation : placesrisksDuallist
					.getTarget()) {
				// If item is new in comparison with original list, add
				if (!prisksRelationsList.contains(relation)) {
					insurancesHasPlacesrisksService
							.addInsurancesHasPlacesrisks(relation);
				}
			}

		} else {
			// If there is not existing relations, then just add all
			Insurances addedBean = insurancesService
					.getInsurancesByNameAndCost(bean);
			int newId = addedBean.getIdinsurances();
			for (InsurancesHasPlacesrisks relation : placesrisksDuallist
					.getTarget()) {
				relation.setId(new InsurancesHasPlacesrisksId(newId, relation
						.getPlacesrisks().getIdrisks()));
				insurancesHasPlacesrisksService
						.addInsurancesHasPlacesrisks(relation);
			}
		}
	}

	@Override
	void doDelete() {
		// Delete all relations first
		trisksRelationsList = insurancesHasTransportationrisksService
				.getInsurancesHasTransportationrisksByInsurancesId(bean
						.getIdinsurances());
		prisksRelationsList = insurancesHasPlacesrisksService
				.getInsurancesHasPlacesrisksByInsurancesId(bean
						.getIdinsurances());
		if (trisksRelationsList != null && trisksRelationsList.size() > 0) {
			for (InsurancesHasTransportationrisks relation : trisksRelationsList) {
				insurancesHasTransportationrisksService
						.deleteInsurancesHasTransportationrisks(relation);
			}
		}
		if (prisksRelationsList != null && prisksRelationsList.size() > 0) {
			for (InsurancesHasPlacesrisks relation : prisksRelationsList) {
				insurancesHasPlacesrisksService
						.deleteInsurancesHasPlacesrisks(relation);
			}
		}
		insurancesService.deleteInsurances(bean);
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
		this.list = insurancesService.getInsurancess();
		filteredList = this.list;
		this.bean = new Insurances();
		transportationrisksList = transportationrisksService
				.getTransportationriskss();
		placesrisksList = placesrisksService.getPlacesriskss();
	}

	/**
	 * Reload the source lists of duallists
	 */
	private void reloadRelationsSources() {
		ihTransportationrisksList = new ArrayList<InsurancesHasTransportationrisks>();
		for (Transportationrisks tr : transportationrisksList) {
			InsurancesHasTransportationrisks ihtr = new InsurancesHasTransportationrisks();
			InsurancesHasTransportationrisksId id = new InsurancesHasTransportationrisksId();
			id.setRisksIdrisks(tr.getIdrisks());
			if (bean.getIdinsurances() != null) {
				id.setInsurancesIdinsurances(bean.getIdinsurances());
			}
			ihtr.setId(id);
			ihtr.setTransportationrisks(tr);
			ihTransportationrisksList.add(ihtr);
		}
		ihPlacesrisksList = new ArrayList<InsurancesHasPlacesrisks>();
		for (Placesrisks pr : placesrisksList) {
			InsurancesHasPlacesrisks ihpr = new InsurancesHasPlacesrisks();
			InsurancesHasPlacesrisksId id = new InsurancesHasPlacesrisksId();
			id.setPlacesrisksIdrisks(pr.getIdrisks());
			if (bean.getIdinsurances() != null) {
				id.setInsurancesIdinsurances(bean.getIdinsurances());
			}
			ihpr.setId(id);
			ihpr.setPlacesrisks(pr);
			ihPlacesrisksList.add(ihpr);
		}
	}

	/**
	 * Save the details of the InsurancesHasTransportationrisks relation
	 */
	public void saveTRelationDetails() {
		for (int i = 0; i < transportationrisksDuallist.getTarget().size(); i++) {
			if (transportationrisksDuallist.getTarget().get(i)
					.equals(triskBean)) {
				transportationrisksDuallist.getTarget().set(i, triskBean);
				break;
			}
		}
	}

	/**
	 * Save the details of the InsurancesHasTransportationrisks relation
	 */
	public void savePRelationDetails() {
		for (int i = 0; i < placesrisksDuallist.getTarget().size(); i++) {
			if (placesrisksDuallist.getTarget().get(i).equals(priskBean)) {
				placesrisksDuallist.getTarget().set(i, priskBean);
				break;
			}
		}
	}

	public void handleIconUpload(FileUploadEvent event) {
		try {
			byte[] photo = IOUtils
					.toByteArray(event.getFile().getInputstream());
			bean.setIcon(photo);
			MessageUtils.showInfoInGrowl(bundle.getString("info_title"),
					bundle.getString("photo_upload_success"));
		} catch (IOException e) {
			System.err.println("=== Error uploading photo file for Place");
			MessageUtils.showErrorInGrowl(bundle.getString("error_title"),
					bundle.getString("photo_upload_fail"));
			e.printStackTrace();
		}
	}

	public void removeIcon() {
		bean.setIcon(null);
		MessageUtils.showInfoInGrowl(bundle.getString("info_title"),
				bundle.getString("photo_removal_success"));
	}

	public StreamedContent getStreamedIcon() {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {
			if (bean.getIcon() != null) {
				return new DefaultStreamedContent(new ByteArrayInputStream(
						bean.getIcon()));
			} else {
				return new DefaultStreamedContent(FacesContext
						.getCurrentInstance().getExternalContext()
						.getResourceAsStream("/static/img/default-image.png"));
			}
		}
	}

	/**
	 * @return the filteredList
	 */
	public List<Insurances> getFilteredList() {
		return filteredList;
	}

	/**
	 * @param filteredList
	 *            the filteredList to set
	 */
	public void setFilteredList(List<Insurances> filteredList) {
		this.filteredList = filteredList;
	}

	public IInsurancesService getInsurancesService() {
		return insurancesService;
	}

	public void setInsurancesService(IInsurancesService insurancesService) {
		this.insurancesService = insurancesService;
	}

	public DualListModel<InsurancesHasTransportationrisks> getTransportationrisksDuallist() {
		return transportationrisksDuallist;
	}

	public void setTransportationrisksDuallist(
			DualListModel<InsurancesHasTransportationrisks> transportationrisksDuallist) {
		this.transportationrisksDuallist = transportationrisksDuallist;
	}

	public DualListModel<InsurancesHasPlacesrisks> getPlacesrisksDuallist() {
		return placesrisksDuallist;
	}

	public void setPlacesrisksDuallist(
			DualListModel<InsurancesHasPlacesrisks> placesrisksDuallist) {
		this.placesrisksDuallist = placesrisksDuallist;
	}

	public ITransportationrisksService getTransportationrisksService() {
		return transportationrisksService;
	}

	public void setTransportationrisksService(
			ITransportationrisksService transportationrisksService) {
		this.transportationrisksService = transportationrisksService;
	}

	public IPlacesrisksService getPlacesrisksService() {
		return placesrisksService;
	}

	public void setPlacesrisksService(IPlacesrisksService placesrisksService) {
		this.placesrisksService = placesrisksService;
	}

	public IInsurancesHasTransportationrisksService getInsurancesHasTransportationrisksService() {
		return insurancesHasTransportationrisksService;
	}

	public void setInsurancesHasTransportationrisksService(
			IInsurancesHasTransportationrisksService insurancesHasTransportationrisksService) {
		this.insurancesHasTransportationrisksService = insurancesHasTransportationrisksService;
	}

	public IInsurancesHasPlacesrisksService getInsurancesHasPlacesrisksService() {
		return insurancesHasPlacesrisksService;
	}

	public void setInsurancesHasPlacesrisksService(
			IInsurancesHasPlacesrisksService insurancesHasPlacesrisksService) {
		this.insurancesHasPlacesrisksService = insurancesHasPlacesrisksService;
	}

	public InsurancesHasTransportationrisks getTriskBean() {
		return triskBean;
	}

	public void setTriskBean(InsurancesHasTransportationrisks triskBean) {
		this.triskBean = triskBean;
	}

	public InsurancesHasPlacesrisks getPriskBean() {
		return priskBean;
	}

	public void setPriskBean(InsurancesHasPlacesrisks priskBean) {
		this.priskBean = priskBean;
	}

}
