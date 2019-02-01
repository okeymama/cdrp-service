package com.abbvie.cdrp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abbvie.cdrp.dto.IDRPPlanDetailDTO;

@Service
public class ExpectedDataPageService {
	
	@Autowired
	private IDRPPlanDetailService idrpPlanDetailService;
	
	public List<IDRPPlanDetailDTO> getIdrpPlanDetailByIds(List<Long>  idrpPlanDetailIds) throws InstantiationException, IllegalAccessException {
		return idrpPlanDetailService.getIDRPPlanDetailDTOList(idrpPlanDetailIds);
		
	}

}
