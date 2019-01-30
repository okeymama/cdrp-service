package com.abbvie.cdrp.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.abbvie.cdrp.dto.AssignedSubjectDTO;
import com.abbvie.cdrp.dto.DataTrajectorySubjectAssignmentDTO;
import com.abbvie.cdrp.entity.AssignedSubject;
import com.abbvie.cdrp.entity.DataTrajectorySubjectAssignment;
import com.abbvie.cdrp.repository.AssignedSubjectRepository;


@Service
public class AssignedSubjectService {
	
	@Autowired
	private AssignedSubjectRepository assignedSubjectRepository;
	
	/**
	 * 
	 * @return
	 */
	public List<AssignedSubjectDTO> getAllAssignedSubjectDTO() {
		List<AssignedSubject> assignedSubjectList = assignedSubjectRepository.findAll();
		List<AssignedSubjectDTO> assignedSubjectDTOList = new ArrayList<>();
		assignedSubjectDTOList = getAssignedSubjectDTO(assignedSubjectDTOList, assignedSubjectList);
		return assignedSubjectDTOList;
	}
	
	/**
	 * 
	 * @param assignedSubjectIds
	 * @return
	 */
	public List<AssignedSubjectDTO> getAssignedSubjectDTOListByIds(List<Long> assignedSubjectIds) {
		List<AssignedSubject> assignedSubjectList = assignedSubjectRepository.findAllById(assignedSubjectIds);
		List<AssignedSubjectDTO>  assignedSubjectDTOList = new ArrayList<>();
		assignedSubjectDTOList = getAssignedSubjectDTO(assignedSubjectDTOList, assignedSubjectList);
		return assignedSubjectDTOList;
	}
	
	public void saveAssignedSubjectDTOList(List<AssignedSubjectDTO> assignedSubjectDTOList) throws InstantiationException, IllegalAccessException{
		
		if(!CollectionUtils.isEmpty(assignedSubjectDTOList)) {
			Set<AssignedSubject> assignedSubjectSet = new HashSet<>();
			assignedSubjectSet = getAssignedSubject(assignedSubjectSet, assignedSubjectDTOList);
			assignedSubjectRepository.saveAll(assignedSubjectSet);
			assignedSubjectRepository.flush();
		}
		
	}
	
	/**
	 * 
	 * @param assignedSubjectIds
	 * @return
	 */
	public String deleteAssignedSubjectDTOList(List<Long> assignedSubjectIds) {
		String result = "fail";
		if(!CollectionUtils.isEmpty(assignedSubjectIds)) {
			for(Long assignedSubjectId : assignedSubjectIds) {
				assignedSubjectRepository.deleteById(assignedSubjectId);
			}
			result = "success";
		}
		return result;
	}
	
	/**
	 * @param assignedSubjectDTOList
	 * @param assignedSubjectList
	 * @return
	 */
	public List<AssignedSubjectDTO> getAssignedSubjectDTO(List<AssignedSubjectDTO> assignedSubjectDTOList,
			List<AssignedSubject> assignedSubjectList) {
		AssignedSubjectDTO assignedSubjectDTO = null;
		if(!CollectionUtils.isEmpty(assignedSubjectList)) {
			assignedSubjectDTOList = new ArrayList<>();
			for(AssignedSubject assignedSubject : assignedSubjectList) {
				assignedSubjectDTO = new AssignedSubjectDTO();
				BeanUtils.copyProperties(assignedSubject, assignedSubjectDTO);
				assignedSubjectDTOList.add(assignedSubjectDTO);	
			}			
		}
		return assignedSubjectDTOList;
	}
	
	private Set<AssignedSubject> getAssignedSubject(Set<AssignedSubject> assignedSubjectSet,
			List<AssignedSubjectDTO> assignedSubjectDTOList) throws InstantiationException, IllegalAccessException {

		DataTrajectorySubjectAssignment dataTrajectorySubjectAssignment;
		AssignedSubject assignedSubject;
		if(!CollectionUtils.isEmpty(assignedSubjectDTOList)) {
			assignedSubjectSet = new HashSet<>();
			for(AssignedSubjectDTO assignedSubjectDTO : assignedSubjectDTOList) {
				dataTrajectorySubjectAssignment = new DataTrajectorySubjectAssignment();
				assignedSubject = new AssignedSubject();
				dataTrajectorySubjectAssignment.setDataTrajectorySubjectAssignmentId(assignedSubjectDTO.getDataTrajectorySubjectAssignmentId());
				BeanUtils.copyProperties(assignedSubjectDTO, assignedSubject);
				assignedSubject.setDataTrajectorySubjectAssignment(dataTrajectorySubjectAssignment);
				assignedSubjectSet.add(assignedSubject);
			}
			
		}
		return assignedSubjectSet;
	}	
		
	
	
}
