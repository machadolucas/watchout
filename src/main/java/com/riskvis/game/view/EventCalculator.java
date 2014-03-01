package com.riskvis.game.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.riskvis.entity.Insurances;
import com.riskvis.entity.InsurancesHasPlacesrisks;
import com.riskvis.entity.InsurancesHasTransportationrisks;
import com.riskvis.entity.Placesrisks;
import com.riskvis.entity.Transportationrisks;

/**
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
public class EventCalculator {

	public static MoneyLossesData calculateMoneyLosses(
			List<Placesrisks> prisks, List<Transportationrisks> trisks,
			List<Insurances> insurances) {

		MoneyLossesData data = new MoneyLossesData();

		BigDecimal total = new BigDecimal(0);
		Integer energy = new Integer(0);

		for (Placesrisks risk : prisks) {
			total = total.add(risk.getCashCost());
			energy += risk.getEnergyCost();
		}
		for (Transportationrisks risk : trisks) {
			total = total.add(risk.getCashCost());
			energy += risk.getEnergyCost();
		}

		Iterator<Insurances> it = insurances.iterator();
		while (it.hasNext()) {
			Insurances insurance = it.next();

			List<InsurancesHasPlacesrisks> coveredPlacesRisks = new ArrayList<InsurancesHasPlacesrisks>();
			coveredPlacesRisks
					.addAll(insurance.getInsurancesHasPlacesriskses());
			for (InsurancesHasPlacesrisks risk : coveredPlacesRisks) {
				if (prisks.contains(risk.getPlacesrisks())) {
					total = total.subtract(risk.getCover());
					data.getCoveredPlacesRisks().add(risk);
				}
			}

			List<InsurancesHasTransportationrisks> coveredTransportationRisks = new ArrayList<InsurancesHasTransportationrisks>();
			coveredTransportationRisks.addAll(insurance
					.getInsurancesHasTransportationriskses());
			for (InsurancesHasTransportationrisks risk : coveredTransportationRisks) {
				if (trisks.contains(risk.getTransportationrisks())) {
					total = total.subtract(risk.getCover());
					data.getCoveredTransportationRisks().add(risk);
				}
			}
		}

		if (total.doubleValue() >= 0) {
			data.setTotal(total);
		}
		data.setEnergyConsumption(energy);

		return data;
	}

	/**
	 * @param risks
	 *            a list of risks
	 * @return a list of risks that happened
	 */
	public static List<Placesrisks> generatePlacesEvents(List<Placesrisks> risks) {
		if (risks == null) {
			return null;
		}
		List<Placesrisks> events = new LinkedList<Placesrisks>();
		for (Placesrisks risk : risks) {
			if (generateEvent(risk)) {
				events.add(risk);
			}
		}
		return events;
	}

	/**
	 * @param risks
	 *            a list of risks
	 * @return a list of risks that happened
	 */
	public static List<Transportationrisks> generateTransportsEvents(
			List<Transportationrisks> risks) {
		if (risks == null) {
			return null;
		}
		List<Transportationrisks> events = new LinkedList<Transportationrisks>();
		for (Transportationrisks risk : risks) {
			if (generateEvent(risk)) {
				events.add(risk);
			}
		}
		return events;
	}

	public static boolean generateEvent(Placesrisks placeRisk) {
		return calculateRandom(placeRisk.getFrequency().doubleValue(),
				placeRisk.getRiskFactor().doubleValue());
	}

	public static boolean generateEvent(Transportationrisks transportationRisk) {
		return calculateRandom(transportationRisk.getFrequency().doubleValue(),
				transportationRisk.getRiskFactor().doubleValue());
	}

	/**
	 * Generates a random number and compares it with the probability
	 * 
	 * @param frequency
	 *            probability of event happening between 0 and 1.
	 * @param riskFactor
	 *            not used.
	 * @return true or false, randomly and dependent on frequency
	 */
	private static boolean calculateRandom(double frequency, double riskFactor) {
		Random random = new Random();
		double value = random.nextDouble();

		if (value < frequency) {
			return true;
		} else {
			return false;
		}
	}

}
