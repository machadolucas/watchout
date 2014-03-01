package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.IInsurancesHasTransportationrisksIdDAO;
import com.riskvis.entity.InsurancesHasTransportationrisksId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class InsurancesHasTransportationrisksIdDAO implements
		IInsurancesHasTransportationrisksIdDAO {

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
	 * Add InsurancesHasTransportationrisksId
	 *
	 * @param InsurancesHasTransportationrisksId
	 *            insurancesHasTransportationrisksId
	 */
	@Override
	public void addInsurancesHasTransportationrisksId(
			InsurancesHasTransportationrisksId insurancesHasTransportationrisksId) {
		getSessionFactory().getCurrentSession().save(
				insurancesHasTransportationrisksId);
	}

	/**
	 * Delete InsurancesHasTransportationrisksId
	 *
	 * @param InsurancesHasTransportationrisksId
	 *            insurancesHasTransportationrisksId
	 */
	@Override
	public void deleteInsurancesHasTransportationrisksId(
			InsurancesHasTransportationrisksId insurancesHasTransportationrisksId) {
		getSessionFactory().getCurrentSession().delete(
				insurancesHasTransportationrisksId);
	}

	/**
	 * Update InsurancesHasTransportationrisksId
	 *
	 * @param InsurancesHasTransportationrisksId
	 *            insurancesHasTransportationrisksId
	 */
	@Override
	public void updateInsurancesHasTransportationrisksId(
			InsurancesHasTransportationrisksId insurancesHasTransportationrisksId) {
		getSessionFactory().getCurrentSession().update(
				insurancesHasTransportationrisksId);
	}

	/**
	 * Get InsurancesHasTransportationrisksId
	 *
	 * @param int InsurancesHasTransportationrisksId Id
	 * @return InsurancesHasTransportationrisksId
	 */
	@Override
	public InsurancesHasTransportationrisksId getInsurancesHasTransportationrisksIdById(
			int id) {
		List list = getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"from InsurancesHasTransportationrisksId where id=?")
				.setParameter(0, id).list();
		if (list.size() < 1) {
			return null;
		}
		return (InsurancesHasTransportationrisksId) list.get(0);
	}

	/**
	 * Get InsurancesHasTransportationrisksId List
	 *
	 * @return List - InsurancesHasTransportationrisksId list
	 */
	@Override
	public List<InsurancesHasTransportationrisksId> getInsurancesHasTransportationrisksIds() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from InsurancesHasTransportationrisksId").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.IInsurancesHasTransportationrisksIdDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(InsurancesHasTransportationrisksId.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
