package com.abbvie.cdrp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abbvie.cdrp.dto.AppliedVisitDTO;
import com.abbvie.cdrp.dto.IDRPCheckDTO;
import com.abbvie.cdrp.dto.IDRPPlanDetailDTO;
import com.abbvie.cdrp.service.IDRPCheckService;
import com.abbvie.cdrp.service.LandingPageService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/LandingPageController")
public class LandingPageController {
	
	@Autowired
	private LandingPageService landingPageService;

	@PostMapping("/addIdRPPlanDetail")
	public @ResponseBody ResponseEntity<String> addIdRPPlanDetail(@RequestBody IDRPPlanDetailDTO idrpPlanDetailDTO) throws Exception{
		 log.info("Inside LandingPageController.addIdRPPlanDetail: ");
		 String result = landingPageService.addIdRPPlanDetail(idrpPlanDetailDTO);
		 return ResponseEntity.ok(result);
	 }
	
}
