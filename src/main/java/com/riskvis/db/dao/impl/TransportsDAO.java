package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.ITransportsDAO;
import com.riskvis.entity.Transports;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class TransportsDAO implements ITransportsDAO {

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
	 * Add Transports
	 *
	 * @param Transports
	 *            transport
	 */
	@Override
	public void addTransports(Transports transport) {
		getSessionFactory().getCurrentSession().save(transport);
	}

	/**
	 * Delete Transports
	 *
	 * @param Transports
	 *            transport
	 */
	@Override
	public void deleteTransports(Transports transport) {
		getSessionFactory().getCurrentSession().delete(transport);
	}

	/**
	 * Update Transports
	 *
	 * @param Transports
	 *            transport
	 */
	@Override
	public void updateTransports(Transports transport) {
		getSessionFactory().getCurrentSession().update(transport);
	}

	/**
	 * Get Transports
	 *
	 * @param int Transports Id
	 * @return Transports
	 */
	@Override
	public Transports getTransportsById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Transports where id=?").setParameter(0, id)
				.list();
		if (list.size() < 1) {
			return null;
		}
		return (Transports) list.get(0);
	}

	/**
	 * Get Transports List
	 *
	 * @return List - Transports list
	 */
	@Override
	public List<Transports> getTransportss() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Transports").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.ITransportsDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(Transports.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
