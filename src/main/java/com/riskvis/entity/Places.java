package com.riskvis.entity;

// Generated May 12, 2014 11:45:38 PM by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * Places generated by hbm2java
 */
@Entity
@Table(name = "places", catalog = "test")
public class Places extends AbstractEntity implements java.io.Serializable {

	private static final long serialVersionUID = -4725647973053769828L;

	private Integer idplaces;
	private String name;
	private String location;
	private String description;
	private byte[] photo;
	private String mapCoordinates;
	private Set<PlacesHasTransports> placesHasTransportses = new HashSet<PlacesHasTransports>(
			0);
	private Set<PlacesHasTransports> placesHasDestinationses = new HashSet<PlacesHasTransports>(
			0);
	private Set<PlayersHasQuests> playersHasQuestses = new HashSet<PlayersHasQuests>(
			0);
	private Set<Placesrisks> placesriskses = new HashSet<Placesrisks>(0);
	private Set<PlacesHasTransports> placesHasTransportses_1 = new HashSet<PlacesHasTransports>(
			0);
	private Set<Quests> questsesForDestination = new HashSet<Quests>(0);
	private Set<Quests> questsesForOrigin = new HashSet<Quests>(0);

	public Places() {
	}

	public Places(String name, String location, String mapCoordinates) {
		this.name = name;
		this.location = location;
		this.mapCoordinates = mapCoordinates;
	}

	public Places(String name, String location, String description,
			byte[] photo, String mapCoordinates,
			Set<PlacesHasTransports> placesHasTransportses,
			Set<PlacesHasTransports> placesHasDestinationses,
			Set<PlayersHasQuests> playersHasQuestses,
			Set<Placesrisks> placesriskses,
			Set<PlacesHasTransports> placesHasTransportses_1,
			Set<Quests> questsesForDestination, Set<Quests> questsesForOrigin) {
		this.name = name;
		this.location = location;
		this.description = description;
		this.photo = photo;
		this.mapCoordinates = mapCoordinates;
		this.placesHasTransportses = placesHasTransportses;
		this.placesHasDestinationses = placesHasDestinationses;
		this.playersHasQuestses = playersHasQuestses;
		this.placesriskses = placesriskses;
		this.placesHasTransportses_1 = placesHasTransportses_1;
		this.questsesForDestination = questsesForDestination;
		this.questsesForOrigin = questsesForOrigin;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idplaces", unique = true, nullable = false)
	public Integer getIdplaces() {
		return this.idplaces;
	}

	public void setIdplaces(Integer idplaces) {
		this.idplaces = idplaces;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "location", nullable = false, length = 45)
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "description", length = 2048)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "photo")
	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Column(name = "map_coordinates", nullable = false, length = 45)
	public String getMapCoordinates() {
		return this.mapCoordinates;
	}

	public void setMapCoordinates(String mapCoordinates) {
		this.mapCoordinates = mapCoordinates;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "places")
	@Cascade({ CascadeType.DELETE })
	public Set<PlacesHasTransports> getPlacesHasTransportses() {
		return this.placesHasTransportses;
	}

	public void setPlacesHasTransportses(
			Set<PlacesHasTransports> placesHasTransportses) {
		this.placesHasTransportses = placesHasTransportses;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "destination")
	@Cascade({ CascadeType.DELETE })
	public Set<PlacesHasTransports> getPlacesHasDestinationses() {
		return this.placesHasDestinationses;
	}

	public void setPlacesHasDestinationses(
			Set<PlacesHasTransports> placesHasDestinationses) {
		this.placesHasDestinationses = placesHasDestinationses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "places")
	@Cascade({ CascadeType.DELETE })
	public Set<PlayersHasQuests> getPlayersHasQuestses() {
		return this.playersHasQuestses;
	}

	public void setPlayersHasQuestses(Set<PlayersHasQuests> playersHasQuestses) {
		this.playersHasQuestses = playersHasQuestses;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "places")
	@Cascade({ CascadeType.DELETE })
	public Set<Placesrisks> getPlacesriskses() {
		return this.placesriskses;
	}

	public void setPlacesriskses(Set<Placesrisks> placesriskses) {
		this.placesriskses = placesriskses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "places")
	@Cascade({ CascadeType.DELETE })
	public Set<PlacesHasTransports> getPlacesHasTransportses_1() {
		return this.placesHasTransportses_1;
	}

	public void setPlacesHasTransportses_1(
			Set<PlacesHasTransports> placesHasTransportses_1) {
		this.placesHasTransportses_1 = placesHasTransportses_1;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "placesByDestination")
	@Cascade({ CascadeType.DELETE })
	public Set<Quests> getQuestsesForDestination() {
		return this.questsesForDestination;
	}

	public void setQuestsesForDestination(Set<Quests> questsesForDestination) {
		this.questsesForDestination = questsesForDestination;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "placesByOrigin")
	@Cascade({ CascadeType.DELETE })
	public Set<Quests> getQuestsesForOrigin() {
		return this.questsesForOrigin;
	}

	public void setQuestsesForOrigin(Set<Quests> questsesForOrigin) {
		this.questsesForOrigin = questsesForOrigin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idplaces == null) ? 0 : idplaces.hashCode());
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
		Places other = (Places) obj;
		if (idplaces == null) {
			if (other.idplaces != null)
				return false;
		} else if (!idplaces.equals(other.idplaces))
			return false;
		return true;
	}

}