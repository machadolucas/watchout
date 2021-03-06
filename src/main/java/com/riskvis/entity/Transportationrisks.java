package com.riskvis.entity;

// Generated May 12, 2014 11:45:38 PM by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * Transportationrisks generated by hbm2java
 */
@Entity
@Table(name = "transportationrisks", catalog = "test")
public class Transportationrisks extends AbstractEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 2475757383158231607L;
	private Integer idrisks;
	private Transports transports;
	private String name;
	private String description;
	private BigDecimal riskFactor;
	private BigDecimal frequency;
	private String data;
	private BigDecimal cashCost;
	private Integer energyCost;
	private Set<InsurancesHasTransportationrisks> insurancesHasTransportationriskses = new HashSet<InsurancesHasTransportationrisks>(
			0);
	private Set<TurnsHistoryHasTransportationrisks> turnsHistoryHasTransportationriskses = new HashSet<TurnsHistoryHasTransportationrisks>(
			0);

	public Transportationrisks() {
	}

	public Transportationrisks(Transports transports, String name,
			BigDecimal riskFactor, BigDecimal frequency, BigDecimal cashCost,
			Integer energyCost) {
		this.transports = transports;
		this.name = name;
		this.riskFactor = riskFactor;
		this.frequency = frequency;
		this.cashCost = cashCost;
		this.energyCost = energyCost;
	}

	public Transportationrisks(
			Transports transports,
			String name,
			String description,
			BigDecimal riskFactor,
			BigDecimal frequency,
			String data,
			BigDecimal cashCost,
			Integer energyCost,
			Set<InsurancesHasTransportationrisks> insurancesHasTransportationriskses,
			Set<TurnsHistoryHasTransportationrisks> turnsHistoryHasTransportationriskses) {
		this.transports = transports;
		this.name = name;
		this.description = description;
		this.riskFactor = riskFactor;
		this.frequency = frequency;
		this.data = data;
		this.cashCost = cashCost;
		this.energyCost = energyCost;
		this.insurancesHasTransportationriskses = insurancesHasTransportationriskses;
		this.turnsHistoryHasTransportationriskses = turnsHistoryHasTransportationriskses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idrisks", unique = true, nullable = false)
	public Integer getIdrisks() {
		return this.idrisks;
	}

	public void setIdrisks(Integer idrisks) {
		this.idrisks = idrisks;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "transports_idtransports", nullable = false)
	public Transports getTransports() {
		return this.transports;
	}

	public void setTransports(Transports transports) {
		this.transports = transports;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 2048)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "risk_factor", precision = 10, scale = 5)
	public BigDecimal getRiskFactor() {
		return this.riskFactor;
	}

	public void setRiskFactor(BigDecimal riskFactor) {
		this.riskFactor = riskFactor;
	}

	@Column(name = "frequency", nullable = false, precision = 4)
	public BigDecimal getFrequency() {
		return this.frequency;
	}

	public void setFrequency(BigDecimal frequency) {
		this.frequency = frequency;
	}

	@Column(name = "data", length = 10240)
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transportationrisks")
	@Cascade({ CascadeType.DELETE })
	public Set<InsurancesHasTransportationrisks> getInsurancesHasTransportationriskses() {
		return this.insurancesHasTransportationriskses;
	}

	public void setInsurancesHasTransportationriskses(
			Set<InsurancesHasTransportationrisks> insurancesHasTransportationriskses) {
		this.insurancesHasTransportationriskses = insurancesHasTransportationriskses;
	}

	@Column(name = "cash_cost", nullable = false, precision = 10, scale = 2)
	public BigDecimal getCashCost() {
		return cashCost;
	}

	public void setCashCost(BigDecimal cashCost) {
		this.cashCost = cashCost;
	}

	@Column(name = "energy_cost", nullable = false)
	public Integer getEnergyCost() {
		return energyCost;
	}

	public void setEnergyCost(Integer energyCost) {
		this.energyCost = energyCost;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transportationrisks")
	@Cascade({ CascadeType.DELETE })
	public Set<TurnsHistoryHasTransportationrisks> getTurnsHistoryHasTransportationriskses() {
		return this.turnsHistoryHasTransportationriskses;
	}

	public void setTurnsHistoryHasTransportationriskses(
			Set<TurnsHistoryHasTransportationrisks> turnsHistoryHasTransportationriskses) {
		this.turnsHistoryHasTransportationriskses = turnsHistoryHasTransportationriskses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idrisks == null) ? 0 : idrisks.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transportationrisks other = (Transportationrisks) obj;
		if (idrisks == null) {
			if (other.idrisks != null)
				return false;
		} else if (!idrisks.equals(other.idrisks))
			return false;
		return true;
	}

}
