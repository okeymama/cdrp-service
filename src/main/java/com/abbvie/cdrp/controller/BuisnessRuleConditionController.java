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
import com.abbvie.cdrp.dto.RuleAssignedSubjectDTO;
import com.abbvie.cdrp.service.BuisnessRuleConditionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/BuisnessRuleConditionController")
public class BuisnessRuleConditionController {

	@Autowired
	private BuisnessRuleConditionService buisnessRuleConditionService;
	
	@GetMapping("/getAllBuisnessRuleConditionDTO")
	public @ResponseBody ResponseEntity<List<BuisnessRuleConditionDTO>> getAllBuisnessRuleConditionDTO() throws Exception{
		log.info("Inside BuisnessRuleConditionController.getAllBuisnessRuleConditionDTO: ");
		List<BuisnessRuleConditionDTO>  buisnessRuleConditionDTO = buisnessRuleConditionService.getAllBuisnessRuleConditionDTO();
		return ResponseEntity.ok(buisnessRuleConditionDTO);
	}
	
	@PostMapping("/getBuisnessRuleConditionByIds")
	public @ResponseBody ResponseEntity<List<BuisnessRuleConditionDTO>> getBuisnessRuleConditionByIds(@RequestBody List<Long> buisnessRuleConditionIds) throws Exception{
		log.info("Inside BuisnessRuleConditionController.getBuisnessRuleConditionByIds: ");
		List<BuisnessRuleConditionDTO> buisnessRuleConditionDTO = buisnessRuleConditionService.getBuisnessRuleConditionByIds(buisnessRuleConditionIds);
		return ResponseEntity.ok(buisnessRuleConditionDTO);
	}
	
	@PostMapping("/deleteBuisnessRuleConditionDTOList")
	public @ResponseBody String deleteBuisnessRuleConditionDTOList(@RequestBody List<Long> buisnessRuleConditionIds) throws Exception{
		log.info("Inside BuisnessRuleConditionController.deleteBuisnessRuleConditionDTOList: ");
		String result = buisnessRuleConditionService.deleteBuisnessRuleConditionDTOList(buisnessRuleConditionIds);
		return result;
	}
	
	@PostMapping("/saveBuisnessRuleConditionDTOList")
	 public @ResponseBody void saveBuisnessRuleConditionDTOList(@RequestBody List<BuisnessRuleConditionDTO> buisnessRuleConditionDTOList) throws Exception{
		 log.info("Inside BuisnessRuleConditionController.saveBuisnessRuleConditionDTOList: ");
		 buisnessRuleConditionService.saveBuisnessRuleConditionDTOList(buisnessRuleConditionDTOList);
	 }
	
	
}
