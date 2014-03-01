package com.riskvis.game.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import com.riskvis.entity.Insurances;
import com.riskvis.entity.InsurancesHasPlacesrisks;
import com.riskvis.entity.InsurancesHasTransportationrisks;
import com.riskvis.entity.Places;
import com.riskvis.entity.Placesrisks;
import com.riskvis.entity.Transportationrisks;
import com.riskvis.entity.Transports;

/**
 * Class that represents a movement to a place in a transportation, and all the
 * places and transportation risks. Provides methods to calculate insurances
 * based on playerSessionBean.
 * 
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class MovementAndRiskData {

	PlayerSessionBean playerSessionBean;

	public MovementAndRiskData() {
		super();
		FacesContext context = FacesContext.getCurrentInstance();
		this.playerSessionBean = context.getApplication()
				.evaluateExpressionGet(context, "#{playerSessionBean}",
						PlayerSessionBean.class);
	}

	private Transports transport;
	private Places destination;
	private BigDecimal cost;
	private List<Transportationrisks> trisks = new ArrayList<Transportationrisks>();
	private List<Placesrisks> prisks = new ArrayList<Placesrisks>();

	private BigDecimal totalRisksCost = null;
	private BigDecimal totalRiskCover = null;
	private BigDecimal riskCostWithInsurances = null;
	private BigDecimal totalRiskProbability = null;

	/**
	 * totalRiskProbability
	 * 
	 * @return the sum of probabilities of all the risks in trisks and prisks
	 */
	public BigDecimal getTotalRiskProbability() {
		if (totalRiskProbability != null) {
			return totalRiskProbability;
		}
		BigDecimal total = new BigDecimal(0);
		for (Transportationrisks risk : trisks) {
			total = total.add(risk.getFrequency());
		}
		for (Placesrisks risk : prisks) {
			total = total.add(risk.getFrequency());
		}
		totalRiskProbability = total;
		return totalRiskProbability;
	}

	/**
	 * totalRisksCost
	 * 
	 * @return the sum of costs of all the risks in trisks and prisks
	 */
	public BigDecimal getTotalRisksCost() {
		if (totalRisksCost != null) {
			return totalRisksCost;
		}
		BigDecimal total = new BigDecimal(0);
		for (Transportationrisks risk : trisks) {
			total = total.add(risk.getCashCost());
		}
		for (Placesrisks risk : prisks) {
			total = total.add(risk.getCashCost());
		}
		totalRisksCost = total;
		return totalRisksCost;
	}

	/**
	 * totalRiskCover
	 * 
	 * @return the sum of covers in player insurances that are in trisks and
	 *         prisks
	 */
	public BigDecimal getTotalRiskCover() {
		if (totalRiskCover != null) {
			return totalRiskCover;
		}

		BigDecimal total = new BigDecimal(0);

		Iterator<Insurances> it = playerSessionBean.getInsurances().iterator();
		while (it.hasNext()) {
			Insurances insurance = it.next();

			List<InsurancesHasPlacesrisks> coveredPlacesRisks = new ArrayList<InsurancesHasPlacesrisks>();
			coveredPlacesRisks
					.addAll(insurance.getInsurancesHasPlacesriskses());
			for (InsurancesHasPlacesrisks risk : coveredPlacesRisks) {
				if (prisks.contains(risk.getPlacesrisks())) {
					total = total.add(risk.getCover());
				}
			}

			List<InsurancesHasTransportationrisks> coveredTransportationRisks = new ArrayList<InsurancesHasTransportationrisks>();
			coveredTransportationRisks.addAll(insurance
					.getInsurancesHasTransportationriskses());
			for (InsurancesHasTransportationrisks risk : coveredTransportationRisks) {
				if (trisks.contains(risk.getTransportationrisks())) {
					total = total.add(risk.getCover());
				}
			}

		}
		totalRiskCover = total;
		return totalRiskCover;
	}

	/**
	 * riskCostWithInsurances
	 * 
	 * @return the difference between totalRisksCost and totalRiskCover
	 */
	public BigDecimal getRiskCostWithInsurances() {
		if (riskCostWithInsurances != null) {
			return riskCostWithInsurances;
		}

		BigDecimal cost = getTotalRisksCost().subtract(getTotalRiskCover());
		if (cost.doubleValue() < 0) {
			return new BigDecimal(0);
		} else {
			riskCostWithInsurances = cost;
			return riskCostWithInsurances;
		}
	}

	public PlayerSessionBean getPlayerSessionBean() {
		return playerSessionBean;
	}

	public void setPlayerSessionBean(PlayerSessionBean playerSessionBean) {
		this.playerSessionBean = playerSessionBean;
	}

	public Transports getTransport() {
		return transport;
	}

	public void setTransport(Transports transport) {
		this.transport = transport;
	}

	public Places getDestination() {
		return destination;
	}

	public void setDestination(Places destination) {
		this.destination = destination;
	}

	public List<Transportationrisks> getTrisks() {
		return trisks;
	}

	public void setTrisks(List<Transportationrisks> trisks) {
		this.trisks = trisks;
	}

	public List<Placesrisks> getPrisks() {
		return prisks;
	}

	public void setPrisks(List<Placesrisks> prisks) {
		this.prisks = prisks;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

}
