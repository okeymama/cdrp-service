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

import com.abbvie.cdrp.dto.AssignedSubjectDTO;
import com.abbvie.cdrp.dto.DataTrajectorySubjectAssignmentDTO;
import com.abbvie.cdrp.service.AssignedSubjectService;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/AssignedSubjectController")
public class AssignedSubjectController {
	
	@Autowired
	private AssignedSubjectService assignedSubjectService;
	
	@GetMapping("/getAllAssignedSubjectDTO")
	 public @ResponseBody ResponseEntity<List<AssignedSubjectDTO>> getAllAssignedSubjectDTO() throws Exception{
		 log.info("Inside AssignedSubjectController.getAllAssignedSubjectDTO: ");
		 List<AssignedSubjectDTO> assignedSubjectDTO = assignedSubjectService.getAllAssignedSubjectDTO();
		 return ResponseEntity.ok(assignedSubjectDTO);
	 }
	
	@PostMapping("/getAssignedSubjectDTOList")
	 public @ResponseBody ResponseEntity<List<AssignedSubjectDTO>> getAssignedSubjectDTOList(@RequestBody List<Long> assignedSubjectIds) throws Exception{
		 log.info("Inside AssignedSubjectController.getAssignedSubjectDTOList: ");
		 List<AssignedSubjectDTO> assignedSubjectDTOList = assignedSubjectService.getAssignedSubjectDTOList(assignedSubjectIds);
		 return ResponseEntity.ok(assignedSubjectDTOList);
	 }
	
	@PostMapping("/saveAssignedSubjectDTOList")
	 public void saveAssignedSubjectDTOList(@RequestBody List<AssignedSubjectDTO> assignedSubjectDTOList) throws Exception{
		 log.info("Inside AssignedSubjectController.saveAssignedSubjectDTOList: ");
		 assignedSubjectService.saveAssignedSubjectDTOList(assignedSubjectDTOList);

	 }
	
	@PostMapping("/deleteAssignedSubjectDTO")
	public @ResponseBody String deleteAssignedSubjectDTOList(@RequestBody List<Long> assignedSubjectIds) throws Exception{
		log.info("Inside AssignedSubjectController.deleteAssignedSubjectDTO: ");
		String result = assignedSubjectService.deleteAssignedSubjectDTOList(assignedSubjectIds);
		return result;
	} 
}
