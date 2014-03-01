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
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DualListModel;
import org.primefaces.model.StreamedContent;

import com.riskvis.db.service.IPlacesHasTransportsService;
import com.riskvis.db.service.IPlacesService;
import com.riskvis.db.service.ITransportsService;
import com.riskvis.entity.Places;
import com.riskvis.entity.PlacesHasTransports;
import com.riskvis.entity.PlacesHasTransportsId;
import com.riskvis.entity.Transports;
import com.riskvis.util.MessageUtils;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@ManagedBean
@SessionScoped
public class PlacesBean extends AbstractEntityBean<Places> {

	private static final long serialVersionUID = 3960687977045277086L;

	private static final String mainOutcome = "main?faces-redirect=true";
	private static final String editOutcome = "/admin/places/edit.jsf?faces-redirect=true";

	@ManagedProperty(value = "#{PlacesService}")
	IPlacesService placesService;

	@ManagedProperty(value = "#{PlacesHasTransportsService}")
	IPlacesHasTransportsService placesHasTransportsService;

	@ManagedProperty(value = "#{TransportsService}")
	ITransportsService transportsService;

	private List<Places> filteredList = new ArrayList<Places>();
	private DualListModel<PlacesHasTransports> relationsDuallist = new DualListModel<PlacesHasTransports>();

	/**
	 * All the transports
	 */
	private List<Transports> transportsList;

	/**
	 * All the current PlacesHasTransports, if they previously exist
	 */
	private List<PlacesHasTransports> relationsList;

	/**
	 * Source for the relationsDualList. All the transports in
	 * PlacesHasTransports format
	 */
	private List<PlacesHasTransports> relationsSourceList = new ArrayList<PlacesHasTransports>();

	/**
	 * Bean for editing the selected transports properties
	 */
	private PlacesHasTransports relationBean;

	@Override
	void doInit() {
		this.list = placesService.getPlacess();
		filteredList = this.list;
		transportsList = transportsService.getTransportss();
	}

	private void startAddEdit() {
		relationBean = null;

		reloadRelationsSource();
		relationsDuallist.setSource(new ArrayList<PlacesHasTransports>(
				relationsSourceList));

		if (bean.getIdplaces() != null) {
			relationsList = placesHasTransportsService
					.getPlacesHasTransportsByPlaceId(bean.getIdplaces());
		} else {
			relationsList = null;
		}

		if (relationsList != null && relationsList.size() > 0) {
			relationsDuallist.setTarget(new ArrayList<PlacesHasTransports>(
					relationsList));
		} else {
			relationsDuallist.setTarget(new ArrayList<PlacesHasTransports>());
		}
	}

	/**
	 * Reload the source list of relationsDuallist
	 */
	private void reloadRelationsSource() {
		relationsSourceList = new ArrayList<PlacesHasTransports>();
		for (Transports t : transportsList) {
			PlacesHasTransports pht = new PlacesHasTransports();
			PlacesHasTransportsId id = new PlacesHasTransportsId();
			id.setTransportation(t.getIdtransports());
			pht.setId(id);
			pht.setTransports(t);
			relationsSourceList.add(pht);
		}
	}

	public void handleRelationsSelection(TransferEvent event) {
		if (event.isAdd()) {
			reloadRelationsSource();
			relationsDuallist.setSource(relationsSourceList);
			List addedRelations = event.getItems();
			for (Object item : addedRelations) {
				PlacesHasTransports pht = (PlacesHasTransports) item;
				pht.setRandomDifferenciator((int) (Math.random() * 1000000000));
			}
		}
		if (event.isRemove()) {
			reloadRelationsSource();
			relationsDuallist.setSource(relationsSourceList);
		}

	}

	/**
	 * Save the details of the PlacesHasTransports relation
	 */
	public void saveRelationDetails() {
		if (relationBean.getDestination() != null) {
			relationBean.getId().setPlacesDestination(
					relationBean.getDestination().getIdplaces());
		}
		if (relationBean.getTransports() != null) {
			relationBean.getId().setTransportation(
					relationBean.getTransports().getIdtransports());
		}
		for (int i = 0; i < relationsDuallist.getTarget().size(); i++) {
			if (relationsDuallist.getTarget().get(i).getRandomDifferenciator() == relationBean
					.getRandomDifferenciator()) {
				relationsDuallist.getTarget().set(i, relationBean);
				break;
			}
		}
	}

	@Override
	String doAdd() {
		this.bean = new Places();
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
		placesService.addPlaces(bean);
		saveRelations();
		reset();
		return mainOutcome;
	}

	@Override
	String doUpdate() {
		saveRelations();
		placesService.updatePlaces(bean);
		reset();
		return mainOutcome;
	}

	@Override
	void doDelete() {
		relationsList = placesHasTransportsService
				.getPlacesHasTransportsByPlaceId(bean.getIdplaces());
		if (relationsList != null && relationsList.size() > 0) {
			for (PlacesHasTransports relation : relationsList) {
				placesHasTransportsService.deletePlacesHasTransports(relation);
			}
		}
		placesService.deletePlaces(bean);
		reset();
	}

	/**
	 * Update the PlacesHasTransports data in the database.
	 */
	private void saveRelations() {
		if (relationsList != null && relationsList.size() > 0) {
			// TODO BUG here java.lang.NullPointerException
			for (PlacesHasTransports relation : relationsDuallist.getTarget()) {
				relation.setId(new PlacesHasTransportsId(bean.getIdplaces(),
						relation.getTransports().getIdtransports(), relation
								.getDestination().getIdplaces()));
			}
			for (PlacesHasTransports relation : relationsList) {
				if (!relationsDuallist.getTarget().contains(relation)) {
					placesHasTransportsService
							.deletePlacesHasTransports(relation);
				} else {
					PlacesHasTransportsId idTemp = new PlacesHasTransportsId();
					idTemp.setPlacesOrigin(bean.getIdplaces());
					idTemp.setTransportation(relation.getTransports()
							.getIdtransports());
					PlacesHasTransports temp = new PlacesHasTransports();
					temp.setId(idTemp);
					placesHasTransportsService.deletePlacesHasTransports(temp);

					PlacesHasTransports updated = relationsDuallist.getTarget()
							.get(relationsDuallist.getTarget()
									.indexOf(relation));
					placesHasTransportsService
							.updatePlacesHasTransports(updated);
				}
			}
			for (PlacesHasTransports relation : relationsDuallist.getTarget()) {
				if (!relationsList.contains(relation)) {
					placesHasTransportsService.addPlacesHasTransports(relation);
				}
			}

		} else {
			Places addedBean = placesService.getPlacesByNameAndLocation(bean);
			int newId = addedBean.getIdplaces();
			for (PlacesHasTransports relation : relationsDuallist.getTarget()) {
				int idTransport = relation.getTransports().getIdtransports();
				int idDestination = relation.getDestination().getIdplaces();
				PlacesHasTransportsId id = new PlacesHasTransportsId(newId,
						idTransport, idDestination);
				relation.setId(id);

				placesHasTransportsService.addPlacesHasTransports(relation);
			}
		}
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
		this.list = placesService.getPlacess();
		filteredList = this.list;
		transportsList = transportsService.getTransportss();
		this.bean = new Places();
	}

	public void handlePhotoUpload(FileUploadEvent event) {
		try {
			byte[] photo = IOUtils
					.toByteArray(event.getFile().getInputstream());
			bean.setPhoto(photo);
			MessageUtils.showInfoInGrowl(bundle.getString("info_title"),
					bundle.getString("photo_upload_success"));
		} catch (IOException e) {
			System.err.println("=== Error uploading photo file for Place");
			MessageUtils.showErrorInGrowl(bundle.getString("error_title"),
					bundle.getString("photo_upload_fail"));
			e.printStackTrace();
		}
	}

	public void removePhoto() {
		bean.setPhoto(null);
		MessageUtils.showInfoInGrowl(bundle.getString("info_title"),
				bundle.getString("photo_removal_success"));
	}

	public StreamedContent getStreamedPhoto() {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {
			if (bean.getPhoto() != null) {
				return new DefaultStreamedContent(new ByteArrayInputStream(
						bean.getPhoto()));
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
	public List<Places> getFilteredList() {
		return filteredList;
	}

	/**
	 * @param filteredList
	 *            the filteredList to set
	 */
	public void setFilteredList(List<Places> filteredList) {
		this.filteredList = filteredList;
	}

	public IPlacesService getPlacesService() {
		return placesService;
	}

	public void setPlacesService(IPlacesService placesService) {
		this.placesService = placesService;
	}

	public IPlacesHasTransportsService getPlacesHasTransportsService() {
		return placesHasTransportsService;
	}

	public void setPlacesHasTransportsService(
			IPlacesHasTransportsService placesHasTransportsService) {
		this.placesHasTransportsService = placesHasTransportsService;
	}

	public ITransportsService getTransportsService() {
		return transportsService;
	}

	public void setTransportsService(ITransportsService transportsService) {
		this.transportsService = transportsService;
	}

	public PlacesHasTransports getRelationBean() {
		return relationBean;
	}

	public void setRelationBean(PlacesHasTransports relationBean) {
		this.relationBean = relationBean;
	}

	public DualListModel<PlacesHasTransports> getRelationsDuallist() {
		return relationsDuallist;
	}

	public void setRelationsDuallist(
			DualListModel<PlacesHasTransports> relationsDuallist) {
		this.relationsDuallist = relationsDuallist;
	}

}
