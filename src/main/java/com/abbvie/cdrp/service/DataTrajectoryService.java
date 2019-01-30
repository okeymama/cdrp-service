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
import com.abbvie.cdrp.dto.AssignedSubjectDTO;
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
import com.abbvie.cdrp.repository.DataTrajectoryRepository;
import com.abbvie.cdrp.repository.IDRPPlanDetailRepository;
import com.abbvie.cdrp.util.CDRPBeanUtil;

@Service
public class DataTrajectoryService {
	
	@Autowired
	private DataTrajectoryRepository dataTrajectoryRepository;
	
	/**
	 * 
	 * @return
	 */
	public List<DataTrajectoryDTO> getAllDataTrajectoryDTO() throws InstantiationException, IllegalAccessException{
		List<DataTrajectory> dataTrajectoryList = dataTrajectoryRepository.findAll();
		List<DataTrajectoryDTO> dataTrajectoryDTOList = new ArrayList<>();
		dataTrajectoryDTOList = getDataTrajectoryDTO(dataTrajectoryDTOList, dataTrajectoryList);
		return dataTrajectoryDTOList;
	}
	
	/**
	 * 
	 * @param dataTrajectoryIds
	 * @return
	 */
	public List<DataTrajectoryDTO> getDataTrajectoryDTOListByIds(List<Long> dataTrajectoryIds) throws InstantiationException, IllegalAccessException {
		List<DataTrajectory> dataTrajectoryList = dataTrajectoryRepository.findAllById(dataTrajectoryIds);
		List<DataTrajectoryDTO>  dataTrajectoryDTOList = new ArrayList<>();
		dataTrajectoryDTOList = getDataTrajectoryDTO(dataTrajectoryDTOList, dataTrajectoryList);
		return dataTrajectoryDTOList;
	}
	
	public void saveDataTrajectoryDTOList(List<DataTrajectoryDTO> dataTrajectoryDTOList) throws InstantiationException, IllegalAccessException{
		
		if(!CollectionUtils.isEmpty(dataTrajectoryDTOList)) {
			Set<DataTrajectory> dataTrajectorySet = new HashSet<>();
			dataTrajectorySet = getDataTrajectory(dataTrajectorySet, dataTrajectoryDTOList);
			dataTrajectoryRepository.saveAll(dataTrajectorySet);
			dataTrajectoryRepository.flush();
		}
		
	}
	
	/**
	 * 
	 * @param dataTrajectoryIds
	 * @return
	 */
	public String deleteDataTrajectoryDTOList(List<Long> dataTrajectoryIds) {
		String result = "fail";
		if(!CollectionUtils.isEmpty(dataTrajectoryIds)) {
			for(Long dataTrajectoryId : dataTrajectoryIds) {
				dataTrajectoryRepository.deleteById(dataTrajectoryId);
			}
			result = "success";
		}
		return result;
	}
	
	
	/**
	 * @param dataTrajectoryDTOList
	 * @param dataTrajectoryList
	 * @return
	 */
	public List<DataTrajectoryDTO> getDataTrajectoryDTO(List<DataTrajectoryDTO> dataTrajectoryDTOList,
			List<DataTrajectory> dataTrajectoryList) throws InstantiationException, IllegalAccessException {
		
		IDRPCheckDTO idrpCheckDTO = null;
		DataTrajectoryDTO dataTrajectoryDTO = null;
		ExpectedDataCategoryDTO expectedDataCategoryDTO = null;
		DataTrajectorySubjectAssignmentDTO dataTrajectorySubjectAssignmentDTO = null;
		List<IDRPCheckDTO> idrpCheckDTOList = null;
		List<AppliedVisitDTO> appliedVisitDTOList = null;		
		List<ExpectedDataCategoryDTO> expectedDataCategoryDTOList =  null;		
		List<DataTrajectorySubjectAssignmentDTO> dataTrajectorySubjectAssignmentDTOList = null;
		if(!CollectionUtils.isEmpty(dataTrajectoryList)) {
			dataTrajectoryDTOList = new ArrayList<>();
			for(DataTrajectory dataTrajectory : dataTrajectoryList) {
				dataTrajectoryDTO = new DataTrajectoryDTO();
				BeanUtils.copyProperties(dataTrajectory, dataTrajectoryDTO);
				if(!CollectionUtils.isEmpty(dataTrajectory.getDataTrajectorySubjectAssignmentSet())) {
					dataTrajectorySubjectAssignmentDTOList = new ArrayList<>();
					for(DataTrajectorySubjectAssignment dataTrajectorySubjectAssignment : dataTrajectory.getDataTrajectorySubjectAssignmentSet()) {
						dataTrajectorySubjectAssignmentDTO = new DataTrajectorySubjectAssignmentDTO();
						BeanUtils.copyProperties(dataTrajectorySubjectAssignment, dataTrajectorySubjectAssignmentDTO);
						if(!CollectionUtils.isEmpty(dataTrajectorySubjectAssignment.getAssignedSubjectSet())) {
							List<AssignedSubjectDTO> assignedSubjectDTOList = CDRPBeanUtil.copyEntityListToDTOList(dataTrajectorySubjectAssignment.getAssignedSubjectSet(), AssignedSubjectDTO.class);
							dataTrajectorySubjectAssignmentDTO.setAssignedSubjectDTOList(assignedSubjectDTOList);
						}
						dataTrajectorySubjectAssignmentDTOList.add(dataTrajectorySubjectAssignmentDTO);
					}
					dataTrajectoryDTO.setDataTrajectorySubjectAssignmentDTOList(dataTrajectorySubjectAssignmentDTOList);
				}
				if(!CollectionUtils.isEmpty(dataTrajectory.getExpectedDataCategorySet())) {
					expectedDataCategoryDTOList = new ArrayList<>();
					for(ExpectedDataCategory expectedDataCategory : dataTrajectory.getExpectedDataCategorySet()) {
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
					dataTrajectoryDTO.setExpectedDataCategoryDTOList(expectedDataCategoryDTOList);
				
				}
				dataTrajectoryDTOList.add(dataTrajectoryDTO);
			}
			
		}
		
		return dataTrajectoryDTOList;
	}
	
	
	private Set<DataTrajectory> getDataTrajectory(Set<DataTrajectory> dataTrajectorySet,
			List<DataTrajectoryDTO> dataTrajectoryDTOList) throws InstantiationException, IllegalAccessException {
		
		IDRPCheck idrpCheck;
		IDRPPlanDetail idrpPlanDetail;
		DataTrajectory dataTrajectory;
		ExpectedDataCategory expectedDataCategory;
		DataTrajectorySubjectAssignment dataTrajectorySubjectAssignment;
		Set<IDRPCheck> idrpCheckSet;
		Set<AppliedVisit> appliedVisitSet;	
		Set<ExpectedDataCategory> expectedDataCategorySet;
		Set<DataTrajectorySubjectAssignment> dataTrajectorySubjectAssignmentSet;
		
		if(!CollectionUtils.isEmpty(dataTrajectoryDTOList)) {
			dataTrajectorySet = new HashSet<>();
			for(DataTrajectoryDTO dataTrajectoryDTO : dataTrajectoryDTOList) {
				idrpPlanDetail = new IDRPPlanDetail();
				dataTrajectory = new DataTrajectory();
				idrpPlanDetail.setIdrpPlanDetailId(dataTrajectoryDTO.getIdrpPlanDetailId());
				BeanUtils.copyProperties(dataTrajectoryDTO, dataTrajectory);
				dataTrajectory.setIdrpPlanDetail(idrpPlanDetail);
				if(!CollectionUtils.isEmpty(dataTrajectoryDTO.getDataTrajectorySubjectAssignmentDTOList())) {
					dataTrajectorySubjectAssignmentSet = new HashSet<>();
					for(DataTrajectorySubjectAssignmentDTO dataTrajectorySubjectAssignmentDTO : dataTrajectoryDTO.getDataTrajectorySubjectAssignmentDTOList()) {
						dataTrajectorySubjectAssignment = new DataTrajectorySubjectAssignment();
						BeanUtils.copyProperties(dataTrajectorySubjectAssignmentDTO, dataTrajectorySubjectAssignment);
						if(!CollectionUtils.isEmpty(dataTrajectorySubjectAssignment.getAssignedSubjectSet())) {
							List<AssignedSubjectDTO> assignedSubjectDTOList = CDRPBeanUtil.copyEntityListToDTOList(dataTrajectorySubjectAssignment.getAssignedSubjectSet(), AssignedSubjectDTO.class);
							dataTrajectorySubjectAssignmentDTO.setAssignedSubjectDTOList(assignedSubjectDTOList);
						}
						dataTrajectorySubjectAssignment.setDataTrajectory(dataTrajectory);
						dataTrajectorySubjectAssignmentSet.add(dataTrajectorySubjectAssignment);
					}
					dataTrajectory.setDataTrajectorySubjectAssignmentSet(dataTrajectorySubjectAssignmentSet);
				}
				if(!CollectionUtils.isEmpty(dataTrajectoryDTO.getExpectedDataCategoryDTOList())) {
					expectedDataCategorySet = new HashSet<>();
					for(ExpectedDataCategoryDTO expectedDataCategoryDTO : dataTrajectoryDTO.getExpectedDataCategoryDTOList()) {
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
					dataTrajectory.setExpectedDataCategorySet(expectedDataCategorySet);
				}
				dataTrajectorySet.add(dataTrajectory);
			}

		}
		return dataTrajectorySet;	
	}
	
}
