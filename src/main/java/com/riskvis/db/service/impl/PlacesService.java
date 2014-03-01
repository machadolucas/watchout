package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.IPlacesDAO;
import com.riskvis.db.service.IPlacesService;
import com.riskvis.entity.Places;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class PlacesService implements IPlacesService {

	IPlacesDAO placesDAO;

	/**
	 * Add Places
	 *
	 * @param Places
	 *            places
	 */
	@Transactional(readOnly = false)
	@Override
	public void addPlaces(Places places) {
		getPlacesDAO().addPlaces(places);
	}

	/**
	 * Delete Places
	 *
	 * @param Places
	 *            places
	 */
	@Transactional(readOnly = false)
	@Override
	public void deletePlaces(Places places) {
		getPlacesDAO().deletePlaces(places);
	}

	/**
	 * Update Places
	 *
	 * @param Places
	 *            places
	 */
	@Transactional(readOnly = false)
	@Override
	public void updatePlaces(Places places) {
		getPlacesDAO().updatePlaces(places);
	}

	/**
	 * Get Places
	 *
	 * @param int Places Id
	 */
	@Override
	public Places getPlacesById(int id) {
		return getPlacesDAO().getPlacesById(id);
	}

	/**
	 * Get Places
	 *
	 * @param Places
	 *            places
	 */
	@Override
	public Places getPlacesByNameAndLocation(Places places) {
		return getPlacesDAO().getPlacesByNameAndLocation(places);
	}

	/**
	 * Get Places List
	 *
	 */
	@Override
	public List<Places> getPlacess() {
		return getPlacesDAO().getPlacess();
	}

	/**
	 * Get amount of places
	 *
	 */
	@Override
	public int getCount() {
		return getPlacesDAO().getCount();
	}

	/**
	 * Get Places DAO
	 *
	 * @return IPlacesDAO - Places DAO
	 */
	public IPlacesDAO getPlacesDAO() {
		return placesDAO;
	}

	/**
	 * Set Places DAO
	 *
	 * @param IPlacesDAO
	 *            - Places DAO
	 */
	public void setPlacesDAO(IPlacesDAO placesDAO) {
		this.placesDAO = placesDAO;
	}

}
