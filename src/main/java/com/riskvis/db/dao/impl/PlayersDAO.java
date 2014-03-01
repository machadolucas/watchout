package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.IPlayersDAO;
import com.riskvis.entity.Players;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class PlayersDAO implements IPlayersDAO {

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
	 * Add Players
	 *
	 * @param Players
	 *            player
	 */
	@Override
	public void addPlayers(Players player) {
		getSessionFactory().getCurrentSession().save(player);
	}

	/**
	 * Delete Players
	 *
	 * @param Players
	 *            player
	 */
	@Override
	public void deletePlayers(Players player) {
		getSessionFactory().getCurrentSession().delete(player);
	}

	/**
	 * Update Players
	 *
	 * @param Players
	 *            player
	 */
	@Override
	public void updatePlayers(Players player) {
		getSessionFactory().getCurrentSession().update(player);
	}

	/**
	 * Get Players
	 *
	 * @param int Players Id
	 * @return Players
	 */
	@Override
	public Players getPlayersById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Players where id=?").setParameter(0, id)
				.list();
		if (list.size() < 1) {
			return null;
		}
		return (Players) list.get(0);
	}

	/**
	 * Get Players List
	 *
	 * @return List - Players list
	 */
	@Override
	public List<Players> getPlayerss() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Players").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.IPlayersDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(Players.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

	@Override
	public Players getPlayersByEmail(String email) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Players where email=?")
				.setParameter(0, email).list();
		if (list.size() < 1) {
			return null;
		}
		return (Players) list.get(0);
	}

	@Override
	public Players getPlayersByUsername(String username) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Players where name=?")
				.setParameter(0, username).list();
		if (list.size() < 1) {
			return null;
		}
		return (Players) list.get(0);
	}

}
