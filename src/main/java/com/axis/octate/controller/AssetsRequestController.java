package com.axis.octate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.octate.constant.PermissionURLConstants;
import com.axis.octate.request.RequestForAssets;
import com.axis.octate.service.AssetsServiceImpl;
import com.axis.octate.service.model.Assets;

@RestController
@RequestMapping("/api/assets")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AssetsRequestController {
	
	@Autowired
	AssetsServiceImpl assetsService;
	
	@PostMapping("/request")
	@PreAuthorize("hasPermission('" + PermissionURLConstants.ASSETS_API_SERVICE + "','" + PermissionURLConstants.ADD
	   			+ "')")
	public ResponseEntity<String> setMyRequest(@RequestBody RequestForAssets requestForAssets){
		return new ResponseEntity<String>(assetsService.createRequest(requestForAssets),HttpStatus.OK);
	}

}
