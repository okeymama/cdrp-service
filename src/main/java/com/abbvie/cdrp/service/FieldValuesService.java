/**
 * 
 */
package com.abbvie.cdrp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abbvie.cdrp.dto.FieldValuesDTO;
import com.abbvie.cdrp.dto.FieldValuesIdDTO;
import com.abbvie.cdrp.entity.FieldValues;
import com.abbvie.cdrp.entity.FieldValuesId;
import com.abbvie.cdrp.repository.FieldValuesRepository;

/**
 * @author cchaubey
 *
 */
@Service
public class FieldValuesService {

	@Autowired
	private FieldValuesRepository fieldValuesRepository;
	
	public FieldValuesDTO getFieldValues(FieldValuesIdDTO fieldValIdDTO) {
		FieldValuesId fieldValuesId = new FieldValuesId(); 
		BeanUtils.copyProperties(fieldValIdDTO, fieldValuesId);
		FieldValues fieldValues = fieldValuesRepository.getOne(fieldValuesId);
		FieldValuesDTO fieldValuesDTO = new FieldValuesDTO();
		copyToFieldValuesDTO(fieldValues, fieldValuesDTO);
		return fieldValuesDTO;	
	}	

	private void copyToFieldValuesDTO(FieldValues fieldValues, FieldValuesDTO fieldValuesDTO) {
		FieldValuesIdDTO fieldValuesIdDTO = new FieldValuesIdDTO();
		BeanUtils.copyProperties(fieldValues, fieldValuesDTO);
		BeanUtils.copyProperties(fieldValues.getId(), fieldValuesIdDTO);
		fieldValuesDTO.setId(fieldValuesIdDTO);
	}

}
