package com.axis.octate.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.octate.repository.AssetsRepository;
import com.axis.octate.repository.AssetsVerificationRepository;
import com.axis.octate.request.RequestForAssets;
import com.axis.octate.request.Verification;
import com.axis.octate.service.model.Assets;
import com.axis.octate.service.model.AssetsVerification;

@Service
public class AssetsServiceImpl implements AssetsService {
	
	@Autowired
	AssetsRepository assetsRepository;
	
	@Autowired 
	AssetsVerificationRepository assetsVerification;

	
	
	@Override
	public String createRequest(RequestForAssets requestForAssets) {
		Date date = new Date();
	
		
		Assets assets = new Assets();
		assets.setEmpId(requestForAssets.getEmpId());
		assets.setEmpName(requestForAssets.getEmpName());
		assets.setEmpEmailId(requestForAssets.getEmpEmail());
		assets.setLaptop(requestForAssets.isLaptop());
		assets.setMobile(requestForAssets.isMobile());
		assets.setTablet(requestForAssets.isTablet());
		assets.setRequestCreatedAt(date);
		
		
		Assets request=assetsRepository.save(assets);
		
		AssetsVerification verify = new AssetsVerification();
		verify.setAssets_request_id(request.getId());
		verify.setVerifiedByITExecutiveId(requestForAssets.getNextId());
		
		
		assetsVerification.save(verify);
		
		return "Request is generated";
	}

	

	@Override
	public String verifyByExecutiveById(String id,Verification verifyByExecutive) {
		// TODO Auto-generated method stub
		Optional<AssetsVerification> data=assetsVerification.findById(id);
		
		if(data.isPresent()) {
			AssetsVerification verify = new AssetsVerification(data.get().getAssets_verification_id(),data.get().getAssets_request_id(),
										data.get().getVerifiedByITExecutiveId(),verifyByExecutive.getName(),verifyByExecutive.getEmail(),
										verifyByExecutive.getConfirmation(),verifyByExecutive.getNextId()
					
					
					);
			
			assetsVerification.save(verify);
		}
		
		
		return "verified by It Executive";
	}




	@Override
	public String verifyByManagerById(String id, Verification verifyByManager) {
		// TODO Auto-generated method stub
Optional<AssetsVerification> data=assetsVerification.findById(id);
		
		if(data.isPresent()) {
			AssetsVerification verify = new AssetsVerification(data.get().getAssets_verification_id(),data.get().getAssets_request_id(),
										data.get().getVerifiedByITExecutiveId(),data.get().getExecutiveName(),data.get().getExecutiveEmail(),
										data.get().getExecutiveConfirmation(),data.get().getVerifiesbyITManagerId(),verifyByManager.getName(),
										verifyByManager.getEmail(),verifyByManager.getConfirmation(),verifyByManager.getNextId()
					
					
					);
			
			assetsVerification.save(verify);
		}
		
		
		return "verified by It Manager";
	}
	
	
	

	@Override
	public String verifyBySeniorManagerById(String id, Verification verifyBySeniorManager) {
		
Optional<AssetsVerification> data=assetsVerification.findById(id);
		
		if(data.isPresent()) {
			AssetsVerification verify = new AssetsVerification(data.get().getAssets_verification_id(),data.get().getAssets_request_id(),
										data.get().getVerifiedByITExecutiveId(),data.get().getExecutiveName(),data.get().getExecutiveEmail(),
										data.get().getExecutiveConfirmation(),data.get().getVerifiesbyITManagerId(),data.get().getManagerName(),
										data.get().getManagerEmail(),data.get().getManagerConfirmation(),data.get().getSeniorManagerId(),
										verifyBySeniorManager.getName(),verifyBySeniorManager.getEmail(),verifyBySeniorManager.getConfirmation()
					
					
					);
			
			assetsVerification.save(verify);
		}
		
		
		return "verified by It Manager";
	}
	
	@Override
	public List<Assets> getRequestByemployeeId(String emp_id) {
		// TODO Auto-generated method stub
		return assetsRepository.findRequestByEmpId(emp_id);
	}



	


}
