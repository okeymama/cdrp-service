/**
 * 
 */
package com.abbvie.cdrp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abbvie.cdrp.dto.FieldValuesDTO;
import com.abbvie.cdrp.dto.FieldValuesIdDTO;
import com.abbvie.cdrp.service.FieldValuesService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author cchaubey
 *	
 */
@Slf4j
@RestController
@RequestMapping("/FieldValuesController")
class FieldValuesController {

	@Autowired
	FieldValuesService fieldValuesService;

	@PostMapping("/getStudyFolderCategoryFormField")
	 public @ResponseBody ResponseEntity<FieldValuesDTO> getFieldValues(@RequestBody FieldValuesIdDTO fieldValIdDTO) throws Exception{
		 log.info("Inside StudyFolderCategoryFormFieldController.getStudyFolderCategoryFormField: "+fieldValIdDTO);
		 FieldValuesDTO fieldValuesDTO = fieldValuesService.getFieldValues(fieldValIdDTO);
		 return ResponseEntity.ok(fieldValuesDTO);
	 }
	
}
