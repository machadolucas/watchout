package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.ITurnsHistoryHasTransportationrisksIdDAO;
import com.riskvis.db.service.ITurnsHistoryHasTransportationrisksIdService;
import com.riskvis.entity.TurnsHistoryHasTransportationrisksId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class TurnsHistoryHasTransportationrisksIdService implements
		ITurnsHistoryHasTransportationrisksIdService {

	ITurnsHistoryHasTransportationrisksIdDAO turnsHistoryHasTransportationrisksIdDAO;

	/**
	 * Add TurnsHistoryHasTransportationrisksId
	 *
	 * @param TurnsHistoryHasTransportationrisksId
	 *            turnsHistoryHasTransportationrisksId
	 */
	@Transactional(readOnly = false)
	@Override
	public void addTurnsHistoryHasTransportationrisksId(
			TurnsHistoryHasTransportationrisksId turnsHistoryHasTransportationrisksId) {
		getTurnsHistoryHasTransportationrisksIdDAO()
				.addTurnsHistoryHasTransportationrisksId(
						turnsHistoryHasTransportationrisksId);
	}

	/**
	 * Delete TurnsHistoryHasTransportationrisksId
	 *
	 * @param TurnsHistoryHasTransportationrisksId
	 *            turnsHistoryHasTransportationrisksId
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteTurnsHistoryHasTransportationrisksId(
			TurnsHistoryHasTransportationrisksId turnsHistoryHasTransportationrisksId) {
		getTurnsHistoryHasTransportationrisksIdDAO()
				.deleteTurnsHistoryHasTransportationrisksId(
						turnsHistoryHasTransportationrisksId);
	}

	/**
	 * Update TurnsHistoryHasTransportationrisksId
	 *
	 * @param TurnsHistoryHasTransportationrisksId
	 *            turnsHistoryHasTransportationrisksId
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateTurnsHistoryHasTransportationrisksId(
			TurnsHistoryHasTransportationrisksId turnsHistoryHasTransportationrisksId) {
		getTurnsHistoryHasTransportationrisksIdDAO()
				.updateTurnsHistoryHasTransportationrisksId(
						turnsHistoryHasTransportationrisksId);
	}

	/**
	 * Get TurnsHistoryHasTransportationrisksId
	 *
	 * @param int TurnsHistoryHasTransportationrisksId Id
	 */
	@Override
	public TurnsHistoryHasTransportationrisksId getTurnsHistoryHasTransportationrisksIdById(
			int id) {
		return getTurnsHistoryHasTransportationrisksIdDAO()
				.getTurnsHistoryHasTransportationrisksIdById(id);
	}

	/**
	 * Get TurnsHistoryHasTransportationrisksId List
	 *
	 */
	@Override
	public List<TurnsHistoryHasTransportationrisksId> getTurnsHistoryHasTransportationrisksIds() {
		return getTurnsHistoryHasTransportationrisksIdDAO()
				.getTurnsHistoryHasTransportationrisksIds();
	}

	/**
	 * Get amount of turnsHistoryHasTransportationrisksId
	 *
	 */
	@Override
	public int getCount() {
		return getTurnsHistoryHasTransportationrisksIdDAO().getCount();
	}

	/**
	 * Get TurnsHistoryHasTransportationrisksId DAO
	 *
	 * @return ITurnsHistoryHasTransportationrisksIdDAO -
	 *         TurnsHistoryHasTransportationrisksId DAO
	 */
	public ITurnsHistoryHasTransportationrisksIdDAO getTurnsHistoryHasTransportationrisksIdDAO() {
		return turnsHistoryHasTransportationrisksIdDAO;
	}

	/**
	 * Set TurnsHistoryHasTransportationrisksId DAO
	 *
	 * @param ITurnsHistoryHasTransportationrisksIdDAO
	 *            - TurnsHistoryHasTransportationrisksId DAO
	 */
	public void setTurnsHistoryHasTransportationrisksIdDAO(
			ITurnsHistoryHasTransportationrisksIdDAO turnsHistoryHasTransportationrisksIdDAO) {
		this.turnsHistoryHasTransportationrisksIdDAO = turnsHistoryHasTransportationrisksIdDAO;
	}

}
