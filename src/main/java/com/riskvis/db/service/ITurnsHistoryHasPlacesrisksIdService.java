package com.riskvis.db.service;

import java.util.List;

import com.riskvis.entity.TurnsHistoryHasPlacesrisksId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface ITurnsHistoryHasPlacesrisksIdService {

	/**
	 * Add TurnsHistoryHasPlacesrisksId
	 *
	 * @param TurnsHistoryHasPlacesrisksId
	 *            turnsHistoryHasPlacesrisksId
	 */
	public void addTurnsHistoryHasPlacesrisksId(
			TurnsHistoryHasPlacesrisksId turnsHistoryHasPlacesrisksId);

	/**
	 * Update TurnsHistoryHasPlacesrisksId
	 *
	 * @param TurnsHistoryHasPlacesrisksId
	 *            turnsHistoryHasPlacesrisksId
	 */
	public void updateTurnsHistoryHasPlacesrisksId(
			TurnsHistoryHasPlacesrisksId turnsHistoryHasPlacesrisksId);

	/**
	 * Delete TurnsHistoryHasPlacesrisksId
	 *
	 * @param TurnsHistoryHasPlacesrisksId
	 *            turnsHistoryHasPlacesrisksId
	 */
	public void deleteTurnsHistoryHasPlacesrisksId(
			TurnsHistoryHasPlacesrisksId turnsHistoryHasPlacesrisksId);

	/**
	 * Get TurnsHistoryHasPlacesrisksId
	 *
	 * @param int TurnsHistoryHasPlacesrisksId HasPlacesrisksId
	 */
	public TurnsHistoryHasPlacesrisksId getTurnsHistoryHasPlacesrisksIdById(
			int id);

	/**
	 * Get TurnsHistoryHasPlacesrisksId List
	 *
	 */
	public List<TurnsHistoryHasPlacesrisksId> getTurnsHistoryHasPlacesrisksIds();

	/**
	 * Get amount of turnsHistoryHasPlacesrisksId
	 *
	 */
	public int getCount();
}
