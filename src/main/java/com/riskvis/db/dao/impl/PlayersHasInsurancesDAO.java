package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.IPlayersHasInsurancesDAO;
import com.riskvis.entity.PlayersHasInsurances;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class PlayersHasInsurancesDAO implements IPlayersHasInsurancesDAO {

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
	 * Add PlayersHasInsurances
	 *
	 * @param PlayersHasInsurances
	 *            playersHasInsurances
	 */
	@Override
	public void addPlayersHasInsurances(
			PlayersHasInsurances playersHasInsurances) {
		getSessionFactory().getCurrentSession().save(playersHasInsurances);
	}

	/**
	 * Delete PlayersHasInsurances
	 *
	 * @param PlayersHasInsurances
	 *            playersHasInsurances
	 */
	@Override
	public void deletePlayersHasInsurances(
			PlayersHasInsurances playersHasInsurances) {
		getSessionFactory().getCurrentSession().delete(playersHasInsurances);
	}

	/**
	 * Update PlayersHasInsurances
	 *
	 * @param PlayersHasInsurances
	 *            playersHasInsurances
	 */
	@Override
	public void updatePlayersHasInsurances(
			PlayersHasInsurances playersHasInsurances) {
		getSessionFactory().getCurrentSession().update(playersHasInsurances);
	}

	/**
	 * Get PlayersHasInsurances
	 *
	 * @param int PlayersHasInsurances Id
	 * @return PlayersHasInsurances
	 */
	@Override
	public PlayersHasInsurances getPlayersHasInsurancesById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from PlayersHasInsurances where id=?")
				.setParameter(0, id).list();
		if (list.size() < 1) {
			return null;
		}
		return (PlayersHasInsurances) list.get(0);
	}

	/**
	 * Get PlayersHasInsurances List
	 *
	 * @return List - PlayersHasInsurances list
	 */
	@Override
	public List<PlayersHasInsurances> getPlayersHasInsurancess() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from PlayersHasInsurances").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.IPlayersHasInsurancesDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(PlayersHasInsurances.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
