package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.IQuestsDAO;
import com.riskvis.db.service.IQuestsService;
import com.riskvis.entity.Quests;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class QuestsService implements IQuestsService {

	IQuestsDAO questsDAO;

	/**
	 * Add Quests
	 *
	 * @param Quests
	 *            quests
	 */
	@Transactional(readOnly = false)
	@Override
	public void addQuests(Quests quests) {
		getQuestsDAO().addQuests(quests);
	}

	/**
	 * Delete Quests
	 *
	 * @param Quests
	 *            quests
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteQuests(Quests quests) {
		getQuestsDAO().deleteQuests(quests);
	}

	/**
	 * Update Quests
	 *
	 * @param Quests
	 *            quests
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateQuests(Quests quests) {
		getQuestsDAO().updateQuests(quests);
	}

	/**
	 * Get Quests
	 *
	 * @param int Quests Id
	 */
	@Override
	public Quests getQuestsById(int id) {
		return getQuestsDAO().getQuestsById(id);
	}

	/**
	 * Get Quests List
	 *
	 */
	@Override
	public List<Quests> getQuestss() {
		return getQuestsDAO().getQuestss();
	}

	/**
	 * Get amount of quests
	 *
	 */
	@Override
	public int getCount() {
		return getQuestsDAO().getCount();
	}

	/**
	 * Get Quests DAO
	 *
	 * @return IQuestsDAO - Quests DAO
	 */
	public IQuestsDAO getQuestsDAO() {
		return questsDAO;
	}

	/**
	 * Set Quests DAO
	 *
	 * @param IQuestsDAO
	 *            - Quests DAO
	 */
	public void setQuestsDAO(IQuestsDAO questsDAO) {
		this.questsDAO = questsDAO;
	}

}
