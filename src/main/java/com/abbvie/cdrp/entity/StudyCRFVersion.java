/**
 * 
 */
package com.abbvie.cdrp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author cchaubey
 *
 */
@Data	
@Entity
@Table(name="study_crf_version")
public class StudyCRFVersion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StudyCRFVersionId id;
	
	@Column(name = "study_active_flag")
	private String StudyActiveFlag;
	
	@Column(name = "crf_version_name")
	private String CRFVersionName;
	
	@Column(name = "crf_version_valid_flag")
	private String CRFVersionValidFlag;
	
	@Column(name = "crf_version_is_draft_flag")
	private String CRFVersionIsDraftFlag;
	
	@Column(name = "crf_version_has_clinicaldata_flag")
	private String CRFVersionHasClinicaldataFlag;
					
}
