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
import com.abbvie.cdrp.service.DataTrajectoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/DataTrajectoryController")
public class DataTrajectoryController {
	
	@Autowired
	private DataTrajectoryService dataTrajectoryService;
	
	@GetMapping("/getAllDataTrajectoryDTO")
	 public @ResponseBody ResponseEntity<List<DataTrajectoryDTO>> getAllDataTrajectoryDTO() throws Exception{
		 log.info("Inside DataTrajectoryController.getAllDataTrajectoryDTO: ");
		 List<DataTrajectoryDTO> dataTrajectoryDTO = dataTrajectoryService.getAllDataTrajectoryDTO();
		 return ResponseEntity.ok(dataTrajectoryDTO);
	 }
	
	@PostMapping("/getDataTrajectoryDTOList")
	 public @ResponseBody ResponseEntity<List<DataTrajectoryDTO>> getDataTrajectoryDTOList(@RequestBody List<Long> dataTrajectoryIds) throws Exception{
		 log.info("Inside DataTrajectoryController.getDataTrajectoryDTOList: ");
		 List<DataTrajectoryDTO> dataTrajectoryDTOList = dataTrajectoryService.getDataTrajectoryDTOList(dataTrajectoryIds);
		 return ResponseEntity.ok(dataTrajectoryDTOList);
	 }
	
	
	@PostMapping("/saveDataTrajectoryDTOList")
	 public void saveDataTrajectoryDTOList(@RequestBody List<DataTrajectoryDTO> dataTrajectoryDTOList) throws Exception{
		 log.info("Inside DataTrajectoryController.saveDataTrajectoryDTOList: ");
		 dataTrajectoryService.saveDataTrajectoryDTOList(dataTrajectoryDTOList);

	 }
	
	@PostMapping("/deleteDataTrajectoryDTO")
	public @ResponseBody String deleteDataTrajectoryDTOList(@RequestBody List<Long> dataTrajectoryIds) throws Exception{
		log.info("Inside DataTrajectoryController.deleteDataTrajectoryDTO: ");
		String result = dataTrajectoryService.deleteDataTrajectoryDTOList(dataTrajectoryIds);
		return result;
	} 
		

}
