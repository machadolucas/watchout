package com.riskvis.db.dao;

import java.util.List;

import com.riskvis.entity.Quests;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface IQuestsDAO {

	/**
	 * Add Quests
	 *
	 * @param Quests
	 *            quests
	 */
	public void addQuests(Quests quests);

	/**
	 * Update Quests
	 *
	 * @param Quests
	 *            quests
	 */
	public void updateQuests(Quests quests);

	/**
	 * Delete Quests
	 *
	 * @param Quests
	 *            quests
	 */
	public void deleteQuests(Quests quests);

	/**
	 * Get Quests
	 *
	 * @param int Quests Id
	 */
	public Quests getQuestsById(int id);

	/**
	 * Get Quests List
	 *
	 */
	public List<Quests> getQuestss();

	/**
	 * Get amount of quests
	 *
	 */
	public int getCount();
}
