package com.riskvis.db.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.riskvis.db.dao.IInsurancesDAO;
import com.riskvis.db.service.IInsurancesService;
import com.riskvis.entity.Insurances;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@Transactional(readOnly = true)
public class InsurancesService implements IInsurancesService {

	IInsurancesDAO insurancesDAO;

	/**
	 * Add Insurances
	 *
	 * @param Insurances
	 *            insurances
	 */
	@Transactional(readOnly = false)
	@Override
	public void addInsurances(Insurances insurances) {
		getInsurancesDAO().addInsurances(insurances);
	}

	/**
	 * Delete Insurances
	 *
	 * @param Insurances
	 *            insurances
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteInsurances(Insurances insurances) {
		getInsurancesDAO().deleteInsurances(insurances);
	}

	/**
	 * Update Insurances
	 *
	 * @param Insurances
	 *            insurances
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateInsurances(Insurances insurances) {
		getInsurancesDAO().updateInsurances(insurances);
	}

	/**
	 * Get Insurances
	 *
	 * @param int Insurances Id
	 */
	@Override
	public Insurances getInsurancesById(int id) {
		return getInsurancesDAO().getInsurancesById(id);
	}

	/**
	 * Get Insurances
	 *
	 * @param Insurances
	 *            insurances
	 */
	@Override
	public Insurances getInsurancesByNameAndCost(Insurances insurances) {
		return getInsurancesDAO().getInsurancesByNameAndCost(insurances);
	}

	/**
	 * Get Insurances List
	 *
	 */
	@Override
	public List<Insurances> getInsurancess() {
		return getInsurancesDAO().getInsurancess();
	}

	/**
	 * Get amount of insurances
	 *
	 */
	@Override
	public int getCount() {
		return getInsurancesDAO().getCount();
	}

	/**
	 * Get Insurances DAO
	 *
	 * @return IInsurancesDAO - Insurances DAO
	 */
	public IInsurancesDAO getInsurancesDAO() {
		return insurancesDAO;
	}

	/**
	 * Set Insurances DAO
	 *
	 * @param IInsurancesDAO
	 *            - Insurances DAO
	 */
	public void setInsurancesDAO(IInsurancesDAO insurancesDAO) {
		this.insurancesDAO = insurancesDAO;
	}

}
