package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.IPlayersHasQuestsIdDAO;
import com.riskvis.entity.PlayersHasQuestsId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class PlayersHasQuestsIdDAO implements IPlayersHasQuestsIdDAO {

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
	 * Add PlayersHasQuestsId
	 *
	 * @param PlayersHasQuestsId
	 *            playersHasQuestsId
	 */
	@Override
	public void addPlayersHasQuestsId(PlayersHasQuestsId playersHasQuestsId) {
		getSessionFactory().getCurrentSession().save(playersHasQuestsId);
	}

	/**
	 * Delete PlayersHasQuestsId
	 *
	 * @param PlayersHasQuestsId
	 *            playersHasQuestsId
	 */
	@Override
	public void deletePlayersHasQuestsId(PlayersHasQuestsId playersHasQuestsId) {
		getSessionFactory().getCurrentSession().delete(playersHasQuestsId);
	}

	/**
	 * Update PlayersHasQuestsId
	 *
	 * @param PlayersHasQuestsId
	 *            playersHasQuestsId
	 */
	@Override
	public void updatePlayersHasQuestsId(PlayersHasQuestsId playersHasQuestsId) {
		getSessionFactory().getCurrentSession().update(playersHasQuestsId);
	}

	/**
	 * Get PlayersHasQuestsId
	 *
	 * @param int PlayersHasQuestsId Id
	 * @return PlayersHasQuestsId
	 */
	@Override
	public PlayersHasQuestsId getPlayersHasQuestsIdById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from PlayersHasQuestsId where id=?")
				.setParameter(0, id).list();
		if (list.size() < 1) {
			return null;
		}
		return (PlayersHasQuestsId) list.get(0);
	}

	/**
	 * Get PlayersHasQuestsId List
	 *
	 * @return List - PlayersHasQuestsId list
	 */
	@Override
	public List<PlayersHasQuestsId> getPlayersHasQuestsIds() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from PlayersHasQuestsId").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.IPlayersHasQuestsIdDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(PlayersHasQuestsId.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
