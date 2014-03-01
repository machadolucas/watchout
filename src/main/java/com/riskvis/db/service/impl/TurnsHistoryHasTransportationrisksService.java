package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.ITurnsHistoryHasTransportationrisksDAO;
import com.riskvis.db.service.ITurnsHistoryHasTransportationrisksService;
import com.riskvis.entity.TurnsHistoryHasTransportationrisks;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class TurnsHistoryHasTransportationrisksService implements
		ITurnsHistoryHasTransportationrisksService {

	ITurnsHistoryHasTransportationrisksDAO turnsHistoryHasTransportationrisksDAO;

	/**
	 * Add TurnsHistoryHasTransportationrisks
	 *
	 * @param TurnsHistoryHasTransportationrisks
	 *            turnsHistoryHasTransportationrisks
	 */
	@Transactional(readOnly = false)
	@Override
	public void addTurnsHistoryHasTransportationrisks(
			TurnsHistoryHasTransportationrisks turnsHistoryHasTransportationrisks) {
		getTurnsHistoryHasTransportationrisksDAO()
				.addTurnsHistoryHasTransportationrisks(
						turnsHistoryHasTransportationrisks);
	}

	/**
	 * Delete TurnsHistoryHasTransportationrisks
	 *
	 * @param TurnsHistoryHasTransportationrisks
	 *            turnsHistoryHasTransportationrisks
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteTurnsHistoryHasTransportationrisks(
			TurnsHistoryHasTransportationrisks turnsHistoryHasTransportationrisks) {
		getTurnsHistoryHasTransportationrisksDAO()
				.deleteTurnsHistoryHasTransportationrisks(
						turnsHistoryHasTransportationrisks);
	}

	/**
	 * Update TurnsHistoryHasTransportationrisks
	 *
	 * @param TurnsHistoryHasTransportationrisks
	 *            turnsHistoryHasTransportationrisks
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateTurnsHistoryHasTransportationrisks(
			TurnsHistoryHasTransportationrisks turnsHistoryHasTransportationrisks) {
		getTurnsHistoryHasTransportationrisksDAO()
				.updateTurnsHistoryHasTransportationrisks(
						turnsHistoryHasTransportationrisks);
	}

	/**
	 * Get TurnsHistoryHasTransportationrisks
	 *
	 * @param int TurnsHistoryHasTransportationrisks Id
	 */
	@Override
	public TurnsHistoryHasTransportationrisks getTurnsHistoryHasTransportationrisksById(
			int id) {
		return getTurnsHistoryHasTransportationrisksDAO()
				.getTurnsHistoryHasTransportationrisksById(id);
	}

	/**
	 * Get TurnsHistoryHasTransportationrisks List
	 *
	 */
	@Override
	public List<TurnsHistoryHasTransportationrisks> getTurnsHistoryHasTransportationriskss() {
		return getTurnsHistoryHasTransportationrisksDAO()
				.getTurnsHistoryHasTransportationriskss();
	}

	/**
	 * Get amount of turnsHistoryHasTransportationrisks
	 *
	 */
	@Override
	public int getCount() {
		return getTurnsHistoryHasTransportationrisksDAO().getCount();
	}

	/**
	 * Get TurnsHistoryHasTransportationrisks DAO
	 *
	 * @return ITurnsHistoryHasTransportationrisksDAO -
	 *         TurnsHistoryHasTransportationrisks DAO
	 */
	public ITurnsHistoryHasTransportationrisksDAO getTurnsHistoryHasTransportationrisksDAO() {
		return turnsHistoryHasTransportationrisksDAO;
	}

	/**
	 * Set TurnsHistoryHasTransportationrisks DAO
	 *
	 * @param ITurnsHistoryHasTransportationrisksDAO
	 *            - TurnsHistoryHasTransportationrisks DAO
	 */
	public void setTurnsHistoryHasTransportationrisksDAO(
			ITurnsHistoryHasTransportationrisksDAO turnsHistoryHasTransportationrisksDAO) {
		this.turnsHistoryHasTransportationrisksDAO = turnsHistoryHasTransportationrisksDAO;
	}

}
