package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.ITurnsHistoryHasTransportationrisksIdDAO;
import com.riskvis.entity.TurnsHistoryHasTransportationrisksId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class TurnsHistoryHasTransportationrisksIdDAO implements
		ITurnsHistoryHasTransportationrisksIdDAO {

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
	 * Add TurnsHistoryHasTransportationrisksId
	 *
	 * @param TurnsHistoryHasTransportationrisksId
	 *            turnsHistoryHasTransportationrisksId
	 */
	@Override
	public void addTurnsHistoryHasTransportationrisksId(
			TurnsHistoryHasTransportationrisksId turnsHistoryHasTransportationrisksId) {
		getSessionFactory().getCurrentSession().save(
				turnsHistoryHasTransportationrisksId);
	}

	/**
	 * Delete TurnsHistoryHasTransportationrisksId
	 *
	 * @param TurnsHistoryHasTransportationrisksId
	 *            turnsHistoryHasTransportationrisksId
	 */
	@Override
	public void deleteTurnsHistoryHasTransportationrisksId(
			TurnsHistoryHasTransportationrisksId turnsHistoryHasTransportationrisksId) {
		getSessionFactory().getCurrentSession().delete(
				turnsHistoryHasTransportationrisksId);
	}

	/**
	 * Update TurnsHistoryHasTransportationrisksId
	 *
	 * @param TurnsHistoryHasTransportationrisksId
	 *            turnsHistoryHasTransportationrisksId
	 */
	@Override
	public void updateTurnsHistoryHasTransportationrisksId(
			TurnsHistoryHasTransportationrisksId turnsHistoryHasTransportationrisksId) {
		getSessionFactory().getCurrentSession().update(
				turnsHistoryHasTransportationrisksId);
	}

	/**
	 * Get TurnsHistoryHasTransportationrisksId
	 *
	 * @param int TurnsHistoryHasTransportationrisksId Id
	 * @return TurnsHistoryHasTransportationrisksId
	 */
	@Override
	public TurnsHistoryHasTransportationrisksId getTurnsHistoryHasTransportationrisksIdById(
			int id) {
		List list = getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"from TurnsHistoryHasTransportationrisksId where id=?")
				.setParameter(0, id).list();
		if (list.size() < 1) {
			return null;
		}
		return (TurnsHistoryHasTransportationrisksId) list.get(0);
	}

	/**
	 * Get TurnsHistoryHasTransportationrisksId List
	 *
	 * @return List - TurnsHistoryHasTransportationrisksId list
	 */
	@Override
	public List<TurnsHistoryHasTransportationrisksId> getTurnsHistoryHasTransportationrisksIds() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from TurnsHistoryHasTransportationrisksId")
				.list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.riskvis.db.dao.ITurnsHistoryHasTransportationrisksIdDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(TurnsHistoryHasTransportationrisksId.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
