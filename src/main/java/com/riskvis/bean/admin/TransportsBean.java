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
import org.primefaces.model.StreamedContent;

import com.riskvis.db.service.ITransportsService;
import com.riskvis.entity.Transports;
import com.riskvis.util.MessageUtils;

/**
 * @author machadolucas@me.com
 * 
 */
@ManagedBean
@SessionScoped
public class TransportsBean extends AbstractEntityBean<Transports> {

	private static final long serialVersionUID = 3960687977045277086L;

	private static final String mainOutcome = "main?faces-redirect=true";
	private static final String editOutcome = "/admin/transports/edit.jsf?faces-redirect=true";

	private List<Transports> filteredList = new ArrayList<Transports>();

	@ManagedProperty(value = "#{TransportsService}")
	ITransportsService transportsService;

	@Override
	void doInit() {
		this.list = transportsService.getTransportss();
		filteredList = this.list;
	}

	public void handleIconUpload(FileUploadEvent event) {
		try {
			byte[] icon = IOUtils.toByteArray(event.getFile().getInputstream());
			bean.setIcon(icon);
			MessageUtils.showInfoInGrowl(bundle.getString("info_title"),
					bundle.getString("icon_upload_success"));
		} catch (IOException e) {
			System.err.println("=== Error uploading icon file for transport");
			MessageUtils.showErrorInGrowl(bundle.getString("error_title"),
					bundle.getString("icon_upload_fail"));
			e.printStackTrace();
		}
	}

	public void removeIcon() {
		bean.setIcon(null);
		MessageUtils.showInfoInGrowl(bundle.getString("info_title"),
				bundle.getString("icon_removal_success"));
	}

	@Override
	String doAdd() {
		this.bean = new Transports();
		return NavigationOutcomeTypes.ADD;
	}

	@Override
	String doEdit() {
		return editOutcome;
	}

	@Override
	String doSave() {
		transportsService.addTransports(bean);
		reset();
		return mainOutcome;
	}

	@Override
	String doUpdate() {
		transportsService.updateTransports(bean);
		reset();
		return mainOutcome;
	}

	@Override
	void doDelete() {
		transportsService.deleteTransports(bean);
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
		this.list = transportsService.getTransportss();
		filteredList = this.list;
		this.bean = new Transports();

	}

	/**
	 * @return the filteredList
	 */
	public List<Transports> getFilteredList() {
		return filteredList;
	}

	/**
	 * @param filteredList
	 *            the filteredList to set
	 */
	public void setFilteredList(List<Transports> filteredList) {
		this.filteredList = filteredList;
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

	public ITransportsService getTransportsService() {
		return transportsService;
	}

	public void setTransportsService(ITransportsService transportsService) {
		this.transportsService = transportsService;
	}

}
