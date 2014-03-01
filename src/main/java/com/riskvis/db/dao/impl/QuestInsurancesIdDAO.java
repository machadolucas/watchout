package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.IQuestInsurancesIdDAO;
import com.riskvis.entity.QuestInsurancesId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class QuestInsurancesIdDAO implements IQuestInsurancesIdDAO {

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
	 * Add QuestInsurancesId
	 *
	 * @param QuestInsurancesId
	 *            questInsurancesId
	 */
	@Override
	public void addQuestInsurancesId(QuestInsurancesId questInsurancesId) {
		getSessionFactory().getCurrentSession().save(questInsurancesId);
	}

	/**
	 * Delete QuestInsurancesId
	 *
	 * @param QuestInsurancesId
	 *            questInsurancesId
	 */
	@Override
	public void deleteQuestInsurancesId(QuestInsurancesId questInsurancesId) {
		getSessionFactory().getCurrentSession().delete(questInsurancesId);
	}

	/**
	 * Update QuestInsurancesId
	 *
	 * @param QuestInsurancesId
	 *            questInsurancesId
	 */
	@Override
	public void updateQuestInsurancesId(QuestInsurancesId questInsurancesId) {
		getSessionFactory().getCurrentSession().update(questInsurancesId);
	}

	/**
	 * Get QuestInsurancesId
	 *
	 * @param int QuestInsurancesId Id
	 * @return QuestInsurancesId
	 */
	@Override
	public QuestInsurancesId getQuestInsurancesIdById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from QuestInsurancesId where id=?")
				.setParameter(0, id).list();
		if (list.size() < 1) {
			return null;
		}
		return (QuestInsurancesId) list.get(0);
	}

	/**
	 * Get QuestInsurancesId List
	 *
	 * @return List - QuestInsurancesId list
	 */
	@Override
	public List<QuestInsurancesId> getQuestInsurancesIds() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from QuestInsurancesId").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.IQuestInsurancesIdDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(QuestInsurancesId.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
