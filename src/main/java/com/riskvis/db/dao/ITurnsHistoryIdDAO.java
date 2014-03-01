package com.riskvis.db.dao;

import java.util.List;

import com.riskvis.entity.TurnsHistoryId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface ITurnsHistoryIdDAO {

	/**
	 * Add TurnsHistoryId
	 *
	 * @param TurnsHistoryId
	 *            turnsHistoryId
	 */
	public void addTurnsHistoryId(TurnsHistoryId turnsHistoryId);

	/**
	 * Update TurnsHistoryId
	 *
	 * @param TurnsHistoryId
	 *            turnsHistoryId
	 */
	public void updateTurnsHistoryId(TurnsHistoryId turnsHistoryId);

	/**
	 * Delete TurnsHistoryId
	 *
	 * @param TurnsHistoryId
	 *            turnsHistoryId
	 */
	public void deleteTurnsHistoryId(TurnsHistoryId turnsHistoryId);

	/**
	 * Get TurnsHistoryId
	 *
	 * @param int TurnsHistoryId Id
	 */
	public TurnsHistoryId getTurnsHistoryIdById(int id);

	/**
	 * Get TurnsHistoryId List
	 *
	 */
	public List<TurnsHistoryId> getTurnsHistoryIds();

	/**
	 * Get amount of turnsHistoryId
	 *
	 */
	public int getCount();
}
