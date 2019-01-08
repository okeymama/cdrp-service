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

import com.abbvie.cdrp.dto.StudyFolderCategoryFormFieldDTO;
import com.abbvie.cdrp.dto.StudyFolderCategoryFormFieldIdDTO;
import com.abbvie.cdrp.service.StudyFolderCategoryFormFieldService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author cchaubey
 *
 */
@Slf4j
@RestController
@RequestMapping("/StudyFolderCategoryFormFieldController")
public class StudyFolderCategoryFormFieldController {

	@Autowired
	private StudyFolderCategoryFormFieldService studyFolderCategoryFormFieldService;
	
	 @PostMapping("/getStudyFolderCategoryFormField")	
	 public @ResponseBody ResponseEntity<StudyFolderCategoryFormFieldDTO> getStudyFolderCategoryFormField(@RequestBody StudyFolderCategoryFormFieldIdDTO studyFldrCategoryFormFieldIdDTO) throws Exception{
		 log.info("Inside StudyFolderCategoryFormFieldController.getStudyFolderCategoryFormField: "+studyFldrCategoryFormFieldIdDTO);
		 StudyFolderCategoryFormFieldDTO studyFolderCategoryFormFieldDTO = studyFolderCategoryFormFieldService.getStudyFolderCategoryFormField(studyFldrCategoryFormFieldIdDTO);
		 return ResponseEntity.ok(studyFolderCategoryFormFieldDTO);
	 }
	
}
