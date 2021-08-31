package com.axis.octate.service.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assets_request")
public class Assets {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="assets_request_id")
	private String id;
	
	@Column(name="emp_id")
	private String empId;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name = "emp_email")
	private String empEmailId;
	
	@Column(name="request_created_at")
	private Date requestCreatedAt;
	
	@Column(name="laptop")
	private boolean laptop;
	
	@Column(name="mobile")
	private boolean mobile;
	
	@Column(name="tablet")
	private boolean tablet;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
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

	public Assets() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Assets(String id, String empId, String empName, String empEmailId, Date requestCreatedAt, boolean laptop,
			boolean mobile, boolean tablet) {
		super();
		this.id = id;
		this.empId = empId;
		this.empName = empName;
		this.empEmailId = empEmailId;
		this.requestCreatedAt = requestCreatedAt;
		this.laptop = laptop;
		this.mobile = mobile;
		this.tablet = tablet;
	}


	
	
	

}
