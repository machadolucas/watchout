package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.IAdminsDAO;
import com.riskvis.entity.Admins;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class AdminsDAO implements IAdminsDAO {

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
	 * Add Admins
	 *
	 * @param Admins
	 *            admin
	 */
	@Override
	public void addAdmins(Admins admin) {
		getSessionFactory().getCurrentSession().save(admin);
	}

	/**
	 * Delete Admins
	 *
	 * @param Admins
	 *            admin
	 */
	@Override
	public void deleteAdmins(Admins admin) {
		getSessionFactory().getCurrentSession().delete(admin);
	}

	/**
	 * Update Admins
	 *
	 * @param Admins
	 *            admin
	 */
	@Override
	public void updateAdmins(Admins admin) {
		getSessionFactory().getCurrentSession().update(admin);
	}

	/**
	 * Get Admins
	 *
	 * @param int Admins Id
	 * @return Admins
	 */
	@Override
	public Admins getAdminsById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Admins where id=?").setParameter(0, id)
				.list();
		if (list.size() < 1) {
			return null;
		}
		return (Admins) list.get(0);
	}

	/**
	 * Get Admins List
	 *
	 * @return List - Admins list
	 */
	@Override
	public List<Admins> getAdminss() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Admins").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.IAdminsDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(Admins.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.IAdminsDAO#getAdminsByEmail(java.lang.String)
	 */
	@Override
	public Admins getAdminsByEmail(String email) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Admins where email=?")
				.setParameter(0, email).list();
		if (list.size() < 1) {
			return null;
		}
		return (Admins) list.get(0);
	}

}
