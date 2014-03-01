package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.IInsurancesHasTransportationrisksDAO;
import com.riskvis.entity.InsurancesHasTransportationrisks;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class InsurancesHasTransportationrisksDAO implements
		IInsurancesHasTransportationrisksDAO {

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
	 * Add InsurancesHasTransportationrisks
	 *
	 * @param InsurancesHasTransportationrisks
	 *            insurancesHasTransportationrisks
	 */
	@Override
	public void addInsurancesHasTransportationrisks(
			InsurancesHasTransportationrisks insurancesHasTransportationrisks) {
		getSessionFactory().getCurrentSession().save(
				insurancesHasTransportationrisks);
	}

	/**
	 * Delete InsurancesHasTransportationrisks
	 *
	 * @param InsurancesHasTransportationrisks
	 *            insurancesHasTransportationrisks
	 */
	@Override
	public void deleteInsurancesHasTransportationrisks(
			InsurancesHasTransportationrisks insurancesHasTransportationrisks) {
		getSessionFactory().getCurrentSession().delete(
				insurancesHasTransportationrisks);
	}

	/**
	 * Update InsurancesHasTransportationrisks
	 *
	 * @param InsurancesHasTransportationrisks
	 *            insurancesHasTransportationrisks
	 */
	@Override
	public void updateInsurancesHasTransportationrisks(
			InsurancesHasTransportationrisks insurancesHasTransportationrisks) {
		getSessionFactory().getCurrentSession().update(
				insurancesHasTransportationrisks);
	}

	/**
	 * Get InsurancesHasTransportationrisks
	 *
	 * @param int InsurancesHasTransportationrisks Id
	 * @return InsurancesHasTransportationrisks
	 */
	@Override
	public InsurancesHasTransportationrisks getInsurancesHasTransportationrisksById(
			int id) {
		List list = getSessionFactory()
				.getCurrentSession()
				.createQuery("from InsurancesHasTransportationrisks where id=?")
				.setParameter(0, id).list();
		if (list.size() < 1) {
			return null;
		}
		return (InsurancesHasTransportationrisks) list.get(0);
	}

	/**
	 * Get InsurancesHasTransportationrisks
	 *
	 * @param int Id
	 * @return List - InsurancesHasTransportationrisks list
	 */
	@Override
	public List<InsurancesHasTransportationrisks> getInsurancesHasTransportationrisksByInsurancesId(
			int id) {
		List list = getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"from InsurancesHasTransportationrisks where insurances_idinsurances=?")
				.setParameter(0, id).list();
		return list;
	}

	/**
	 * Get InsurancesHasTransportationrisks List
	 *
	 * @return List - InsurancesHasTransportationrisks list
	 */
	@Override
	public List<InsurancesHasTransportationrisks> getInsurancesHasTransportationriskss() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from InsurancesHasTransportationrisks").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.IInsurancesHasTransportationrisksDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(InsurancesHasTransportationrisks.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
