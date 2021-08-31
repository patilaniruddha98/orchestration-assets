package com.axis.octate.controller;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.octate.constant.PermissionURLConstants;
import com.axis.octate.request.CompleteDetails;
import com.axis.octate.service.AssetsServiceImpl;
import com.axis.octate.service.model.Assets;

@RestController
@RequestMapping("/api/assets")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AssetsController {
	
	@Autowired
	AssetsServiceImpl assetsService;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	CompleteDetails data1;
	
	
	
	@GetMapping("/allrequests")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ASSETS_API_SERVICE + "','" + PermissionURLConstants.VIEW
	   			+ "')")
	public List<CompleteDetails> getAllRequest(){
		
		List<CompleteDetails> list = jdbcTemplate.query("select assets_request.assets_request_id,assets_request.emp_id,\r\n"
				+ "assets_request.emp_name,assets_request.emp_email,assets_request.request_created_at,\r\n"
				+ "assets_request.laptop,assets_request.mobile,assets_request.tablet,\r\n"
				+ "assets_verification.assets_verification_id,assets_verification.IT_Executive_id,\r\n"
				+ "assets_verification.executive_name,assets_verification.executive_email,assets_verification.executive_confirmation,\r\n"
				+ "assets_verification.IT_manager_id, assets_verification.manager_name,\r\n"
				+ "assets_verification.manager_email,assets_verification.manager_confirmation,assets_verification.IT_senior_manager_Id,\r\n"
				+ "assets_verification.senior_manager_name,assets_verification.senior_manager_email ,assets_verification.senior_manager_confirmation\r\n"
				+ "from assets_request \r\n"
				+ "inner join assets_verification on assets_request.assets_request_id = assets_verification.assets_request_id"
				,  (ResultSet rs, int rowNum) -> {
					CompleteDetails data = new CompleteDetails();
					data.setId(rs.getString("assets_request_id"));
					data.setEmpId(rs.getString("emp_id"));
					data.setEmpName(rs.getString("emp_name"));
					data.setEmpEmailId(rs.getString("emp_email"));
					data.setRequestCreatedAt(rs.getDate("request_created_at"));
					data.setLaptop(rs.getBoolean("laptop"));
					data.setMobile(rs.getBoolean("mobile"));
					data.setTablet(rs.getBoolean("tablet"));
					data.setAssets_verification_id(rs.getString("assets_verification_id"));
					data.setVerifiedByITExecutiveId(rs.getString("IT_Executive_id"));
					data.setExecutiveName(rs.getString("executive_name"));
					data.setExecutiveEmail(rs.getString("executive_email"));
					data.setExecutiveConfirmation(rs.getString("executive_confirmation"));
					data.setVerifiesbyITManagerId(rs.getString("IT_manager_id"));
					data.setManagerName(rs.getString("manager_name"));
					data.setManagerEmail(rs.getString("manager_email"));
					data.setManagerConfirmation(rs.getString("manager_confirmation"));
					data.setSeniorManagerId(rs.getString("IT_senior_manager_Id"));
					data.setSeniorManagerName(rs.getString("senior_manager_name"));
					data.setSeniorManagerEmail(rs.getString("senior_manager_email"));
					data.setSeniorManagerConfirmation(rs.getString("senior_manager_confirmation"));
					return data;
				
				});
				
		return list;

	}
	
	@GetMapping("/getRequest/{assets_request_id}")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ASSETS_API_SERVICE + "','" + PermissionURLConstants.VIEW
	   			+ "')")
	public CompleteDetails getRequestById(@PathVariable("assets_request_id") String id) {
		
		List<CompleteDetails> list = jdbcTemplate.query("select assets_request.assets_request_id,assets_request.emp_id,\r\n"
				+ "assets_request.emp_name,assets_request.emp_email,assets_request.request_created_at,\r\n"
				+ "assets_request.laptop,assets_request.mobile,assets_request.tablet,\r\n"
				+ "assets_verification.assets_verification_id,assets_verification.IT_Executive_id,\r\n"
				+ "assets_verification.executive_name,assets_verification.executive_email,assets_verification.executive_confirmation,\r\n"
				+ "assets_verification.IT_manager_id, assets_verification.manager_name,\r\n"
				+ "assets_verification.manager_email,assets_verification.manager_confirmation,assets_verification.IT_senior_manager_Id,\r\n"
				+ "assets_verification.senior_manager_name,assets_verification.senior_manager_email ,assets_verification.senior_manager_confirmation\r\n"
				+ "from assets_request \r\n"
				+ "inner join assets_verification on assets_request.assets_request_id = assets_verification.assets_request_id where  assets_request.assets_request_id = ?"
				
				,  new String[] {id}
				,  (ResultSet rs, int rowNum) -> {
					data1 = new CompleteDetails();
					data1.setId(rs.getString("assets_request_id"));
					data1.setEmpId(rs.getString("emp_id"));
					data1.setEmpName(rs.getString("emp_name"));
					data1.setEmpEmailId(rs.getString("emp_email"));
					data1.setRequestCreatedAt(rs.getDate("request_created_at"));
					data1.setLaptop(rs.getBoolean("laptop"));
					data1.setMobile(rs.getBoolean("mobile"));
					data1.setTablet(rs.getBoolean("tablet"));
					data1.setAssets_verification_id(rs.getString("assets_verification_id"));
					data1.setVerifiedByITExecutiveId(rs.getString("IT_Executive_id"));
					data1.setExecutiveName(rs.getString("executive_name"));
					data1.setExecutiveEmail(rs.getString("executive_email"));
					data1.setExecutiveConfirmation(rs.getString("executive_confirmation"));
					data1.setVerifiesbyITManagerId(rs.getString("IT_manager_id"));
					data1.setManagerName(rs.getString("manager_name"));
					data1.setManagerEmail(rs.getString("manager_email"));
					data1.setManagerConfirmation(rs.getString("manager_confirmation"));
					data1.setSeniorManagerId(rs.getString("IT_senior_manager_Id"));
					data1.setSeniorManagerName(rs.getString("senior_manager_name"));
					data1.setSeniorManagerEmail(rs.getString("senior_manager_email"));
					data1.setSeniorManagerConfirmation(rs.getString("senior_manager_confirmation"));
					return data1;
				
				});
		
		return data1;
		
	}
	
	
	@GetMapping("/requests/{emp_id}")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ASSETS_API_SERVICE + "','" + PermissionURLConstants.VIEW
   			+ "')")
	public List<CompleteDetails> getAllRequestByEmpId(@PathVariable("emp_id") String emp_id){
		List<CompleteDetails> list = jdbcTemplate.query("select assets_request.assets_request_id,assets_request.emp_id,\r\n"
				+ "assets_request.emp_name,assets_request.emp_email,assets_request.request_created_at,\r\n"
				+ "assets_request.laptop,assets_request.mobile,assets_request.tablet,\r\n"
				+ "assets_verification.assets_verification_id,assets_verification.IT_Executive_id,\r\n"
				+ "assets_verification.executive_name,assets_verification.executive_email,assets_verification.executive_confirmation,\r\n"
				+ "assets_verification.IT_manager_id, assets_verification.manager_name,\r\n"
				+ "assets_verification.manager_email,assets_verification.manager_confirmation,assets_verification.IT_senior_manager_Id,\r\n"
				+ "assets_verification.senior_manager_name,assets_verification.senior_manager_email ,assets_verification.senior_manager_confirmation\r\n"
				+ "from assets_request \r\n"
				+ "inner join assets_verification on assets_request.assets_request_id = assets_verification.assets_request_id where assets_request.emp_id=?"
				
				,  new String[] {emp_id}
				,  (ResultSet rs, int rowNum) -> {
					CompleteDetails data = new CompleteDetails();
					data.setId(rs.getString("assets_request_id"));
					data.setEmpId(rs.getString("emp_id"));
					data.setEmpName(rs.getString("emp_name"));
					data.setEmpEmailId(rs.getString("emp_email"));
					data.setRequestCreatedAt(rs.getDate("request_created_at"));
					data.setLaptop(rs.getBoolean("laptop"));
					data.setMobile(rs.getBoolean("mobile"));
					data.setTablet(rs.getBoolean("tablet"));
					data.setAssets_verification_id(rs.getString("assets_verification_id"));
					data.setVerifiedByITExecutiveId(rs.getString("IT_Executive_id"));
					data.setExecutiveName(rs.getString("executive_name"));
					data.setExecutiveEmail(rs.getString("executive_email"));
					data.setExecutiveConfirmation(rs.getString("executive_confirmation"));
					data.setVerifiesbyITManagerId(rs.getString("IT_manager_id"));
					data.setManagerName(rs.getString("manager_name"));
					data.setManagerEmail(rs.getString("manager_email"));
					data.setManagerConfirmation(rs.getString("manager_confirmation"));
					data.setSeniorManagerId(rs.getString("IT_senior_manager_Id"));
					data.setSeniorManagerName(rs.getString("senior_manager_name"));
					data.setSeniorManagerEmail(rs.getString("senior_manager_email"));
					data.setSeniorManagerConfirmation(rs.getString("senior_manager_confirmation"));
					return data;
				
				});
		return list;
	}
	
	
	@GetMapping("/executiveVerificaton/{IT_Executive_id}")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ASSETS_API_SERVICE + "','" + PermissionURLConstants.VIEW
   			+ "')")
	public List<CompleteDetails> executiveVerification(@PathVariable("IT_Executive_id") String IT_Executive_id ){
		List<CompleteDetails> list = jdbcTemplate.query("select assets_request.assets_request_id,assets_request.emp_id,\r\n"
				+ "assets_request.emp_name,assets_request.emp_email,assets_request.request_created_at,\r\n"
				+ "assets_request.laptop,assets_request.mobile,assets_request.tablet,\r\n"
				+ "assets_verification.assets_verification_id,assets_verification.IT_Executive_id,\r\n"
				+ "assets_verification.executive_name,assets_verification.executive_email,assets_verification.executive_confirmation,\r\n"
				+ "assets_verification.IT_manager_id, assets_verification.manager_name,\r\n"
				+ "assets_verification.manager_email,assets_verification.manager_confirmation,assets_verification.IT_senior_manager_Id,\r\n"
				+ "assets_verification.senior_manager_name,assets_verification.senior_manager_email ,assets_verification.senior_manager_confirmation\r\n"
				+ "from assets_request \r\n"
				+ "inner join assets_verification on assets_request.assets_request_id = assets_verification.assets_request_id where assets_verification.IT_Executive_id=?"
				
				,  new String[] {IT_Executive_id}
				,  (ResultSet rs, int rowNum) -> {
					CompleteDetails data = new CompleteDetails();
					data.setId(rs.getString("assets_request_id"));
					data.setEmpId(rs.getString("emp_id"));
					data.setEmpName(rs.getString("emp_name"));
					data.setEmpEmailId(rs.getString("emp_email"));
					data.setRequestCreatedAt(rs.getDate("request_created_at"));
					data.setLaptop(rs.getBoolean("laptop"));
					data.setMobile(rs.getBoolean("mobile"));
					data.setTablet(rs.getBoolean("tablet"));
					data.setAssets_verification_id(rs.getString("assets_verification_id"));
					data.setVerifiedByITExecutiveId(rs.getString("IT_Executive_id"));
					data.setExecutiveName(rs.getString("executive_name"));
					data.setExecutiveEmail(rs.getString("executive_email"));
					data.setExecutiveConfirmation(rs.getString("executive_confirmation"));
					data.setVerifiesbyITManagerId(rs.getString("IT_manager_id"));
					data.setManagerName(rs.getString("manager_name"));
					data.setManagerEmail(rs.getString("manager_email"));
					data.setManagerConfirmation(rs.getString("manager_confirmation"));
					data.setSeniorManagerId(rs.getString("IT_senior_manager_Id"));
					data.setSeniorManagerName(rs.getString("senior_manager_name"));
					data.setSeniorManagerEmail(rs.getString("senior_manager_email"));
					data.setSeniorManagerConfirmation(rs.getString("senior_manager_confirmation"));
					return data;
				
				});
		return list;
	}
	
	@GetMapping("/managerVerificaton/{IT_Executive_id}")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ASSETS_API_SERVICE + "','" + PermissionURLConstants.VIEW
   			+ "')")
	public List<CompleteDetails> managerVerification(@PathVariable("IT_manager_id") String IT_manager_id ){
		List<CompleteDetails> list = jdbcTemplate.query("select assets_request.assets_request_id,assets_request.emp_id,\r\n"
				+ "assets_request.emp_name,assets_request.emp_email,assets_request.request_created_at,\r\n"
				+ "assets_request.laptop,assets_request.mobile,assets_request.tablet,\r\n"
				+ "assets_verification.assets_verification_id,assets_verification.IT_Executive_id,\r\n"
				+ "assets_verification.executive_name,assets_verification.executive_email,assets_verification.executive_confirmation,\r\n"
				+ "assets_verification.IT_manager_id, assets_verification.manager_name,\r\n"
				+ "assets_verification.manager_email,assets_verification.manager_confirmation,assets_verification.IT_senior_manager_Id,\r\n"
				+ "assets_verification.senior_manager_name,assets_verification.senior_manager_email ,assets_verification.senior_manager_confirmation\r\n"
				+ "from assets_request \r\n"
				+ "inner join assets_verification on assets_request.assets_request_id = assets_verification.assets_request_id where assets_verification.IT_manager_id=?"
				
				,  new String[] {IT_manager_id}
				,  (ResultSet rs, int rowNum) -> {
					CompleteDetails data = new CompleteDetails();
					data.setId(rs.getString("assets_request_id"));
					data.setEmpId(rs.getString("emp_id"));
					data.setEmpName(rs.getString("emp_name"));
					data.setEmpEmailId(rs.getString("emp_email"));
					data.setRequestCreatedAt(rs.getDate("request_created_at"));
					data.setLaptop(rs.getBoolean("laptop"));
					data.setMobile(rs.getBoolean("mobile"));
					data.setTablet(rs.getBoolean("tablet"));
					data.setAssets_verification_id(rs.getString("assets_verification_id"));
					data.setVerifiedByITExecutiveId(rs.getString("IT_Executive_id"));
					data.setExecutiveName(rs.getString("executive_name"));
					data.setExecutiveEmail(rs.getString("executive_email"));
					data.setExecutiveConfirmation(rs.getString("executive_confirmation"));
					data.setVerifiesbyITManagerId(rs.getString("IT_manager_id"));
					data.setManagerName(rs.getString("manager_name"));
					data.setManagerEmail(rs.getString("manager_email"));
					data.setManagerConfirmation(rs.getString("manager_confirmation"));
					data.setSeniorManagerId(rs.getString("IT_senior_manager_Id"));
					data.setSeniorManagerName(rs.getString("senior_manager_name"));
					data.setSeniorManagerEmail(rs.getString("senior_manager_email"));
					data.setSeniorManagerConfirmation(rs.getString("senior_manager_confirmation"));
					return data;
				
				});
		return list;
	}
	
	
	@GetMapping("/seniorManagerVerificaton/{IT_Executive_id}")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ASSETS_API_SERVICE + "','" + PermissionURLConstants.VIEW
   			+ "')")
	public List<CompleteDetails> seniorManagerVerification(@PathVariable("IT_senior_manager_Id") String IT_senior_manager_Id ){
		List<CompleteDetails> list = jdbcTemplate.query("select assets_request.assets_request_id,assets_request.emp_id,\r\n"
				+ "assets_request.emp_name,assets_request.emp_email,assets_request.request_created_at,\r\n"
				+ "assets_request.laptop,assets_request.mobile,assets_request.tablet,\r\n"
				+ "assets_verification.assets_verification_id,assets_verification.IT_Executive_id,\r\n"
				+ "assets_verification.executive_name,assets_verification.executive_email,assets_verification.executive_confirmation,\r\n"
				+ "assets_verification.IT_manager_id, assets_verification.manager_name,\r\n"
				+ "assets_verification.manager_email,assets_verification.manager_confirmation,assets_verification.IT_senior_manager_Id,\r\n"
				+ "assets_verification.senior_manager_name,assets_verification.senior_manager_email ,assets_verification.senior_manager_confirmation\r\n"
				+ "from assets_request \r\n"
				+ "inner join assets_verification on assets_request.assets_request_id = assets_verification.assets_request_id where assets_verification.IT_senior_manager_Id=?"
				
				,  new String[] {IT_senior_manager_Id}
				,  (ResultSet rs, int rowNum) -> {
					CompleteDetails data = new CompleteDetails();
					data.setId(rs.getString("assets_request_id"));
					data.setEmpId(rs.getString("emp_id"));
					data.setEmpName(rs.getString("emp_name"));
					data.setEmpEmailId(rs.getString("emp_email"));
					data.setRequestCreatedAt(rs.getDate("request_created_at"));
					data.setLaptop(rs.getBoolean("laptop"));
					data.setMobile(rs.getBoolean("mobile"));
					data.setTablet(rs.getBoolean("tablet"));
					data.setAssets_verification_id(rs.getString("assets_verification_id"));
					data.setVerifiedByITExecutiveId(rs.getString("IT_Executive_id"));
					data.setExecutiveName(rs.getString("executive_name"));
					data.setExecutiveEmail(rs.getString("executive_email"));
					data.setExecutiveConfirmation(rs.getString("executive_confirmation"));
					data.setVerifiesbyITManagerId(rs.getString("IT_manager_id"));
					data.setManagerName(rs.getString("manager_name"));
					data.setManagerEmail(rs.getString("manager_email"));
					data.setManagerConfirmation(rs.getString("manager_confirmation"));
					data.setSeniorManagerId(rs.getString("IT_senior_manager_Id"));
					data.setSeniorManagerName(rs.getString("senior_manager_name"));
					data.setSeniorManagerEmail(rs.getString("senior_manager_email"));
					data.setSeniorManagerConfirmation(rs.getString("senior_manager_confirmation"));
					return data;
				
				});
		return list;
	}
	
	

	
	
	

}
