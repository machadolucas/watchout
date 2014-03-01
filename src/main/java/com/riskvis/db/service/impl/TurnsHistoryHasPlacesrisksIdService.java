package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.ITurnsHistoryHasPlacesrisksIdDAO;
import com.riskvis.db.service.ITurnsHistoryHasPlacesrisksIdService;
import com.riskvis.entity.TurnsHistoryHasPlacesrisksId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class TurnsHistoryHasPlacesrisksIdService implements
		ITurnsHistoryHasPlacesrisksIdService {

	ITurnsHistoryHasPlacesrisksIdDAO turnsHistoryHasPlacesrisksIdDAO;

	/**
	 * Add TurnsHistoryHasPlacesrisksId
	 *
	 * @param TurnsHistoryHasPlacesrisksId
	 *            turnsHistoryHasPlacesrisksId
	 */
	@Transactional(readOnly = false)
	@Override
	public void addTurnsHistoryHasPlacesrisksId(
			TurnsHistoryHasPlacesrisksId turnsHistoryHasPlacesrisksId) {
		getTurnsHistoryHasPlacesrisksIdDAO().addTurnsHistoryHasPlacesrisksId(
				turnsHistoryHasPlacesrisksId);
	}

	/**
	 * Delete TurnsHistoryHasPlacesrisksId
	 *
	 * @param TurnsHistoryHasPlacesrisksId
	 *            turnsHistoryHasPlacesrisksId
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteTurnsHistoryHasPlacesrisksId(
			TurnsHistoryHasPlacesrisksId turnsHistoryHasPlacesrisksId) {
		getTurnsHistoryHasPlacesrisksIdDAO()
				.deleteTurnsHistoryHasPlacesrisksId(
						turnsHistoryHasPlacesrisksId);
	}

	/**
	 * Update TurnsHistoryHasPlacesrisksId
	 *
	 * @param TurnsHistoryHasPlacesrisksId
	 *            turnsHistoryHasPlacesrisksId
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateTurnsHistoryHasPlacesrisksId(
			TurnsHistoryHasPlacesrisksId turnsHistoryHasPlacesrisksId) {
		getTurnsHistoryHasPlacesrisksIdDAO()
				.updateTurnsHistoryHasPlacesrisksId(
						turnsHistoryHasPlacesrisksId);
	}

	/**
	 * Get TurnsHistoryHasPlacesrisksId
	 *
	 * @param int TurnsHistoryHasPlacesrisksId Id
	 */
	@Override
	public TurnsHistoryHasPlacesrisksId getTurnsHistoryHasPlacesrisksIdById(
			int id) {
		return getTurnsHistoryHasPlacesrisksIdDAO()
				.getTurnsHistoryHasPlacesrisksIdById(id);
	}

	/**
	 * Get TurnsHistoryHasPlacesrisksId List
	 *
	 */
	@Override
	public List<TurnsHistoryHasPlacesrisksId> getTurnsHistoryHasPlacesrisksIds() {
		return getTurnsHistoryHasPlacesrisksIdDAO()
				.getTurnsHistoryHasPlacesrisksIds();
	}

	/**
	 * Get amount of turnsHistoryHasPlacesrisksId
	 *
	 */
	@Override
	public int getCount() {
		return getTurnsHistoryHasPlacesrisksIdDAO().getCount();
	}

	/**
	 * Get TurnsHistoryHasPlacesrisksId DAO
	 *
	 * @return ITurnsHistoryHasPlacesrisksIdDAO - TurnsHistoryHasPlacesrisksId
	 *         DAO
	 */
	public ITurnsHistoryHasPlacesrisksIdDAO getTurnsHistoryHasPlacesrisksIdDAO() {
		return turnsHistoryHasPlacesrisksIdDAO;
	}

	/**
	 * Set TurnsHistoryHasPlacesrisksId DAO
	 *
	 * @param ITurnsHistoryHasPlacesrisksIdDAO
	 *            - TurnsHistoryHasPlacesrisksId DAO
	 */
	public void setTurnsHistoryHasPlacesrisksIdDAO(
			ITurnsHistoryHasPlacesrisksIdDAO turnsHistoryHasPlacesrisksIdDAO) {
		this.turnsHistoryHasPlacesrisksIdDAO = turnsHistoryHasPlacesrisksIdDAO;
	}

}
