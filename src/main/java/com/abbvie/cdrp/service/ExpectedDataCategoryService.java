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
import com.abbvie.cdrp.dto.DataTrajectoryDTO;
import com.abbvie.cdrp.dto.DataTrajectorySubjectAssignmentDTO;
import com.abbvie.cdrp.dto.ExpectedDataCategoryDTO;
import com.abbvie.cdrp.dto.IDRPCheckDTO;
import com.abbvie.cdrp.dto.IDRPPlanDetailDTO;
import com.abbvie.cdrp.entity.AppliedVisit;
import com.abbvie.cdrp.entity.DataTrajectory;
import com.abbvie.cdrp.entity.DataTrajectorySubjectAssignment;
import com.abbvie.cdrp.entity.ExpectedDataCategory;
import com.abbvie.cdrp.entity.IDRPCheck;
import com.abbvie.cdrp.entity.IDRPPlanDetail;
import com.abbvie.cdrp.repository.ExpectedDataCategoryRepository;

@Service
public class ExpectedDataCategoryService {
	@Autowired
	private ExpectedDataCategoryRepository expectedDataCategoryRepository;
	
	
	public List<ExpectedDataCategoryDTO> getAllExpectedDataCategoryDTO() {
		List<ExpectedDataCategory> expectedDataCategoryList = expectedDataCategoryRepository.findAll();
		List<ExpectedDataCategoryDTO> expectedDataCategoryDTOList = new ArrayList<>();
		expectedDataCategoryDTOList = getExpectedDataCategoryDTO(expectedDataCategoryDTOList, expectedDataCategoryList);
		return expectedDataCategoryDTOList;
	}
	
	public List<ExpectedDataCategoryDTO> getExpectedDataCategoryDTOListById(List<Long> expectedDataCategoryIds)  throws InstantiationException, IllegalAccessException  {
		List<ExpectedDataCategory> expectedDataCategoryList = expectedDataCategoryRepository.findAllById(expectedDataCategoryIds);
		List<ExpectedDataCategoryDTO>  expectedDataCategoryDTOList = new ArrayList<>();
		expectedDataCategoryDTOList = getExpectedDataCategoryDTO(expectedDataCategoryDTOList,expectedDataCategoryList);
		return expectedDataCategoryDTOList;
	}
	
	public void saveExpectedDataCategoryDTOList(List<ExpectedDataCategoryDTO> expectedDataCategoryDTOList) {
		
		if(!CollectionUtils.isEmpty(expectedDataCategoryDTOList)) {
			Set<ExpectedDataCategory> expectedDataCategorySet = new HashSet<>();
			expectedDataCategorySet = getExpectedDataCategory(expectedDataCategorySet, expectedDataCategoryDTOList);
			expectedDataCategoryRepository.saveAll(expectedDataCategorySet);
			expectedDataCategoryRepository.flush();
		}
		
	}
	
	public List<ExpectedDataCategoryDTO> getExpectedDataCategoryDTO(List<ExpectedDataCategoryDTO> expectedDataCategoryDTOList,
			List<ExpectedDataCategory> expectedDataCategoryList) {
		
		IDRPCheckDTO idrpCheckDTO ;
		List<IDRPCheckDTO> idrpCheckDTOList ;
		List<AppliedVisitDTO> appliedVisitDTOList ;
		ExpectedDataCategoryDTO expectedDataCategoryDTO ;
		if(!CollectionUtils.isEmpty(expectedDataCategoryList)) {
			expectedDataCategoryDTOList = new ArrayList<>();
			for(ExpectedDataCategory expectedDataCategory : expectedDataCategoryList) {
				 expectedDataCategoryDTO = new ExpectedDataCategoryDTO();
				BeanUtils.copyProperties(expectedDataCategory, expectedDataCategoryDTO);
				if(!CollectionUtils.isEmpty(expectedDataCategory.getAppliedVisitSet())) {
					appliedVisitDTOList = new ArrayList<>();
					for(AppliedVisit appliedVisit : expectedDataCategory.getAppliedVisitSet()) {
						AppliedVisitDTO appliedVisitDTO = new AppliedVisitDTO();
						BeanUtils.copyProperties(appliedVisit, appliedVisitDTO);
						appliedVisitDTOList.add(appliedVisitDTO);
					}
					expectedDataCategoryDTO.setAppliedVisitDTOList(appliedVisitDTOList);
				}
				if(!CollectionUtils.isEmpty(expectedDataCategory.getIdrpCheckSet())) {
					idrpCheckDTOList = new ArrayList<>();
					for(IDRPCheck idrpCheck : expectedDataCategory.getIdrpCheckSet()) {
						idrpCheckDTO = new IDRPCheckDTO();
						BeanUtils.copyProperties(idrpCheck, idrpCheckDTO);
						idrpCheckDTOList.add(idrpCheckDTO);
					}
					expectedDataCategoryDTO.setIdrpCheckDTOList(idrpCheckDTOList);
				}
				expectedDataCategoryDTOList.add(expectedDataCategoryDTO);
			}
		}
		
		return expectedDataCategoryDTOList;
		
	}
	
	public String deleteExpectedDatacategories(List<Long> expectedDataCategoryIds) {
		if(!CollectionUtils.isEmpty(expectedDataCategoryIds)) {
		for(Long expectedDataCategoryId : expectedDataCategoryIds) {
			 expectedDataCategoryRepository.deleteById(expectedDataCategoryId);
			
		}
		
		}
		return "Deleted";
	}

	
	private Set<ExpectedDataCategory> getExpectedDataCategory(Set<ExpectedDataCategory> expectedDataCategorySet,
			List<ExpectedDataCategoryDTO> expectedDataCategoryDTOList) {
		IDRPCheck idrpCheck;
		Set<IDRPCheck> idrpCheckSet;
		Set<AppliedVisit> appliedVisitSet;
		DataTrajectory dataTrajectory;
		ExpectedDataCategory expectedDataCategory;
		if(!CollectionUtils.isEmpty(expectedDataCategoryDTOList)) {
				expectedDataCategorySet = new HashSet<>();
				for(ExpectedDataCategoryDTO expectedDataCategoryDTO : expectedDataCategoryDTOList ) {
					dataTrajectory = new DataTrajectory();
					dataTrajectory.setDataTrajectoryId(expectedDataCategoryDTO.getDataTrajectoryId());
					expectedDataCategory = new ExpectedDataCategory();
					BeanUtils.copyProperties(expectedDataCategoryDTO, expectedDataCategory);
					expectedDataCategory.setDataTrajectory(dataTrajectory);
					if(!CollectionUtils.isEmpty(expectedDataCategoryDTO.getAppliedVisitDTOList())) {
							appliedVisitSet = new HashSet<>();
							for(AppliedVisitDTO appliedVisitDTO : expectedDataCategoryDTO.getAppliedVisitDTOList()) {
									AppliedVisit appliedVisit = new AppliedVisit();
									BeanUtils.copyProperties(appliedVisitDTO,appliedVisit);
									appliedVisit.setExpectedDataCategory(expectedDataCategory);
									appliedVisitSet.add(appliedVisit);
							}
							expectedDataCategory.setAppliedVisitSet(appliedVisitSet);
					}
					if(!CollectionUtils.isEmpty(expectedDataCategoryDTO.getIdrpCheckDTOList())) {
							idrpCheckSet = new HashSet<>();
							for(IDRPCheckDTO idrpCheckDTO : expectedDataCategoryDTO.getIdrpCheckDTOList()) {
										idrpCheck = new IDRPCheck();
										BeanUtils.copyProperties(idrpCheckDTO, idrpCheck);
										idrpCheck.setExpectedDataCategory(expectedDataCategory);
										idrpCheckSet.add(idrpCheck);
								}
									expectedDataCategory.setIdrpCheckSet(idrpCheckSet);
							}
								expectedDataCategorySet.add(expectedDataCategory);
							}
							
						}
						
		return expectedDataCategorySet;
	}
	
	
	
	
	
	
	
	
	
}
