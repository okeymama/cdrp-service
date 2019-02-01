package com.abbvie.cdrp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abbvie.cdrp.dto.DataTrajectoryDTO;
import com.abbvie.cdrp.dto.IDRPPlanDetailDTO;
import com.abbvie.cdrp.service.AddDataTrajectoryPageService;
import com.abbvie.cdrp.service.ExpectedDataPageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@RestController
@RequestMapping("/AddDataTrajectoryPageController")
@CrossOrigin(value="*")
public class AddDataTrajectoryPageController {
	
	@Autowired
	private AddDataTrajectoryPageService addDataTrajectoryPageService;
	
	@PostMapping("/saveNewDataTrajectoryDTO")
	public @ResponseBody ResponseEntity<String> saveNewDataTrajectoryDTO(@RequestBody DataTrajectoryDTO dataTrajectoryDTO) throws Exception{
		 log.info("Inside AddDataTrajectoryPageController.saveNewDataTrajectoryDTO: ");
		 addDataTrajectoryPageService.saveNewDataTrajectoryDTOList(dataTrajectoryDTO);
		 return ResponseEntity.ok("saved");
	 }
}
