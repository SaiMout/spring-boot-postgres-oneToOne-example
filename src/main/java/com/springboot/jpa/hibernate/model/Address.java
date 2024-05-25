package com.springboot.jpa.hibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int buildingNumber;
	private String streetName;
	private TownShipAndDistrict townshipAndDistrict;
	private StateAndDivision stateAndDivision;

//	  public Address(int buildingNumber, String streetName, TownShipAndDistrict townshipAndDistrict, StateAndDivision stateAndDivision) {
//	    this.buildingNumber = buildingNumber;
//	    this.streetName = streetName;
//	    this.townshipAndDistrict = townshipAndDistrict;
//	    this.stateAndDivision = stateAndDivision;
//	  }
//
//	  public int getBuildingNumber() {
//	    return buildingNumber;
//	  }
//
//	  public String getStreetName() {
//	    return streetName;
//	  }
//
//	  public TownShipAndDistrict getTownshipAndDistrict() {
//	    return townshipAndDistrict;
//	  }
//
//	  public StateAndDivision getStateAndDivision() {
//	    return stateAndDivision;
//	  }

	@Override
	public String toString() {
		return "Address{" + "buildingNumber=" + buildingNumber + ", streetName='" + streetName + '\''
				+ ", townshipAndDistrict=" + townshipAndDistrict + ", stateAndDivision=" + stateAndDivision + '}';
	}
}
