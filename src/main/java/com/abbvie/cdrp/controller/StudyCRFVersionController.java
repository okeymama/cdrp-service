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

import com.abbvie.cdrp.dto.StudyCRFVersionDTO;
import com.abbvie.cdrp.dto.StudyCRFVersionIdDTO;
import com.abbvie.cdrp.service.StudyCRFVersionService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author cchaubey
 *
 */
@Slf4j
@RestController
@RequestMapping("/StudyCRFVersionController")
public class StudyCRFVersionController {
	
	@Autowired
	StudyCRFVersionService studyCRFVersionService;

	@PostMapping("/getStudyCRFVersion")
	 public @ResponseBody ResponseEntity<StudyCRFVersionDTO> getStudyCRFVersion(@RequestBody StudyCRFVersionIdDTO studyCRFVerIdDTO) throws Exception{
		 log.info("Inside StudyCRFVersionController.getStudyCRFVersion: "+studyCRFVerIdDTO);
		 StudyCRFVersionDTO studyCRFVersionDTO = studyCRFVersionService.getStudyCRFVersion(studyCRFVerIdDTO);
		 return ResponseEntity.ok(studyCRFVersionDTO);
	 }
	
}
