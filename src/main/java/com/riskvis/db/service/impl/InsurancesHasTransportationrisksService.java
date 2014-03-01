package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.IInsurancesHasTransportationrisksDAO;
import com.riskvis.db.service.IInsurancesHasTransportationrisksService;
import com.riskvis.entity.InsurancesHasTransportationrisks;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class InsurancesHasTransportationrisksService implements
		IInsurancesHasTransportationrisksService {

	IInsurancesHasTransportationrisksDAO insuranceHasTransportationrisksDAO;

	/**
	 * Add InsurancesHasTransportationrisks
	 *
	 * @param InsurancesHasTransportationrisks
	 *            insuranceHasTransportationrisks
	 */
	@Transactional(readOnly = false)
	@Override
	public void addInsurancesHasTransportationrisks(
			InsurancesHasTransportationrisks insuranceHasTransportationrisks) {
		getInsurancesHasTransportationrisksDAO()
				.addInsurancesHasTransportationrisks(
						insuranceHasTransportationrisks);
	}

	/**
	 * Delete InsurancesHasTransportationrisks
	 *
	 * @param InsurancesHasTransportationrisks
	 *            insuranceHasTransportationrisks
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteInsurancesHasTransportationrisks(
			InsurancesHasTransportationrisks insuranceHasTransportationrisks) {
		getInsurancesHasTransportationrisksDAO()
				.deleteInsurancesHasTransportationrisks(
						insuranceHasTransportationrisks);
	}

	/**
	 * Update InsurancesHasTransportationrisks
	 *
	 * @param InsurancesHasTransportationrisks
	 *            insuranceHasTransportationrisks
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateInsurancesHasTransportationrisks(
			InsurancesHasTransportationrisks insuranceHasTransportationrisks) {
		getInsurancesHasTransportationrisksDAO()
				.updateInsurancesHasTransportationrisks(
						insuranceHasTransportationrisks);
	}

	/**
	 * Get InsurancesHasTransportationrisks
	 *
	 * @param int InsurancesHasTransportationrisks Id
	 */
	@Override
	public InsurancesHasTransportationrisks getInsurancesHasTransportationrisksById(
			int id) {
		return getInsurancesHasTransportationrisksDAO()
				.getInsurancesHasTransportationrisksById(id);
	}

	/**
	 * Get InsurancesHasTransportationrisks
	 *
	 * @param int Id
	 */
	@Override
	public List<InsurancesHasTransportationrisks> getInsurancesHasTransportationrisksByInsurancesId(
			int id) {
		return getInsurancesHasTransportationrisksDAO()
				.getInsurancesHasTransportationrisksByInsurancesId(id);
	}

	/**
	 * Get InsurancesHasTransportationrisks List
	 *
	 */
	@Override
	public List<InsurancesHasTransportationrisks> getInsurancesHasTransportationriskss() {
		return getInsurancesHasTransportationrisksDAO()
				.getInsurancesHasTransportationriskss();
	}

	/**
	 * Get amount of insuranceHasTransportationrisks
	 *
	 */
	@Override
	public int getCount() {
		return getInsurancesHasTransportationrisksDAO().getCount();
	}

	/**
	 * Get InsurancesHasTransportationrisks DAO
	 *
	 * @return IInsurancesHasTransportationrisksDAO -
	 *         InsurancesHasTransportationrisks DAO
	 */
	public IInsurancesHasTransportationrisksDAO getInsurancesHasTransportationrisksDAO() {
		return insuranceHasTransportationrisksDAO;
	}

	/**
	 * Set InsurancesHasTransportationrisks DAO
	 *
	 * @param IInsurancesHasTransportationrisksDAO
	 *            - InsurancesHasTransportationrisks DAO
	 */
	public void setInsurancesHasTransportationrisksDAO(
			IInsurancesHasTransportationrisksDAO insuranceHasTransportationrisksDAO) {
		this.insuranceHasTransportationrisksDAO = insuranceHasTransportationrisksDAO;
	}

}
