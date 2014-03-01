package com.riskvis.db.service;

import java.util.List;

import com.riskvis.entity.Insurances;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface IInsurancesService {

	/**
	 * Add Insurances
	 *
	 * @param Insurances
	 *            insurances
	 */
	public void addInsurances(Insurances insurances);

	/**
	 * Update Insurances
	 *
	 * @param Insurances
	 *            insurances
	 */
	public void updateInsurances(Insurances insurances);

	/**
	 * Delete Insurances
	 *
	 * @param Insurances
	 *            insurances
	 */
	public void deleteInsurances(Insurances insurances);

	/**
	 * Get Insurances
	 *
	 * @param int Insurances Id
	 */
	public Insurances getInsurancesById(int id);

	/**
	 * Get Insurances
	 *
	 * @param Insurances
	 *            insurances
	 */
	public Insurances getInsurancesByNameAndCost(Insurances insurances);

	/**
	 * Get Insurances List
	 *
	 */
	public List<Insurances> getInsurancess();

	/**
	 * Get amount of insurances
	 *
	 */
	public int getCount();
}
