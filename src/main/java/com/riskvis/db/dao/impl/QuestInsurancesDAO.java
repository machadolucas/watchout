package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.IQuestInsurancesDAO;
import com.riskvis.entity.PlayersHasQuestsId;
import com.riskvis.entity.QuestInsurances;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class QuestInsurancesDAO implements IQuestInsurancesDAO {

	private SessionFactory sessionFactory;

	/**
	 * Get Hibernate Session Factory
	 *
	 * @return SessionFactory - Hibernate Session Factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Set Hibernate Session Factory
	 *
	 * @param SessionFactory
	 *            - Hibernate Session Factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Add QuestInsurances
	 *
	 * @param QuestInsurances
	 *            questInsurances
	 */
	@Override
	public void addQuestInsurances(QuestInsurances questInsurances) {
		getSessionFactory().getCurrentSession().save(questInsurances);
	}

	/**
	 * Delete QuestInsurances
	 *
	 * @param QuestInsurances
	 *            questInsurances
	 */
	@Override
	public void deleteQuestInsurances(QuestInsurances questInsurances) {
		getSessionFactory().getCurrentSession().delete(questInsurances);
	}

	/**
	 * Update QuestInsurances
	 *
	 * @param QuestInsurances
	 *            questInsurances
	 */
	@Override
	public void updateQuestInsurances(QuestInsurances questInsurances) {
		getSessionFactory().getCurrentSession().update(questInsurances);
	}

	/**
	 * Get QuestInsurances
	 *
	 * @param int QuestInsurances Id
	 * @return QuestInsurances
	 */
	@Override
	public QuestInsurances getQuestInsurancesById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from QuestInsurances where id=?")
				.setParameter(0, id).list();
		if (list.size() < 1) {
			return null;
		}
		return (QuestInsurances) list.get(0);
	}

	/**
	 * Get QuestInsurances List
	 *
	 * @param PlayersHasQuestsId
	 *            id
	 * @return List - QuestInsurances list
	 */
	@Override
	public List<QuestInsurances> getQuestInsurancesByPlayersHasQuestId(
			PlayersHasQuestsId id) {
		List list = getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"from QuestInsurances qi where qi.playersHasQuests.players.idplayers = :player and qi.playersHasQuests.quests.idquests = :quest")
				.setParameter("player", id.getPlayersIdplayers())
				.setParameter("quest", id.getQuestsIdquests()).list();
		if (list.size() < 1) {
			return null;
		}
		return list;
	}

	/**
	 * Get QuestInsurances List
	 *
	 * @return List - QuestInsurances list
	 */
	@Override
	public List<QuestInsurances> getQuestInsurancess() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from QuestInsurances").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.IQuestInsurancesDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(QuestInsurances.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
