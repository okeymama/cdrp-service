/**
 * 
 */
package com.abbvie.cdrp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author cchaubey
 *
 */
@Data
@Embeddable
@EqualsAndHashCode
public class StudyFolderCategoryFormFieldId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "study_number")
	private String studyNumber;
	
	@Column(name = "latest_crf_version_id")
	private String latestCRFVersionId;
	
	@Column(name = "folder_oid")
	private String folderOID;
	
	@Column(name = "data_category")
	private String dataCategory;
	
	@Column(name = "form_oid")
	private String formOID;
	
	@Column(name = "field_oid")
	private String fieldOID;
	
	@Column(name = "source")
	private String source;
	
}
