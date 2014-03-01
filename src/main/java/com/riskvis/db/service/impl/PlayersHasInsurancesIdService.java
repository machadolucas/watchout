package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.IPlayersHasInsurancesIdDAO;
import com.riskvis.db.service.IPlayersHasInsurancesIdService;
import com.riskvis.entity.PlayersHasInsurancesId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class PlayersHasInsurancesIdService implements
		IPlayersHasInsurancesIdService {

	IPlayersHasInsurancesIdDAO playersHasInsurancesIdDAO;

	/**
	 * Add PlayersHasInsurancesId
	 *
	 * @param PlayersHasInsurancesId
	 *            playersHasInsurancesId
	 */
	@Transactional(readOnly = false)
	@Override
	public void addPlayersHasInsurancesId(
			PlayersHasInsurancesId playersHasInsurancesId) {
		getPlayersHasInsurancesIdDAO().addPlayersHasInsurancesId(
				playersHasInsurancesId);
	}

	/**
	 * Delete PlayersHasInsurancesId
	 *
	 * @param PlayersHasInsurancesId
	 *            playersHasInsurancesId
	 */
	@Transactional(readOnly = false)
	@Override
	public void deletePlayersHasInsurancesId(
			PlayersHasInsurancesId playersHasInsurancesId) {
		getPlayersHasInsurancesIdDAO().deletePlayersHasInsurancesId(
				playersHasInsurancesId);
	}

	/**
	 * Update PlayersHasInsurancesId
	 *
	 * @param PlayersHasInsurancesId
	 *            playersHasInsurancesId
	 */
	@Transactional(readOnly = false)
	@Override
	public void updatePlayersHasInsurancesId(
			PlayersHasInsurancesId playersHasInsurancesId) {
		getPlayersHasInsurancesIdDAO().updatePlayersHasInsurancesId(
				playersHasInsurancesId);
	}

	/**
	 * Get PlayersHasInsurancesId
	 *
	 * @param int PlayersHasInsurancesId Id
	 */
	@Override
	public PlayersHasInsurancesId getPlayersHasInsurancesIdById(int id) {
		return getPlayersHasInsurancesIdDAO().getPlayersHasInsurancesIdById(id);
	}

	/**
	 * Get PlayersHasInsurancesId List
	 *
	 */
	@Override
	public List<PlayersHasInsurancesId> getPlayersHasInsurancesIds() {
		return getPlayersHasInsurancesIdDAO().getPlayersHasInsurancesIds();
	}

	/**
	 * Get amount of playersHasInsurancesId
	 *
	 */
	@Override
	public int getCount() {
		return getPlayersHasInsurancesIdDAO().getCount();
	}

	/**
	 * Get PlayersHasInsurancesId DAO
	 *
	 * @return IPlayersHasInsurancesIdDAO - PlayersHasInsurancesId DAO
	 */
	public IPlayersHasInsurancesIdDAO getPlayersHasInsurancesIdDAO() {
		return playersHasInsurancesIdDAO;
	}

	/**
	 * Set PlayersHasInsurancesId DAO
	 *
	 * @param IPlayersHasInsurancesIdDAO
	 *            - PlayersHasInsurancesId DAO
	 */
	public void setPlayersHasInsurancesIdDAO(
			IPlayersHasInsurancesIdDAO playersHasInsurancesIdDAO) {
		this.playersHasInsurancesIdDAO = playersHasInsurancesIdDAO;
	}

}
