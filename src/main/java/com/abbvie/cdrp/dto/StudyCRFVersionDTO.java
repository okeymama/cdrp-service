/**
 * 
 */
package com.abbvie.cdrp.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @author cchaubey
 *
 */
@Data
public class StudyCRFVersionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private StudyCRFVersionIdDTO id;
	
	private String studyActiveFlag;
	
	private String crfVersionName;
	
	private String crfVersionValidFlag;
	
	private String crfVersionIsDraftFlag;
	
	private String crfVersionHasClinicaldataFlag;
					
}
