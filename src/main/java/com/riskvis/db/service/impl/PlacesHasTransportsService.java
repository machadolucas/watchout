package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.IPlacesHasTransportsDAO;
import com.riskvis.db.service.IPlacesHasTransportsService;
import com.riskvis.entity.PlacesHasTransports;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class PlacesHasTransportsService implements IPlacesHasTransportsService {

	IPlacesHasTransportsDAO placesHasTransportsDAO;

	/**
	 * Add PlacesHasTransports
	 *
	 * @param PlacesHasTransports
	 *            placesHasTransports
	 */
	@Transactional(readOnly = false)
	@Override
	public void addPlacesHasTransports(PlacesHasTransports placesHasTransports) {
		getPlacesHasTransportsDAO().addPlacesHasTransports(placesHasTransports);
	}

	/**
	 * Delete PlacesHasTransports
	 *
	 * @param PlacesHasTransports
	 *            placesHasTransports
	 */
	@Transactional(readOnly = false)
	@Override
	public void deletePlacesHasTransports(
			PlacesHasTransports placesHasTransports) {
		getPlacesHasTransportsDAO().deletePlacesHasTransports(
				placesHasTransports);
	}

	/**
	 * Update PlacesHasTransports
	 *
	 * @param PlacesHasTransports
	 *            placesHasTransports
	 */
	@Transactional(readOnly = false)
	@Override
	public void updatePlacesHasTransports(
			PlacesHasTransports placesHasTransports) {
		getPlacesHasTransportsDAO().updatePlacesHasTransports(
				placesHasTransports);
	}

	/**
	 * Get PlacesHasTransports
	 *
	 * @param int PlacesHasTransports Id
	 */
	@Transactional(readOnly = true)
	@Override
	public PlacesHasTransports getPlacesHasTransportsById(int id) {
		return getPlacesHasTransportsDAO().getPlacesHasTransportsById(id);
	}

	/**
	 * Get PlacesHasTransports List
	 *
	 * @param int Places Id
	 */
	@Transactional(readOnly = true)
	@Override
	public List<PlacesHasTransports> getPlacesHasTransportsByPlaceId(int id) {
		return getPlacesHasTransportsDAO().getPlacesHasTransportsByPlaceId(id);
	}

	/**
	 * Get PlacesHasTransports List
	 *
	 */
	@Transactional(readOnly = true)
	@Override
	public List<PlacesHasTransports> getPlacesHasTransportss() {
		return getPlacesHasTransportsDAO().getPlacesHasTransportss();
	}

	/**
	 * Get amount of placesHasTransports
	 *
	 */
	@Override
	public int getCount() {
		return getPlacesHasTransportsDAO().getCount();
	}

	/**
	 * Get PlacesHasTransports DAO
	 *
	 * @return IPlacesHasTransportsDAO - PlacesHasTransports DAO
	 */
	public IPlacesHasTransportsDAO getPlacesHasTransportsDAO() {
		return placesHasTransportsDAO;
	}

	/**
	 * Set PlacesHasTransports DAO
	 *
	 * @param IPlacesHasTransportsDAO
	 *            - PlacesHasTransports DAO
	 */
	public void setPlacesHasTransportsDAO(
			IPlacesHasTransportsDAO placesHasTransportsDAO) {
		this.placesHasTransportsDAO = placesHasTransportsDAO;
	}

}
