package com.riskvis.entity;

// Generated May 12, 2014 11:45:38 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PlacesHasTransportsId generated by hbm2java
 */
@Embeddable
public class PlacesHasTransportsId extends AbstractEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 6198229985037903415L;
	private int placesOrigin;
	private int transportation;
	private int placesDestination;

	public PlacesHasTransportsId() {
	}

	public PlacesHasTransportsId(int placesOrigin, int transportation,
			int placesDestination) {
		this.placesOrigin = placesOrigin;
		this.transportation = transportation;
		this.placesDestination = placesDestination;
	}

	@Column(name = "places_origin", nullable = false)
	public int getPlacesOrigin() {
		return this.placesOrigin;
	}

	public void setPlacesOrigin(int placesOrigin) {
		this.placesOrigin = placesOrigin;
	}

	@Column(name = "transportation", nullable = false)
	public int getTransportation() {
		return this.transportation;
	}

	public void setTransportation(int transportation) {
		this.transportation = transportation;
	}

	@Column(name = "places_destination", nullable = false)
	public int getPlacesDestination() {
		return this.placesDestination;
	}

	public void setPlacesDestination(int placesDestination) {
		this.placesDestination = placesDestination;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PlacesHasTransportsId))
			return false;
		PlacesHasTransportsId castOther = (PlacesHasTransportsId) other;

		return (this.getPlacesOrigin() == castOther.getPlacesOrigin())
				&& (this.getTransportation() == castOther.getTransportation())
				&& (this.getPlacesDestination() == castOther
						.getPlacesDestination());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getPlacesOrigin();
		result = 37 * result + this.getTransportation();
		result = 37 * result + this.getPlacesDestination();
		return result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[placesOrigin=");
		builder.append(placesOrigin);
		builder.append(", transportation=");
		builder.append(transportation);
		builder.append(", placesDestination=");
		builder.append(placesDestination);
		builder.append("]");
		return builder.toString();
	}

}
