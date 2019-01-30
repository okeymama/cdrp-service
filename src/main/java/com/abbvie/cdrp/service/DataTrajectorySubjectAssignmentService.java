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
import com.abbvie.cdrp.entity.AppliedVisit;
import com.abbvie.cdrp.entity.AssignedSubject;
import com.abbvie.cdrp.entity.DataTrajectory;
import com.abbvie.cdrp.entity.DataTrajectorySubjectAssignment;
import com.abbvie.cdrp.entity.ExpectedDataCategory;
import com.abbvie.cdrp.entity.IDRPCheck;
import com.abbvie.cdrp.entity.IDRPPlanDetail;
import com.abbvie.cdrp.repository.DataTrajectorySubjectAssignmentRepository;
import com.abbvie.cdrp.util.CDRPBeanUtil;

@Service
public class DataTrajectorySubjectAssignmentService {
	
	@Autowired
	private DataTrajectorySubjectAssignmentRepository dataTrajectorySubjectAssignmentRepository;
	
	/**
	 * 
	 * @return
	 */
	public List<DataTrajectorySubjectAssignmentDTO> getAllDataTrajectorySubjectAssignmentDTO() throws InstantiationException, IllegalAccessException{
		List<DataTrajectorySubjectAssignment> dataTrajectorySubjectAssignmentList = dataTrajectorySubjectAssignmentRepository.findAll();
		List<DataTrajectorySubjectAssignmentDTO> dataTrajectorySubjectAssignmentDTOList = new ArrayList<>();
		dataTrajectorySubjectAssignmentDTOList = getDataTrajectorySubjectAssignmentDTO(dataTrajectorySubjectAssignmentDTOList, dataTrajectorySubjectAssignmentList);
		return dataTrajectorySubjectAssignmentDTOList;
	}
	
	/**
	 * 
	 * @param dataTrajectorySubjectAssignmentIds
	 * @return
	 */
	public List<DataTrajectorySubjectAssignmentDTO> getDataTrajectorySubjectAssignmentDTOList(List<Long> dataTrajectorySubjectAssignmentIds)throws InstantiationException, IllegalAccessException {
		List<DataTrajectorySubjectAssignment> dataTrajectorySubjectAssignmentList = dataTrajectorySubjectAssignmentRepository.findAllById(dataTrajectorySubjectAssignmentIds);
		List<DataTrajectorySubjectAssignmentDTO>  dataTrajectorySubjectAssignmentDTOList = new ArrayList<>();
		dataTrajectorySubjectAssignmentDTOList = getDataTrajectorySubjectAssignmentDTO(dataTrajectorySubjectAssignmentDTOList, dataTrajectorySubjectAssignmentList);
		return dataTrajectorySubjectAssignmentDTOList;
	}
	
	public void saveDataTrajectorySubjectAssignmentDTOList(List<DataTrajectorySubjectAssignmentDTO> dataTrajectorySubjectAssignmentDTOList) throws InstantiationException, IllegalAccessException{
		
		if(!CollectionUtils.isEmpty(dataTrajectorySubjectAssignmentDTOList)) {
			Set<DataTrajectorySubjectAssignment> dataTrajectorySubjectAssignmentSet = new HashSet<>();
			dataTrajectorySubjectAssignmentSet = getDataTrajectorySubjectAssignment(dataTrajectorySubjectAssignmentSet, dataTrajectorySubjectAssignmentDTOList);
			dataTrajectorySubjectAssignmentRepository.saveAll(dataTrajectorySubjectAssignmentSet);
			dataTrajectorySubjectAssignmentRepository.flush();
		}
		
	}
	
	/**
	 * 
	 * @param dataTrajectorySubjectAssignmentIds
	 * @return
	 */
	public String deleteDataTrajectorySubjectAssignmentDTOList(List<Long> dataTrajectorySubjectAssignmentIds) {
		String result = "fail";
		if(!CollectionUtils.isEmpty(dataTrajectorySubjectAssignmentIds)) {
			for(Long dataTrajectorySubjectAssignmentId : dataTrajectorySubjectAssignmentIds) {
				dataTrajectorySubjectAssignmentRepository.deleteById(dataTrajectorySubjectAssignmentId);
			}
			result = "success";
		}
		return result;
	}
	
	/**
	 * @param dataTrajectorySubjectAssignmentDTOList
	 * @param dataTrajectorySubjectAssignmentList
	 * @return
	 */
	public List<DataTrajectorySubjectAssignmentDTO> getDataTrajectorySubjectAssignmentDTO(List<DataTrajectorySubjectAssignmentDTO> dataTrajectorySubjectAssignmentDTOList,
			List<DataTrajectorySubjectAssignment> dataTrajectorySubjectAssignmentList) {
		DataTrajectorySubjectAssignmentDTO dataTrajectorySubjectAssignmentDTO = null;
		AssignedSubjectDTO assignedSubjectDTO = null;
		List<AssignedSubjectDTO> assignedSubjectDTOList = null;	
		if(!CollectionUtils.isEmpty(dataTrajectorySubjectAssignmentList)) {
			dataTrajectorySubjectAssignmentDTOList = new ArrayList<>();
			for(DataTrajectorySubjectAssignment dataTrajectorySubjectAssignment : dataTrajectorySubjectAssignmentList) {
				dataTrajectorySubjectAssignmentDTO = new DataTrajectorySubjectAssignmentDTO();
				BeanUtils.copyProperties(dataTrajectorySubjectAssignment, dataTrajectorySubjectAssignmentDTO);
				if(!CollectionUtils.isEmpty(dataTrajectorySubjectAssignment.getAssignedSubjectSet())) {
					assignedSubjectDTOList = new ArrayList<>();
					for(AssignedSubject assignedSubject : dataTrajectorySubjectAssignment.getAssignedSubjectSet()) {
						assignedSubjectDTO = new AssignedSubjectDTO();
						BeanUtils.copyProperties(assignedSubject, assignedSubjectDTO);
						assignedSubjectDTOList.add(assignedSubjectDTO);
					}
					dataTrajectorySubjectAssignmentDTO.setAssignedSubjectDTOList(assignedSubjectDTOList);
				}
				dataTrajectorySubjectAssignmentDTOList.add(dataTrajectorySubjectAssignmentDTO);	
			}			
		}
		return dataTrajectorySubjectAssignmentDTOList;
	}
	
	private Set<DataTrajectorySubjectAssignment> getDataTrajectorySubjectAssignment(Set<DataTrajectorySubjectAssignment> dataTrajectorySubjectAssignmentSet,
			List<DataTrajectorySubjectAssignmentDTO> dataTrajectorySubjectAssignmentDTOList) throws InstantiationException, IllegalAccessException{
		
		DataTrajectory dataTrajectory;
		DataTrajectorySubjectAssignment dataTrajectorySubjectAssignment;
		//AssignedSubjectDTO assignedSubjectDTO = null;
		Set<AssignedSubject> assignedSubjectSet;	
		//Set<DataTrajectorySubjectAssignment> dataTrajectorySubjectAssignmentSet;
		if(!CollectionUtils.isEmpty(dataTrajectorySubjectAssignmentDTOList)) {
			dataTrajectorySubjectAssignmentSet = new HashSet<>();
			for(DataTrajectorySubjectAssignmentDTO dataTrajectorySubjectAssignmentDTO : dataTrajectorySubjectAssignmentDTOList) {
				
				dataTrajectorySubjectAssignment = new DataTrajectorySubjectAssignment();
				BeanUtils.copyProperties(dataTrajectorySubjectAssignmentDTO, dataTrajectorySubjectAssignment);
				dataTrajectory = new DataTrajectory();
				dataTrajectory.setDataTrajectoryId(dataTrajectorySubjectAssignmentDTO.getDataTrajectoryId());
				dataTrajectorySubjectAssignment.setDataTrajectory(dataTrajectory);
				if(!CollectionUtils.isEmpty(dataTrajectorySubjectAssignmentDTO.getAssignedSubjectDTOList())) {
					assignedSubjectSet = new HashSet<>();
					for(AssignedSubjectDTO assignedSubjectDTO : dataTrajectorySubjectAssignmentDTO.getAssignedSubjectDTOList()) {
						AssignedSubject assignedSubject = new AssignedSubject();
						BeanUtils.copyProperties(assignedSubjectDTO,assignedSubject);
						assignedSubject.setDataTrajectorySubjectAssignment(dataTrajectorySubjectAssignment);
						assignedSubjectSet.add(assignedSubject);
					}
					dataTrajectorySubjectAssignment.setAssignedSubjectSet(assignedSubjectSet);
				}
				
				dataTrajectorySubjectAssignmentSet.add(dataTrajectorySubjectAssignment);
			}
			
		}
		return dataTrajectorySubjectAssignmentSet;
	}
	
}
