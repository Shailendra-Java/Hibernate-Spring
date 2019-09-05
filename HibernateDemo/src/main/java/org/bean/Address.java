package org.bean;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String country;

	private String state;
	private String district;

	public Address() {
		super();
	}

	public Address(String country, String state, String district) {
		super();
		this.country = country;
		this.state = state;
		this.district = district;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCountry() {
		return country;
	}

	public String getState() {
		return state;
	}

	public String getDistrict() {
		return district;
	}

}
