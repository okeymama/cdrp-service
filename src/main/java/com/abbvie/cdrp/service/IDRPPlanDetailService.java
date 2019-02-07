/**
 * 
 */
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
import com.abbvie.cdrp.entity.AssignedSubject;
import com.abbvie.cdrp.entity.DataTrajectory;
import com.abbvie.cdrp.entity.DataTrajectorySubjectAssignment;
import com.abbvie.cdrp.entity.ExpectedDataCategory;
import com.abbvie.cdrp.entity.IDRPCheck;
import com.abbvie.cdrp.entity.IDRPPlanDetail;
import com.abbvie.cdrp.repository.IDRPPlanDetailRepository;
import com.abbvie.cdrp.util.CDRPBeanUtil;

/**
 * @author cchaubey
 *
 */
@Service
public class IDRPPlanDetailService {

	@Autowired
	private IDRPPlanDetailRepository idrpPlanDetailRepository;

	/**
	 * 
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public List<IDRPPlanDetailDTO> getAllIDRPPlanDetailDTO() throws InstantiationException, IllegalAccessException {
		List<IDRPPlanDetail> idrpPlanDetailList = idrpPlanDetailRepository.findAll();
		List<IDRPPlanDetailDTO> idrpPlanDetailDTOList = new ArrayList<>();
		idrpPlanDetailDTOList = getIDRPPlanDetailDTO(idrpPlanDetailDTOList, idrpPlanDetailList);
		return idrpPlanDetailDTOList;
	}

	/**
	 * 
	 * @param idrpPlanDetailsIds
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public List<IDRPPlanDetailDTO> getIDRPPlanDetailDTOList(List<Long> idrpPlanDetailsIds) throws InstantiationException, IllegalAccessException {
		List<IDRPPlanDetail> idrpPlanDetailList = idrpPlanDetailRepository.findAllById(idrpPlanDetailsIds);
		List<IDRPPlanDetailDTO>  idrpPlanDetailDTOList = new ArrayList<>();
		idrpPlanDetailDTOList = getIDRPPlanDetailDTO(idrpPlanDetailDTOList,idrpPlanDetailList);
		return idrpPlanDetailDTOList;
	}

	/**
	 * 
	 * @param studyId
	 * @return
	 */
	public IDRPPlanDetailDTO getIDRPPlanDetailDTOByStudyID(String studyId) {
		IDRPPlanDetailDTO idrpPlanDetailDTO = null;
		IDRPPlanDetail idrpPlanDetail = idrpPlanDetailRepository.findByStudyId(studyId);
		if(null != idrpPlanDetail) {
			idrpPlanDetailDTO = new IDRPPlanDetailDTO();
			BeanUtils.copyProperties(idrpPlanDetail, idrpPlanDetailDTO);
		}
		return idrpPlanDetailDTO;
	}
	
	/**
	 * 
	 * @param idrpPlanDetailsIds
	 * @return
	 */
	public String deleteIDRPPlanDetailDTOList(List<Long> idrpPlanDetailsIds) {
		String result = "fail";
		if(!CollectionUtils.isEmpty(idrpPlanDetailsIds)) {
			for(Long idrpPlanDetailsId : idrpPlanDetailsIds) {
				idrpPlanDetailRepository.deleteById(idrpPlanDetailsId);
			}
			result = "success";
		}
		return result;
	}
	
	
	public String saveIDRPPlanDetailDTOList(List<IDRPPlanDetailDTO> idrpPlanDetailDTOList) {
		String result="fail";
		if(!CollectionUtils.isEmpty(idrpPlanDetailDTOList)) {
			Set<IDRPPlanDetail> idrpPlanDetailSet = new HashSet<>();
			idrpPlanDetailSet = getIDRPPlanDetail(idrpPlanDetailSet, idrpPlanDetailDTOList);
			idrpPlanDetailRepository.saveAll(idrpPlanDetailSet);
			idrpPlanDetailRepository.flush();
			/*for(IDRPPlanDetail idrpPlanDetail : idrpPlanDetailSet) {
				idrpPlanDetailRepository.saveAndFlush(idrpPlanDetail);
			}*/
		result="success";
		}
		return result;
	}
	
	
	/**
	 * @param idrpPlanDetailDTOList
	 * @param idrpPlanDetailList
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private List<IDRPPlanDetailDTO> getIDRPPlanDetailDTO(List<IDRPPlanDetailDTO> idrpPlanDetailDTOList,
			List<IDRPPlanDetail> idrpPlanDetailList) throws InstantiationException, IllegalAccessException {
		IDRPCheckDTO idrpCheckDTO;
		IDRPPlanDetailDTO idrpPlanDetailDTO;
		DataTrajectoryDTO dataTrajectoryDTO;
		List<IDRPCheckDTO> idrpCheckDTOList;
		List<AppliedVisitDTO> appliedVisitDTOList;
		ExpectedDataCategoryDTO expectedDataCategoryDTO;
		List<DataTrajectoryDTO> dataTrajectoryDTOList;
		List<ExpectedDataCategoryDTO> expectedDataCategoryDTOList;
		DataTrajectorySubjectAssignmentDTO dataTrajectorySubjectAssignmentDTO;
		List<DataTrajectorySubjectAssignmentDTO> dataTrajectorySubjectAssignmentDTOList;
		if(!CollectionUtils.isEmpty(idrpPlanDetailList)) {
			idrpPlanDetailDTOList = new ArrayList<>();
			for(IDRPPlanDetail idrpPlanDetail : idrpPlanDetailList) {
				idrpPlanDetailDTO = new IDRPPlanDetailDTO();
				BeanUtils.copyProperties(idrpPlanDetail, idrpPlanDetailDTO);
				if(!CollectionUtils.isEmpty(idrpPlanDetail.getDataTrajectorySet())) {
					dataTrajectoryDTOList = new ArrayList<>();
					for(DataTrajectory dataTrajectory : idrpPlanDetail.getDataTrajectorySet()) {
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
						idrpPlanDetailDTO.setDataTrajectoryDTOList(dataTrajectoryDTOList);
					}

				}
				idrpPlanDetailDTOList.add(idrpPlanDetailDTO);
			}
		}
		return idrpPlanDetailDTOList;
	}
	
	
	private Set<IDRPPlanDetail> getIDRPPlanDetail(Set<IDRPPlanDetail> idrpPlanDetailSet,
			List<IDRPPlanDetailDTO> idrpPlanDetailDTOList) {
		IDRPCheck idrpCheck;
		IDRPPlanDetail idrpPlanDetail;
		DataTrajectory dataTrajectory;
		Set<IDRPCheck> idrpCheckSet;
		Set<AppliedVisit> appliedVisitSet;
		ExpectedDataCategory expectedDataCategory;
		Set<DataTrajectory> dataTrajectorySet;
		Set<ExpectedDataCategory> expectedDataCategorySet;
		DataTrajectorySubjectAssignment dataTrajectorySubjectAssignment;
		Set<DataTrajectorySubjectAssignment> dataTrajectorySubjectAssignmentSet;
		if(!CollectionUtils.isEmpty(idrpPlanDetailDTOList)) {
			idrpPlanDetailSet = new HashSet<>();
			for(IDRPPlanDetailDTO idrpPlanDetailDTO : idrpPlanDetailDTOList) {
				idrpPlanDetail = new IDRPPlanDetail();
				BeanUtils.copyProperties(idrpPlanDetailDTO, idrpPlanDetail);
				if(!CollectionUtils.isEmpty(idrpPlanDetailDTO.getDataTrajectoryDTOList())) {
					dataTrajectorySet = new HashSet<>();
					for(DataTrajectoryDTO dataTrajectoryDTO : idrpPlanDetailDTO.getDataTrajectoryDTOList()) {
						dataTrajectory = new DataTrajectory();
						BeanUtils.copyProperties(dataTrajectoryDTO, dataTrajectory);
						dataTrajectory.setIdrpPlanDetail(idrpPlanDetail);
						if(!CollectionUtils.isEmpty(dataTrajectoryDTO.getDataTrajectorySubjectAssignmentDTOList())) {
							dataTrajectorySubjectAssignmentSet = new HashSet<>();
							for(DataTrajectorySubjectAssignmentDTO dataTrajectorySubjectAssignmentDTO : dataTrajectoryDTO.getDataTrajectorySubjectAssignmentDTOList()) {
								dataTrajectorySubjectAssignment = new DataTrajectorySubjectAssignment();
								BeanUtils.copyProperties(dataTrajectorySubjectAssignmentDTO, dataTrajectorySubjectAssignment);
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
						idrpPlanDetail.setDataTrajectorySet(dataTrajectorySet);
					}

				}
				idrpPlanDetailSet.add(idrpPlanDetail);
			}
		}
		return idrpPlanDetailSet;
	}
	

}
