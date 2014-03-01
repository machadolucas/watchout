package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.ITurnsHistoryDAO;
import com.riskvis.db.service.ITurnsHistoryService;
import com.riskvis.entity.PlayersHasQuestsId;
import com.riskvis.entity.TurnsHistory;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class TurnsHistoryService implements ITurnsHistoryService {

	ITurnsHistoryDAO turnsHistoryDAO;

	/**
	 * Add TurnsHistory
	 *
	 * @param TurnsHistory
	 *            turnsHistory
	 */
	@Transactional(readOnly = false)
	@Override
	public void addTurnsHistory(TurnsHistory turnsHistory) {
		getTurnsHistoryDAO().addTurnsHistory(turnsHistory);
	}

	/**
	 * Delete TurnsHistory
	 *
	 * @param TurnsHistory
	 *            turnsHistory
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteTurnsHistory(TurnsHistory turnsHistory) {
		getTurnsHistoryDAO().deleteTurnsHistory(turnsHistory);
	}

	/**
	 * Update TurnsHistory
	 *
	 * @param TurnsHistory
	 *            turnsHistory
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateTurnsHistory(TurnsHistory turnsHistory) {
		getTurnsHistoryDAO().updateTurnsHistory(turnsHistory);
	}

	/**
	 * Get TurnsHistory
	 *
	 * @param int TurnsHistory Id
	 */
	@Override
	public TurnsHistory getTurnsHistoryById(int id) {
		return getTurnsHistoryDAO().getTurnsHistoryById(id);
	}

	/**
	 * Get TurnsHistory List
	 *
	 */
	@Transactional(readOnly = true)
	@Override
	public List<TurnsHistory> getTurnsHistoryByPlayerHasQuestsId(
			PlayersHasQuestsId id) {
		return getTurnsHistoryDAO().getTurnsHistoryByPlayerHasQuestsId(id);
	}

	/**
	 * Get TurnsHistory List
	 *
	 */
	@Override
	public List<TurnsHistory> getTurnsHistorys() {
		return getTurnsHistoryDAO().getTurnsHistorys();
	}

	/**
	 * Get amount of turnsHistory
	 *
	 */
	@Override
	public int getCount() {
		return getTurnsHistoryDAO().getCount();
	}

	/**
	 * Get TurnsHistory DAO
	 *
	 * @return ITurnsHistoryDAO - TurnsHistory DAO
	 */
	public ITurnsHistoryDAO getTurnsHistoryDAO() {
		return turnsHistoryDAO;
	}

	/**
	 * Set TurnsHistory DAO
	 *
	 * @param ITurnsHistoryDAO
	 *            - TurnsHistory DAO
	 */
	public void setTurnsHistoryDAO(ITurnsHistoryDAO turnsHistoryDAO) {
		this.turnsHistoryDAO = turnsHistoryDAO;
	}

}
