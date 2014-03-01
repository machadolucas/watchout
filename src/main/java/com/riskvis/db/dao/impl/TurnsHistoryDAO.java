package com.riskvis.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.riskvis.db.dao.ITurnsHistoryDAO;
import com.riskvis.entity.PlayersHasQuestsId;
import com.riskvis.entity.TurnsHistory;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class TurnsHistoryDAO implements ITurnsHistoryDAO {

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
	 * Add TurnsHistory
	 *
	 * @param TurnsHistory
	 *            turnsHistory
	 */
	@Override
	public void addTurnsHistory(TurnsHistory turnsHistory) {
		getSessionFactory().getCurrentSession().save(turnsHistory);
	}

	/**
	 * Delete TurnsHistory
	 *
	 * @param TurnsHistory
	 *            turnsHistory
	 */
	@Override
	public void deleteTurnsHistory(TurnsHistory turnsHistory) {
		getSessionFactory().getCurrentSession().delete(turnsHistory);
	}

	/**
	 * Update TurnsHistory
	 *
	 * @param TurnsHistory
	 *            turnsHistory
	 */
	@Override
	public void updateTurnsHistory(TurnsHistory turnsHistory) {
		getSessionFactory().getCurrentSession().update(turnsHistory);
	}

	/**
	 * Get TurnsHistory
	 *
	 * @param int TurnsHistory Id
	 * @return TurnsHistory
	 */
	@Override
	public TurnsHistory getTurnsHistoryById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from TurnsHistory where id=?")
				.setParameter(0, id).list();
		if (list.size() < 1) {
			return null;
		}
		return (TurnsHistory) list.get(0);
	}

	/**
	 * Get TurnsHistory List
	 *
	 * @param PlayersHasQuestsId
	 *            id
	 * @return List - TurnsHistory list
	 */
	@Override
	public List<TurnsHistory> getTurnsHistoryByPlayerHasQuestsId(
			PlayersHasQuestsId id) {
		List list = getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"from TurnsHistory tr where tr.playersHasQuests.players.idplayers = :player and tr.playersHasQuests.quests.idquests = :quest")
				.setParameter("player", id.getPlayersIdplayers())
				.setParameter("quest", id.getQuestsIdquests()).list();
		if (list.size() < 1) {
			return null;
		}
		return list;
	}

	/**
	 * Get TurnsHistory List
	 *
	 * @return List - TurnsHistory list
	 */
	@Override
	public List<TurnsHistory> getTurnsHistorys() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from TurnsHistory").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.riskvis.db.dao.ITurnsHistoryDAO#getCount()
	 */
	@Override
	public int getCount() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(TurnsHistory.class);
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.list().get(0)).intValue();
	}

}
