package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.ITransportsDAO;
import com.riskvis.db.service.ITransportsService;
import com.riskvis.entity.Transports;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class TransportsService implements ITransportsService {

	ITransportsDAO transportsDAO;

	/**
	 * Add Transports
	 *
	 * @param Transports
	 *            transports
	 */
	@Transactional(readOnly = false)
	@Override
	public void addTransports(Transports transports) {
		getTransportsDAO().addTransports(transports);
	}

	/**
	 * Delete Transports
	 *
	 * @param Transports
	 *            transports
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteTransports(Transports transports) {
		getTransportsDAO().deleteTransports(transports);
	}

	/**
	 * Update Transports
	 *
	 * @param Transports
	 *            transports
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateTransports(Transports transports) {
		getTransportsDAO().updateTransports(transports);
	}

	/**
	 * Get Transports
	 *
	 * @param int Transports Id
	 */
	@Override
	public Transports getTransportsById(int id) {
		return getTransportsDAO().getTransportsById(id);
	}

	/**
	 * Get Transports List
	 *
	 */
	@Override
	public List<Transports> getTransportss() {
		return getTransportsDAO().getTransportss();
	}

	/**
	 * Get amount of transports
	 *
	 */
	@Override
	public int getCount() {
		return getTransportsDAO().getCount();
	}

	/**
	 * Get Transports DAO
	 *
	 * @return ITransportsDAO - Transports DAO
	 */
	public ITransportsDAO getTransportsDAO() {
		return transportsDAO;
	}

	/**
	 * Set Transports DAO
	 *
	 * @param ITransportsDAO
	 *            - Transports DAO
	 */
	public void setTransportsDAO(ITransportsDAO transportsDAO) {
		this.transportsDAO = transportsDAO;
	}

}
