package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.IInsurancesHasPlacesrisksIdDAO;
import com.riskvis.entity.InsurancesHasPlacesrisksId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class InsurancesHasPlacesrisksIdDAO implements
		IInsurancesHasPlacesrisksIdDAO {

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
	 * Add InsurancesHasPlacesrisksId
	 *
	 * @param InsurancesHasPlacesrisksId
	 *            insurancesHasPlacesrisksId
	 */
	@Override
	public void addInsurancesHasPlacesrisksId(
			InsurancesHasPlacesrisksId insurancesHasPlacesrisksId) {
		getSessionFactory().getCurrentSession()
				.save(insurancesHasPlacesrisksId);
	}

	/**
	 * Delete InsurancesHasPlacesrisksId
	 *
	 * @param InsurancesHasPlacesrisksId
	 *            insurancesHasPlacesrisksId
	 */
	@Override
	public void deleteInsurancesHasPlacesrisksId(
			InsurancesHasPlacesrisksId insurancesHasPlacesrisksId) {
		getSessionFactory().getCurrentSession().delete(
				insurancesHasPlacesrisksId);
	}

	/**
	 * Update InsurancesHasPlacesrisksId
	 *
	 * @param InsurancesHasPlacesrisksId
	 *            insurancesHasPlacesrisksId
	 */
	@Override
	public void updateInsurancesHasPlacesrisksId(
			InsurancesHasPlacesrisksId insurancesHasPlacesrisksId) {
		getSessionFactory().getCurrentSession().update(
				insurancesHasPlacesrisksId);
	}

	/**
	 * Get InsurancesHasPlacesrisksId
	 *
	 * @param int InsurancesHasPlacesrisksId Id
	 * @return InsurancesHasPlacesrisksId
	 */
	@Override
	public InsurancesHasPlacesrisksId getInsurancesHasPlacesrisksIdById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from InsurancesHasPlacesrisksId where id=?")
				.setParameter(0, id).list();
		if (list.size() < 1) {
			return null;
		}
		return (InsurancesHasPlacesrisksId) list.get(0);
	}

	/**
	 * Get InsurancesHasPlacesrisksId List
	 *
	 * @return List - InsurancesHasPlacesrisksId list
	 */
	@Override
	public List<InsurancesHasPlacesrisksId> getInsurancesHasPlacesrisksIds() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from InsurancesHasPlacesrisksId").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.IInsurancesHasPlacesrisksIdDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(InsurancesHasPlacesrisksId.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
