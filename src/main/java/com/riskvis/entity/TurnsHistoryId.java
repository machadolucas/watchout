package com.riskvis.entity;

// Generated Sep 29, 2014 10:02:36 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TurnsHistoryId generated by hbm2java
 */
@Embeddable
public class TurnsHistoryId extends AbstractEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 7354817993125734311L;
	private int playersHasQuestsPlayersIdplayers;
	private int playersHasQuestsQuestsIdquests;
	private int placesHasTransportsPlacesOrigin;
	private int placesHasTransportsTransportation;
	private int placesHasTransportsPlacesDestination;

	public TurnsHistoryId() {
	}

	public TurnsHistoryId(int playersHasQuestsPlayersIdplayers,
			int playersHasQuestsQuestsIdquests,
			int placesHasTransportsPlacesOrigin,
			int placesHasTransportsTransportation,
			int placesHasTransportsPlacesDestination) {
		this.playersHasQuestsPlayersIdplayers = playersHasQuestsPlayersIdplayers;
		this.playersHasQuestsQuestsIdquests = playersHasQuestsQuestsIdquests;
		this.placesHasTransportsPlacesOrigin = placesHasTransportsPlacesOrigin;
		this.placesHasTransportsTransportation = placesHasTransportsTransportation;
		this.placesHasTransportsPlacesDestination = placesHasTransportsPlacesDestination;
	}

	@Column(name = "players_has_quests_players_idplayers", nullable = false)
	public int getPlayersHasQuestsPlayersIdplayers() {
		return this.playersHasQuestsPlayersIdplayers;
	}

	public void setPlayersHasQuestsPlayersIdplayers(
			int playersHasQuestsPlayersIdplayers) {
		this.playersHasQuestsPlayersIdplayers = playersHasQuestsPlayersIdplayers;
	}

	@Column(name = "players_has_quests_quests_idquests", nullable = false)
	public int getPlayersHasQuestsQuestsIdquests() {
		return this.playersHasQuestsQuestsIdquests;
	}

	public void setPlayersHasQuestsQuestsIdquests(
			int playersHasQuestsQuestsIdquests) {
		this.playersHasQuestsQuestsIdquests = playersHasQuestsQuestsIdquests;
	}

	@Column(name = "places_has_transports_places_origin", nullable = false)
	public int getPlacesHasTransportsPlacesOrigin() {
		return this.placesHasTransportsPlacesOrigin;
	}

	public void setPlacesHasTransportsPlacesOrigin(
			int placesHasTransportsPlacesOrigin) {
		this.placesHasTransportsPlacesOrigin = placesHasTransportsPlacesOrigin;
	}

	@Column(name = "places_has_transports_transportation", nullable = false)
	public int getPlacesHasTransportsTransportation() {
		return this.placesHasTransportsTransportation;
	}

	public void setPlacesHasTransportsTransportation(
			int placesHasTransportsTransportation) {
		this.placesHasTransportsTransportation = placesHasTransportsTransportation;
	}

	@Column(name = "places_has_transports_places_destination", nullable = false)
	public int getPlacesHasTransportsPlacesDestination() {
		return this.placesHasTransportsPlacesDestination;
	}

	public void setPlacesHasTransportsPlacesDestination(
			int placesHasTransportsPlacesDestination) {
		this.placesHasTransportsPlacesDestination = placesHasTransportsPlacesDestination;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TurnsHistoryId))
			return false;
		TurnsHistoryId castOther = (TurnsHistoryId) other;

		return (this.getPlayersHasQuestsPlayersIdplayers() == castOther
				.getPlayersHasQuestsPlayersIdplayers())
				&& (this.getPlayersHasQuestsQuestsIdquests() == castOther
						.getPlayersHasQuestsQuestsIdquests())
				&& (this.getPlacesHasTransportsPlacesOrigin() == castOther
						.getPlacesHasTransportsPlacesOrigin())
				&& (this.getPlacesHasTransportsTransportation() == castOther
						.getPlacesHasTransportsTransportation())
				&& (this.getPlacesHasTransportsPlacesDestination() == castOther
						.getPlacesHasTransportsPlacesDestination());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getPlayersHasQuestsPlayersIdplayers();
		result = 37 * result + this.getPlayersHasQuestsQuestsIdquests();
		result = 37 * result + this.getPlacesHasTransportsPlacesOrigin();
		result = 37 * result + this.getPlacesHasTransportsTransportation();
		result = 37 * result + this.getPlacesHasTransportsPlacesDestination();
		return result;
	}

}