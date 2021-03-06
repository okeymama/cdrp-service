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
import com.abbvie.cdrp.service.AppliedVisitService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/AppliedVisitController")
public class AppliedVisitController {
	
	@Autowired
	private AppliedVisitService appliedVisitService;
	
	@GetMapping("/getAllAppliedVisitDTO")
	 public @ResponseBody ResponseEntity<List<AppliedVisitDTO>> getAllAppliedVisitDTO() throws Exception{
		log.info("Inside AppliedVisitController.getAllAppliedVisitDTO: ");
		 List<AppliedVisitDTO> appliedVisitDTO = appliedVisitService.getAllAppliedVisitDTO();
		 return ResponseEntity.ok(appliedVisitDTO);
	 }
	
	@PostMapping("/getAppliedVisitDTOListByIds")
	public @ResponseBody ResponseEntity<List<AppliedVisitDTO>> getAppliedVisitDTOListByIds(@RequestBody List<Long> appliedVisitIds) throws Exception{
		 log.info("Inside AppliedVisitController.getAppliedVisitDTOListByIds: ");
		 List<AppliedVisitDTO> appliedVisitDTO = appliedVisitService.getAppliedVisitDTOListByIds(appliedVisitIds);
		 return ResponseEntity.ok(appliedVisitDTO);
	 }
	
	@PostMapping("/deleteAppliedVisitDTOList")
	 public @ResponseBody String deleteAppliedVisitDTOList(@RequestBody List<Long> appliedVisitIds) throws Exception{
		 log.info("Inside AppliedVisitController.deleteAppliedVisitDTOList: ");
		 String result = appliedVisitService.deleteAppliedVisitDTOList(appliedVisitIds);
		 return result;
	 }
	
	@PostMapping("/saveAppliedVisitDTOList")
	 public @ResponseBody void saveAppliedVisitDTOList(@RequestBody List<AppliedVisitDTO> appliedVisitDTOList) throws Exception{
		 log.info("Inside IDRPPlanDetailController.saveAppliedVisitDTOList: ");
		 appliedVisitService.saveAppliedVisitDTOList(appliedVisitDTOList);
	 }
	
}
