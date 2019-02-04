package com.abbvie.cdrp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abbvie.cdrp.dto.BusinessRuleDTO;
import com.abbvie.cdrp.dto.ExpectedDataCategoryDTO;
import com.abbvie.cdrp.dto.IDRPPlanDetailDTO;

@Service
public class ExpectedDataPageService {
	
	@Autowired
	private IDRPPlanDetailService idrpPlanDetailService;
	
	@Autowired
	private ExpectedDataCategoryService expectedDataCategoryService;
	
	@Autowired
	private BusinessRuleService businessRuleService;
	
	
	public List<IDRPPlanDetailDTO> getIdrpPlanDetailByIds(List<Long>  idrpPlanDetailIds) throws InstantiationException, IllegalAccessException {
		return idrpPlanDetailService.getIDRPPlanDetailDTOList(idrpPlanDetailIds);
		
	}
	

	public String  deleteExpectedDatacategory(Long expectedDataCategoryId) {
		String result = "fail";
		List<Long> expectedDataCategoryIds = new ArrayList();
		expectedDataCategoryIds.add(expectedDataCategoryId);
		result = expectedDataCategoryService.deleteExpectedDatacategoryDTOList(expectedDataCategoryIds);
		return result;
	}
	
	public String  updateExpectedDataCategory(ExpectedDataCategoryDTO expectedDataCategoryDTO) {
		String result = "fail";
		List<ExpectedDataCategoryDTO> expectedDataCategoryDTOList = new ArrayList();
		expectedDataCategoryDTOList.add(expectedDataCategoryDTO);
		result = expectedDataCategoryService.saveExpectedDataCategoryDTOList(expectedDataCategoryDTOList);
		return result;
	}
	
	public String  saveBuisnessRule(BusinessRuleDTO businessRuleDTO) {
		String result = "fail";
		List<BusinessRuleDTO> businessRuleDTOList = new ArrayList();
		businessRuleDTOList.add(businessRuleDTO);
		result = businessRuleService.saveBusinessRuleDTOList(businessRuleDTOList);
		return result;
	}

}
