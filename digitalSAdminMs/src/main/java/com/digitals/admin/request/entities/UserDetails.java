package com.digitals.admin.request.entities;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetails {
	@JsonProperty
	private String firstName;
	@JsonProperty
	private String lastName;
	private Date dob;
	@JsonProperty
	private String email;
	@JsonProperty
	private String username;
	@JsonProperty
	private String password;
	@JsonProperty
	private String postcode;
	@JsonProperty
	private String addressLine1;
	@JsonProperty
	private String addressLine2;
	@JsonProperty
	private String city;
	@JsonProperty
	private String country;
	@JsonProperty
	private String contactNumber;
	private String role;
	private Map<String,String> securityQuestions;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Map<String, String> getSecurityQuestions() {
		return securityQuestions;
	}
	public void setSecurityQuestions(Map<String, String> securityQuestions) {
		this.securityQuestions = securityQuestions;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	

	

}
