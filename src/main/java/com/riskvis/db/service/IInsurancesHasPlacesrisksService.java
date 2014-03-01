package com.riskvis.db.service;

import java.util.List;

import com.riskvis.entity.InsurancesHasPlacesrisks;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface IInsurancesHasPlacesrisksService {

	/**
	 * Add InsurancesHasPlacesrisks
	 *
	 * @param InsurancesHasPlacesrisks
	 *            insurancesHasPlacesrisks
	 */
	public void addInsurancesHasPlacesrisks(
			InsurancesHasPlacesrisks insurancesHasPlacesrisks);

	/**
	 * Update InsurancesHasPlacesrisks
	 *
	 * @param InsurancesHasPlacesrisks
	 *            insurancesHasPlacesrisks
	 */
	public void updateInsurancesHasPlacesrisks(
			InsurancesHasPlacesrisks insurancesHasPlacesrisks);

	/**
	 * Delete InsurancesHasPlacesrisks
	 *
	 * @param InsurancesHasPlacesrisks
	 *            insurancesHasPlacesrisks
	 */
	public void deleteInsurancesHasPlacesrisks(
			InsurancesHasPlacesrisks insurancesHasPlacesrisks);

	/**
	 * Get InsurancesHasPlacesrisks
	 *
	 * @param int InsurancesHasPlacesrisks Id
	 */
	public InsurancesHasPlacesrisks getInsurancesHasPlacesrisksById(int id);

	/**
	 * Get InsurancesHasPlacesrisks
	 *
	 * @param int Id
	 */
	public List<InsurancesHasPlacesrisks> getInsurancesHasPlacesrisksByInsurancesId(
			int id);

	/**
	 * Get InsurancesHasPlacesrisks List
	 *
	 */
	public List<InsurancesHasPlacesrisks> getInsurancesHasPlacesriskss();

	/**
	 * Get amount of insurancesHasPlacesrisks
	 *
	 */
	public int getCount();
}
