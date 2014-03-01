package com.riskvis.db.dao;

import java.util.List;

import com.riskvis.entity.InsurancesHasPlacesrisksId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface IInsurancesHasPlacesrisksIdDAO {

	/**
	 * Add InsurancesHasPlacesrisksId
	 *
	 * @param InsurancesHasPlacesrisksId
	 *            insurancesHasPlacesrisksIdHasPlacesrisksId
	 */
	public void addInsurancesHasPlacesrisksId(
			InsurancesHasPlacesrisksId insurancesHasPlacesrisksIdHasPlacesrisksId);

	/**
	 * Update InsurancesHasPlacesrisksId
	 *
	 * @param InsurancesHasPlacesrisksId
	 *            insurancesHasPlacesrisksId
	 */
	public void updateInsurancesHasPlacesrisksId(
			InsurancesHasPlacesrisksId insurancesHasPlacesrisksId);

	/**
	 * Delete InsurancesHasPlacesrisksId
	 *
	 * @param InsurancesHasPlacesrisksId
	 *            insurancesHasPlacesrisksId
	 */
	public void deleteInsurancesHasPlacesrisksId(
			InsurancesHasPlacesrisksId insurancesHasPlacesrisksId);

	/**
	 * Get InsurancesHasPlacesrisksId
	 *
	 * @param int InsurancesHasPlacesrisksId Id
	 */
	public InsurancesHasPlacesrisksId getInsurancesHasPlacesrisksIdById(int id);

	/**
	 * Get InsurancesHasPlacesrisksId List
	 *
	 */
	public List<InsurancesHasPlacesrisksId> getInsurancesHasPlacesrisksIds();

	/**
	 * Get amount of insurancesHasPlacesrisksId
	 *
	 */
	public int getCount();
}
