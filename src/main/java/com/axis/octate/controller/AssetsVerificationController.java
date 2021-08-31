package com.axis.octate.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.axis.octate.constant.PermissionURLConstants;
import com.axis.octate.jwt.JwtAuthTokenFilter;
import com.axis.octate.request.EmailRequestDto;
import com.axis.octate.request.Verification;
import com.axis.octate.service.AssetsServiceImpl;

@RestController
@RequestMapping("/api/assets")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AssetsVerificationController {
	
	@Autowired
	AssetsServiceImpl assetsService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/verifybyexecutive/{assets_verification_id}")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ASSETS_API_SERVICE + "','" + PermissionURLConstants.EDIT
   			+ "')")
	public ResponseEntity<String> verifyByExecutive(@PathVariable("assets_verification_id") String id,@RequestBody Verification verifyByExecutive){
		return new ResponseEntity<String>(assetsService.verifyByExecutiveById(id, verifyByExecutive),HttpStatus.OK);
	}
	
	@PostMapping("/verifybymanager/{assets_verification_id}")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ASSETS_API_SERVICE + "','" + PermissionURLConstants.EDIT
   			+ "')")
	public ResponseEntity<String> verifyByManager(@PathVariable("assets_verification_id") String id,@RequestBody Verification verifyByManager){
		return new ResponseEntity<String>(assetsService.verifyByExecutiveById(id, verifyByManager),HttpStatus.OK);
	}
	
	@PostMapping("/verifybySeniorManager/{assets_verification_id}")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ASSETS_API_SERVICE + "','" + PermissionURLConstants.EDIT
   			+ "')")
	public ResponseEntity<String> verifyBySeniorManager(@PathVariable("assets_verification_id") String id,@RequestBody Verification verifyBySeniorManager){
		return new ResponseEntity<String>(assetsService.verifyByExecutiveById(id, verifyBySeniorManager),HttpStatus.OK);
	}
	
	
	@PostMapping("/edit/deny/email")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ASSETS_API_SERVICE + "','" + PermissionURLConstants.ADD + "')")
	public String sendEmail(@Valid @RequestBody EmailRequestDto emailRequestDto) {

		
		emailRequestDto.setSubject("Orchestration - Assets Confirmation");
		emailRequestDto.setBody("Assets Request is deny" );
	
		
		HttpHeaders headers = new HttpHeaders();
		

		headers.setBearerAuth(JwtAuthTokenFilter.jwt.toString());
		headers.setAccept(Arrays.asList(org.springframework.http.MediaType.APPLICATION_JSON));
		HttpEntity<EmailRequestDto> entity = new HttpEntity<EmailRequestDto>(emailRequestDto, headers);

		ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8082/api/access/hr/email",
				HttpMethod.POST, entity, String.class);
		
		return responseEntity.getBody();
	}
	
	

}
