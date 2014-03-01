package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.IInsurancesHasTransportationrisksIdDAO;
import com.riskvis.db.service.IInsurancesHasTransportationrisksIdService;
import com.riskvis.entity.InsurancesHasTransportationrisksId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class InsurancesHasTransportationrisksIdService implements
		IInsurancesHasTransportationrisksIdService {

	IInsurancesHasTransportationrisksIdDAO insurancesHasTransportationrisksIdDAO;

	/**
	 * Add InsurancesHasTransportationrisksId
	 *
	 * @param InsurancesHasTransportationrisksId
	 *            insurancesHasTransportationrisksId
	 */
	@Transactional(readOnly = false)
	@Override
	public void addInsurancesHasTransportationrisksId(
			InsurancesHasTransportationrisksId insurancesHasTransportationrisksId) {
		getInsurancesHasTransportationrisksIdDAO()
				.addInsurancesHasTransportationrisksId(
						insurancesHasTransportationrisksId);
	}

	/**
	 * Delete InsurancesHasTransportationrisksId
	 *
	 * @param InsurancesHasTransportationrisksId
	 *            insurancesHasTransportationrisksId
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteInsurancesHasTransportationrisksId(
			InsurancesHasTransportationrisksId insurancesHasTransportationrisksId) {
		getInsurancesHasTransportationrisksIdDAO()
				.deleteInsurancesHasTransportationrisksId(
						insurancesHasTransportationrisksId);
	}

	/**
	 * Update InsurancesHasTransportationrisksId
	 *
	 * @param InsurancesHasTransportationrisksId
	 *            insurancesHasTransportationrisksId
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateInsurancesHasTransportationrisksId(
			InsurancesHasTransportationrisksId insurancesHasTransportationrisksId) {
		getInsurancesHasTransportationrisksIdDAO()
				.updateInsurancesHasTransportationrisksId(
						insurancesHasTransportationrisksId);
	}

	/**
	 * Get InsurancesHasTransportationrisksId
	 *
	 * @param int InsurancesHasTransportationrisksId Id
	 */
	@Override
	public InsurancesHasTransportationrisksId getInsurancesHasTransportationrisksIdById(
			int id) {
		return getInsurancesHasTransportationrisksIdDAO()
				.getInsurancesHasTransportationrisksIdById(id);
	}

	/**
	 * Get InsurancesHasTransportationrisksId List
	 *
	 */
	@Override
	public List<InsurancesHasTransportationrisksId> getInsurancesHasTransportationrisksIds() {
		return getInsurancesHasTransportationrisksIdDAO()
				.getInsurancesHasTransportationrisksIds();
	}

	/**
	 * Get amount of insurancesHasTransportationrisksId
	 *
	 */
	@Override
	public int getCount() {
		return getInsurancesHasTransportationrisksIdDAO().getCount();
	}

	/**
	 * Get InsurancesHasTransportationrisksId DAO
	 *
	 * @return IInsurancesHasTransportationrisksIdDAO -
	 *         InsurancesHasTransportationrisksId DAO
	 */
	public IInsurancesHasTransportationrisksIdDAO getInsurancesHasTransportationrisksIdDAO() {
		return insurancesHasTransportationrisksIdDAO;
	}

	/**
	 * Set InsurancesHasTransportationrisksId DAO
	 *
	 * @param IInsurancesHasTransportationrisksIdDAO
	 *            - InsurancesHasTransportationrisksId DAO
	 */
	public void setInsurancesHasTransportationrisksIdDAO(
			IInsurancesHasTransportationrisksIdDAO insurancesHasTransportationrisksIdDAO) {
		this.insurancesHasTransportationrisksIdDAO = insurancesHasTransportationrisksIdDAO;
	}

}
