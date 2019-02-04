package com.abbvie.cdrp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abbvie.cdrp.dto.BusinessRuleDTO;
import com.abbvie.cdrp.dto.ExpectedDataCategoryDTO;
import com.abbvie.cdrp.dto.IDRPPlanDetailDTO;
import com.abbvie.cdrp.service.ExpectedDataPageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ExpectedDataPageController")
@CrossOrigin(value="*")
public class ExpectedDataPageController {

	@Autowired
	private ExpectedDataPageService expectedDataPageService;

	@PostMapping("/getIdrpPlanDetailByIds")
	public @ResponseBody ResponseEntity<List<IDRPPlanDetailDTO>> getIdrpPlanDetailByIds(@RequestBody Long idrpPlanDetailId) throws Exception{
		 log.info("Inside ExpectedDataPageController.getIdrpPlanDetailByIds: ");
		 List<Long> idrpPlanDetailIds = new ArrayList<>();
		 idrpPlanDetailIds.add(idrpPlanDetailId);
		 List<IDRPPlanDetailDTO> idrpPlanDetailDTOList = expectedDataPageService.getIdrpPlanDetailByIds(idrpPlanDetailIds);
		 return ResponseEntity.ok(idrpPlanDetailDTOList);
	 }
	
	@GetMapping("/deleteExpectedDataCategory")
	public ResponseEntity<String> deleteExpectedDataCategory(@RequestParam Long expectedDataCategoryId) throws Exception{
		String result="fail";
		log.info("Inside ExpectedDataPageController.deleteExpectedDataCategory: ");
		result = expectedDataPageService.deleteExpectedDatacategory(expectedDataCategoryId);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/updateExpectedDataCategory")
	public ResponseEntity<String> updateExpectedDataCategory(@RequestBody ExpectedDataCategoryDTO expectedDataCategoryDTO) throws Exception{
		String result="fail";
		log.info("Inside ExpectedDataPageController.updateExpectedDataCategory: ");
		result = expectedDataPageService.updateExpectedDataCategory(expectedDataCategoryDTO);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/saveBuisnessRule")
	public ResponseEntity<String> saveBuisnessRule(@RequestBody BusinessRuleDTO businessRuleDTO) throws Exception{
		String result="fail";
		log.info("Inside ExpectedDataPageController.saveBuisnessRule: ");
		result = expectedDataPageService.saveBuisnessRule(businessRuleDTO);
		return ResponseEntity.ok(result);
	}
	
}
