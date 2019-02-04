package com.abbvie.cdrp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abbvie.cdrp.dto.DataTrajectoryDTO;
import com.abbvie.cdrp.dto.ExpectedDataCategoryDTO;
import com.abbvie.cdrp.entity.DataTrajectory;
import com.abbvie.cdrp.entity.ExpectedDataCategory;
import com.abbvie.cdrp.repository.DataTrajectoryRepository;
import com.abbvie.cdrp.repository.ExpectedDataCategoryRepository;

@Service 
public class AddDataTrajectoryPageService {
	
	@Autowired
	private DataTrajectoryService dataTrajectoryService;
	
	public void saveNewDataTrajectoryDTO(DataTrajectoryDTO dataTrajectoryDTO) throws InstantiationException, IllegalAccessException{
		List<DataTrajectoryDTO> dataTrajectoryDTOList = new ArrayList<>();
		dataTrajectoryDTO.setCreatedDate(LocalDate.now());
		dataTrajectoryDTO.setLastUpdatedDate(LocalDate.now());
		for(ExpectedDataCategoryDTO expectedDataCategory : dataTrajectoryDTO.getExpectedDataCategoryDTOList()) {
			expectedDataCategory.setCreatedDate(LocalDate.now());
			expectedDataCategory.setLastUpdatedDate(LocalDate.now());
		}
		dataTrajectoryDTOList.add(dataTrajectoryDTO); 
		dataTrajectoryService.saveDataTrajectoryDTOList(dataTrajectoryDTOList);
	}	
		

}
