package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.ITurnsHistoryHasPlacesrisksDAO;
import com.riskvis.db.service.ITurnsHistoryHasPlacesrisksService;
import com.riskvis.entity.TurnsHistoryHasPlacesrisks;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class TurnsHistoryHasPlacesrisksService implements
		ITurnsHistoryHasPlacesrisksService {

	ITurnsHistoryHasPlacesrisksDAO turnsHistoryHasPlacesrisksDAO;

	/**
	 * Add TurnsHistoryHasPlacesrisks
	 *
	 * @param TurnsHistoryHasPlacesrisks
	 *            turnsHistoryHasPlacesrisks
	 */
	@Transactional(readOnly = false)
	@Override
	public void addTurnsHistoryHasPlacesrisks(
			TurnsHistoryHasPlacesrisks turnsHistoryHasPlacesrisks) {
		getTurnsHistoryHasPlacesrisksDAO().addTurnsHistoryHasPlacesrisks(
				turnsHistoryHasPlacesrisks);
	}

	/**
	 * Delete TurnsHistoryHasPlacesrisks
	 *
	 * @param TurnsHistoryHasPlacesrisks
	 *            turnsHistoryHasPlacesrisks
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteTurnsHistoryHasPlacesrisks(
			TurnsHistoryHasPlacesrisks turnsHistoryHasPlacesrisks) {
		getTurnsHistoryHasPlacesrisksDAO().deleteTurnsHistoryHasPlacesrisks(
				turnsHistoryHasPlacesrisks);
	}

	/**
	 * Update TurnsHistoryHasPlacesrisks
	 *
	 * @param TurnsHistoryHasPlacesrisks
	 *            turnsHistoryHasPlacesrisks
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateTurnsHistoryHasPlacesrisks(
			TurnsHistoryHasPlacesrisks turnsHistoryHasPlacesrisks) {
		getTurnsHistoryHasPlacesrisksDAO().updateTurnsHistoryHasPlacesrisks(
				turnsHistoryHasPlacesrisks);
	}

	/**
	 * Get TurnsHistoryHasPlacesrisks
	 *
	 * @param int TurnsHistoryHasPlacesrisks Id
	 */
	@Override
	public TurnsHistoryHasPlacesrisks getTurnsHistoryHasPlacesrisksById(int id) {
		return getTurnsHistoryHasPlacesrisksDAO()
				.getTurnsHistoryHasPlacesrisksById(id);
	}

	/**
	 * Get TurnsHistoryHasPlacesrisks List
	 *
	 */
	@Override
	public List<TurnsHistoryHasPlacesrisks> getTurnsHistoryHasPlacesriskss() {
		return getTurnsHistoryHasPlacesrisksDAO()
				.getTurnsHistoryHasPlacesriskss();
	}

	/**
	 * Get amount of turnsHistoryHasPlacesrisks
	 *
	 */
	@Override
	public int getCount() {
		return getTurnsHistoryHasPlacesrisksDAO().getCount();
	}

	/**
	 * Get TurnsHistoryHasPlacesrisks DAO
	 *
	 * @return ITurnsHistoryHasPlacesrisksDAO - TurnsHistoryHasPlacesrisks DAO
	 */
	public ITurnsHistoryHasPlacesrisksDAO getTurnsHistoryHasPlacesrisksDAO() {
		return turnsHistoryHasPlacesrisksDAO;
	}

	/**
	 * Set TurnsHistoryHasPlacesrisks DAO
	 *
	 * @param ITurnsHistoryHasPlacesrisksDAO
	 *            - TurnsHistoryHasPlacesrisks DAO
	 */
	public void setTurnsHistoryHasPlacesrisksDAO(
			ITurnsHistoryHasPlacesrisksDAO turnsHistoryHasPlacesrisksDAO) {
		this.turnsHistoryHasPlacesrisksDAO = turnsHistoryHasPlacesrisksDAO;
	}

}
