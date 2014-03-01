package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.IPlayersHasInsurancesIdDAO;
import com.riskvis.entity.PlayersHasInsurancesId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class PlayersHasInsurancesIdDAO implements IPlayersHasInsurancesIdDAO {

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
	 * Add PlayersHasInsurancesId
	 *
	 * @param PlayersHasInsurancesId
	 *            playersHasInsurancesId
	 */
	@Override
	public void addPlayersHasInsurancesId(
			PlayersHasInsurancesId playersHasInsurancesId) {
		getSessionFactory().getCurrentSession().save(playersHasInsurancesId);
	}

	/**
	 * Delete PlayersHasInsurancesId
	 *
	 * @param PlayersHasInsurancesId
	 *            playersHasInsurancesId
	 */
	@Override
	public void deletePlayersHasInsurancesId(
			PlayersHasInsurancesId playersHasInsurancesId) {
		getSessionFactory().getCurrentSession().delete(playersHasInsurancesId);
	}

	/**
	 * Update PlayersHasInsurancesId
	 *
	 * @param PlayersHasInsurancesId
	 *            playersHasInsurancesId
	 */
	@Override
	public void updatePlayersHasInsurancesId(
			PlayersHasInsurancesId playersHasInsurancesId) {
		getSessionFactory().getCurrentSession().update(playersHasInsurancesId);
	}

	/**
	 * Get PlayersHasInsurancesId
	 *
	 * @param int PlayersHasInsurancesId Id
	 * @return PlayersHasInsurancesId
	 */
	@Override
	public PlayersHasInsurancesId getPlayersHasInsurancesIdById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from PlayersHasInsurancesId where id=?")
				.setParameter(0, id).list();
		if (list.size() < 1) {
			return null;
		}
		return (PlayersHasInsurancesId) list.get(0);
	}

	/**
	 * Get PlayersHasInsurancesId List
	 *
	 * @return List - PlayersHasInsurancesId list
	 */
	@Override
	public List<PlayersHasInsurancesId> getPlayersHasInsurancesIds() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from PlayersHasInsurancesId").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.IPlayersHasInsurancesIdDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(PlayersHasInsurancesId.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
