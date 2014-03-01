package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.IPlayersHasInsurancesDAO;
import com.riskvis.db.service.IPlayersHasInsurancesService;
import com.riskvis.entity.PlayersHasInsurances;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class PlayersHasInsurancesService implements
		IPlayersHasInsurancesService {

	IPlayersHasInsurancesDAO playersHasInsurancesDAO;

	/**
	 * Add PlayersHasInsurances
	 *
	 * @param PlayersHasInsurances
	 *            playersHasInsurances
	 */
	@Transactional(readOnly = false)
	@Override
	public void addPlayersHasInsurances(
			PlayersHasInsurances playersHasInsurances) {
		getPlayersHasInsurancesDAO().addPlayersHasInsurances(
				playersHasInsurances);
	}

	/**
	 * Delete PlayersHasInsurances
	 *
	 * @param PlayersHasInsurances
	 *            playersHasInsurances
	 */
	@Transactional(readOnly = false)
	@Override
	public void deletePlayersHasInsurances(
			PlayersHasInsurances playersHasInsurances) {
		getPlayersHasInsurancesDAO().deletePlayersHasInsurances(
				playersHasInsurances);
	}

	/**
	 * Update PlayersHasInsurances
	 *
	 * @param PlayersHasInsurances
	 *            playersHasInsurances
	 */
	@Transactional(readOnly = false)
	@Override
	public void updatePlayersHasInsurances(
			PlayersHasInsurances playersHasInsurances) {
		getPlayersHasInsurancesDAO().updatePlayersHasInsurances(
				playersHasInsurances);
	}

	/**
	 * Get PlayersHasInsurances
	 *
	 * @param int PlayersHasInsurances Id
	 */
	@Override
	public PlayersHasInsurances getPlayersHasInsurancesById(int id) {
		return getPlayersHasInsurancesDAO().getPlayersHasInsurancesById(id);
	}

	/**
	 * Get PlayersHasInsurances List
	 *
	 */
	@Override
	public List<PlayersHasInsurances> getPlayersHasInsurancess() {
		return getPlayersHasInsurancesDAO().getPlayersHasInsurancess();
	}

	/**
	 * Get amount of playersHasInsurances
	 *
	 */
	@Override
	public int getCount() {
		return getPlayersHasInsurancesDAO().getCount();
	}

	/**
	 * Get PlayersHasInsurances DAO
	 *
	 * @return IPlayersHasInsurancesDAO - PlayersHasInsurances DAO
	 */
	public IPlayersHasInsurancesDAO getPlayersHasInsurancesDAO() {
		return playersHasInsurancesDAO;
	}

	/**
	 * Set PlayersHasInsurances DAO
	 *
	 * @param IPlayersHasInsurancesDAO
	 *            - PlayersHasInsurances DAO
	 */
	public void setPlayersHasInsurancesDAO(
			IPlayersHasInsurancesDAO playersHasInsurancesDAO) {
		this.playersHasInsurancesDAO = playersHasInsurancesDAO;
	}

}
