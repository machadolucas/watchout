package com.riskvis.db.dao;

import java.util.List;

import com.riskvis.entity.TurnsHistoryHasPlacesrisksId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface ITurnsHistoryHasPlacesrisksIdDAO {

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
	 * @param int TurnsHistoryHasPlacesrisksId Id
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
