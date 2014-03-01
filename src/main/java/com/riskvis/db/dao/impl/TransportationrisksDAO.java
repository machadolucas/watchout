package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.ITransportationrisksDAO;
import com.riskvis.entity.Transportationrisks;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class TransportationrisksDAO implements ITransportationrisksDAO {

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
	 * Add Transportationrisks
	 *
	 * @param Transportationrisks
	 *            transportationrisk
	 */
	@Override
	public void addTransportationrisks(Transportationrisks transportationrisk) {
		getSessionFactory().getCurrentSession().save(transportationrisk);
	}

	/**
	 * Delete Transportationrisks
	 *
	 * @param Transportationrisks
	 *            transportationrisk
	 */
	@Override
	public void deleteTransportationrisks(Transportationrisks transportationrisk) {
		getSessionFactory().getCurrentSession().delete(transportationrisk);
	}

	/**
	 * Update Transportationrisks
	 *
	 * @param Transportationrisks
	 *            transportationrisk
	 */
	@Override
	public void updateTransportationrisks(Transportationrisks transportationrisk) {
		getSessionFactory().getCurrentSession().update(transportationrisk);
	}

	/**
	 * Get Transportationrisks
	 *
	 * @param int Transportationrisks Id
	 * @return Transportationrisks
	 */
	@Override
	public Transportationrisks getTransportationrisksById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Transportationrisks where id=?")
				.setParameter(0, id).list();
		if (list.size() < 1) {
			return null;
		}
		return (Transportationrisks) list.get(0);
	}

	/**
	 * Get Transportationrisks List
	 *
	 * @return List - Transportationrisks list
	 */
	@Override
	public List<Transportationrisks> getTransportationriskss() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Transportationrisks").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.ITransportationrisksDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(Transportationrisks.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
