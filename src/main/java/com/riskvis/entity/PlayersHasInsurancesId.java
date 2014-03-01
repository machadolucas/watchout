package com.riskvis.entity;

// Generated Sep 29, 2014 10:02:36 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PlayersHasInsurancesId generated by hbm2java
 */
@Deprecated
@Embeddable
public class PlayersHasInsurancesId extends AbstractEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 3493279505018507843L;
	private int playersIdplayers;
	private int insurancesIdinsurances;

	public PlayersHasInsurancesId() {
	}

	public PlayersHasInsurancesId(int playersIdplayers,
			int insurancesIdinsurances) {
		this.playersIdplayers = playersIdplayers;
		this.insurancesIdinsurances = insurancesIdinsurances;
	}

	@Column(name = "players_idplayers", nullable = false)
	public int getPlayersIdplayers() {
		return this.playersIdplayers;
	}

	public void setPlayersIdplayers(int playersIdplayers) {
		this.playersIdplayers = playersIdplayers;
	}

	@Column(name = "insurances_idinsurances", nullable = false)
	public int getInsurancesIdinsurances() {
		return this.insurancesIdinsurances;
	}

	public void setInsurancesIdinsurances(int insurancesIdinsurances) {
		this.insurancesIdinsurances = insurancesIdinsurances;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PlayersHasInsurancesId))
			return false;
		PlayersHasInsurancesId castOther = (PlayersHasInsurancesId) other;

		return (this.getPlayersIdplayers() == castOther.getPlayersIdplayers())
				&& (this.getInsurancesIdinsurances() == castOther
						.getInsurancesIdinsurances());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getPlayersIdplayers();
		result = 37 * result + this.getInsurancesIdinsurances();
		return result;
	}

}