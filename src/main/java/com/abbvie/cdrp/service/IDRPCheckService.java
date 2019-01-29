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
import com.abbvie.cdrp.dto.ExpectedDataCategoryDTO;
import com.abbvie.cdrp.dto.IDRPCheckDTO;
import com.abbvie.cdrp.entity.AppliedVisit;
import com.abbvie.cdrp.entity.DataTrajectory;
import com.abbvie.cdrp.entity.ExpectedDataCategory;
import com.abbvie.cdrp.entity.IDRPCheck;

import com.abbvie.cdrp.repository.IDRPCheckRepository;

@Service
public class IDRPCheckService {

	@Autowired
	private IDRPCheckRepository idrpCheckRepository;
	
	
	public List<IDRPCheckDTO> getAllIDRPCheckDTO() {
		List<IDRPCheck> idrpCheckList = idrpCheckRepository.findAll();
		List<IDRPCheckDTO> idrpCheckDTOList = new ArrayList<>();
		idrpCheckDTOList = getIDRPCheckDTO(idrpCheckDTOList, idrpCheckList);
		return idrpCheckDTOList;
	}
	
	public List<IDRPCheckDTO> getIDRPCheckDTOListById(List<Long> idrpCheckIds) {
		List<IDRPCheck> idrpCheckList = idrpCheckRepository.findAllById(idrpCheckIds);
		List<IDRPCheckDTO>  idrpCheckDTOList = new ArrayList<>();
		idrpCheckDTOList = getIDRPCheckDTO(idrpCheckDTOList,idrpCheckList);
		return idrpCheckDTOList;
	}
	
	public void saveIDRPCheckDTOList(List<IDRPCheckDTO> idrpCheckDTOList) {
		
		if(!CollectionUtils.isEmpty(idrpCheckDTOList)) {
			Set<IDRPCheck> idrpCheckSet = new HashSet<>();
			idrpCheckSet = getIDRPCheck(idrpCheckSet, idrpCheckDTOList);
			idrpCheckRepository.saveAll(idrpCheckSet);
			idrpCheckRepository.flush();
		}
		
	}
	
	public List<IDRPCheckDTO> getIDRPCheckDTO(List<IDRPCheckDTO> idrpCheckDTOList,
			List<IDRPCheck> idrpCheckList) {
		
		IDRPCheckDTO idrpCheckDTO ;
				if(!CollectionUtils.isEmpty(idrpCheckList)) {
					idrpCheckDTOList = new ArrayList<>();
					for(IDRPCheck idrpCheck : idrpCheckList) {
						idrpCheckDTO = new IDRPCheckDTO();
						BeanUtils.copyProperties(idrpCheck, idrpCheckDTO);
						idrpCheckDTOList.add(idrpCheckDTO);
					}
				}
		
		return idrpCheckDTOList;
		
	}
	
	private Set<IDRPCheck> getIDRPCheck(Set<IDRPCheck> idrpCheckSet,
			List<IDRPCheckDTO> idrpCheckDTOList) {
		IDRPCheck idrpCheck;
		ExpectedDataCategory expectedDataCategory;
		if(!CollectionUtils.isEmpty(idrpCheckDTOList)) {
				idrpCheckSet = new HashSet<>();
				for(IDRPCheckDTO idrpCheckDTO : idrpCheckDTOList) {
					expectedDataCategory = new ExpectedDataCategory();
					expectedDataCategory.setExpectedDataCategoryId(idrpCheckDTO.getExpectedDataCategoryId());
					idrpCheck = new IDRPCheck();
					BeanUtils.copyProperties(idrpCheckDTO, idrpCheck);
					idrpCheck.setExpectedDataCategory(expectedDataCategory);
					idrpCheckSet.add(idrpCheck);
				}

		}				
		return idrpCheckSet;
	}
	
	
	
	public String deleteIDRPChecks(List<Long>  idrpCheckIds) {
		if(!CollectionUtils.isEmpty(idrpCheckIds)) {
		for(Long idrpCheckId : idrpCheckIds) {
			idrpCheckRepository.deleteById(idrpCheckId);
			
		}
		
		}
		return "Deleted";
	}
	
	
	
	
}
