package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.ITurnsHistoryIdDAO;
import com.riskvis.entity.TurnsHistoryId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class TurnsHistoryIdDAO implements ITurnsHistoryIdDAO {

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
	 * Add TurnsHistoryId
	 *
	 * @param TurnsHistoryId
	 *            turnsHistoryId
	 */
	@Override
	public void addTurnsHistoryId(TurnsHistoryId turnsHistoryId) {
		getSessionFactory().getCurrentSession().save(turnsHistoryId);
	}

	/**
	 * Delete TurnsHistoryId
	 *
	 * @param TurnsHistoryId
	 *            turnsHistoryId
	 */
	@Override
	public void deleteTurnsHistoryId(TurnsHistoryId turnsHistoryId) {
		getSessionFactory().getCurrentSession().delete(turnsHistoryId);
	}

	/**
	 * Update TurnsHistoryId
	 *
	 * @param TurnsHistoryId
	 *            turnsHistoryId
	 */
	@Override
	public void updateTurnsHistoryId(TurnsHistoryId turnsHistoryId) {
		getSessionFactory().getCurrentSession().update(turnsHistoryId);
	}

	/**
	 * Get TurnsHistoryId
	 *
	 * @param int TurnsHistoryId Id
	 * @return TurnsHistoryId
	 */
	@Override
	public TurnsHistoryId getTurnsHistoryIdById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from TurnsHistoryId where id=?")
				.setParameter(0, id).list();
		if (list.size() < 1) {
			return null;
		}
		return (TurnsHistoryId) list.get(0);
	}

	/**
	 * Get TurnsHistoryId List
	 *
	 * @return List - TurnsHistoryId list
	 */
	@Override
	public List<TurnsHistoryId> getTurnsHistoryIds() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from TurnsHistoryId").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.ITurnsHistoryIdDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(TurnsHistoryId.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
