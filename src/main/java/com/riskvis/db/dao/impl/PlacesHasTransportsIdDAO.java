package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.IPlacesHasTransportsIdDAO;
import com.riskvis.entity.PlacesHasTransportsId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class PlacesHasTransportsIdDAO implements IPlacesHasTransportsIdDAO {

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
	 * Add PlacesHasTransportsId
	 *
	 * @param PlacesHasTransportsId
	 *            placesHasTransportsId
	 */
	@Override
	public void addPlacesHasTransportsId(
			PlacesHasTransportsId placesHasTransportsId) {
		getSessionFactory().getCurrentSession().save(placesHasTransportsId);
	}

	/**
	 * Delete PlacesHasTransportsId
	 *
	 * @param PlacesHasTransportsId
	 *            placesHasTransportsId
	 */
	@Override
	public void deletePlacesHasTransportsId(
			PlacesHasTransportsId placesHasTransportsId) {
		getSessionFactory().getCurrentSession().delete(placesHasTransportsId);
	}

	/**
	 * Update PlacesHasTransportsId
	 *
	 * @param PlacesHasTransportsId
	 *            placesHasTransportsId
	 */
	@Override
	public void updatePlacesHasTransportsId(
			PlacesHasTransportsId placesHasTransportsId) {
		getSessionFactory().getCurrentSession().update(placesHasTransportsId);
	}

	/**
	 * Get PlacesHasTransportsId
	 *
	 * @param int PlacesHasTransportsId Id
	 * @return PlacesHasTransportsId
	 */
	@Override
	public PlacesHasTransportsId getPlacesHasTransportsIdById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from PlacesHasTransportsId where id=?")
				.setParameter(0, id).list();
		if (list.size() < 1) {
			return null;
		}
		return (PlacesHasTransportsId) list.get(0);
	}

	/**
	 * Get PlacesHasTransportsId List
	 *
	 * @return List - PlacesHasTransportsId list
	 */
	@Override
	public List<PlacesHasTransportsId> getPlacesHasTransportsIds() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from PlacesHasTransportsId").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.IPlacesHasTransportsIdDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(PlacesHasTransportsId.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
