package com.axis.octate.request;

public class Verification {
	
	private String id;
	
	private String name;
	
	private String email;
	
	private String confirmation;
	
	private String nextId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	public String getNextId() {
		return nextId;
	}

	public void setNextId(String nextId) {
		this.nextId = nextId;
	}

	public Verification(String id, String name, String email, String confirmation) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.confirmation = confirmation;
	}

	public Verification(String id, String name, String email, String confirmation, String nextId) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.confirmation = confirmation;
		this.nextId = nextId;
	}

	public Verification() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	

}
