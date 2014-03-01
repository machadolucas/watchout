package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.IPlacesrisksDAO;
import com.riskvis.entity.Placesrisks;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class PlacesrisksDAO implements IPlacesrisksDAO {

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
	 * Add Placesrisks
	 *
	 * @param Placesrisks
	 *            placesrisk
	 */
	@Override
	public void addPlacesrisks(Placesrisks placesrisk) {
		getSessionFactory().getCurrentSession().save(placesrisk);
	}

	/**
	 * Delete Placesrisks
	 *
	 * @param Placesrisks
	 *            placesrisk
	 */
	@Override
	public void deletePlacesrisks(Placesrisks placesrisk) {
		getSessionFactory().getCurrentSession().delete(placesrisk);
	}

	/**
	 * Update Placesrisks
	 *
	 * @param Placesrisks
	 *            placesrisk
	 */
	@Override
	public void updatePlacesrisks(Placesrisks placesrisk) {
		getSessionFactory().getCurrentSession().update(placesrisk);
	}

	/**
	 * Get Placesrisks
	 *
	 * @param int Placesrisks Id
	 * @return Placesrisks
	 */
	@Override
	public Placesrisks getPlacesrisksById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Placesrisks where id=?").setParameter(0, id)
				.list();
		if (list.size() < 1) {
			return null;
		}
		return (Placesrisks) list.get(0);
	}

	/**
	 * Get Placesrisks List
	 *
	 * @return List - Placesrisks list
	 */
	@Override
	public List<Placesrisks> getPlacesriskss() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Placesrisks").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.IPlacesrisksDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(Placesrisks.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
