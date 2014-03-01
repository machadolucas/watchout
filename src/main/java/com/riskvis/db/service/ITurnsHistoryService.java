package com.riskvis.db.service;

import java.util.List;

import com.riskvis.entity.PlayersHasQuestsId;
import com.riskvis.entity.TurnsHistory;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface ITurnsHistoryService {

	/**
	 * Add TurnsHistory
	 *
	 * @param TurnsHistory
	 *            turnsHistory
	 */
	public void addTurnsHistory(TurnsHistory turnsHistory);

	/**
	 * Update TurnsHistory
	 *
	 * @param TurnsHistory
	 *            turnsHistory
	 */
	public void updateTurnsHistory(TurnsHistory turnsHistory);

	/**
	 * Delete TurnsHistory
	 *
	 * @param TurnsHistory
	 *            turnsHistory
	 */
	public void deleteTurnsHistory(TurnsHistory turnsHistory);

	/**
	 * Get TurnsHistory
	 *
	 * @param int TurnsHistory Id
	 */
	public TurnsHistory getTurnsHistoryById(int id);

	/**
	 * Get TurnsHistory List
	 *
	 */
	public List<TurnsHistory> getTurnsHistoryByPlayerHasQuestsId(
			PlayersHasQuestsId id);

	/**
	 * Get TurnsHistory List
	 *
	 */
	public List<TurnsHistory> getTurnsHistorys();

	/**
	 * Get amount of turnsHistory
	 *
	 */
	public int getCount();
}
