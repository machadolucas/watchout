package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.IPlayersDAO;
import com.riskvis.db.service.IPlayersService;
import com.riskvis.entity.Players;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class PlayersService implements IPlayersService {

	IPlayersDAO playersDAO;

	/**
	 * Add Players
	 *
	 * @param Players
	 *            players
	 */
	@Transactional(readOnly = false)
	@Override
	public void addPlayers(Players players) {
		getPlayersDAO().addPlayers(players);
	}

	/**
	 * Delete Players
	 *
	 * @param Players
	 *            players
	 */
	@Transactional(readOnly = false)
	@Override
	public void deletePlayers(Players players) {
		getPlayersDAO().deletePlayers(players);
	}

	/**
	 * Update Players
	 *
	 * @param Players
	 *            players
	 */
	@Transactional(readOnly = false)
	@Override
	public void updatePlayers(Players players) {
		getPlayersDAO().updatePlayers(players);
	}

	/**
	 * Get Players
	 *
	 * @param int Players Id
	 */
	@Override
	public Players getPlayersById(int id) {
		return getPlayersDAO().getPlayersById(id);
	}

	/**
	 * Get Players List
	 *
	 */
	@Override
	public List<Players> getPlayerss() {
		return getPlayersDAO().getPlayerss();
	}

	/**
	 * Get Players
	 *
	 * @param String
	 *            Players email
	 */
	@Override
	public Players getPlayersByEmail(String email) {
		return getPlayersDAO().getPlayersByEmail(email);
	}

	/**
	 * Get Players
	 *
	 * @param String
	 *            Players email
	 */
	@Override
	public Players getPlayersByUsername(String username) {
		return getPlayersDAO().getPlayersByUsername(username);
	}

	/**
	 * Get amount of players
	 *
	 */
	@Override
	public int getCount() {
		return getPlayersDAO().getCount();
	}

	/**
	 * Get Players DAO
	 *
	 * @return IPlayersDAO - Players DAO
	 */
	public IPlayersDAO getPlayersDAO() {
		return playersDAO;
	}

	/**
	 * Set Players DAO
	 *
	 * @param IPlayersDAO
	 *            - Players DAO
	 */
	public void setPlayersDAO(IPlayersDAO playersDAO) {
		this.playersDAO = playersDAO;
	}

}
