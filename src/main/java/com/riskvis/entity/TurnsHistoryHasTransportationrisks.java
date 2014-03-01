package com.riskvis.entity;

// Generated Sep 29, 2014 10:02:36 PM by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TurnsHistoryHasTransportationrisks generated by hbm2java
 */
@Entity
@Table(name = "turns_history_has_transportationrisks", catalog = "test")
public class TurnsHistoryHasTransportationrisks extends AbstractEntity
		implements java.io.Serializable {

	private static final long serialVersionUID = -8441095792075142156L;
	private TurnsHistoryHasTransportationrisksId id;
	private Transportationrisks transportationrisks;
	private TurnsHistory turnsHistory;

	public TurnsHistoryHasTransportationrisks() {
	}

	public TurnsHistoryHasTransportationrisks(
			TurnsHistoryHasTransportationrisksId id,
			Transportationrisks transportationrisks, TurnsHistory turnsHistory) {
		this.id = id;
		this.transportationrisks = transportationrisks;
		this.turnsHistory = turnsHistory;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "turnsHistoryPlayersHasQuestsPlayersIdplayers", column = @Column(name = "turns_history_players_has_quests_players_idplayers", nullable = false)),
			@AttributeOverride(name = "turnsHistoryPlayersHasQuestsQuestsIdquests", column = @Column(name = "turns_history_players_has_quests_quests_idquests", nullable = false)),
			@AttributeOverride(name = "turnsHistoryPlacesHasTransportsPlacesOrigin", column = @Column(name = "turns_history_places_has_transports_places_origin", nullable = false)),
			@AttributeOverride(name = "turnsHistoryPlacesHasTransportsTransportation", column = @Column(name = "turns_history_places_has_transports_transportation", nullable = false)),
			@AttributeOverride(name = "turnsHistoryPlacesHasTransportsPlacesDestination", column = @Column(name = "turns_history_places_has_transports_places_destination", nullable = false)),
			@AttributeOverride(name = "transportationrisksIdrisks", column = @Column(name = "transportationrisks_idrisks", nullable = false)) })
	public TurnsHistoryHasTransportationrisksId getId() {
		return this.id;
	}

	public void setId(TurnsHistoryHasTransportationrisksId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transportationrisks_idrisks", nullable = false, insertable = false, updatable = false)
	public Transportationrisks getTransportationrisks() {
		return this.transportationrisks;
	}

	public void setTransportationrisks(Transportationrisks transportationrisks) {
		this.transportationrisks = transportationrisks;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "turns_history_players_has_quests_players_idplayers", referencedColumnName = "players_has_quests_players_idplayers", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "turns_history_players_has_quests_quests_idquests", referencedColumnName = "players_has_quests_quests_idquests", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "turns_history_places_has_transports_places_origin", referencedColumnName = "places_has_transports_places_origin", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "turns_history_places_has_transports_transportation", referencedColumnName = "places_has_transports_transportation", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "turns_history_places_has_transports_places_destination", referencedColumnName = "places_has_transports_places_destination", nullable = false, insertable = false, updatable = false) })
	public TurnsHistory getTurnsHistory() {
		return this.turnsHistory;
	}

	public void setTurnsHistory(TurnsHistory turnsHistory) {
		this.turnsHistory = turnsHistory;
	}

}
