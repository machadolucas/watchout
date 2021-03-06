package com.riskvis.db.dao;

import java.util.List;

import com.riskvis.entity.TurnsHistoryHasTransportationrisks;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface ITurnsHistoryHasTransportationrisksDAO {

	/**
	 * Add TurnsHistoryHasTransportationrisks
	 *
	 * @param TurnsHistoryHasTransportationrisks
	 *            turnsHistoryHasTransportationrisks
	 */
	public void addTurnsHistoryHasTransportationrisks(
			TurnsHistoryHasTransportationrisks turnsHistoryHasTransportationrisks);

	/**
	 * Update TurnsHistoryHasTransportationrisks
	 *
	 * @param TurnsHistoryHasTransportationrisks
	 *            turnsHistoryHasTransportationrisks
	 */
	public void updateTurnsHistoryHasTransportationrisks(
			TurnsHistoryHasTransportationrisks turnsHistoryHasTransportationrisks);

	/**
	 * Delete TurnsHistoryHasTransportationrisks
	 *
	 * @param TurnsHistoryHasTransportationrisks
	 *            turnsHistoryHasTransportationrisks
	 */
	public void deleteTurnsHistoryHasTransportationrisks(
			TurnsHistoryHasTransportationrisks turnsHistoryHasTransportationrisks);

	/**
	 * Get TurnsHistoryHasTransportationrisks
	 *
	 * @param int TurnsHistoryHasTransportationrisks
	 */
	public TurnsHistoryHasTransportationrisks getTurnsHistoryHasTransportationrisksById(
			int id);

	/**
	 * Get TurnsHistoryHasTransportationrisks List
	 *
	 */
	public List<TurnsHistoryHasTransportationrisks> getTurnsHistoryHasTransportationriskss();

	/**
	 * Get amount of turnsHistoryHasTransportationrisks
	 *
	 */
	public int getCount();
}
