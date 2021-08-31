package com.axis.octate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.octate.service.model.Assets;
import com.axis.octate.service.model.AssetsVerification;

@Repository
public interface AssetsRepository extends JpaRepository<Assets, String> {
	
	public List<Assets> findRequestByEmpId(String emp_id);

}
