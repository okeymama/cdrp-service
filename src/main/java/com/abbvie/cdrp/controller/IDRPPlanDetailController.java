/**
 * 
 */
package com.abbvie.cdrp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author cchaubey
 *
 */
@Slf4j
@RestController
@RequestMapping("/IDRPPlanDetailController")
public class IDRPPlanDetailController {

	
	/*@PostMapping("/getStudyFolderCategoryFormField")
	 public @ResponseBody ResponseEntity<IDRPPlanDetail> getIDRPPlanDetail(@RequestBody String studyId) throws Exception{
		 log.info("Inside StudyFolderCategoryFormFieldController.getStudyFolderCategoryFormField: "+fieldValIdDTO);
		 FieldValuesDTO fieldValuesDTO = fieldValuesService.getFieldValues(fieldValIdDTO);
		 return ResponseEntity.ok(fieldValuesDTO);
	 }*/
	
}
