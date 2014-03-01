package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.IPlayersHasQuestsDAO;
import com.riskvis.entity.PlayersHasQuests;
import com.riskvis.entity.PlayersHasQuestsId;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class PlayersHasQuestsDAO implements IPlayersHasQuestsDAO {

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
	 * Add PlayersHasQuests
	 *
	 * @param PlayersHasQuests
	 *            playersHasQuests
	 */
	@Override
	public void addPlayersHasQuests(PlayersHasQuests playersHasQuests) {
		getSessionFactory().getCurrentSession().save(playersHasQuests);
	}

	/**
	 * Delete PlayersHasQuests
	 *
	 * @param PlayersHasQuests
	 *            playersHasQuests
	 */
	@Override
	public void deletePlayersHasQuests(PlayersHasQuests playersHasQuests) {
		getSessionFactory().getCurrentSession().delete(playersHasQuests);
	}

	/**
	 * Update PlayersHasQuests
	 *
	 * @param PlayersHasQuests
	 *            playersHasQuests
	 */
	@Override
	public void updatePlayersHasQuests(PlayersHasQuests playersHasQuests) {
		getSessionFactory().getCurrentSession().update(playersHasQuests);
	}

	/**
	 * Get PlayersHasQuests
	 *
	 * @param int PlayersHasQuests Id
	 * @return PlayersHasQuests
	 */
	@Override
	public PlayersHasQuests getPlayersHasQuestsById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from PlayersHasQuests where id=?")
				.setParameter(0, id).list();
		if (list.size() < 1) {
			return null;
		}
		return (PlayersHasQuests) list.get(0);
	}

	/**
	 * Get PlayersHasQuests List
	 *
	 * @return List - PlayersHasQuests list
	 */
	@Override
	public List<PlayersHasQuests> getPlayersHasQuestss() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from PlayersHasQuests").list();
		return list;
	}

	/**
	 * Get PlayersHasQuests List by Player
	 *
	 * @param PlayersHasQuestsId
	 *            Id
	 * @return List - PlayersHasQuests list with quests of the passed player
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PlayersHasQuests> getPlayersHasQuestsByPlayer(
			PlayersHasQuestsId id) {
		List<PlayersHasQuests> list = getSessionFactory().getCurrentSession()
				.createQuery("from PlayersHasQuests where players_idplayers=?")
				.setParameter(0, id.getPlayersIdplayers()).list();
		for (PlayersHasQuests result : list) {
			result.getQuests().getName().toString();
		}
		return list;
	}

	/**
	 * Get PlayersHasQuests List by Quest
	 *
	 * @param PlayersHasQuestsId
	 *            Id
	 * @return List - PlayersHasQuests list with players of the passed quest
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PlayersHasQuests> getPlayersHasQuestsByQuest(
			PlayersHasQuestsId id) {
		PlayersHasQuests example = new PlayersHasQuests();
		example.setId(id);
		List<PlayersHasQuests> list = getSessionFactory().getCurrentSession()
				.createQuery("from PlayersHasQuests where quests_idquests=?")
				.setParameter(0, id.getQuestsIdquests()).list();
		for (PlayersHasQuests result : list) {
			result.getPlayers().getName().toString();
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.IPlayersHasQuestsDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(PlayersHasQuests.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
