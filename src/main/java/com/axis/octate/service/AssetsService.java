package com.axis.octate.service;

import java.util.List;

import com.axis.octate.request.RequestForAssets;
import com.axis.octate.request.Verification;

import com.axis.octate.service.model.Assets;
import com.axis.octate.service.model.AssetsVerification;

public interface AssetsService {
	
	//public String createRequest(Assets assets);
	
	
	
	public List<Assets> getRequestByemployeeId(String empId);

//	String createRequest(Assets assets, String verifiedByITExecutiveId);

	String createRequest(RequestForAssets requestForAssets);

	String verifyByExecutiveById(String id, Verification verifyByExecutive);
	
	String verifyByManagerById(String id, Verification verifyByManager);
	
	String verifyBySeniorManagerById(String id, Verification verifyBySeniorManager);

	
	//String createRequest(Assets assets);

	//String createRequest(RequestForAssets requestForAssets);
	


}
