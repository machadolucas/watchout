package com.riskvis.bean.admin;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.riskvis.db.service.ITransportationrisksService;
import com.riskvis.db.service.ITransportsService;
import com.riskvis.entity.Transportationrisks;
import com.riskvis.entity.Transports;

/**
 * @author machadolucas@me.com
 * 
 */
@ManagedBean
@SessionScoped
public class TransportationrisksBean extends
		AbstractEntityBean<Transportationrisks> {

	private static final long serialVersionUID = 3960687977045277086L;

	private static final String mainOutcome = "main?faces-redirect=true";
	private static final String editOutcome = "/admin/transportationrisks/edit.jsf?faces-redirect=true";

	private List<Transportationrisks> filteredList = new ArrayList<Transportationrisks>();

	private List<Transports> transportsList = new ArrayList<Transports>();

	@ManagedProperty(value = "#{TransportationrisksService}")
	ITransportationrisksService transportationrisksService;

	@ManagedProperty(value = "#{TransportsService}")
	ITransportsService transportsService;

	@Override
	void doInit() {
		this.list = transportationrisksService.getTransportationriskss();
		filteredList = this.list;
		transportsList = transportsService.getTransportss();
	}

	@Override
	String doAdd() {
		this.bean = new Transportationrisks();
		return NavigationOutcomeTypes.ADD;
	}

	@Override
	String doEdit() {
		return editOutcome;
	}

	@Override
	String doSave() {
		transportationrisksService.addTransportationrisks(bean);
		reset();
		return mainOutcome;
	}

	@Override
	String doUpdate() {
		transportationrisksService.updateTransportationrisks(bean);
		reset();
		return mainOutcome;
	}

	@Override
	void doDelete() {
		transportationrisksService.deleteTransportationrisks(bean);
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
		this.list = transportationrisksService.getTransportationriskss();
		filteredList = this.list;
		transportsList = transportsService.getTransportss();
		this.bean = new Transportationrisks();

	}

	/**
	 * @return the filteredList
	 */
	public List<Transportationrisks> getFilteredList() {
		return filteredList;
	}

	/**
	 * @param filteredList
	 *            the filteredList to set
	 */
	public void setFilteredList(List<Transportationrisks> filteredList) {
		this.filteredList = filteredList;
	}

	public ITransportationrisksService getTransportationrisksService() {
		return transportationrisksService;
	}

	public void setTransportationrisksService(
			ITransportationrisksService transportationrisksService) {
		this.transportationrisksService = transportationrisksService;
	}

	public ITransportsService getTransportsService() {
		return transportsService;
	}

	public void setTransportsService(ITransportsService transportsService) {
		this.transportsService = transportsService;
	}

	public List<Transports> getTransportsList() {
		return transportsList;
	}

	public void setTransportsList(List<Transports> transportsList) {
		this.transportsList = transportsList;
	}

}
