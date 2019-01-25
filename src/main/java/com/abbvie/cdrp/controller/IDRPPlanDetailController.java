/**
 * 
 */
package com.abbvie.cdrp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abbvie.cdrp.dto.IDRPPlanDetailDTO;
import com.abbvie.cdrp.service.IDRPPlanDetailService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author cchaubey
 *
 */
@Slf4j
@RestController
@RequestMapping("/IDRPPlanDetailController")
public class IDRPPlanDetailController {

	@Autowired
	private IDRPPlanDetailService idrpPlanDetailService;
	
	@GetMapping("/getIDRPPlanDetailDTO")
	 public @ResponseBody ResponseEntity<List<IDRPPlanDetailDTO>> getAllIDRPPlanDetailDTO() throws Exception{
		 log.info("Inside IDRPPlanDetailController.getAllIDRPPlanDetailDTO: ");
		 List<IDRPPlanDetailDTO> idrpPlanDetailDTO = idrpPlanDetailService.getAllIDRPPlanDetailDTO();
		 return ResponseEntity.ok(idrpPlanDetailDTO);
	 }
	
}
