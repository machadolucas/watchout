package com.riskvis.db.dao;

import java.util.List;

import com.riskvis.entity.PlacesHasTransports;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface IPlacesHasTransportsDAO {

	/**
	 * Add PlacesHasTransports
	 *
	 * @param PlacesHasTransports
	 *            placesHasTransports
	 */
	public void addPlacesHasTransports(PlacesHasTransports placesHasTransports);

	/**
	 * Update PlacesHasTransports
	 *
	 * @param PlacesHasTransports
	 *            placesHasTransports
	 */
	public void updatePlacesHasTransports(
			PlacesHasTransports placesHasTransports);

	/**
	 * Delete PlacesHasTransports
	 *
	 * @param PlacesHasTransports
	 *            placesHasTransports
	 */
	public void deletePlacesHasTransports(
			PlacesHasTransports placesHasTransports);

	/**
	 * Get PlacesHasTransports
	 *
	 * @param int PlacesHasTransports Id
	 */
	public PlacesHasTransports getPlacesHasTransportsById(int id);

	/**
	 * Get PlacesHasTransports List
	 *
	 * @param int Places Id
	 */
	public List<PlacesHasTransports> getPlacesHasTransportsByPlaceId(int id);

	/**
	 * Get PlacesHasTransports List
	 *
	 */
	public List<PlacesHasTransports> getPlacesHasTransportss();

	/**
	 * Get amount of placesHasTransports
	 *
	 */
	public int getCount();
}
