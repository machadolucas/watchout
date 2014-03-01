package com.riskvis.db.dao;

import java.util.List;

import com.riskvis.entity.Placesrisks;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface IPlacesrisksDAO {

	/**
	 * Add Placesrisks
	 *
	 * @param Placesrisks
	 *            placesrisks
	 */
	public void addPlacesrisks(Placesrisks placesrisks);

	/**
	 * Update Placesrisks
	 *
	 * @param Placesrisks
	 *            placesrisks
	 */
	public void updatePlacesrisks(Placesrisks placesrisks);

	/**
	 * Delete Placesrisks
	 *
	 * @param Placesrisks
	 *            placesrisks
	 */
	public void deletePlacesrisks(Placesrisks placesrisks);

	/**
	 * Get Placesrisks
	 *
	 * @param int Placesrisks Id
	 */
	public Placesrisks getPlacesrisksById(int id);

	/**
	 * Get Placesrisks List
	 *
	 */
	public List<Placesrisks> getPlacesriskss();

	/**
	 * Get amount of placesrisks
	 *
	 */
	public int getCount();
}
