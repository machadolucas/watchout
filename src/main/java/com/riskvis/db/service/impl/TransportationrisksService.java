package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.ITransportationrisksDAO;
import com.riskvis.db.service.ITransportationrisksService;
import com.riskvis.entity.Transportationrisks;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class TransportationrisksService implements ITransportationrisksService {

	ITransportationrisksDAO transportationrisksDAO;

	/**
	 * Add Transportationrisks
	 *
	 * @param Transportationrisks
	 *            transportationrisks
	 */
	@Transactional(readOnly = false)
	@Override
	public void addTransportationrisks(Transportationrisks transportationrisks) {
		getTransportationrisksDAO().addTransportationrisks(transportationrisks);
	}

	/**
	 * Delete Transportationrisks
	 *
	 * @param Transportationrisks
	 *            transportationrisks
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteTransportationrisks(
			Transportationrisks transportationrisks) {
		getTransportationrisksDAO().deleteTransportationrisks(
				transportationrisks);
	}

	/**
	 * Update Transportationrisks
	 *
	 * @param Transportationrisks
	 *            transportationrisks
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateTransportationrisks(
			Transportationrisks transportationrisks) {
		getTransportationrisksDAO().updateTransportationrisks(
				transportationrisks);
	}

	/**
	 * Get Transportationrisks
	 *
	 * @param int Transportationrisks Id
	 */
	@Override
	public Transportationrisks getTransportationrisksById(int id) {
		return getTransportationrisksDAO().getTransportationrisksById(id);
	}

	/**
	 * Get Transportationrisks List
	 *
	 */
	@Override
	public List<Transportationrisks> getTransportationriskss() {
		return getTransportationrisksDAO().getTransportationriskss();
	}

	/**
	 * Get amount of transportationrisks
	 *
	 */
	@Override
	public int getCount() {
		return getTransportationrisksDAO().getCount();
	}

	/**
	 * Get Transportationrisks DAO
	 *
	 * @return ITransportationrisksDAO - Transportationrisks DAO
	 */
	public ITransportationrisksDAO getTransportationrisksDAO() {
		return transportationrisksDAO;
	}

	/**
	 * Set Transportationrisks DAO
	 *
	 * @param ITransportationrisksDAO
	 *            - Transportationrisks DAO
	 */
	public void setTransportationrisksDAO(
			ITransportationrisksDAO transportationrisksDAO) {
		this.transportationrisksDAO = transportationrisksDAO;
	}

}
