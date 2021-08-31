package com.axis.octate.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assets_verification")
public class AssetsVerification {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="assets_verification_id")
	private String assets_verification_id;
	
	@Column(name="assets_request_id")
	private String assets_request_id;
	
	@Column(name="IT_Executive_id")
	private String verifiedByITExecutiveId;
	
	@Column(name = "executive_name")
	private String executiveName;
	
	@Column(name = "executive_email")
	private String executiveEmail;
	
	@Column(name = "executive_confirmation")
	private String executiveConfirmation;
	
	@Column(name="IT_manager_id")
	private String verifiesbyITManagerId;
	
	@Column(name = "manager_name")
	private String managerName;
	
	@Column(name = "manager_email")
	private String managerEmail;
	
	@Column(name = "manager_confirmation")
	private String managerConfirmation;
	
	@Column(name = "IT_senior_manager_Id")
	private String seniorManagerId;
	
	@Column(name = "senior_manager_name")
	private String seniorManagerEmail;
	
	@Column(name = "senior_manager_email")
	private String seniorManagerName;
	
	@Column(name = "senior_manager_confirmation")
	private String seniorManagerConfirmation;

	public String getAssets_verification_id() {
		return assets_verification_id;
	}

	public void setAssets_verification_id(String assets_verification_id) {
		this.assets_verification_id = assets_verification_id;
	}

	public String getAssets_request_id() {
		return assets_request_id;
	}

	public void setAssets_request_id(String assets_request_id) {
		this.assets_request_id = assets_request_id;
	}

	public String getVerifiedByITExecutiveId() {
		return verifiedByITExecutiveId;
	}

	public void setVerifiedByITExecutiveId(String verifiedByITExecutiveId) {
		this.verifiedByITExecutiveId = verifiedByITExecutiveId;
	}

	public String getExecutiveName() {
		return executiveName;
	}

	public void setExecutiveName(String executiveName) {
		this.executiveName = executiveName;
	}

	public String getExecutiveEmail() {
		return executiveEmail;
	}

	public void setExecutiveEmail(String executiveEmail) {
		this.executiveEmail = executiveEmail;
	}

	public String getExecutiveConfirmation() {
		return executiveConfirmation;
	}

	public void setExecutiveConfirmation(String executiveConfirmation) {
		this.executiveConfirmation = executiveConfirmation;
	}

	public String getVerifiesbyITManagerId() {
		return verifiesbyITManagerId;
	}

	public void setVerifiesbyITManagerId(String verifiesbyITManagerId) {
		this.verifiesbyITManagerId = verifiesbyITManagerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public String getManagerConfirmation() {
		return managerConfirmation;
	}

	public void setManagerConfirmation(String managerConfirmation) {
		this.managerConfirmation = managerConfirmation;
	}

	public String getSeniorManagerId() {
		return seniorManagerId;
	}

	public void setSeniorManagerId(String seniorManagerId) {
		this.seniorManagerId = seniorManagerId;
	}

	public String getSeniorManagerEmail() {
		return seniorManagerEmail;
	}

	public void setSeniorManagerEmail(String seniorManagerEmail) {
		this.seniorManagerEmail = seniorManagerEmail;
	}

	public String getSeniorManagerName() {
		return seniorManagerName;
	}

	public void setSeniorManagerName(String seniorManagerName) {
		this.seniorManagerName = seniorManagerName;
	}

	public String getSeniorManagerConfirmation() {
		return seniorManagerConfirmation;
	}

	public void setSeniorManagerConfirmation(String seniorManagerConfirmation) {
		this.seniorManagerConfirmation = seniorManagerConfirmation;
	}

	public AssetsVerification(String assets_verification_id, String assets_request_id, String verifiedByITExecutiveId,
			String executiveName, String executiveEmail, String executiveConfirmation, String verifiesbyITManagerId,
			String managerName, String managerEmail, String managerConfirmation, String seniorManagerId,
			String seniorManagerEmail, String seniorManagerName, String seniorManagerConfirmation) {
		super();
		this.assets_verification_id = assets_verification_id;
		this.assets_request_id = assets_request_id;
		this.verifiedByITExecutiveId = verifiedByITExecutiveId;
		this.executiveName = executiveName;
		this.executiveEmail = executiveEmail;
		this.executiveConfirmation = executiveConfirmation;
		this.verifiesbyITManagerId = verifiesbyITManagerId;
		this.managerName = managerName;
		this.managerEmail = managerEmail;
		this.managerConfirmation = managerConfirmation;
		this.seniorManagerId = seniorManagerId;
		this.seniorManagerEmail = seniorManagerEmail;
		this.seniorManagerName = seniorManagerName;
		this.seniorManagerConfirmation = seniorManagerConfirmation;
	}

	public AssetsVerification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssetsVerification(String assets_verification_id, String assets_request_id, String verifiedByITExecutiveId,
			String executiveName, String executiveEmail, String executiveConfirmation, String verifiesbyITManagerId) {
		super();
		this.assets_verification_id = assets_verification_id;
		this.assets_request_id = assets_request_id;
		this.verifiedByITExecutiveId = verifiedByITExecutiveId;
		this.executiveName = executiveName;
		this.executiveEmail = executiveEmail;
		this.executiveConfirmation = executiveConfirmation;
		this.verifiesbyITManagerId = verifiesbyITManagerId;
	}

	public AssetsVerification(String assets_verification_id, String assets_request_id, String verifiedByITExecutiveId,
			String executiveName, String executiveEmail, String executiveConfirmation, String verifiesbyITManagerId,
			String managerName, String managerEmail, String managerConfirmation, String seniorManagerId) {
		super();
		this.assets_verification_id = assets_verification_id;
		this.assets_request_id = assets_request_id;
		this.verifiedByITExecutiveId = verifiedByITExecutiveId;
		this.executiveName = executiveName;
		this.executiveEmail = executiveEmail;
		this.executiveConfirmation = executiveConfirmation;
		this.verifiesbyITManagerId = verifiesbyITManagerId;
		this.managerName = managerName;
		this.managerEmail = managerEmail;
		this.managerConfirmation = managerConfirmation;
		this.seniorManagerId = seniorManagerId;
	}
	
	
	
	

	

	


	
	
	
}
