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
import com.abbvie.cdrp.dto.RuleAssignedSubjectDTO;
import com.abbvie.cdrp.service.RuleAssignedSubjectService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/RuleAssignedSubjectController")
public class RuleAssignedSubjectController {

	@Autowired
	private RuleAssignedSubjectService ruleAssignedSubjectService;
	
	@GetMapping("/getAllRuleAssignedSubjectDTO")
	public @ResponseBody ResponseEntity<List<RuleAssignedSubjectDTO>> getAllRuleAssignedSubjectDTO() throws Exception{
		log.info("Inside AssignedSubjectController.getAllRuleAssignedSubjectDTO: ");
		List<RuleAssignedSubjectDTO>  ruleAssignedSubjectDTO = ruleAssignedSubjectService.getAllRuleAssignedSubjectDTO();
		return ResponseEntity.ok(ruleAssignedSubjectDTO);
	}
	
	@PostMapping("/getRuleAssignedSubjectByIds")
	public @ResponseBody ResponseEntity<List<RuleAssignedSubjectDTO>> getRuleAssignedSubjectByIds(@RequestBody List<Long> assignedSubjectIds) throws Exception{
		log.info("Inside AssignedSubjectController.getRuleAssignedSubjectByIds: ");
		List<RuleAssignedSubjectDTO> ruleAssignedSubjectDTO = ruleAssignedSubjectService.getRuleAssignedSubjectByIds(assignedSubjectIds);
		return ResponseEntity.ok(ruleAssignedSubjectDTO);
	}
	
	@PostMapping("/deleteRuleAssignedSubjectDTOList")
	public @ResponseBody String deleteRuleAssignedSubjectDTOList(@RequestBody List<Long> assignedSubjectIds) throws Exception{
		log.info("Inside AssignedSubjectController.deleteRuleAssignedSubjectDTOList: ");
		String result = ruleAssignedSubjectService.deleteRuleAssignedSubjectDTOList(assignedSubjectIds);
		return result;
	}
	
	@PostMapping("/saveRuleAssignedSubjectDTOList")
	 public @ResponseBody void saveRuleAssignedSubjectDTOList(@RequestBody List<RuleAssignedSubjectDTO> ruleAssignedSubjectDTOList) throws Exception{
		 log.info("Inside IDRPPlanDetailController.saveRuleAssignedSubjectDTOList: ");
		 ruleAssignedSubjectService.saveRuleAssignedSubjectDTOList(ruleAssignedSubjectDTOList);
	 }
	
}
