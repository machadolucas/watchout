package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.ITurnsHistoryIdDAO;
import com.riskvis.db.service.ITurnsHistoryIdService;
import com.riskvis.entity.TurnsHistoryId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class TurnsHistoryIdService implements ITurnsHistoryIdService {

	ITurnsHistoryIdDAO turnsHistoryIdDAO;

	/**
	 * Add TurnsHistoryId
	 *
	 * @param TurnsHistoryId
	 *            turnsHistoryId
	 */
	@Transactional(readOnly = false)
	@Override
	public void addTurnsHistoryId(TurnsHistoryId turnsHistoryId) {
		getTurnsHistoryIdDAO().addTurnsHistoryId(turnsHistoryId);
	}

	/**
	 * Delete TurnsHistoryId
	 *
	 * @param TurnsHistoryId
	 *            turnsHistoryId
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteTurnsHistoryId(TurnsHistoryId turnsHistoryId) {
		getTurnsHistoryIdDAO().deleteTurnsHistoryId(turnsHistoryId);
	}

	/**
	 * Update TurnsHistoryId
	 *
	 * @param TurnsHistoryId
	 *            turnsHistoryId
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateTurnsHistoryId(TurnsHistoryId turnsHistoryId) {
		getTurnsHistoryIdDAO().updateTurnsHistoryId(turnsHistoryId);
	}

	/**
	 * Get TurnsHistoryId
	 *
	 * @param int TurnsHistoryId Id
	 */
	@Override
	public TurnsHistoryId getTurnsHistoryIdById(int id) {
		return getTurnsHistoryIdDAO().getTurnsHistoryIdById(id);
	}

	/**
	 * Get TurnsHistoryId List
	 *
	 */
	@Override
	public List<TurnsHistoryId> getTurnsHistoryIds() {
		return getTurnsHistoryIdDAO().getTurnsHistoryIds();
	}

	/**
	 * Get amount of turnsHistoryId
	 *
	 */
	@Override
	public int getCount() {
		return getTurnsHistoryIdDAO().getCount();
	}

	/**
	 * Get TurnsHistoryId DAO
	 *
	 * @return ITurnsHistoryIdDAO - TurnsHistoryId DAO
	 */
	public ITurnsHistoryIdDAO getTurnsHistoryIdDAO() {
		return turnsHistoryIdDAO;
	}

	/**
	 * Set TurnsHistoryId DAO
	 *
	 * @param ITurnsHistoryIdDAO
	 *            - TurnsHistoryId DAO
	 */
	public void setTurnsHistoryIdDAO(ITurnsHistoryIdDAO turnsHistoryIdDAO) {
		this.turnsHistoryIdDAO = turnsHistoryIdDAO;
	}

}
