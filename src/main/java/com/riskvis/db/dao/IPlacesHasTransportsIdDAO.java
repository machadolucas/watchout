package com.riskvis.db.dao;

import java.util.List;

import com.riskvis.entity.PlacesHasTransportsId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface IPlacesHasTransportsIdDAO {

	/**
	 * Add PlacesHasTransportsId
	 *
	 * @param PlacesHasTransportsId
	 *            placesHasTransportsId
	 */
	public void addPlacesHasTransportsId(
			PlacesHasTransportsId placesHasTransportsId);

	/**
	 * Update PlacesHasTransportsId
	 *
	 * @param PlacesHasTransportsId
	 *            placesHasTransportsId
	 */
	public void updatePlacesHasTransportsId(
			PlacesHasTransportsId placesHasTransportsId);

	/**
	 * Delete PlacesHasTransportsId
	 *
	 * @param PlacesHasTransportsId
	 *            placesHasTransportsId
	 */
	public void deletePlacesHasTransportsId(
			PlacesHasTransportsId placesHasTransportsId);

	/**
	 * Get PlacesHasTransportsId
	 *
	 * @param int PlacesHasTransportsId Id
	 */
	public PlacesHasTransportsId getPlacesHasTransportsIdById(int id);

	/**
	 * Get PlacesHasTransportsId List
	 *
	 */
	public List<PlacesHasTransportsId> getPlacesHasTransportsIds();

	/**
	 * Get amount of placesHasTransportsId
	 *
	 */
	public int getCount();
}
