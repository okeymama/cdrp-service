/**
 * 
 */
package com.abbvie.cdrp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@CrossOrigin(value="*")
public class IDRPPlanDetailController {

	@Autowired
	private IDRPPlanDetailService idrpPlanDetailService;
	
	@GetMapping("/getAllIDRPPlanDetailDTO")
	 public  ResponseEntity<List<IDRPPlanDetailDTO>> getAllIDRPPlanDetailDTO() throws Exception{
		 log.info("Inside IDRPPlanDetailController.getAllIDRPPlanDetailDTO: ");
		 List<IDRPPlanDetailDTO> idrpPlanDetailDTO = idrpPlanDetailService.getAllIDRPPlanDetailDTO();
		 return ResponseEntity.ok(idrpPlanDetailDTO);		
	 }
	
	@PostMapping("/getIDRPPlanDetailDTOList")
	 public @ResponseBody ResponseEntity<List<IDRPPlanDetailDTO>> getIDRPPlanDetailDTOList(@RequestBody List<Long> idrpPlanDetailsIds) throws Exception{
		 log.info("Inside IDRPPlanDetailController.getIDRPPlanDetailDTOList: ");
		 List<IDRPPlanDetailDTO> idrpPlanDetailDTO = idrpPlanDetailService.getIDRPPlanDetailDTOList(idrpPlanDetailsIds);
		 return ResponseEntity.ok(idrpPlanDetailDTO);
	 }
	
	@PostMapping("/saveIDRPPlanDetailDTOList")
	 public @ResponseBody void saveIDRPPlanDetailDTOList(@RequestBody List<IDRPPlanDetailDTO> idrpPlanDetailDTOList) throws Exception{
		 log.info("Inside IDRPPlanDetailController.saveIDRPPlanDetailDTOList: ");
		 idrpPlanDetailService.saveIDRPPlanDetailDTOList(idrpPlanDetailDTOList);
	 }
	
	@PostMapping("/deleteIDRPPlanDetailDTOList")
	public @ResponseBody String deleteIDRPPlanDetailDTOList(@RequestBody List<Long> idrpPlanDetailsIds) {
		log.info("Inside IDRPPlanDetailController.saveIDRPPlanDetailDTOList: ");
		return idrpPlanDetailService.deleteIDRPPlanDetailDTOList(idrpPlanDetailsIds);
	}
	
}
