package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.IPlacesDAO;
import com.riskvis.entity.Places;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class PlacesDAO implements IPlacesDAO {

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
	 * Add Places
	 *
	 * @param Places
	 *            place
	 */
	@Override
	public void addPlaces(Places place) {
		getSessionFactory().getCurrentSession().save(place);
	}

	/**
	 * Delete Places
	 *
	 * @param Places
	 *            place
	 */
	@Override
	public void deletePlaces(Places place) {
		getSessionFactory().getCurrentSession().delete(place);
	}

	/**
	 * Update Places
	 *
	 * @param Places
	 *            place
	 */
	@Override
	public void updatePlaces(Places place) {
		getSessionFactory().getCurrentSession().update(place);
	}

	/**
	 * Get Places
	 *
	 * @param int Places Id
	 * @return Places
	 */
	@Override
	public Places getPlacesById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Places where id=?").setParameter(0, id)
				.list();
		if (list.size() < 1) {
			return null;
		}
		return (Places) list.get(0);
	}

	/**
	 * Get Places
	 *
	 * @param Places
	 *            places
	 */
	@Override
	public Places getPlacesByNameAndLocation(Places places) {
		List list = getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"from Places where name = :name and location = :location")
				.setProperties(places).list();
		if (list.size() < 1) {
			return null;
		}
		return (Places) list.get(0);
	}

	/**
	 * Get Places List
	 *
	 * @return List - Places list
	 */
	@Override
	public List<Places> getPlacess() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Places").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.IPlacesDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(Places.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
