package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.ITurnsHistoryHasPlacesrisksIdDAO;
import com.riskvis.entity.TurnsHistoryHasPlacesrisksId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class TurnsHistoryHasPlacesrisksIdDAO implements
		ITurnsHistoryHasPlacesrisksIdDAO {

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
	 * Add TurnsHistoryHasPlacesrisksId
	 *
	 * @param TurnsHistoryHasPlacesrisksId
	 *            turnsHistoryHasPlacesrisksId
	 */
	@Override
	public void addTurnsHistoryHasPlacesrisksId(
			TurnsHistoryHasPlacesrisksId turnsHistoryHasPlacesrisksId) {
		getSessionFactory().getCurrentSession().save(
				turnsHistoryHasPlacesrisksId);
	}

	/**
	 * Delete TurnsHistoryHasPlacesrisksId
	 *
	 * @param TurnsHistoryHasPlacesrisksId
	 *            turnsHistoryHasPlacesrisksId
	 */
	@Override
	public void deleteTurnsHistoryHasPlacesrisksId(
			TurnsHistoryHasPlacesrisksId turnsHistoryHasPlacesrisksId) {
		getSessionFactory().getCurrentSession().delete(
				turnsHistoryHasPlacesrisksId);
	}

	/**
	 * Update TurnsHistoryHasPlacesrisksId
	 *
	 * @param TurnsHistoryHasPlacesrisksId
	 *            turnsHistoryHasPlacesrisksId
	 */
	@Override
	public void updateTurnsHistoryHasPlacesrisksId(
			TurnsHistoryHasPlacesrisksId turnsHistoryHasPlacesrisksId) {
		getSessionFactory().getCurrentSession().update(
				turnsHistoryHasPlacesrisksId);
	}

	/**
	 * Get TurnsHistoryHasPlacesrisksId
	 *
	 * @param int TurnsHistoryHasPlacesrisksId Id
	 * @return TurnsHistoryHasPlacesrisksId
	 */
	@Override
	public TurnsHistoryHasPlacesrisksId getTurnsHistoryHasPlacesrisksIdById(
			int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from TurnsHistoryHasPlacesrisksId where id=?")
				.setParameter(0, id).list();
		if (list.size() < 1) {
			return null;
		}
		return (TurnsHistoryHasPlacesrisksId) list.get(0);
	}

	/**
	 * Get TurnsHistoryHasPlacesrisksId List
	 *
	 * @return List - TurnsHistoryHasPlacesrisksId list
	 */
	@Override
	public List<TurnsHistoryHasPlacesrisksId> getTurnsHistoryHasPlacesrisksIds() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from TurnsHistoryHasPlacesrisksId").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.ITurnsHistoryHasPlacesrisksIdDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(TurnsHistoryHasPlacesrisksId.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
