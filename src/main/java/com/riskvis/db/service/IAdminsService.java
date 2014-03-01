package com.riskvis.db.service;

import java.util.List;

import com.riskvis.entity.Admins;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public interface IAdminsService {

	/**
	 * Add Admins
	 *
	 * @param Admins
	 *            admins
	 */
	public void addAdmins(Admins admins);

	/**
	 * Update Admins
	 *
	 * @param Admins
	 *            admins
	 */
	public void updateAdmins(Admins admins);

	/**
	 * Delete Admins
	 *
	 * @param Admins
	 *            admins
	 */
	public void deleteAdmins(Admins admins);

	/**
	 * Get Admins
	 *
	 * @param int Admins Id
	 */
	public Admins getAdminsById(int id);

	/**
	 * Get Admins
	 *
	 * @param int Admins email
	 */
	public Admins getAdminsByEmail(String email);

	/**
	 * Get Admins List
	 *
	 */
	public List<Admins> getAdminss();

	/**
	 * Get amount of admins
	 *
	 */
	public int getCount();
}
