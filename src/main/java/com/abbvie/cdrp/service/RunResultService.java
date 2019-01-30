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
import com.abbvie.cdrp.dto.RunResultDTO;
import com.abbvie.cdrp.entity.AssignedSubject;
import com.abbvie.cdrp.entity.DataTrajectorySubjectAssignment;
import com.abbvie.cdrp.entity.RunResult;
import com.abbvie.cdrp.repository.RunResultRepository;

@Service
public class RunResultService {
	
	@Autowired
	private RunResultRepository runResultRepository;
	
	/**
	 * 
	 * @return
	 */
	public List<RunResultDTO> getAllRunResultDTO() {
		List<RunResult> runResultList = runResultRepository.findAll();
		List<RunResultDTO> runResultDTOList = new ArrayList<>();
		runResultDTOList = getRunResultDTO(runResultDTOList, runResultList);
		return runResultDTOList;
	}
	
	/**
	 * 
	 * @param runResultIds
	 * @return
	 */
	public List<RunResultDTO> getRunResultDTOListByIds(List<String> runResultIds) {
		List<RunResult> runResultList = runResultRepository.findAllById(runResultIds);
		List<RunResultDTO>  runResultDTOList = new ArrayList<>();
		runResultDTOList = getRunResultDTO(runResultDTOList, runResultList);
		return runResultDTOList;
	}
	
	public List<RunResultDTO> getRunResultDTOListByStudyIds(List<String> runResultStudyIds) {
		List<RunResult> runResultList = runResultRepository.findAllByStudyIdIn(runResultStudyIds);
		List<RunResultDTO>  runResultDTOList = new ArrayList<>();
		runResultDTOList = getRunResultDTO(runResultDTOList, runResultList);
		return runResultDTOList;
	}
	
	public void saveRunResultDTOList(List<RunResultDTO> runResultDTOList) throws InstantiationException, IllegalAccessException{
		
		if(!CollectionUtils.isEmpty(runResultDTOList)) {
			Set<RunResult> runResultSet = new HashSet<>();
			runResultSet = getRunResult(runResultSet, runResultDTOList);
			runResultRepository.saveAll(runResultSet);
			runResultRepository.flush();
		}
		
	}
	
	/**
	 * @param runResultDTOList
	 * @param runResultList
	 * @return
	 */
	public List<RunResultDTO> getRunResultDTO(List<RunResultDTO> runResultDTOList,
			List<RunResult> runResultList) {
		RunResultDTO runResultDTO = null;
		if(!CollectionUtils.isEmpty(runResultList)) {
			runResultDTOList = new ArrayList<>();
			for(RunResult runResult : runResultList) {
				runResultDTO = new RunResultDTO();
				BeanUtils.copyProperties(runResult, runResultDTO);
				runResultDTOList.add(runResultDTO);	
			}			
		}
		return runResultDTOList;
	}
	
	private Set<RunResult> getRunResult(Set<RunResult> runResultSet,
			List<RunResultDTO> runResultDTOList) throws InstantiationException, IllegalAccessException {

		RunResult runResult = null;
		if(!CollectionUtils.isEmpty(runResultDTOList)) {
			runResultSet = new HashSet<>();
			for(RunResultDTO runResultDTO : runResultDTOList) {
				runResult = new RunResult();
				BeanUtils.copyProperties(runResultDTO, runResult);
				runResultSet.add(runResult);
			}
			
		}
		return runResultSet;
	}	
	
}
