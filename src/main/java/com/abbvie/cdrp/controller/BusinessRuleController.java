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

import com.abbvie.cdrp.dto.BuisnessRuleConditionDTO;
import com.abbvie.cdrp.dto.BusinessRuleDTO;
import com.abbvie.cdrp.service.BuisnessRuleConditionService;
import com.abbvie.cdrp.service.BusinessRuleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/BusinessRuleController")
public class BusinessRuleController {
	
	@Autowired
	private BusinessRuleService businessRuleService;
	
	@GetMapping("/getAllBusinessRuleDTO")
	public @ResponseBody ResponseEntity<List<BusinessRuleDTO>> getAllBusinessRuleDTO() throws Exception{
		log.info("Inside BusinessRuleController.getAllBusinessRuleDTO: ");
		List<BusinessRuleDTO>  businessRuleDTODTO = businessRuleService.getAllBusinessRuleDTO();
		return ResponseEntity.ok(businessRuleDTODTO);
	}
	
	@PostMapping("/getBusinessRuleByIds")
	public @ResponseBody ResponseEntity<List<BusinessRuleDTO>> getBusinessRuleByIds(@RequestBody List<Long> businessRuleIds) throws Exception{
		log.info("Inside BusinessRuleController.getBuisnessRuleConditionByIds: ");
		List<BusinessRuleDTO> businessRuleDTO = businessRuleService.getBusinessRuleByIds(businessRuleIds);
		return ResponseEntity.ok(businessRuleDTO);
	}
	
	@PostMapping("/deleteBusinessRuleDTOList")
	public @ResponseBody String deleteBusinessRuleDTOList(@RequestBody List<Long> businessRuleIds) throws Exception{
		log.info("Inside BusinessRuleController.deleteBusinessRuleDTOList: ");
		String result = businessRuleService.deleteBusinessRuleDTOList(businessRuleIds);
		return result;
	}
	
	@PostMapping("/saveBusinessRuleDTOList")
	 public @ResponseBody void saveBusinessRuleDTOList(@RequestBody List<BusinessRuleDTO> businessRuleDTOList) throws Exception{
		 log.info("Inside BusinessRulenController.saveBusinessRuleDTOList: ");
		 businessRuleService.saveBusinessRuleDTOList(businessRuleDTOList);
	 }

}
