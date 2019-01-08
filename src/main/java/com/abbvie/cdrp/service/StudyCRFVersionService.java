/**
 * 
 */
package com.abbvie.cdrp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abbvie.cdrp.dto.StudyCRFVersionDTO;
import com.abbvie.cdrp.dto.StudyCRFVersionIdDTO;
import com.abbvie.cdrp.entity.StudyCRFVersion;
import com.abbvie.cdrp.entity.StudyCRFVersionId;
import com.abbvie.cdrp.repository.StudyCRFVersionRepository;

/**
 * @author cchaubey
 *
 */
@Service
public class StudyCRFVersionService {

	@Autowired
	StudyCRFVersionRepository studyCRFVersionRepository;
	
	public StudyCRFVersionDTO getStudyCRFVersion(StudyCRFVersionIdDTO studyCRFVerIdDTO) {
		StudyCRFVersionId studyCRFVersionId = new StudyCRFVersionId();
		BeanUtils.copyProperties(studyCRFVerIdDTO, studyCRFVersionId);
		StudyCRFVersion studyCRFVersion = studyCRFVersionRepository.getOne(studyCRFVersionId);
		StudyCRFVersionDTO studyCRFVersionDTO = new StudyCRFVersionDTO();
		copyToStudyCRFVersionDTO(studyCRFVersion, studyCRFVersionDTO);
		return studyCRFVersionDTO;
	}

	/**
	 * @param studyCRFVersion
	 * @param studyCRFVersionDTO
	 */
	private void copyToStudyCRFVersionDTO(StudyCRFVersion studyCRFVersion, StudyCRFVersionDTO studyCRFVersionDTO) {
		StudyCRFVersionIdDTO studyCRFVersionIdDTO = new StudyCRFVersionIdDTO();
		BeanUtils.copyProperties(studyCRFVersion.getId(), studyCRFVersionIdDTO);
		BeanUtils.copyProperties(studyCRFVersion, studyCRFVersionDTO);
		studyCRFVersionDTO.setId(studyCRFVersionIdDTO);
	}

}
