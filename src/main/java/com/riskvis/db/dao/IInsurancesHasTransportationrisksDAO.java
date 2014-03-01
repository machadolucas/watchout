package com.riskvis.db.dao;

import java.util.List;

import com.riskvis.entity.InsurancesHasTransportationrisks;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface IInsurancesHasTransportationrisksDAO {

	/**
	 * Add InsurancesHasTransportationrisks
	 *
	 * @param InsurancesHasTransportationrisks
	 *            insurancesHasTransportationrisks
	 */
	public void addInsurancesHasTransportationrisks(
			InsurancesHasTransportationrisks insurancesHasTransportationrisks);

	/**
	 * Update InsurancesHasTransportationrisks
	 *
	 * @param InsurancesHasTransportationrisks
	 *            insurancesHasTransportationrisks
	 */
	public void updateInsurancesHasTransportationrisks(
			InsurancesHasTransportationrisks insurancesHasTransportationrisks);

	/**
	 * Delete InsurancesHasTransportationrisks
	 *
	 * @param InsurancesHasTransportationrisks
	 *            insurancesHasTransportationrisks
	 */
	public void deleteInsurancesHasTransportationrisks(
			InsurancesHasTransportationrisks insurancesHasTransportationrisks);

	/**
	 * Get InsurancesHasTransportationrisks
	 *
	 * @param int InsurancesHasTransportationrisks Id
	 */
	public InsurancesHasTransportationrisks getInsurancesHasTransportationrisksById(
			int id);

	/**
	 * Get InsurancesHasTransportationrisks
	 *
	 * @param int Id
	 */
	public List<InsurancesHasTransportationrisks> getInsurancesHasTransportationrisksByInsurancesId(
			int id);

	/**
	 * Get InsurancesHasTransportationrisks List
	 *
	 */
	public List<InsurancesHasTransportationrisks> getInsurancesHasTransportationriskss();

	/**
	 * Get amount of insurancesHasTransportationrisks
	 *
	 */
	public int getCount();
}
