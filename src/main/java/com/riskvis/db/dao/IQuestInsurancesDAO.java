package com.riskvis.db.dao;

import java.util.List;

import com.riskvis.entity.PlayersHasQuestsId;
import com.riskvis.entity.QuestInsurances;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface IQuestInsurancesDAO {

	/**
	 * Add QuestInsurances
	 *
	 * @param QuestInsurances
	 *            questInsurances
	 */
	public void addQuestInsurances(QuestInsurances questInsurances);

	/**
	 * Update QuestInsurances
	 *
	 * @param QuestInsurances
	 *            questInsurances
	 */
	public void updateQuestInsurances(QuestInsurances questInsurances);

	/**
	 * Delete QuestInsurances
	 *
	 * @param QuestInsurances
	 *            questInsurances
	 */
	public void deleteQuestInsurances(QuestInsurances questInsurances);

	/**
	 * Get QuestInsurances
	 *
	 * @param int QuestInsurances Id
	 */
	public QuestInsurances getQuestInsurancesById(int id);

	/**
	 * Get QuestInsurances List
	 *
	 */
	public List<QuestInsurances> getQuestInsurancess();

	/**
	 * Get QuestInsurances List
	 *
	 */
	public List<QuestInsurances> getQuestInsurancesByPlayersHasQuestId(
			PlayersHasQuestsId id);

	/**
	 * Get amount of questInsurances
	 *
	 */
	public int getCount();

}
