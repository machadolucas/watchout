package com.riskvis.db.service;

import java.util.List;

import com.riskvis.entity.PlayersHasQuests;
import com.riskvis.entity.PlayersHasQuestsId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface IPlayersHasQuestsService {

	/**
	 * Add PlayersHasQuests
	 *
	 * @param PlayersHasQuests
	 *            playersHasQuests
	 */
	public void addPlayersHasQuests(PlayersHasQuests playersHasQuests);

	/**
	 * Update PlayersHasQuests
	 *
	 * @param PlayersHasQuests
	 *            playersHasQuests
	 */
	public void updatePlayersHasQuests(PlayersHasQuests playersHasQuests);

	/**
	 * Delete PlayersHasQuests
	 *
	 * @param PlayersHasQuests
	 *            playersHasQuests
	 */
	public void deletePlayersHasQuests(PlayersHasQuests playersHasQuests);

	/**
	 * Get PlayersHasQuests
	 *
	 * @param int PlayersHasQuests Id
	 */
	public PlayersHasQuests getPlayersHasQuestsById(int id);

	/**
	 * Get PlayersHasQuests List
	 *
	 */
	public List<PlayersHasQuests> getPlayersHasQuestss();

	/**
	 * Get PlayersHasQuests List by Player
	 *
	 */
	public List<PlayersHasQuests> getPlayersHasQuestsByPlayer(
			PlayersHasQuestsId id);

	/**
	 * Get PlayersHasQuests List by Quest
	 *
	 */
	public List<PlayersHasQuests> getPlayersHasQuestsByQuest(
			PlayersHasQuestsId id);

	/**
	 * Get amount of playersHasQuests
	 *
	 */
	public int getCount();
}
