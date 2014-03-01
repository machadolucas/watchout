package com.riskvis.entity;

// Generated May 12, 2014 11:45:38 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * PlacesHasTransports generated by hbm2java
 */
@Entity
@Table(name = "places_has_transports", catalog = "test")
public class PlacesHasTransports extends AbstractEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -4476789021633366831L;
	private PlacesHasTransportsId id;
	private Places places;
	private Places destination;
	private Transports transports;
	private BigDecimal moneyCost;
	private Set<TurnsHistory> turnsHistories = new HashSet<TurnsHistory>(0);

	public PlacesHasTransports() {
	}

	public PlacesHasTransports(PlacesHasTransportsId id, Places places,
			Transports transports, Places destination, BigDecimal moneyCost) {
		this.id = id;
		this.places = places;
		this.transports = transports;
		this.destination = destination;
		this.moneyCost = moneyCost;
	}

	public PlacesHasTransports(PlacesHasTransportsId id, Places places,
			Transports transports, Places destination, BigDecimal moneyCost,
			Set<TurnsHistory> turnsHistories) {
		this.id = id;
		this.places = places;
		this.transports = transports;
		this.moneyCost = moneyCost;
		this.destination = destination;
		this.turnsHistories = turnsHistories;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "placesOrigin", column = @Column(name = "places_origin", nullable = false)),
			@AttributeOverride(name = "transportation", column = @Column(name = "transportation", nullable = false)),
			@AttributeOverride(name = "placesDestination", column = @Column(name = "places_destination", nullable = false)) })
	public PlacesHasTransportsId getId() {
		return this.id;
	}

	public void setId(PlacesHasTransportsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "places_origin", nullable = false, insertable = false, updatable = false)
	public Places getPlaces() {
		return this.places;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "places_destination", nullable = false, insertable = false, updatable = false)
	public Places getDestination() {
		return destination;
	}

	public void setDestination(Places destination) {
		this.destination = destination;
	}

	public void setPlaces(Places places) {
		this.places = places;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "transportation", nullable = false, insertable = false, updatable = false)
	public Transports getTransports() {
		return this.transports;
	}

	public void setTransports(Transports transports) {
		this.transports = transports;
	}

	@Column(name = "money_cost", nullable = false, precision = 10)
	public BigDecimal getMoneyCost() {
		return this.moneyCost;
	}

	public void setMoneyCost(BigDecimal moneyCost) {
		this.moneyCost = moneyCost;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "placesHasTransports")
	@Cascade({ CascadeType.DELETE })
	public Set<TurnsHistory> getTurnsHistories() {
		return this.turnsHistories;
	}

	public void setTurnsHistories(Set<TurnsHistory> turnsHistories) {
		this.turnsHistories = turnsHistories;
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
		PlacesHasTransports other = (PlacesHasTransports) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	private int randomDifferenciator;

	@Transient
	public int getRandomDifferenciator() {
		return this.randomDifferenciator;
	}

	public void setRandomDifferenciator(int i) {
		this.randomDifferenciator = i;
	}

}
