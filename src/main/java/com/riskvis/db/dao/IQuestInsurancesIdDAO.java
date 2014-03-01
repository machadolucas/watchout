package com.riskvis.db.dao;

import java.util.List;

import com.riskvis.entity.QuestInsurancesId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface IQuestInsurancesIdDAO {

	/**
	 * Add QuestInsurancesId
	 *
	 * @param QuestInsurancesId
	 *            questInsurancesId
	 */
	public void addQuestInsurancesId(QuestInsurancesId questInsurancesId);

	/**
	 * Update QuestInsurancesId
	 *
	 * @param QuestInsurancesId
	 *            questInsurancesId
	 */
	public void updateQuestInsurancesId(QuestInsurancesId questInsurancesId);

	/**
	 * Delete QuestInsurancesId
	 *
	 * @param QuestInsurancesId
	 *            questInsurancesId
	 */
	public void deleteQuestInsurancesId(QuestInsurancesId questInsurancesId);

	/**
	 * Get QuestInsurancesId
	 *
	 * @param int QuestInsurancesId Id
	 */
	public QuestInsurancesId getQuestInsurancesIdById(int id);

	/**
	 * Get QuestInsurancesId List
	 *
	 */
	public List<QuestInsurancesId> getQuestInsurancesIds();

	/**
	 * Get amount of questInsurancesId
	 *
	 */
	public int getCount();
}
