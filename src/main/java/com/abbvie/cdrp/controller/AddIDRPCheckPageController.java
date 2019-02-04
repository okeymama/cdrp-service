package com.abbvie.cdrp.controller;

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
import com.abbvie.cdrp.dto.IDRPCheckDTO;
import com.abbvie.cdrp.service.AddDataTrajectoryPageService;
import com.abbvie.cdrp.service.AddIDRPCheckPageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/AddIDRPCheckPageController")
@CrossOrigin(value="*")
public class AddIDRPCheckPageController {
	
	@Autowired
	private AddIDRPCheckPageService addIDRPCheckPageService;
	
	@PostMapping("/saveIDRPCheckDTOList")
	public @ResponseBody ResponseEntity<String> saveIDRPCheckDTOList(@RequestBody List<IDRPCheckDTO> idrpCheckDTOList) throws Exception{
		 log.info("Inside AddIDRPCheckPageController.saveIDRPCheckDTOList: ");
		 addIDRPCheckPageService.saveIDRPCheckDTOList(idrpCheckDTOList);
		 return ResponseEntity.ok("saved");
	 }

}
