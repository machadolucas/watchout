package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.IAdminsDAO;
import com.riskvis.db.service.IAdminsService;
import com.riskvis.entity.Admins;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class AdminsService implements IAdminsService {

	IAdminsDAO adminsDAO;

	/**
	 * Add Admins
	 *
	 * @param Admins
	 *            admins
	 */
	@Transactional(readOnly = false)
	@Override
	public void addAdmins(Admins admins) {
		getAdminsDAO().addAdmins(admins);
	}

	/**
	 * Delete Admins
	 *
	 * @param Admins
	 *            admins
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteAdmins(Admins admins) {
		getAdminsDAO().deleteAdmins(admins);
	}

	/**
	 * Update Admins
	 *
	 * @param Admins
	 *            admins
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateAdmins(Admins admins) {
		getAdminsDAO().updateAdmins(admins);
	}

	/**
	 * Get Admins
	 *
	 * @param int Admins Id
	 */
	@Override
	public Admins getAdminsById(int id) {
		return getAdminsDAO().getAdminsById(id);
	}

	/**
	 * Get Admins
	 *
	 * @param int Admins email
	 */
	@Override
	public Admins getAdminsByEmail(String email) {
		return getAdminsDAO().getAdminsByEmail(email);
	}

	/**
	 * Get Admins List
	 *
	 */
	@Override
	public List<Admins> getAdminss() {
		return getAdminsDAO().getAdminss();
	}

	/**
	 * Get amount of admins
	 *
	 */
	@Override
	public int getCount() {
		return getAdminsDAO().getCount();
	}

	/**
	 * Get Admins DAO
	 *
	 * @return IAdminsDAO - Admins DAO
	 */
	public IAdminsDAO getAdminsDAO() {
		return adminsDAO;
	}

	/**
	 * Set Admins DAO
	 *
	 * @param IAdminsDAO
	 *            - Admins DAO
	 */
	public void setAdminsDAO(IAdminsDAO adminsDAO) {
		this.adminsDAO = adminsDAO;
	}

}
