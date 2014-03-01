package com.riskvis.db.service;

import java.util.List;

import com.riskvis.entity.Transports;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface ITransportsService {

	/**
	 * Add Transports
	 *
	 * @param Transports
	 *            transports
	 */
	public void addTransports(Transports transports);

	/**
	 * Update Transports
	 *
	 * @param Transports
	 *            transports
	 */
	public void updateTransports(Transports transports);

	/**
	 * Delete Transports
	 *
	 * @param Transports
	 *            transports
	 */
	public void deleteTransports(Transports transports);

	/**
	 * Get Transports
	 *
	 * @param int Transports Id
	 */
	public Transports getTransportsById(int id);

	/**
	 * Get Transports List
	 *
	 */
	public List<Transports> getTransportss();

	/**
	 * Get amount of transports
	 *
	 */
	public int getCount();
}
