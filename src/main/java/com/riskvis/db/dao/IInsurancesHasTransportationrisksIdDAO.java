package com.riskvis.db.dao;

import java.util.List;

import com.riskvis.entity.InsurancesHasTransportationrisksId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface IInsurancesHasTransportationrisksIdDAO {

	/**
	 * Add InsurancesHasTransportationrisksId
	 *
	 * @param InsurancesHasTransportationrisksId
	 *            insurancesHasTransportationrisksId
	 */
	public void addInsurancesHasTransportationrisksId(
			InsurancesHasTransportationrisksId insurancesHasTransportationrisksId);

	/**
	 * Update InsurancesHasTransportationrisksId
	 *
	 * @param InsurancesHasTransportationrisksId
	 *            insurancesHasTransportationrisksId
	 */
	public void updateInsurancesHasTransportationrisksId(
			InsurancesHasTransportationrisksId insurancesHasTransportationrisksId);

	/**
	 * Delete InsurancesHasTransportationrisksId
	 *
	 * @param InsurancesHasTransportationrisksId
	 *            insurancesHasTransportationrisksId
	 */
	public void deleteInsurancesHasTransportationrisksId(
			InsurancesHasTransportationrisksId insurancesHasTransportationrisksId);

	/**
	 * Get InsurancesHasTransportationrisksId
	 *
	 * @param int InsurancesHasTransportationrisksId Id
	 */
	public InsurancesHasTransportationrisksId getInsurancesHasTransportationrisksIdById(
			int id);

	/**
	 * Get InsurancesHasTransportationrisksId List
	 *
	 */
	public List<InsurancesHasTransportationrisksId> getInsurancesHasTransportationrisksIds();

	/**
	 * Get amount of insurancesHasTransportationrisksId
	 *
	 */
	public int getCount();
}
