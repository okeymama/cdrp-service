package com.abbvie.cdrp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abbvie.cdrp.dto.ExpectedDataCategoryDTO;
import com.abbvie.cdrp.dto.IDRPCheckDTO;

@Service 
public class AddIDRPCheckPageService {
	
	@Autowired
	private IDRPCheckService idrpCheckService;
	
	public void saveIDRPCheckDTOList(List<IDRPCheckDTO> idrpCheckDTOList) throws InstantiationException, IllegalAccessException{
		for(IDRPCheckDTO idrpCheckDTO : idrpCheckDTOList) {
			idrpCheckDTO.setCreatedDate(LocalDate.now());
			idrpCheckDTO.setLastUpdatedDate(LocalDate.now());
		} 
		idrpCheckService.saveIDRPCheckDTOList(idrpCheckDTOList);
	}	
}
