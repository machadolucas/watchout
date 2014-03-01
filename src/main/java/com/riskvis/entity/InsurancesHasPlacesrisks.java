package com.riskvis.entity;

// Generated May 12, 2014 11:45:38 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * InsurancesHasPlacesrisks generated by hbm2java
 */
@Entity
@Table(name = "insurances_has_placesrisks", catalog = "test")
public class InsurancesHasPlacesrisks extends AbstractEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -8187684018477702571L;
	private InsurancesHasPlacesrisksId id;
	private Insurances insurances;
	private Placesrisks placesrisks;
	private BigDecimal cover;

	public InsurancesHasPlacesrisks() {
	}

	public InsurancesHasPlacesrisks(InsurancesHasPlacesrisksId id,
			Insurances insurances, Placesrisks placesrisks, BigDecimal cover) {
		this.id = id;
		this.insurances = insurances;
		this.placesrisks = placesrisks;
		this.cover = cover;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "insurancesIdinsurances", column = @Column(name = "insurances_idinsurances", nullable = false)),
			@AttributeOverride(name = "placesrisksIdrisks", column = @Column(name = "placesrisks_idrisks", nullable = false)) })
	public InsurancesHasPlacesrisksId getId() {
		return this.id;
	}

	public void setId(InsurancesHasPlacesrisksId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "insurances_idinsurances", nullable = false, insertable = false, updatable = false)
	public Insurances getInsurances() {
		return this.insurances;
	}

	public void setInsurances(Insurances insurances) {
		this.insurances = insurances;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "placesrisks_idrisks", nullable = false, insertable = false, updatable = false)
	public Placesrisks getPlacesrisks() {
		return this.placesrisks;
	}

	public void setPlacesrisks(Placesrisks placesrisks) {
		this.placesrisks = placesrisks;
	}

	@Column(name = "cover", nullable = false, precision = 10)
	public BigDecimal getCover() {
		return this.cover;
	}

	public void setCover(BigDecimal cover) {
		this.cover = cover;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		InsurancesHasPlacesrisks other = (InsurancesHasPlacesrisks) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
