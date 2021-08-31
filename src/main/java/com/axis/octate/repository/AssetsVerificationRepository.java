package com.axis.octate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.octate.service.model.AssetsVerification;

@Repository
public interface AssetsVerificationRepository extends JpaRepository<AssetsVerification, String> {
	
	

}
