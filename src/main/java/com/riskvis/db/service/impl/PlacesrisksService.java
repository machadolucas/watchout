package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.IPlacesrisksDAO;
import com.riskvis.db.service.IPlacesrisksService;
import com.riskvis.entity.Placesrisks;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class PlacesrisksService implements IPlacesrisksService {

	IPlacesrisksDAO placesrisksDAO;

	/**
	 * Add Placesrisks
	 *
	 * @param Placesrisks
	 *            placesrisks
	 */
	@Transactional(readOnly = false)
	@Override
	public void addPlacesrisks(Placesrisks placesrisks) {
		getPlacesrisksDAO().addPlacesrisks(placesrisks);
	}

	/**
	 * Delete Placesrisks
	 *
	 * @param Placesrisks
	 *            placesrisks
	 */
	@Transactional(readOnly = false)
	@Override
	public void deletePlacesrisks(Placesrisks placesrisks) {
		getPlacesrisksDAO().deletePlacesrisks(placesrisks);
	}

	/**
	 * Update Placesrisks
	 *
	 * @param Placesrisks
	 *            placesrisks
	 */
	@Transactional(readOnly = false)
	@Override
	public void updatePlacesrisks(Placesrisks placesrisks) {
		getPlacesrisksDAO().updatePlacesrisks(placesrisks);
	}

	/**
	 * Get Placesrisks
	 *
	 * @param int Placesrisks Id
	 */
	@Override
	public Placesrisks getPlacesrisksById(int id) {
		return getPlacesrisksDAO().getPlacesrisksById(id);
	}

	/**
	 * Get Placesrisks List
	 *
	 */
	@Override
	public List<Placesrisks> getPlacesriskss() {
		return getPlacesrisksDAO().getPlacesriskss();
	}

	/**
	 * Get amount of placesrisks
	 *
	 */
	@Override
	public int getCount() {
		return getPlacesrisksDAO().getCount();
	}

	/**
	 * Get Placesrisks DAO
	 *
	 * @return IPlacesrisksDAO - Placesrisks DAO
	 */
	public IPlacesrisksDAO getPlacesrisksDAO() {
		return placesrisksDAO;
	}

	/**
	 * Set Placesrisks DAO
	 *
	 * @param IPlacesrisksDAO
	 *            - Placesrisks DAO
	 */
	public void setPlacesrisksDAO(IPlacesrisksDAO placesrisksDAO) {
		this.placesrisksDAO = placesrisksDAO;
	}

}
