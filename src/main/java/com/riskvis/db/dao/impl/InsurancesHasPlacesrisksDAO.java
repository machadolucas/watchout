package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.IInsurancesHasPlacesrisksDAO;
import com.riskvis.entity.InsurancesHasPlacesrisks;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class InsurancesHasPlacesrisksDAO implements
		IInsurancesHasPlacesrisksDAO {

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
	 * Add InsurancesHasPlacesrisks
	 *
	 * @param InsurancesHasPlacesrisks
	 *            insurancesHasPlacesrisks
	 */
	@Override
	public void addInsurancesHasPlacesrisks(
			InsurancesHasPlacesrisks insurancesHasPlacesrisks) {
		getSessionFactory().getCurrentSession().save(insurancesHasPlacesrisks);
	}

	/**
	 * Delete InsurancesHasPlacesrisks
	 *
	 * @param InsurancesHasPlacesrisks
	 *            insurancesHasPlacesrisks
	 */
	@Override
	public void deleteInsurancesHasPlacesrisks(
			InsurancesHasPlacesrisks insurancesHasPlacesrisks) {
		getSessionFactory().getCurrentSession()
				.delete(insurancesHasPlacesrisks);
	}

	/**
	 * Update InsurancesHasPlacesrisks
	 *
	 * @param InsurancesHasPlacesrisks
	 *            insurancesHasPlacesrisks
	 */
	@Override
	public void updateInsurancesHasPlacesrisks(
			InsurancesHasPlacesrisks insurancesHasPlacesrisks) {
		getSessionFactory().getCurrentSession()
				.update(insurancesHasPlacesrisks);
	}

	/**
	 * Get InsurancesHasPlacesrisks
	 *
	 * @param int InsurancesHasPlacesrisks Id
	 * @return InsurancesHasPlacesrisks
	 */
	@Override
	public InsurancesHasPlacesrisks getInsurancesHasPlacesrisksById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from InsurancesHasPlacesrisks where id=?")
				.setParameter(0, id).list();
		if (list.size() < 1) {
			return null;
		}
		return (InsurancesHasPlacesrisks) list.get(0);
	}

	/**
	 * Get InsurancesHasPlacesrisks
	 *
	 * @param int Id
	 * @return List - InsurancesHasPlacesrisks list
	 */
	@Override
	public List<InsurancesHasPlacesrisks> getInsurancesHasPlacesrisksByInsurancesId(
			int id) {
		List list = getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"from InsurancesHasPlacesrisks where insurances_idinsurances=?")
				.setParameter(0, id).list();
		return list;
	}

	/**
	 * Get InsurancesHasPlacesrisks List
	 *
	 * @return List - InsurancesHasPlacesrisks list
	 */
	@Override
	public List<InsurancesHasPlacesrisks> getInsurancesHasPlacesriskss() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from InsurancesHasPlacesrisks").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.IInsurancesHasPlacesrisksDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(InsurancesHasPlacesrisks.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
