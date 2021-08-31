package com.axis.octate.request;

import java.util.Date;

public class RequestForAssets {
	
	private String empId;
	
	private String empName;
	
	private String empEmail;
	
	private Date requestCreatedAt;
	
	private boolean laptop;
	
	private boolean mobile;
	
	private boolean tablet;
	
	private String nextId;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public Date getRequestCreatedAt() {
		return requestCreatedAt;
	}

	public void setRequestCreatedAt(Date requestCreatedAt) {
		this.requestCreatedAt = requestCreatedAt;
	}

	public boolean isLaptop() {
		return laptop;
	}

	public void setLaptop(boolean laptop) {
		this.laptop = laptop;
	}

	public boolean isMobile() {
		return mobile;
	}

	public void setMobile(boolean mobile) {
		this.mobile = mobile;
	}

	public boolean isTablet() {
		return tablet;
	}

	public void setTablet(boolean tablet) {
		this.tablet = tablet;
	}

	public String getNextId() {
		return nextId;
	}

	public void setNextId(String nextId) {
		this.nextId = nextId;
	}

	public RequestForAssets() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestForAssets(String empId, String empName, String empEmail, Date requestCreatedAt, boolean laptop,
			boolean mobile, boolean tablet) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.requestCreatedAt = requestCreatedAt;
		this.laptop = laptop;
		this.mobile = mobile;
		this.tablet = tablet;
	}
	
	
	
	

}
