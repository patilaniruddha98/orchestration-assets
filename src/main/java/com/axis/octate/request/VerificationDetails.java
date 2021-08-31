package com.axis.octate.request;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class VerificationDetails {

	private String assets_verification_id;

	private String verifiedByITExecutiveId;
	

	private String executiveName;
	

	private String executiveEmail;
	

	private String verifiesbyITManagerId;
	
	
	private String managerName;
	
	
	private String managerEmail;


	public String getAssets_verification_id() {
		return assets_verification_id;
	}


	public void setAssets_verification_id(String assets_verification_id) {
		this.assets_verification_id = assets_verification_id;
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

}
