package com.riskvis.db.service;

import java.util.List;

import com.riskvis.entity.PlayersHasInsurances;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface IPlayersHasInsurancesService {

	/**
	 * Add PlayersHasInsurances
	 *
	 * @param PlayersHasInsurances
	 *            playersHasInsurances
	 */
	public void addPlayersHasInsurances(
			PlayersHasInsurances playersHasInsurances);

	/**
	 * Update PlayersHasInsurances
	 *
	 * @param PlayersHasInsurances
	 *            playersHasInsurances
	 */
	public void updatePlayersHasInsurances(
			PlayersHasInsurances playersHasInsurances);

	/**
	 * Delete PlayersHasInsurances
	 *
	 * @param PlayersHasInsurances
	 *            playersHasInsurances
	 */
	public void deletePlayersHasInsurances(
			PlayersHasInsurances playersHasInsurances);

	/**
	 * Get PlayersHasInsurances
	 *
	 * @param int PlayersHasInsurances Id
	 */
	public PlayersHasInsurances getPlayersHasInsurancesById(int id);

	/**
	 * Get PlayersHasInsurances List
	 *
	 */
	public List<PlayersHasInsurances> getPlayersHasInsurancess();

	/**
	 * Get amount of playersHasInsurances
	 *
	 */
	public int getCount();
}
