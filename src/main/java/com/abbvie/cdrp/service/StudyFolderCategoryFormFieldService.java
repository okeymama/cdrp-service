/**
 * 
 */
package com.abbvie.cdrp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abbvie.cdrp.dto.StudyFolderCategoryFormFieldDTO;
import com.abbvie.cdrp.dto.StudyFolderCategoryFormFieldIdDTO;
import com.abbvie.cdrp.entity.StudyFolderCategoryFormField;
import com.abbvie.cdrp.entity.StudyFolderCategoryFormFieldId;
import com.abbvie.cdrp.repository.StudyFolderCategoryFormFieldRepository;

/**
 * @author cchaubey
 *
 */
@Service
public class StudyFolderCategoryFormFieldService {

	@Autowired
	private StudyFolderCategoryFormFieldRepository studyFolderCategoryFormFieldRepository;
	
	
	public StudyFolderCategoryFormFieldDTO getStudyFolderCategoryFormField(
			StudyFolderCategoryFormFieldId studyFolderCategoryFormFieldId) {
		 StudyFolderCategoryFormField studyFolderCategoryFormField = studyFolderCategoryFormFieldRepository.getOne(studyFolderCategoryFormFieldId);
		 StudyFolderCategoryFormFieldDTO studyFolderCategoryFormFieldDTO = new StudyFolderCategoryFormFieldDTO();
		 StudyFolderCategoryFormFieldIdDTO studyFolderCategoryFormFieldIdDTO = new StudyFolderCategoryFormFieldIdDTO();
		 BeanUtils.copyProperties(studyFolderCategoryFormField, studyFolderCategoryFormFieldDTO);
		 BeanUtils.copyProperties(studyFolderCategoryFormField.getId(), studyFolderCategoryFormFieldIdDTO);
		 studyFolderCategoryFormFieldDTO.setId(studyFolderCategoryFormFieldIdDTO);
		 return studyFolderCategoryFormFieldDTO;
	}

}
