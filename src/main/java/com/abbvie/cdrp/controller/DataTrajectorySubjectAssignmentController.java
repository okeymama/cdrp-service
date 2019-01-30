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

import com.abbvie.cdrp.dto.DataTrajectoryDTO;
import com.abbvie.cdrp.dto.DataTrajectorySubjectAssignmentDTO;
import com.abbvie.cdrp.service.DataTrajectoryService;
import com.abbvie.cdrp.service.DataTrajectorySubjectAssignmentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/DataTrajectorySubjectAssignmentController")
public class DataTrajectorySubjectAssignmentController {
	
	@Autowired
	private DataTrajectorySubjectAssignmentService dataTrajectorySubjectAssignmentService;
	
	@GetMapping("/getAllDataTrajectorySubjectAssignmentDTO")
	 public @ResponseBody ResponseEntity<List<DataTrajectorySubjectAssignmentDTO>> getAllDataTrajectorySubjectAssignmentDTO() throws Exception{
		 log.info("Inside DataTrajectorySubjectAssignmentController.getAllDataTrajectorySubjectAssignmentDTO: ");
		 List<DataTrajectorySubjectAssignmentDTO> dataTrajectorySubjectAssignmentDTO = dataTrajectorySubjectAssignmentService.getAllDataTrajectorySubjectAssignmentDTO();
		 return ResponseEntity.ok(dataTrajectorySubjectAssignmentDTO);
	 }
	
	@PostMapping("/getDataTrajectorySubjectAssignmentDTOListByIds")
	 public @ResponseBody ResponseEntity<List<DataTrajectorySubjectAssignmentDTO>> getDataTrajectorySubjectAssignmentDTOListByIds(@RequestBody List<Long> dataTrajectorySubjectAssignmentIds) throws Exception{
		 log.info("Inside DataTrajectorySubjectAssignmentController.getDataTrajectorySubjectAssignmentDTOListByIds: ");
		 List<DataTrajectorySubjectAssignmentDTO> dataTrajectorySubjectAssignmentDTOList = dataTrajectorySubjectAssignmentService.getDataTrajectorySubjectAssignmentDTOListByIds(dataTrajectorySubjectAssignmentIds);
		 return ResponseEntity.ok(dataTrajectorySubjectAssignmentDTOList);
	 }
	
	
	@PostMapping("/saveDataTrajectorySubjectAssignmentDTOList")
	 public void saveDataTrajectorySubjectAssignmentDTOList(@RequestBody List<DataTrajectorySubjectAssignmentDTO> dataTrajectorySubjectAssignmentDTOList) throws Exception{
		 log.info("Inside DataTrajectorySubjectAssignmentController.DataTrajectorySubjectAssignmentDTOList: ");
		 dataTrajectorySubjectAssignmentService.saveDataTrajectorySubjectAssignmentDTOList(dataTrajectorySubjectAssignmentDTOList);

	 }
	
	@PostMapping("/deleteDataTrajectorySubjectAssignmentDTO")
	public @ResponseBody String deleteDataTrajectorySubjectAssignmentDTOList(@RequestBody List<Long> dataTrajectorySubjectAssignmentIds) throws Exception{
		log.info("Inside DataTrajectorySubjectAssignmentController.deleteDataTrajectorySubjectAssignmentDTO: ");
		String result = dataTrajectorySubjectAssignmentService.deleteDataTrajectorySubjectAssignmentDTOList(dataTrajectorySubjectAssignmentIds);
		return result;
	} 
}
