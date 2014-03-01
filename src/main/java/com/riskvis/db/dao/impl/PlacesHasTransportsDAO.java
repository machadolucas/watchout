package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.IPlacesHasTransportsDAO;
import com.riskvis.entity.PlacesHasTransports;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class PlacesHasTransportsDAO implements IPlacesHasTransportsDAO {

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
	 * Add PlacesHasTransports
	 *
	 * @param PlacesHasTransports
	 *            placesHasTransports
	 */
	@Override
	public void addPlacesHasTransports(PlacesHasTransports placesHasTransports) {
		getSessionFactory().getCurrentSession().save(placesHasTransports);
	}

	/**
	 * Delete PlacesHasTransports
	 *
	 * @param PlacesHasTransports
	 *            placesHasTransports
	 */
	@Override
	public void deletePlacesHasTransports(
			PlacesHasTransports placesHasTransports) {
		getSessionFactory().getCurrentSession().delete(placesHasTransports);
	}

	/**
	 * Update PlacesHasTransports
	 *
	 * @param PlacesHasTransports
	 *            placesHasTransports
	 */
	@Override
	public void updatePlacesHasTransports(
			PlacesHasTransports placesHasTransports) {
		getSessionFactory().getCurrentSession().update(placesHasTransports);
	}

	/**
	 * Get PlacesHasTransports
	 *
	 * @param int PlacesHasTransports Id
	 * @return PlacesHasTransports
	 */
	@Override
	public PlacesHasTransports getPlacesHasTransportsById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from PlacesHasTransports where id=?")
				.setParameter(0, id).list();
		if (list.size() < 1) {
			return null;
		}
		return (PlacesHasTransports) list.get(0);
	}

	/**
	 * Get PlacesHasTransports List
	 *
	 * @return List - PlacesHasTransports list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PlacesHasTransports> getPlacesHasTransportsByPlaceId(int id) {
		List<PlacesHasTransports> list = getSessionFactory()
				.getCurrentSession()
				.createQuery("from PlacesHasTransports where places_origin=?")
				.setParameter(0, id).list();
		if (list.size() < 1) {
			return null;
		}
		return list;
	}

	/**
	 * Get PlacesHasTransports List
	 *
	 * @return List - PlacesHasTransports list
	 */
	@Override
	public List<PlacesHasTransports> getPlacesHasTransportss() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from PlacesHasTransports").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.IPlacesHasTransportsDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(PlacesHasTransports.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
