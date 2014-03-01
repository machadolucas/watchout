package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.IInsurancesDAO;
import com.riskvis.entity.Insurances;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class InsurancesDAO implements IInsurancesDAO {

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
	 * Add Insurances
	 *
	 * @param Insurances
	 *            insurance
	 */
	@Override
	public void addInsurances(Insurances insurance) {
		getSessionFactory().getCurrentSession().save(insurance);
	}

	/**
	 * Delete Insurances
	 *
	 * @param Insurances
	 *            insurance
	 */
	@Override
	public void deleteInsurances(Insurances insurance) {
		getSessionFactory().getCurrentSession().delete(insurance);
	}

	/**
	 * Update Insurances
	 *
	 * @param Insurances
	 *            insurance
	 */
	@Override
	public void updateInsurances(Insurances insurance) {
		getSessionFactory().getCurrentSession().update(insurance);
	}

	/**
	 * Get Insurances
	 *
	 * @param int Insurances Id
	 * @return Insurances
	 */
	@Override
	public Insurances getInsurancesById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Insurances where id=?").setParameter(0, id)
				.list();
		if (list.size() < 1) {
			return null;
		}
		return (Insurances) list.get(0);
	}

	/**
	 * Get Insurances
	 *
	 * @param Insurances
	 *            insurances
	 * @return Insurances
	 */
	@Override
	public Insurances getInsurancesByNameAndCost(Insurances insurances) {
		List list = getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"from Insurances where name = :name and cost = :cost")
				.setProperties(insurances).list();
		if (list.size() < 1) {
			return null;
		}
		return (Insurances) list.get(0);
	}

	/**
	 * Get Insurances List
	 *
	 * @return List - Insurances list
	 */
	@Override
	public List<Insurances> getInsurancess() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Insurances").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.IInsurancesDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(Insurances.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
