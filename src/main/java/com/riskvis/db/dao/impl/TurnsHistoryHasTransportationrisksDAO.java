package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.ITurnsHistoryHasTransportationrisksDAO;
import com.riskvis.entity.TurnsHistoryHasTransportationrisks;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class TurnsHistoryHasTransportationrisksDAO implements
		ITurnsHistoryHasTransportationrisksDAO {

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
	 * Add TurnsHistoryHasTransportationrisks
	 *
	 * @param TurnsHistoryHasTransportationrisks
	 *            turnsHistoryHasTransportationrisks
	 */
	@Override
	public void addTurnsHistoryHasTransportationrisks(
			TurnsHistoryHasTransportationrisks turnsHistoryHasTransportationrisks) {
		getSessionFactory().getCurrentSession().save(
				turnsHistoryHasTransportationrisks);
	}

	/**
	 * Delete TurnsHistoryHasTransportationrisks
	 *
	 * @param TurnsHistoryHasTransportationrisks
	 *            turnsHistoryHasTransportationrisks
	 */
	@Override
	public void deleteTurnsHistoryHasTransportationrisks(
			TurnsHistoryHasTransportationrisks turnsHistoryHasTransportationrisks) {
		getSessionFactory().getCurrentSession().delete(
				turnsHistoryHasTransportationrisks);
	}

	/**
	 * Update TurnsHistoryHasTransportationrisks
	 *
	 * @param TurnsHistoryHasTransportationrisks
	 *            turnsHistoryHasTransportationrisks
	 */
	@Override
	public void updateTurnsHistoryHasTransportationrisks(
			TurnsHistoryHasTransportationrisks turnsHistoryHasTransportationrisks) {
		getSessionFactory().getCurrentSession().update(
				turnsHistoryHasTransportationrisks);
	}

	/**
	 * Get TurnsHistoryHasTransportationrisks
	 *
	 * @param int TurnsHistoryHasTransportationrisks Id
	 * @return TurnsHistoryHasTransportationrisks
	 */
	@Override
	public TurnsHistoryHasTransportationrisks getTurnsHistoryHasTransportationrisksById(
			int id) {
		List list = getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"from TurnsHistoryHasTransportationrisks where id=?")
				.setParameter(0, id).list();
		if (list.size() < 1) {
			return null;
		}
		return (TurnsHistoryHasTransportationrisks) list.get(0);
	}

	/**
	 * Get TurnsHistoryHasTransportationrisks List
	 *
	 * @return List - TurnsHistoryHasTransportationrisks list
	 */
	@Override
	public List<TurnsHistoryHasTransportationrisks> getTurnsHistoryHasTransportationriskss() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from TurnsHistoryHasTransportationrisks").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.ITurnsHistoryHasTransportationrisksDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(TurnsHistoryHasTransportationrisks.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
