package com.abbvie.cdrp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abbvie.cdrp.dto.ExpectedDataCategoryDTO;
import com.abbvie.cdrp.dto.IDRPPlanDetailDTO;
import com.abbvie.cdrp.service.ExpectedDataCategoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ExpectedDataCategoryController")
@CrossOrigin(value="*")
public class ExpectedDataCategoryController {

	@Autowired
	private ExpectedDataCategoryService expectedDataCategoryService;
	@GetMapping("/getAllExpectedDataCategoryDTO")
	 public @ResponseBody ResponseEntity<List<ExpectedDataCategoryDTO>> getAllExpectedDataCategoryDTO() throws Exception{
		log.info("Inside ExpectedDataCategoryController.getAllExpectedDataCategoryDTO: ");
		 List<ExpectedDataCategoryDTO> expectedDataCategoryDTO = expectedDataCategoryService.getAllExpectedDataCategoryDTO();
		 return ResponseEntity.ok(expectedDataCategoryDTO);
	 }
	
	@PostMapping("/getExpectedDataCategoryDTOListByIds")
	public @ResponseBody ResponseEntity<List<ExpectedDataCategoryDTO>> getExpectedDataCategoryDTOListByIds(@RequestBody List<Long> expectedDataCategoryIds) throws Exception{
		log.info("Inside ExpectedDataCategoryController.getExpectedDataCategoryDTOListByIds: ");
		 List<ExpectedDataCategoryDTO> expectedDataCategoryDTO = expectedDataCategoryService.getExpectedDataCategoryDTOListByIds(expectedDataCategoryIds);
		 return ResponseEntity.ok(expectedDataCategoryDTO);
	 }
	
	@PostMapping("/deleteExpectedDatacategoryDTOList")
	 public @ResponseBody String deleteExpectedDatacategoryDTOList(@RequestBody List<Long> expectedDataCategoryIds) throws Exception{
		 log.info("Inside ExpectedDataCategoryController.deleteExpectedDatacategoryDTOList: ");
		 String result = expectedDataCategoryService.deleteExpectedDatacategoryDTOList(expectedDataCategoryIds);
		 return result;
	 }
	
	@PostMapping("/saveExpectedDataCategoryDTOList")
	 public @ResponseBody void saveExpectedDataCategoryDTOList(@RequestBody List<ExpectedDataCategoryDTO> expectedDataCategoryDTOList) throws Exception{
		 log.info("Inside IDRPPlanDetailController.saveExpectedDataCategoryDTOList: ");
		 expectedDataCategoryService.saveExpectedDataCategoryDTOList(expectedDataCategoryDTOList);
	 }
	
}
