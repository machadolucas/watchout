package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.IInsurancesHasPlacesrisksIdDAO;
import com.riskvis.db.service.IInsurancesHasPlacesrisksIdService;
import com.riskvis.entity.InsurancesHasPlacesrisksId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class InsurancesHasPlacesrisksIdService implements
		IInsurancesHasPlacesrisksIdService {

	IInsurancesHasPlacesrisksIdDAO insurancesHasPlacesrisksIdDAO;

	/**
	 * Add InsurancesHasPlacesrisksId
	 *
	 * @param InsurancesHasPlacesrisksId
	 *            insurancesHasPlacesrisksId
	 */
	@Transactional(readOnly = false)
	@Override
	public void addInsurancesHasPlacesrisksId(
			InsurancesHasPlacesrisksId insurancesHasPlacesrisksId) {
		getInsurancesHasPlacesrisksIdDAO().addInsurancesHasPlacesrisksId(
				insurancesHasPlacesrisksId);
	}

	/**
	 * Delete InsurancesHasPlacesrisksId
	 *
	 * @param InsurancesHasPlacesrisksId
	 *            insurancesHasPlacesrisksId
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteInsurancesHasPlacesrisksId(
			InsurancesHasPlacesrisksId insurancesHasPlacesrisksId) {
		getInsurancesHasPlacesrisksIdDAO().deleteInsurancesHasPlacesrisksId(
				insurancesHasPlacesrisksId);
	}

	/**
	 * Update InsurancesHasPlacesrisksId
	 *
	 * @param InsurancesHasPlacesrisksId
	 *            insurancesHasPlacesrisksId
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateInsurancesHasPlacesrisksId(
			InsurancesHasPlacesrisksId insurancesHasPlacesrisksId) {
		getInsurancesHasPlacesrisksIdDAO().updateInsurancesHasPlacesrisksId(
				insurancesHasPlacesrisksId);
	}

	/**
	 * Get InsurancesHasPlacesrisksId
	 *
	 * @param int InsurancesHasPlacesrisksId Id
	 */
	@Override
	public InsurancesHasPlacesrisksId getInsurancesHasPlacesrisksIdById(int id) {
		return getInsurancesHasPlacesrisksIdDAO()
				.getInsurancesHasPlacesrisksIdById(id);
	}

	/**
	 * Get InsurancesHasPlacesrisksId List
	 *
	 */
	@Override
	public List<InsurancesHasPlacesrisksId> getInsurancesHasPlacesrisksIds() {
		return getInsurancesHasPlacesrisksIdDAO()
				.getInsurancesHasPlacesrisksIds();
	}

	/**
	 * Get amount of insurancesHasPlacesrisksId
	 *
	 */
	@Override
	public int getCount() {
		return getInsurancesHasPlacesrisksIdDAO().getCount();
	}

	/**
	 * Get InsurancesHasPlacesrisksId DAO
	 *
	 * @return IInsurancesHasPlacesrisksIdDAO - InsurancesHasPlacesrisksId DAO
	 */
	public IInsurancesHasPlacesrisksIdDAO getInsurancesHasPlacesrisksIdDAO() {
		return insurancesHasPlacesrisksIdDAO;
	}

	/**
	 * Set InsurancesHasPlacesrisksId DAO
	 *
	 * @param IInsurancesHasPlacesrisksIdDAO
	 *            - InsurancesHasPlacesrisksId DAO
	 */
	public void setInsurancesHasPlacesrisksIdDAO(
			IInsurancesHasPlacesrisksIdDAO insurancesHasPlacesrisksIdDAO) {
		this.insurancesHasPlacesrisksIdDAO = insurancesHasPlacesrisksIdDAO;
	}

}
