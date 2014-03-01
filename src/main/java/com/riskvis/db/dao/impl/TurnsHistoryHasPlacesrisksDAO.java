package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.ITurnsHistoryHasPlacesrisksDAO;
import com.riskvis.entity.TurnsHistoryHasPlacesrisks;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class TurnsHistoryHasPlacesrisksDAO implements
		ITurnsHistoryHasPlacesrisksDAO {

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
	 * Add TurnsHistoryHasPlacesrisks
	 *
	 * @param TurnsHistoryHasPlacesrisks
	 *            turnsHistoryHasPlacesrisks
	 */
	@Override
	public void addTurnsHistoryHasPlacesrisks(
			TurnsHistoryHasPlacesrisks turnsHistoryHasPlacesrisks) {
		getSessionFactory().getCurrentSession()
				.save(turnsHistoryHasPlacesrisks);
	}

	/**
	 * Delete TurnsHistoryHasPlacesrisks
	 *
	 * @param TurnsHistoryHasPlacesrisks
	 *            turnsHistoryHasPlacesrisks
	 */
	@Override
	public void deleteTurnsHistoryHasPlacesrisks(
			TurnsHistoryHasPlacesrisks turnsHistoryHasPlacesrisks) {
		getSessionFactory().getCurrentSession().delete(
				turnsHistoryHasPlacesrisks);
	}

	/**
	 * Update TurnsHistoryHasPlacesrisks
	 *
	 * @param TurnsHistoryHasPlacesrisks
	 *            turnsHistoryHasPlacesrisks
	 */
	@Override
	public void updateTurnsHistoryHasPlacesrisks(
			TurnsHistoryHasPlacesrisks turnsHistoryHasPlacesrisks) {
		getSessionFactory().getCurrentSession().update(
				turnsHistoryHasPlacesrisks);
	}

	/**
	 * Get TurnsHistoryHasPlacesrisks
	 *
	 * @param int TurnsHistoryHasPlacesrisks Id
	 * @return TurnsHistoryHasPlacesrisks
	 */
	@Override
	public TurnsHistoryHasPlacesrisks getTurnsHistoryHasPlacesrisksById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from TurnsHistoryHasPlacesrisks where id=?")
				.setParameter(0, id).list();
		if (list.size() < 1) {
			return null;
		}
		return (TurnsHistoryHasPlacesrisks) list.get(0);
	}

	/**
	 * Get TurnsHistoryHasPlacesrisks List
	 *
	 * @return List - TurnsHistoryHasPlacesrisks list
	 */
	@Override
	public List<TurnsHistoryHasPlacesrisks> getTurnsHistoryHasPlacesriskss() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from TurnsHistoryHasPlacesrisks").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.ITurnsHistoryHasPlacesrisksDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(TurnsHistoryHasPlacesrisks.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
