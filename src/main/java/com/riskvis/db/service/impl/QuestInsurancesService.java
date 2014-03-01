package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.IQuestInsurancesDAO;
import com.riskvis.db.service.IQuestInsurancesService;
import com.riskvis.entity.PlayersHasQuestsId;
import com.riskvis.entity.QuestInsurances;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class QuestInsurancesService implements IQuestInsurancesService {

	IQuestInsurancesDAO questInsurancesDAO;

	/**
	 * Add QuestInsurances
	 *
	 * @param QuestInsurances
	 *            questInsurances
	 */
	@Transactional(readOnly = false)
	@Override
	public void addQuestInsurances(QuestInsurances questInsurances) {
		getQuestInsurancesDAO().addQuestInsurances(questInsurances);
	}

	/**
	 * Delete QuestInsurances
	 *
	 * @param QuestInsurances
	 *            questInsurances
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteQuestInsurances(QuestInsurances questInsurances) {
		getQuestInsurancesDAO().deleteQuestInsurances(questInsurances);
	}

	/**
	 * Update QuestInsurances
	 *
	 * @param QuestInsurances
	 *            questInsurances
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateQuestInsurances(QuestInsurances questInsurances) {
		getQuestInsurancesDAO().updateQuestInsurances(questInsurances);
	}

	/**
	 * Get QuestInsurances
	 *
	 * @param int QuestInsurances Id
	 */
	@Override
	public QuestInsurances getQuestInsurancesById(int id) {
		return getQuestInsurancesDAO().getQuestInsurancesById(id);
	}

	/**
	 * Get QuestInsurances List
	 *
	 */
	@Transactional(readOnly = true)
	@Override
	public List<QuestInsurances> getQuestInsurancesByPlayersHasQuestId(
			PlayersHasQuestsId id) {
		return getQuestInsurancesDAO()
				.getQuestInsurancesByPlayersHasQuestId(id);
	}

	/**
	 * Get QuestInsurances List
	 *
	 */
	@Override
	public List<QuestInsurances> getQuestInsurancess() {
		return getQuestInsurancesDAO().getQuestInsurancess();
	}

	/**
	 * Get amount of questInsurances
	 *
	 */
	@Override
	public int getCount() {
		return getQuestInsurancesDAO().getCount();
	}

	/**
	 * Get QuestInsurances DAO
	 *
	 * @return IQuestInsurancesDAO - QuestInsurances DAO
	 */
	public IQuestInsurancesDAO getQuestInsurancesDAO() {
		return questInsurancesDAO;
	}

	/**
	 * Set QuestInsurances DAO
	 *
	 * @param IQuestInsurancesDAO
	 *            - QuestInsurances DAO
	 */
	public void setQuestInsurancesDAO(IQuestInsurancesDAO questInsurancesDAO) {
		this.questInsurancesDAO = questInsurancesDAO;
	}

}
