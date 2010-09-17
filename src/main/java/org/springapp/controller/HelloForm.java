package org.springapp.controller;


public class HelloForm {
	
	private String firstname = "";
	private String lastname = "";
	private Integer id = -1;
	private boolean active = false;
	
	public HelloForm() {
		
	}

	public HelloForm(String first, String last, Integer id, boolean active) {
		this.firstname = first;
		this.lastname = last;
		this.id = id;
		this.active = active;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean getActive() {
		return this.active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
}