package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.IPlayersHasQuestsDAO;
import com.riskvis.db.service.IPlayersHasQuestsService;
import com.riskvis.entity.PlayersHasQuests;
import com.riskvis.entity.PlayersHasQuestsId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class PlayersHasQuestsService implements IPlayersHasQuestsService {

	IPlayersHasQuestsDAO playersHasQuestsDAO;

	/**
	 * Add PlayersHasQuests
	 *
	 * @param PlayersHasQuests
	 *            playersHasQuests
	 */
	@Transactional(readOnly = false)
	@Override
	public void addPlayersHasQuests(PlayersHasQuests playersHasQuests) {
		getPlayersHasQuestsDAO().addPlayersHasQuests(playersHasQuests);
	}

	/**
	 * Delete PlayersHasQuests
	 *
	 * @param PlayersHasQuests
	 *            playersHasQuests
	 */
	@Transactional(readOnly = false)
	@Override
	public void deletePlayersHasQuests(PlayersHasQuests playersHasQuests) {
		getPlayersHasQuestsDAO().deletePlayersHasQuests(playersHasQuests);
	}

	/**
	 * Update PlayersHasQuests
	 *
	 * @param PlayersHasQuests
	 *            playersHasQuests
	 */
	@Transactional(readOnly = false)
	@Override
	public void updatePlayersHasQuests(PlayersHasQuests playersHasQuests) {
		getPlayersHasQuestsDAO().updatePlayersHasQuests(playersHasQuests);
	}

	/**
	 * Get PlayersHasQuests
	 *
	 * @param int PlayersHasQuests Id
	 */
	@Override
	public PlayersHasQuests getPlayersHasQuestsById(int id) {
		return getPlayersHasQuestsDAO().getPlayersHasQuestsById(id);
	}

	/**
	 * Get PlayersHasQuests List
	 *
	 */
	@Override
	public List<PlayersHasQuests> getPlayersHasQuestss() {
		return getPlayersHasQuestsDAO().getPlayersHasQuestss();
	}

	/**
	 * Get PlayersHasQuests List by Player
	 *
	 * @param PlayersHasQuestsId
	 *            Id
	 */
	@Override
	public List<PlayersHasQuests> getPlayersHasQuestsByPlayer(
			PlayersHasQuestsId id) {
		return getPlayersHasQuestsDAO().getPlayersHasQuestsByPlayer(id);
	}

	/**
	 * Get PlayersHasQuests List by Quest
	 *
	 * @param PlayersHasQuestsId
	 *            Id
	 */
	@Override
	public List<PlayersHasQuests> getPlayersHasQuestsByQuest(
			PlayersHasQuestsId id) {
		return getPlayersHasQuestsDAO().getPlayersHasQuestsByQuest(id);
	}

	/**
	 * Get amount of playersHasQuests
	 *
	 */
	@Override
	public int getCount() {
		return getPlayersHasQuestsDAO().getCount();
	}

	/**
	 * Get PlayersHasQuests DAO
	 *
	 * @return IPlayersHasQuestsDAO - PlayersHasQuests DAO
	 */
	public IPlayersHasQuestsDAO getPlayersHasQuestsDAO() {
		return playersHasQuestsDAO;
	}

	/**
	 * Set PlayersHasQuests DAO
	 *
	 * @param IPlayersHasQuestsDAO
	 *            - PlayersHasQuests DAO
	 */
	public void setPlayersHasQuestsDAO(IPlayersHasQuestsDAO playersHasQuestsDAO) {
		this.playersHasQuestsDAO = playersHasQuestsDAO;
	}

}
