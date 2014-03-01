package com.riskvis.db.service;

import java.util.List;

import com.riskvis.entity.Places;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface IPlacesService {

	/**
	 * Add Places
	 *
	 * @param Places
	 *            places
	 */
	public void addPlaces(Places places);

	/**
	 * Update Places
	 *
	 * @param Places
	 *            places
	 */
	public void updatePlaces(Places places);

	/**
	 * Delete Places
	 *
	 * @param Places
	 *            places
	 */
	public void deletePlaces(Places places);

	/**
	 * Get Places
	 *
	 * @param int Places Id
	 */
	public Places getPlacesById(int id);

	/**
	 * Get Places
	 *
	 * @param Places
	 *            places
	 */
	public Places getPlacesByNameAndLocation(Places places);

	/**
	 * Get Places List
	 *
	 */
	public List<Places> getPlacess();

	/**
	 * Get amount of places
	 *
	 */
	public int getCount();
}
