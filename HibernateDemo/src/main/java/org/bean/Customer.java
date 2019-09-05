package org.bean;

public class Customer {
	private int custId;
	private String firstName;
	private String lastName;
	private String email;
	private Address address;

	public Customer(int custId, String firstName, String lastName, String email) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getCustId() {
		return custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

}
