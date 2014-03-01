package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.IQuestsDAO;
import com.riskvis.entity.Quests;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class QuestsDAO implements IQuestsDAO {

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
	 * Add Quests
	 *
	 * @param Quests
	 *            quest
	 */
	@Override
	public void addQuests(Quests quest) {
		getSessionFactory().getCurrentSession().save(quest);
	}

	/**
	 * Delete Quests
	 *
	 * @param Quests
	 *            quest
	 */
	@Override
	public void deleteQuests(Quests quest) {
		getSessionFactory().getCurrentSession().delete(quest);
	}

	/**
	 * Update Quests
	 *
	 * @param Quests
	 *            quest
	 */
	@Override
	public void updateQuests(Quests quest) {
		getSessionFactory().getCurrentSession().update(quest);
	}

	/**
	 * Get Quests
	 *
	 * @param int Quests Id
	 * @return Quests
	 */
	@Override
	public Quests getQuestsById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Quests where id=?").setParameter(0, id)
				.list();
		if (list.size() < 1) {
			return null;
		}
		return (Quests) list.get(0);
	}

	/**
	 * Get Quests List
	 *
	 * @return List - Quests list
	 */
	@Override
	public List<Quests> getQuestss() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Quests").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.IQuestsDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(Quests.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
