package com.riskvis.db.dao;

import java.util.List;

import com.riskvis.entity.TurnsHistoryHasTransportationrisksId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface ITurnsHistoryHasTransportationrisksIdDAO {

	/**
	 * Add TurnsHistoryHasTransportationrisksId
	 *
	 * @param TurnsHistoryHasTransportationrisksId
	 *            turnsHistoryHasTransportationrisksId
	 */
	public void addTurnsHistoryHasTransportationrisksId(
			TurnsHistoryHasTransportationrisksId turnsHistoryHasTransportationrisksId);

	/**
	 * Update TurnsHistoryHasTransportationrisksId
	 *
	 * @param TurnsHistoryHasTransportationrisksId
	 *            turnsHistoryHasTransportationrisksId
	 */
	public void updateTurnsHistoryHasTransportationrisksId(
			TurnsHistoryHasTransportationrisksId turnsHistoryHasTransportationrisksId);

	/**
	 * Delete TurnsHistoryHasTransportationrisksId
	 *
	 * @param TurnsHistoryHasTransportationrisksId
	 *            turnsHistoryHasTransportationrisksId
	 */
	public void deleteTurnsHistoryHasTransportationrisksId(
			TurnsHistoryHasTransportationrisksId turnsHistoryHasTransportationrisksId);

	/**
	 * Get TurnsHistoryHasTransportationrisksId
	 *
	 * @param int TurnsHistoryHasTransportationrisksId Id
	 */
	public TurnsHistoryHasTransportationrisksId getTurnsHistoryHasTransportationrisksIdById(
			int id);

	/**
	 * Get TurnsHistoryHasTransportationrisksId List
	 *
	 */
	public List<TurnsHistoryHasTransportationrisksId> getTurnsHistoryHasTransportationrisksIds();

	/**
	 * Get amount of turnsHistoryHasTransportationrisksId
	 *
	 */
	public int getCount();
}
