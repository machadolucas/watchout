package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.IPlayersHasQuestsIdDAO;
import com.riskvis.db.service.IPlayersHasQuestsIdService;
import com.riskvis.entity.PlayersHasQuestsId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class PlayersHasQuestsIdService implements IPlayersHasQuestsIdService {

	IPlayersHasQuestsIdDAO playersHasQuestsIdDAO;

	/**
	 * Add PlayersHasQuestsId
	 *
	 * @param PlayersHasQuestsId
	 *            playersHasQuestsId
	 */
	@Transactional(readOnly = false)
	@Override
	public void addPlayersHasQuestsId(PlayersHasQuestsId playersHasQuestsId) {
		getPlayersHasQuestsIdDAO().addPlayersHasQuestsId(playersHasQuestsId);
	}

	/**
	 * Delete PlayersHasQuestsId
	 *
	 * @param PlayersHasQuestsId
	 *            playersHasQuestsId
	 */
	@Transactional(readOnly = false)
	@Override
	public void deletePlayersHasQuestsId(PlayersHasQuestsId playersHasQuestsId) {
		getPlayersHasQuestsIdDAO().deletePlayersHasQuestsId(playersHasQuestsId);
	}

	/**
	 * Update PlayersHasQuestsId
	 *
	 * @param PlayersHasQuestsId
	 *            playersHasQuestsId
	 */
	@Transactional(readOnly = false)
	@Override
	public void updatePlayersHasQuestsId(PlayersHasQuestsId playersHasQuestsId) {
		getPlayersHasQuestsIdDAO().updatePlayersHasQuestsId(playersHasQuestsId);
	}

	/**
	 * Get PlayersHasQuestsId
	 *
	 * @param int PlayersHasQuestsId Id
	 */
	@Override
	public PlayersHasQuestsId getPlayersHasQuestsIdById(int id) {
		return getPlayersHasQuestsIdDAO().getPlayersHasQuestsIdById(id);
	}

	/**
	 * Get PlayersHasQuestsId List
	 *
	 */
	@Override
	public List<PlayersHasQuestsId> getPlayersHasQuestsIds() {
		return getPlayersHasQuestsIdDAO().getPlayersHasQuestsIds();
	}

	/**
	 * Get amount of playersHasQuestsId
	 *
	 */
	@Override
	public int getCount() {
		return getPlayersHasQuestsIdDAO().getCount();
	}

	/**
	 * Get PlayersHasQuestsId DAO
	 *
	 * @return IPlayersHasQuestsIdDAO - PlayersHasQuestsId DAO
	 */
	public IPlayersHasQuestsIdDAO getPlayersHasQuestsIdDAO() {
		return playersHasQuestsIdDAO;
	}

	/**
	 * Set PlayersHasQuestsId DAO
	 *
	 * @param IPlayersHasQuestsIdDAO
	 *            - PlayersHasQuestsId DAO
	 */
	public void setPlayersHasQuestsIdDAO(
			IPlayersHasQuestsIdDAO playersHasQuestsIdDAO) {
		this.playersHasQuestsIdDAO = playersHasQuestsIdDAO;
	}

}
