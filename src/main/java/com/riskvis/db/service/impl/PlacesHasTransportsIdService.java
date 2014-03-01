package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.IPlacesHasTransportsIdDAO;
import com.riskvis.db.service.IPlacesHasTransportsIdService;
import com.riskvis.entity.PlacesHasTransportsId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class PlacesHasTransportsIdService implements
		IPlacesHasTransportsIdService {

	IPlacesHasTransportsIdDAO placesHasTransportsIdDAO;

	/**
	 * Add PlacesHasTransportsId
	 *
	 * @param PlacesHasTransportsId
	 *            placesHasTransportsId
	 */
	@Transactional(readOnly = false)
	@Override
	public void addPlacesHasTransportsId(
			PlacesHasTransportsId placesHasTransportsId) {
		getPlacesHasTransportsIdDAO().addPlacesHasTransportsId(
				placesHasTransportsId);
	}

	/**
	 * Delete PlacesHasTransportsId
	 *
	 * @param PlacesHasTransportsId
	 *            placesHasTransportsId
	 */
	@Transactional(readOnly = false)
	@Override
	public void deletePlacesHasTransportsId(
			PlacesHasTransportsId placesHasTransportsId) {
		getPlacesHasTransportsIdDAO().deletePlacesHasTransportsId(
				placesHasTransportsId);
	}

	/**
	 * Update PlacesHasTransportsId
	 *
	 * @param PlacesHasTransportsId
	 *            placesHasTransportsId
	 */
	@Transactional(readOnly = false)
	@Override
	public void updatePlacesHasTransportsId(
			PlacesHasTransportsId placesHasTransportsId) {
		getPlacesHasTransportsIdDAO().updatePlacesHasTransportsId(
				placesHasTransportsId);
	}

	/**
	 * Get PlacesHasTransportsId
	 *
	 * @param int PlacesHasTransportsId Id
	 */
	@Override
	public PlacesHasTransportsId getPlacesHasTransportsIdById(int id) {
		return getPlacesHasTransportsIdDAO().getPlacesHasTransportsIdById(id);
	}

	/**
	 * Get PlacesHasTransportsId List
	 *
	 */
	@Override
	public List<PlacesHasTransportsId> getPlacesHasTransportsIds() {
		return getPlacesHasTransportsIdDAO().getPlacesHasTransportsIds();
	}

	/**
	 * Get amount of placesHasTransportsId
	 *
	 */
	@Override
	public int getCount() {
		return getPlacesHasTransportsIdDAO().getCount();
	}

	/**
	 * Get PlacesHasTransportsId DAO
	 *
	 * @return IPlacesHasTransportsIdDAO - PlacesHasTransportsId DAO
	 */
	public IPlacesHasTransportsIdDAO getPlacesHasTransportsIdDAO() {
		return placesHasTransportsIdDAO;
	}

	/**
	 * Set PlacesHasTransportsId DAO
	 *
	 * @param IPlacesHasTransportsIdDAO
	 *            - PlacesHasTransportsId DAO
	 */
	public void setPlacesHasTransportsIdDAO(
			IPlacesHasTransportsIdDAO placesHasTransportsIdDAO) {
		this.placesHasTransportsIdDAO = placesHasTransportsIdDAO;
	}

}
