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

import com.abbvie.cdrp.dto.ExpectedDataCategoryDTO;
import com.abbvie.cdrp.dto.IDRPCheckDTO;
import com.abbvie.cdrp.service.IDRPCheckService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/IDRPCheckController")
public class IDRPCheckController {

	
	@Autowired
	private IDRPCheckService idrpCheckService;
	
	@GetMapping("/getAllIDRPCheckDTO")
	 public @ResponseBody ResponseEntity<List<IDRPCheckDTO>> getAllIDRPCheckDTO() throws Exception{
		log.info("Inside IDRPCheckController.getAllIDRPCheckDTO: ");
		 List<IDRPCheckDTO> idrpCheckDTO = idrpCheckService.getAllIDRPCheckDTO();
		 return ResponseEntity.ok(idrpCheckDTO);
	 }
	
	@PostMapping("/getIDRPCheckDTOListById")
	public @ResponseBody ResponseEntity<List<IDRPCheckDTO>> getIDRPCheckDTOListById(@RequestBody List<Long> idrpCheckIds) throws Exception{
		 log.info("Inside IDRPCheckController.getIDRPCheckDTOListById: ");
		 List<IDRPCheckDTO> idrpCheckDTO = idrpCheckService.getIDRPCheckDTOListById(idrpCheckIds);
		 return ResponseEntity.ok(idrpCheckDTO);
	 }
	
	@PostMapping("/deleteIDRPChecks")
	 public @ResponseBody String deleteIDRPChecks(@RequestBody List<Long> idrpCheckIds) throws Exception{
		 log.info("Inside IDRPCheckController.deleteIDRPChecks: ");
		 String result = idrpCheckService.deleteIDRPChecks(idrpCheckIds);
		 return result;
	 }
	
	@PostMapping("/saveIDRPCheckDTOList")
	 public @ResponseBody void saveIDRPCheckDTOList(@RequestBody List<IDRPCheckDTO> idrpCheckDTOList) throws Exception{
		 log.info("Inside IDRPPlanDetailController.saveIDRPCheckDTOList: ");
		 idrpCheckService.saveIDRPCheckDTOList(idrpCheckDTOList);
	 }
	
	
	
}
