package com.riskvis.db.dao;

import java.util.List;

import com.riskvis.entity.PlayersHasInsurancesId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface IPlayersHasInsurancesIdDAO {

	/**
	 * Add PlayersHasInsurancesId
	 *
	 * @param PlayersHasInsurancesId
	 *            playersHasInsurancesId
	 */
	public void addPlayersHasInsurancesId(
			PlayersHasInsurancesId playersHasInsurancesId);

	/**
	 * Update PlayersHasInsurancesId
	 *
	 * @param PlayersHasInsurancesId
	 *            playersHasInsurancesId
	 */
	public void updatePlayersHasInsurancesId(
			PlayersHasInsurancesId playersHasInsurancesId);

	/**
	 * Delete PlayersHasInsurancesId
	 *
	 * @param PlayersHasInsurancesId
	 *            playersHasInsurancesId
	 */
	public void deletePlayersHasInsurancesId(
			PlayersHasInsurancesId playersHasInsurancesId);

	/**
	 * Get PlayersHasInsurancesId
	 *
	 * @param int PlayersHasInsurancesId Id
	 */
	public PlayersHasInsurancesId getPlayersHasInsurancesIdById(int id);

	/**
	 * Get PlayersHasInsurancesId List
	 *
	 */
	public List<PlayersHasInsurancesId> getPlayersHasInsurancesIds();

	/**
	 * Get amount of playersHasInsurancesId
	 *
	 */
	public int getCount();
}
