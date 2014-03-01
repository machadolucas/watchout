package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.IInsurancesHasPlacesrisksDAO;
import com.riskvis.db.service.IInsurancesHasPlacesrisksService;
import com.riskvis.entity.InsurancesHasPlacesrisks;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class InsurancesHasPlacesrisksService implements
		IInsurancesHasPlacesrisksService {

	IInsurancesHasPlacesrisksDAO insuranceHasPlacesrisksDAO;

	/**
	 * Add InsurancesHasPlacesrisks
	 *
	 * @param InsurancesHasPlacesrisks
	 *            insuranceHasPlacesrisks
	 */
	@Transactional(readOnly = false)
	@Override
	public void addInsurancesHasPlacesrisks(
			InsurancesHasPlacesrisks insuranceHasPlacesrisks) {
		getInsurancesHasPlacesrisksDAO().addInsurancesHasPlacesrisks(
				insuranceHasPlacesrisks);
	}

	/**
	 * Delete InsurancesHasPlacesrisks
	 *
	 * @param InsurancesHasPlacesrisks
	 *            insuranceHasPlacesrisks
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteInsurancesHasPlacesrisks(
			InsurancesHasPlacesrisks insuranceHasPlacesrisks) {
		getInsurancesHasPlacesrisksDAO().deleteInsurancesHasPlacesrisks(
				insuranceHasPlacesrisks);
	}

	/**
	 * Update InsurancesHasPlacesrisks
	 *
	 * @param InsurancesHasPlacesrisks
	 *            insuranceHasPlacesrisks
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateInsurancesHasPlacesrisks(
			InsurancesHasPlacesrisks insuranceHasPlacesrisks) {
		getInsurancesHasPlacesrisksDAO().updateInsurancesHasPlacesrisks(
				insuranceHasPlacesrisks);
	}

	/**
	 * Get InsurancesHasPlacesrisks
	 *
	 * @param int InsurancesHasPlacesrisks Id
	 */
	@Override
	public InsurancesHasPlacesrisks getInsurancesHasPlacesrisksById(int id) {
		return getInsurancesHasPlacesrisksDAO()
				.getInsurancesHasPlacesrisksById(id);
	}

	/**
	 * Get InsurancesHasPlacesrisks
	 *
	 * @param int Id
	 */
	@Override
	public List<InsurancesHasPlacesrisks> getInsurancesHasPlacesrisksByInsurancesId(
			int id) {
		return getInsurancesHasPlacesrisksDAO()
				.getInsurancesHasPlacesrisksByInsurancesId(id);
	}

	/**
	 * Get InsurancesHasPlacesrisks List
	 *
	 */
	@Override
	public List<InsurancesHasPlacesrisks> getInsurancesHasPlacesriskss() {
		return getInsurancesHasPlacesrisksDAO().getInsurancesHasPlacesriskss();
	}

	/**
	 * Get amount of insuranceHasPlacesrisks
	 *
	 */
	@Override
	public int getCount() {
		return getInsurancesHasPlacesrisksDAO().getCount();
	}

	/**
	 * Get InsurancesHasPlacesrisks DAO
	 *
	 * @return IInsurancesHasPlacesrisksDAO - InsurancesHasPlacesrisks DAO
	 */
	public IInsurancesHasPlacesrisksDAO getInsurancesHasPlacesrisksDAO() {
		return insuranceHasPlacesrisksDAO;
	}

	/**
	 * Set InsurancesHasPlacesrisks DAO
	 *
	 * @param IInsurancesHasPlacesrisksDAO
	 *            - InsurancesHasPlacesrisks DAO
	 */
	public void setInsurancesHasPlacesrisksDAO(
			IInsurancesHasPlacesrisksDAO insuranceHasPlacesrisksDAO) {
		this.insuranceHasPlacesrisksDAO = insuranceHasPlacesrisksDAO;
	}

}
