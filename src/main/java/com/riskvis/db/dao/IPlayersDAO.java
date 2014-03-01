package com.riskvis.db.dao;

import java.util.List;

import com.riskvis.entity.Players;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface IPlayersDAO {

	/**
	 * Add Players
	 *
	 * @param Players
	 *            players
	 */
	public void addPlayers(Players players);

	/**
	 * Update Players
	 *
	 * @param Players
	 *            players
	 */
	public void updatePlayers(Players players);

	/**
	 * Delete Players
	 *
	 * @param Players
	 *            players
	 */
	public void deletePlayers(Players players);

	/**
	 * Get Players
	 *
	 * @param int Players Id
	 */
	public Players getPlayersById(int id);

	/**
	 * Get Players List
	 *
	 */
	public List<Players> getPlayerss();

	/**
	 * Get amount of players
	 *
	 */
	public int getCount();

	/**
	 * Get Players
	 *
	 * @param String
	 *            Players email
	 */
	public Players getPlayersByEmail(String email);

	/**
	 * Get Players
	 *
	 * @param String
	 *            Players username
	 */
	public Players getPlayersByUsername(String username);
}
