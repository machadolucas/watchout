package com.riskvis.db.service;

import java.util.List;

import com.riskvis.entity.TurnsHistoryHasPlacesrisks;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface ITurnsHistoryHasPlacesrisksService {

	/**
	 * Add TurnsHistoryHasPlacesrisks
	 *
	 * @param TurnsHistoryHasPlacesrisks
	 *            turnsHistoryHasPlacesrisks
	 */
	public void addTurnsHistoryHasPlacesrisks(
			TurnsHistoryHasPlacesrisks turnsHistoryHasPlacesrisks);

	/**
	 * Update TurnsHistoryHasPlacesrisks
	 *
	 * @param TurnsHistoryHasPlacesrisks
	 *            turnsHistoryHasPlacesrisks
	 */
	public void updateTurnsHistoryHasPlacesrisks(
			TurnsHistoryHasPlacesrisks turnsHistoryHasPlacesrisks);

	/**
	 * Delete TurnsHistoryHasPlacesrisks
	 *
	 * @param TurnsHistoryHasPlacesrisks
	 *            turnsHistoryHasPlacesrisks
	 */
	public void deleteTurnsHistoryHasPlacesrisks(
			TurnsHistoryHasPlacesrisks turnsHistoryHasPlacesrisks);

	/**
	 * Get TurnsHistoryHasPlacesrisks
	 *
	 * @param int TurnsHistoryHasPlacesrisks HasPlacesrisks
	 */
	public TurnsHistoryHasPlacesrisks getTurnsHistoryHasPlacesrisksById(int id);

	/**
	 * Get TurnsHistoryHasPlacesrisks List
	 *
	 */
	public List<TurnsHistoryHasPlacesrisks> getTurnsHistoryHasPlacesriskss();

	/**
	 * Get amount of turnsHistoryHasPlacesrisks
	 *
	 */
	public int getCount();
}
