package com.riskvis.db.dao;

import java.util.List;

import com.riskvis.entity.PlayersHasQuestsId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface IPlayersHasQuestsIdDAO {

	/**
	 * Add PlayersHasQuestsId
	 *
	 * @param PlayersHasQuestsId
	 *            playersHasQuestsId
	 */
	public void addPlayersHasQuestsId(PlayersHasQuestsId playersHasQuestsId);

	/**
	 * Update PlayersHasQuestsId
	 *
	 * @param PlayersHasQuestsId
	 *            playersHasQuestsId
	 */
	public void updatePlayersHasQuestsId(PlayersHasQuestsId playersHasQuestsId);

	/**
	 * Delete PlayersHasQuestsId
	 *
	 * @param PlayersHasQuestsId
	 *            playersHasQuestsId
	 */
	public void deletePlayersHasQuestsId(PlayersHasQuestsId playersHasQuestsId);

	/**
	 * Get PlayersHasQuestsId
	 *
	 * @param int PlayersHasQuestsId Id
	 */
	public PlayersHasQuestsId getPlayersHasQuestsIdById(int id);

	/**
	 * Get PlayersHasQuestsId List
	 *
	 */
	public List<PlayersHasQuestsId> getPlayersHasQuestsIds();

	/**
	 * Get amount of playersHasQuestsId
	 *
	 */
	public int getCount();
}
