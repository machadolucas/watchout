package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.IQuestInsurancesIdDAO;
import com.riskvis.db.service.IQuestInsurancesIdService;
import com.riskvis.entity.QuestInsurancesId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class QuestInsurancesIdService implements IQuestInsurancesIdService {

	IQuestInsurancesIdDAO questInsurancesIdDAO;

	/**
	 * Add QuestInsurancesId
	 *
	 * @param QuestInsurancesId
	 *            questInsurancesId
	 */
	@Transactional(readOnly = false)
	@Override
	public void addQuestInsurancesId(QuestInsurancesId questInsurancesId) {
		getQuestInsurancesIdDAO().addQuestInsurancesId(questInsurancesId);
	}

	/**
	 * Delete QuestInsurancesId
	 *
	 * @param QuestInsurancesId
	 *            questInsurancesId
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteQuestInsurancesId(QuestInsurancesId questInsurancesId) {
		getQuestInsurancesIdDAO().deleteQuestInsurancesId(questInsurancesId);
	}

	/**
	 * Update QuestInsurancesId
	 *
	 * @param QuestInsurancesId
	 *            questInsurancesId
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateQuestInsurancesId(QuestInsurancesId questInsurancesId) {
		getQuestInsurancesIdDAO().updateQuestInsurancesId(questInsurancesId);
	}

	/**
	 * Get QuestInsurancesId
	 *
	 * @param int QuestInsurancesId Id
	 */
	@Override
	public QuestInsurancesId getQuestInsurancesIdById(int id) {
		return getQuestInsurancesIdDAO().getQuestInsurancesIdById(id);
	}

	/**
	 * Get QuestInsurancesId List
	 *
	 */
	@Override
	public List<QuestInsurancesId> getQuestInsurancesIds() {
		return getQuestInsurancesIdDAO().getQuestInsurancesIds();
	}

	/**
	 * Get amount of questInsurancesId
	 *
	 */
	@Override
	public int getCount() {
		return getQuestInsurancesIdDAO().getCount();
	}

	/**
	 * Get QuestInsurancesId DAO
	 *
	 * @return IQuestInsurancesIdDAO - QuestInsurancesId DAO
	 */
	public IQuestInsurancesIdDAO getQuestInsurancesIdDAO() {
		return questInsurancesIdDAO;
	}

	/**
	 * Set QuestInsurancesId DAO
	 *
	 * @param IQuestInsurancesIdDAO
	 *            - QuestInsurancesId DAO
	 */
	public void setQuestInsurancesIdDAO(
			IQuestInsurancesIdDAO questInsurancesIdDAO) {
		this.questInsurancesIdDAO = questInsurancesIdDAO;
	}

}
