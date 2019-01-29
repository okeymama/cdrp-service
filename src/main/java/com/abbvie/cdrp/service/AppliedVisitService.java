package com.abbvie.cdrp.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.abbvie.cdrp.dto.AppliedVisitDTO;
import com.abbvie.cdrp.dto.IDRPCheckDTO;
import com.abbvie.cdrp.entity.AppliedVisit;
import com.abbvie.cdrp.entity.ExpectedDataCategory;
import com.abbvie.cdrp.entity.IDRPCheck;
import com.abbvie.cdrp.repository.AppliedVisitRepository;

@Service
public class AppliedVisitService {

	@Autowired
	private AppliedVisitRepository appliedVisitRepository;
	
	
	public List<AppliedVisitDTO> getAllAppliedVisitDTO() {
		List<AppliedVisit> appliedVisitList = appliedVisitRepository.findAll();
		List<AppliedVisitDTO> appliedVisitDTOList = new ArrayList<>();
		appliedVisitDTOList = getAppliedVisitDTO(appliedVisitDTOList, appliedVisitList);
		return appliedVisitDTOList;
	}
	
	public List<AppliedVisitDTO> getAppliedVisitDTOListById(List<Long> appliedVisitIds) {
		List<AppliedVisit> appliedVisitList = appliedVisitRepository.findAllById(appliedVisitIds);
		List<AppliedVisitDTO>  appliedVisitDTOList = new ArrayList<>();
		appliedVisitDTOList = getAppliedVisitDTO(appliedVisitDTOList,appliedVisitList);
		return appliedVisitDTOList;
	}
	
	public void saveAppliedVisitDTOList(List<AppliedVisitDTO> appliedVisitDTOList) {
		
		if(!CollectionUtils.isEmpty(appliedVisitDTOList)) {
			Set<AppliedVisit> idrpCheckSet = new HashSet<>();
			idrpCheckSet = getAppliedVisit(idrpCheckSet, appliedVisitDTOList);
			appliedVisitRepository.saveAll(idrpCheckSet);
			appliedVisitRepository.flush();
		}
		
	}
	
	public List<AppliedVisitDTO> getAppliedVisitDTO(List<AppliedVisitDTO> appliedVisitDTOList,
			List<AppliedVisit> appliedVisitList) {
		
		
				if(!CollectionUtils.isEmpty(appliedVisitList)) {
					appliedVisitDTOList = new ArrayList<>();
					for(AppliedVisit appliedVisit : appliedVisitList) {
						AppliedVisitDTO appliedVisitDTO = new AppliedVisitDTO();
						BeanUtils.copyProperties(appliedVisit, appliedVisitDTO);
						appliedVisitDTOList.add(appliedVisitDTO);
					}
				}
			return appliedVisitDTOList;
		
	}
	
	private Set<AppliedVisit> getAppliedVisit(Set<AppliedVisit> appliedVisitSet,
			List<AppliedVisitDTO> appliedVisitDTOList) {
		AppliedVisit appliedVisit;
		ExpectedDataCategory expectedDataCategory;
		if(!CollectionUtils.isEmpty(appliedVisitDTOList)) {
				appliedVisitSet = new HashSet<>();
				for(AppliedVisitDTO appliedVisitDTO : appliedVisitDTOList) {
					expectedDataCategory = new ExpectedDataCategory();
					expectedDataCategory.setExpectedDataCategoryId(appliedVisitDTO.getExpectedDataCategoryId());
					appliedVisit =new AppliedVisit();
					BeanUtils.copyProperties(appliedVisitDTO,appliedVisit);
					appliedVisit.setExpectedDataCategory(expectedDataCategory);
					appliedVisitSet.add(appliedVisit);
				}

		}				
		return appliedVisitSet;
	}
	
	public String deleteAppliedVisits(List<Long> appliedVisitIds) {
		if(!CollectionUtils.isEmpty(appliedVisitIds)) {
		for(Long appliedVisitId : appliedVisitIds) {
			appliedVisitRepository.deleteById(appliedVisitId);
			
		}
		
		}
		return "Deleted";
	}
	
}
