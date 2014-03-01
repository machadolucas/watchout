package com.riskvis.game.view;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import com.riskvis.entity.InsurancesHasPlacesrisks;
import com.riskvis.entity.InsurancesHasTransportationrisks;

/**
 * Class to store results of calculation of risks effects and insurances over
 * them
 * 
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class MoneyLossesData {

	private BigDecimal total = new BigDecimal(0);
	private Integer energyConsumption = new Integer(0);

	/**
	 * Insurance covers that took effect
	 */
	private List<InsurancesHasPlacesrisks> coveredPlacesRisks = new LinkedList<InsurancesHasPlacesrisks>();

	/**
	 * Insurance covers that took effect
	 */
	private List<InsurancesHasTransportationrisks> coveredTransportationRisks = new LinkedList<InsurancesHasTransportationrisks>();

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<InsurancesHasPlacesrisks> getCoveredPlacesRisks() {
		return coveredPlacesRisks;
	}

	public void setCoveredPlacesRisks(
			List<InsurancesHasPlacesrisks> coveredPlacesRisks) {
		this.coveredPlacesRisks = coveredPlacesRisks;
	}

	public List<InsurancesHasTransportationrisks> getCoveredTransportationRisks() {
		return coveredTransportationRisks;
	}

	public void setCoveredTransportationRisks(
			List<InsurancesHasTransportationrisks> coveredTransportationRisks) {
		this.coveredTransportationRisks = coveredTransportationRisks;
	}

	public Integer getEnergyConsumption() {
		return energyConsumption;
	}

	public void setEnergyConsumption(Integer energyConsumption) {
		this.energyConsumption = energyConsumption;
	}

}
