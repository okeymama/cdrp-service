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
public class StudyFolderCategoryFormFieldDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private StudyFolderCategoryFormFieldIdDTO id;
	
	private String folderOrdinal;
	
	private String folderName;
	
	private String folderReusableFlag;
	
	private String folderIsDraftFlag;
	
	private String formOrdinal;
	
	private String formName;
	
	private String formIsSignatureRequiredFlag;
	
	private String formIsDraftFlag;
	
	private String fieldOrdinal;
	
	private String fieldName;
	
	private String fieldIsVisibleFlag;
	
	private String fieldIsRequiredFlag;
	
	private String fieldHasClinicalSignificanceFlag;
	
	private String fieldIsDraftFlag;

}

