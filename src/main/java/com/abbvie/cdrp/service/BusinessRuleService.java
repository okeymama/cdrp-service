package com.abbvie.cdrp.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import com.abbvie.cdrp.dto.BuisnessRuleConditionDTO;
import com.abbvie.cdrp.dto.BusinessRuleDTO;
import com.abbvie.cdrp.dto.IDRPCheckDTO;
import com.abbvie.cdrp.entity.BusinessRule;
import com.abbvie.cdrp.entity.BusinessRuleCondition;
import com.abbvie.cdrp.entity.DataTrajectory;
import com.abbvie.cdrp.entity.ExpectedDataCategory;
import com.abbvie.cdrp.repository.BusinessRuleRepository;

@Service
public class BusinessRuleService {
	
	@Autowired
	private BusinessRuleRepository businessRuleRepository;
	
	
	public List<BusinessRuleDTO> getAllBusinessRuleDTO() {
		List<BusinessRule> businessRuleList = businessRuleRepository.findAll();
		List<BusinessRuleDTO> businessRuleDTOList = new ArrayList<>();
		businessRuleDTOList = getBusinessRuleDTO(businessRuleDTOList, businessRuleList);
		return businessRuleDTOList;
	}
	
	public List<BusinessRuleDTO> getBusinessRuleByIds(@RequestBody List<Long> businessRuleIds) {
		List<BusinessRule> businessRuleList = businessRuleRepository.findAllById(businessRuleIds);
		List<BusinessRuleDTO>  businessRuleDTOList = new ArrayList<>();
		businessRuleDTOList = getBusinessRuleDTO(businessRuleDTOList,businessRuleList);
		return businessRuleDTOList;
	}

	public void saveBusinessRuleDTOList(List<BusinessRuleDTO> businessRuleDTOList) {

		if(!CollectionUtils.isEmpty(businessRuleDTOList)) {
			Set<BusinessRule> businessRuleSet = new HashSet<>();
			businessRuleSet = getBusniessRule(businessRuleSet, businessRuleDTOList);
			businessRuleRepository.saveAll(businessRuleSet);
			businessRuleRepository.flush();
		}

	}
	
	
	public List<BusinessRuleDTO> getBusinessRuleDTO(List<BusinessRuleDTO> businessRuleDTOList,
			List<BusinessRule> businessRuleList) {
		
		IDRPCheckDTO idrpCheckDTO ;
		List<BusinessRuleCondition> businessRuleConditionList ;
		BusinessRuleDTO businessRuleDTO;
		if(!CollectionUtils.isEmpty(businessRuleList)) {
			businessRuleDTOList = new ArrayList<>();
			for(BusinessRule businessRule : businessRuleList) {
				businessRuleDTO = new BusinessRuleDTO();
				BeanUtils.copyProperties(businessRule, businessRuleDTO);
				if(!CollectionUtils.isEmpty(businessRule.getBusinessRuleConditionSet())) {
					List<BuisnessRuleConditionDTO> buisnessRuleConditionDTOList = new ArrayList<>();
					for(BusinessRuleCondition businessRuleCondition : businessRule.getBusinessRuleConditionSet()) {
						BuisnessRuleConditionDTO buisnessRuleConditionDTO = new BuisnessRuleConditionDTO();
						BeanUtils.copyProperties(businessRuleCondition, buisnessRuleConditionDTO);
						buisnessRuleConditionDTOList.add(buisnessRuleConditionDTO);
					}
					businessRuleDTO.setBusinessRuleConditionDTOList(buisnessRuleConditionDTOList);
				}
				businessRuleDTOList.add(businessRuleDTO);
			}
		}
		
		return businessRuleDTOList;
		
	}
	
	
	private Set<BusinessRule> getBusniessRule(Set<BusinessRule> businessRuleSet,
			List<BusinessRuleDTO> businessRuleDTOList) {
		BusinessRule businessRule;
		Set<BusinessRuleCondition> businessRuleConditionSet;

		DataTrajectory dataTrajectory;
		ExpectedDataCategory expectedDataCategory;
		if(!CollectionUtils.isEmpty(businessRuleDTOList)) {
			businessRuleSet = new HashSet<>();
			for(BusinessRuleDTO businessRuleDTO : businessRuleDTOList ) {
				expectedDataCategory = new ExpectedDataCategory();
				expectedDataCategory.setExpectedDataCategoryId(businessRuleDTO.getExpectedDataCategoryId());
				businessRule = new BusinessRule();
				BeanUtils.copyProperties(businessRuleDTO, businessRule);
				businessRule.setExpectedDataCategory(expectedDataCategory);
				if(!CollectionUtils.isEmpty(businessRuleDTO.getBusinessRuleConditionDTOList())) {
					businessRuleConditionSet = new HashSet<>();
					for(BuisnessRuleConditionDTO buisnessRuleConditionDTO : businessRuleDTO.getBusinessRuleConditionDTOList()) {
						BusinessRuleCondition businessRuleCondition = new BusinessRuleCondition();
						BeanUtils.copyProperties(buisnessRuleConditionDTO,businessRuleCondition);
						businessRuleCondition.setBusinessRule(businessRule);
						businessRuleConditionSet.add(businessRuleCondition);
					}
					businessRule.setBusinessRuleConditionSet(businessRuleConditionSet);
				}

				businessRuleSet.add(businessRule);
			}

		}

		return businessRuleSet;
	}
	
	
	
	public String deleteBusinessRuleDTOList(List<Long> businessRuleIds) {
		String result = "fail";
		if(!CollectionUtils.isEmpty(businessRuleIds)) {
			for(Long businessRuleId : businessRuleIds) {
				businessRuleRepository.deleteById(businessRuleId);
			}
			result="success";
		}
		return result;
	}
}
