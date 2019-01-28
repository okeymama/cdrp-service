/**
 * 
 */
package com.abbvie.cdrp.service;

import java.util.ArrayList;
import java.util.List;

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
import com.abbvie.cdrp.repository.IDRPPlanDetailRepository;

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
	 */
	public List<IDRPPlanDetailDTO> getAllIDRPPlanDetailDTO() {
		List<IDRPPlanDetail> idrpPlanDetailList = idrpPlanDetailRepository.findAll();
		List<IDRPPlanDetailDTO> idrpPlanDetailDTOList = new ArrayList<>();
		idrpPlanDetailDTOList = getIDRPPlanDetailDTO(idrpPlanDetailDTOList, idrpPlanDetailList);
		return idrpPlanDetailDTOList;
	}

	/**
	 * 
	 * @param idrpPlanDetailsIds
	 * @return
	 */
	public List<IDRPPlanDetailDTO> getIDRPPlanDetailDTOList(List<Long> idrpPlanDetailsIds) {
		List<IDRPPlanDetail> idrpPlanDetailList = idrpPlanDetailRepository.findAllById(idrpPlanDetailsIds);
		List<IDRPPlanDetailDTO>  idrpPlanDetailDTOList = new ArrayList<>();
		idrpPlanDetailDTOList = getIDRPPlanDetailDTO(idrpPlanDetailDTOList,idrpPlanDetailList);
		return idrpPlanDetailDTOList;
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
	
	
	/**
	 * @param idrpPlanDetailDTOList
	 * @param idrpPlanDetailList
	 * @return
	 */
	private List<IDRPPlanDetailDTO> getIDRPPlanDetailDTO(List<IDRPPlanDetailDTO> idrpPlanDetailDTOList,
			List<IDRPPlanDetail> idrpPlanDetailList) {
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
	

}
