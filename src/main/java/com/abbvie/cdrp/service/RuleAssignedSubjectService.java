package com.abbvie.cdrp.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.abbvie.cdrp.dto.RuleAssignedSubjectDTO;

import com.abbvie.cdrp.entity.ExpectedDataCategory;
import com.abbvie.cdrp.entity.RuleAssignedSubject;

import com.abbvie.cdrp.repository.RuleAssignedSubjectRepository;

@Service
public class RuleAssignedSubjectService {

	@Autowired
	private RuleAssignedSubjectRepository ruleAssignedSubjectRepository;
	
	
	public List<RuleAssignedSubjectDTO> getAllRuleAssignedSubjectDTO() {
		List<RuleAssignedSubject> ruleAssignedSubjectList = ruleAssignedSubjectRepository.findAll();
		List<RuleAssignedSubjectDTO> ruleAssignedSubjectDTOList = new ArrayList<>();
		ruleAssignedSubjectDTOList = getRuleAssignedSubjectDTO(ruleAssignedSubjectDTOList, ruleAssignedSubjectList);
		return ruleAssignedSubjectDTOList;
	}
	
	public List<RuleAssignedSubjectDTO> getRuleAssignedSubjectByIds(List<Long> assignedSubjectIds) {
		List<RuleAssignedSubject> ruleAssignedSubjectList = ruleAssignedSubjectRepository.findAllById(assignedSubjectIds);
		List<RuleAssignedSubjectDTO>  ruleAssignedSubjectDTOList = new ArrayList<>();
		ruleAssignedSubjectDTOList = getRuleAssignedSubjectDTO(ruleAssignedSubjectDTOList,ruleAssignedSubjectList);
		return ruleAssignedSubjectDTOList;
	}
	
	public String deleteRuleAssignedSubjectDTOList(List<Long> assignedSubjectIds) {
		String result = "fail";
		if(!CollectionUtils.isEmpty(assignedSubjectIds)) {
			for(Long assignedSubjectId : assignedSubjectIds) {
				ruleAssignedSubjectRepository.deleteById(assignedSubjectId);
			}
			result="success";
		}
		return result;
	}
	
	public void saveRuleAssignedSubjectDTOList(List<RuleAssignedSubjectDTO> ruleAssignedSubjectDTOList) {

		if(!CollectionUtils.isEmpty(ruleAssignedSubjectDTOList)) {
			Set<RuleAssignedSubject> ruleAssignedSubjectSet = new HashSet<>();
			ruleAssignedSubjectSet = getRuleAssignedSubject(ruleAssignedSubjectSet, ruleAssignedSubjectDTOList);
			ruleAssignedSubjectRepository.saveAll(ruleAssignedSubjectSet);
			ruleAssignedSubjectRepository.flush();
		}

	}
	
	public List<RuleAssignedSubjectDTO> getRuleAssignedSubjectDTO(List<RuleAssignedSubjectDTO> ruleAssignedSubjectDTOList,
			List<RuleAssignedSubject> ruleAssignedSubjectList) {
		
		
				if(!CollectionUtils.isEmpty(ruleAssignedSubjectList)) {
					ruleAssignedSubjectDTOList = new ArrayList<>();
					for(RuleAssignedSubject ruleAssignedSubject : ruleAssignedSubjectList) {
						RuleAssignedSubjectDTO ruleAssignedSubjectDTO = new RuleAssignedSubjectDTO();
						BeanUtils.copyProperties(ruleAssignedSubject, ruleAssignedSubjectDTO);
						ruleAssignedSubjectDTOList.add(ruleAssignedSubjectDTO);
					}
				}
			return ruleAssignedSubjectDTOList;
		
	}
	
	private Set<RuleAssignedSubject> getRuleAssignedSubject(Set<RuleAssignedSubject> ruleAssignedSubjectSet,
			List<RuleAssignedSubjectDTO> ruleAssignedSubjectDTOList) {
		RuleAssignedSubject ruleAssignedSubject;
		ExpectedDataCategory expectedDataCategory;
		if(!CollectionUtils.isEmpty(ruleAssignedSubjectDTOList)) {
			ruleAssignedSubjectSet = new HashSet<>();
				for(RuleAssignedSubjectDTO ruleAssignedSubjectDTO : ruleAssignedSubjectDTOList) {
					expectedDataCategory = new ExpectedDataCategory();
					expectedDataCategory.setExpectedDataCategoryId(ruleAssignedSubjectDTO.getExpectedDataCategoryId());
					ruleAssignedSubject =new RuleAssignedSubject();
					BeanUtils.copyProperties(ruleAssignedSubjectDTO,ruleAssignedSubject);
					ruleAssignedSubject.setExpectedDataCategory(expectedDataCategory);
					ruleAssignedSubjectSet.add(ruleAssignedSubject);
				}

		}				
		return ruleAssignedSubjectSet;
	}
	
	
	
}
