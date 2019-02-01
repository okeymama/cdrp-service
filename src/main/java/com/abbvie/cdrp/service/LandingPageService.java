package com.abbvie.cdrp.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abbvie.cdrp.dto.IDRPPlanDetailDTO;

@Service
public class LandingPageService {

	@Autowired
	private IDRPPlanDetailService idrpPlanDetailService;
	
	public String addIdRPPlanDetail(IDRPPlanDetailDTO idrpPlanDetailDTO) {
		String result="fail";
		if(idrpPlanDetailDTO!=null) {
			List<IDRPPlanDetailDTO> idrpPlanDetailDTOList = new ArrayList<>();
			idrpPlanDetailDTO.setLastModifiedBy(LocalDate.now());
			if(idrpPlanDetailDTO.getIdrpPlanDetailId()==null) {
				idrpPlanDetailDTO.setCreatedDate(LocalDate.now());
			}	
			idrpPlanDetailDTOList.add(idrpPlanDetailDTO);
			result = idrpPlanDetailService.saveIDRPPlanDetailDTOList(idrpPlanDetailDTOList);
		}
		return result;
	}
	
}
