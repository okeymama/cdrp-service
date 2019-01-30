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
import com.abbvie.cdrp.dto.RunResultDTO;
import com.abbvie.cdrp.service.AssignedSubjectService;
import com.abbvie.cdrp.service.RunResultService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/RunResultController")
public class RunResultController {
	
	@Autowired
	private RunResultService runResultService;
	
	@GetMapping("/getAllRunResultDTO")
	 public @ResponseBody ResponseEntity<List<RunResultDTO>> getAllRunResultDTO() throws Exception{
		 log.info("Inside RunResultController.getAllRunResultDTO: ");
		 List<RunResultDTO> runResultDTO = runResultService.getAllRunResultDTO();
		 return ResponseEntity.ok(runResultDTO);
	 }
	
	@PostMapping("/getRunResultDTOListByIds")
	 public @ResponseBody ResponseEntity<List<RunResultDTO>> getRunResultDTOListByIds(@RequestBody List<String> runResultIds) throws Exception{
		 log.info("Inside RunResultController.getRunResultDTOListByIds: ");
		 List<RunResultDTO> runResultDTOList = runResultService.getRunResultDTOListByIds(runResultIds);
		 return ResponseEntity.ok(runResultDTOList);
	 }
	
	@PostMapping("/getRunResultDTOListByStudyIds")
	 public @ResponseBody ResponseEntity<List<RunResultDTO>> getRunResultDTOListByStudyIds(@RequestBody List<String> runResultStudyIds) throws Exception{
		 log.info("Inside RunResultController.getRunResultDTOListByStudyIds: ");
		 List<RunResultDTO> runResultDTOList = runResultService.getRunResultDTOListByStudyIds(runResultStudyIds);
		 return ResponseEntity.ok(runResultDTOList);
	 }
	
	@PostMapping("/saveRunResultDTOList")
	 public void saveRunResultDTOList(@RequestBody List<RunResultDTO> runResultDTOList) throws Exception{
		 log.info("Inside RunResultController.saveRunResultDTOList: ");
		 runResultService.saveRunResultDTOList(runResultDTOList);

	 }
}
