package com.riskvis.db.dao;

import java.util.List;

import com.riskvis.entity.Transportationrisks;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface ITransportationrisksDAO {

	/**
	 * Add Transportationrisks
	 *
	 * @param Transportationrisks
	 *            transportationrisks
	 */
	public void addTransportationrisks(Transportationrisks transportationrisks);

	/**
	 * Update Transportationrisks
	 *
	 * @param Transportationrisks
	 *            transportationrisks
	 */
	public void updateTransportationrisks(
			Transportationrisks transportationrisks);

	/**
	 * Delete Transportationrisks
	 *
	 * @param Transportationrisks
	 *            transportationrisks
	 */
	public void deleteTransportationrisks(
			Transportationrisks transportationrisks);

	/**
	 * Get Transportationrisks
	 *
	 * @param int Transportationrisks Id
	 */
	public Transportationrisks getTransportationrisksById(int id);

	/**
	 * Get Transportationrisks List
	 *
	 */
	public List<Transportationrisks> getTransportationriskss();

	/**
	 * Get amount of transportationrisks
	 *
	 */
	public int getCount();
}
