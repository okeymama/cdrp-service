package com.abbvie.cdrp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abbvie.cdrp.dto.IDRPPlanDetailDTO;
import com.abbvie.cdrp.dto.StudyInfo;
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
	 public @ResponseBody ResponseEntity<StudyInfo> getStudyInfo(@RequestParam String studyId) throws Exception{
		log.info("Inside IDRPCheckController.getStudyInfo: ");
		StudyInfo studyInfo = studyInfoService.getStudyInfo(studyId);
		 return ResponseEntity.ok(studyInfo);
	 }
	
	
}

