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

import com.abbvie.cdrp.dto.AppliedVisitDTO;
import com.abbvie.cdrp.dto.BuisnessRuleConditionDTO;
import com.abbvie.cdrp.dto.RuleAssignedSubjectDTO;
import com.abbvie.cdrp.entity.AppliedVisit;
import com.abbvie.cdrp.entity.BusinessRule;
import com.abbvie.cdrp.entity.BusinessRuleCondition;
import com.abbvie.cdrp.entity.ExpectedDataCategory;
import com.abbvie.cdrp.entity.RuleAssignedSubject;
import com.abbvie.cdrp.repository.BuisnessRuleConditionRepository;
import com.abbvie.cdrp.repository.RuleAssignedSubjectRepository;

@Service
public class BuisnessRuleConditionService {

	@Autowired
	private BuisnessRuleConditionRepository buisnessRuleConditionRepository;
	
	
	public List<BuisnessRuleConditionDTO> getAllBuisnessRuleConditionDTO() {
		List<BusinessRuleCondition> businessRuleConditionList = buisnessRuleConditionRepository.findAll();
		List<BuisnessRuleConditionDTO> buisnessRuleConditiontDTOList = new ArrayList<>();
		buisnessRuleConditiontDTOList = getBuisnessRuleConditionDTO(buisnessRuleConditiontDTOList, businessRuleConditionList);
		return buisnessRuleConditiontDTOList;
	}
	
	public List<BuisnessRuleConditionDTO> getBuisnessRuleConditionByIds(@RequestBody List<Long> buisnessRuleConditionIds) {
		List<BusinessRuleCondition> businessRuleConditionList = buisnessRuleConditionRepository.findAllById(buisnessRuleConditionIds);
		List<BuisnessRuleConditionDTO>  buisnessRuleConditiontDTOList = new ArrayList<>();
		buisnessRuleConditiontDTOList = getBuisnessRuleConditionDTO(buisnessRuleConditiontDTOList,businessRuleConditionList);
		return buisnessRuleConditiontDTOList;
	}
	
	public void saveBuisnessRuleConditionDTOList(List<BuisnessRuleConditionDTO> buisnessRuleConditionDTOList) {

		if(!CollectionUtils.isEmpty(buisnessRuleConditionDTOList)) {
			Set<BusinessRuleCondition> buisnessRuleConditionSet = new HashSet<>();
			buisnessRuleConditionSet = getBuisnessRuleCondition(buisnessRuleConditionSet, buisnessRuleConditionDTOList);
			buisnessRuleConditionRepository.saveAll(buisnessRuleConditionSet);
			buisnessRuleConditionRepository.flush();
		}

	}
	
	public List<BuisnessRuleConditionDTO> getBuisnessRuleConditionDTO(List<BuisnessRuleConditionDTO> buisnessRuleConditiontDTOList,
			List<BusinessRuleCondition> businessRuleConditionList) {
		
		
				if(!CollectionUtils.isEmpty(businessRuleConditionList)) {
					buisnessRuleConditiontDTOList = new ArrayList<>();
					for(BusinessRuleCondition businessRuleCondition : businessRuleConditionList) {
						BuisnessRuleConditionDTO buisnessRuleConditionDTO = new BuisnessRuleConditionDTO();
						BeanUtils.copyProperties(businessRuleCondition, buisnessRuleConditionDTO);
						buisnessRuleConditiontDTOList.add(buisnessRuleConditionDTO);
					}
				}
			return buisnessRuleConditiontDTOList;
		
	}
	
	private Set<BusinessRuleCondition> getBuisnessRuleCondition(Set<BusinessRuleCondition> buisnessRuleConditionSet,
			List<BuisnessRuleConditionDTO> buisnessRuleConditionDTOList) {
		BusinessRule businessRule;
		BusinessRuleCondition businessRuleCondition;
		if(!CollectionUtils.isEmpty(buisnessRuleConditionDTOList)) {
			buisnessRuleConditionSet = new HashSet<>();
				for(BuisnessRuleConditionDTO buisnessRuleConditionDTO : buisnessRuleConditionDTOList) {
					businessRule = new BusinessRule();
					businessRule.setBusinessRuleId(buisnessRuleConditionDTO.getBusinessRuleId());
					businessRuleCondition =new BusinessRuleCondition();
					BeanUtils.copyProperties(buisnessRuleConditionDTO,businessRuleCondition);
					businessRuleCondition.setBusinessRule(businessRule);
					buisnessRuleConditionSet.add(businessRuleCondition);
				}

		}				
		return buisnessRuleConditionSet;
	}
	
	public String deleteBuisnessRuleConditionDTOList(List<Long> buisnessRuleConditionIds) {
		String result = "fail";
		if(!CollectionUtils.isEmpty(buisnessRuleConditionIds)) {
			for(Long buisnessRuleConditionId : buisnessRuleConditionIds) {
				buisnessRuleConditionRepository.deleteById(buisnessRuleConditionId);
			}
			result="success";
		}
		return result;
	}
	
}
