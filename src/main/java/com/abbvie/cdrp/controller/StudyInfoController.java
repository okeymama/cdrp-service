package com.abbvie.cdrp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.abbvie.cdrp.dto.IDRPPlanDetailDTO;
import com.abbvie.cdrp.dto.StudyInfo;
import com.abbvie.cdrp.dto.StudyInfoDTO;
import com.abbvie.cdrp.dto.StudyInfoTeslaDTO;
import com.abbvie.cdrp.service.IDRPPlanDetailService;
import com.abbvie.cdrp.service.StudyInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(value="*")
@RequestMapping("/StudyInfoController")
public class StudyInfoController {

	@Autowired
	private IDRPPlanDetailService idrpPlanDetailService;

	@Autowired
	private StudyInfoService studyInfoService;

	
	@GetMapping("/getIDRPPlanDetailDTOByStudyID")
	 public @ResponseBody ResponseEntity<IDRPPlanDetailDTO> getIDRPPlanDetailDTOByStudyID(@RequestParam String studyId) throws Exception{
		log.info("Inside IDRPCheckController.getIDRPPlanDetailDTOByStudyID: ");
		 IDRPPlanDetailDTO idrpPlanDetailDTO = idrpPlanDetailService.getIDRPPlanDetailDTOByStudyID(studyId);
		 return ResponseEntity.ok(idrpPlanDetailDTO);
	 }
	
	@GetMapping("/getStudyInfo")
	 public @ResponseBody ResponseEntity<StudyInfoDTO> getStudyInfo(@RequestParam String studyId) throws Exception{
		log.info("Inside IDRPCheckController.getStudyInfo: ");
	    StudyInfoDTO studyInfoDTOList = studyInfoService.getStudyInfo(studyId);
		return ResponseEntity.ok(studyInfoDTOList);
	 }
	
	
	
	
	
}

