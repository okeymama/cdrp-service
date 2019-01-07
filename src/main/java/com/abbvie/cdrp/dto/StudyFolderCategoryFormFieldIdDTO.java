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
public class StudyFolderCategoryFormFieldIdDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String studyNumber;
	
	private String latestCRFVersionId;
	
	private String folderOID;
	
	private String dataCategory;
	
	private String formOID;
	
	private String fieldOID;
	
	private String source;
	
}
