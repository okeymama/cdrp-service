/**
 * 
 */
package com.abbvie.cdrp.entity;

import java.io.Serializable;
import java.util.Date;

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
	private String studyActiveFlag;
	
	@Column(name = "crf_version_name")
	private String crfVersionName;
	
	@Column(name = "crf_version_valid_flag")
	private String crfVersionValidFlag;
	
	@Column(name = "crf_version_is_draft_flag")
	private String crfVersionIsDraftFlag;
	
	@Column(name = "crf_version_has_clinicaldata_flag")
	private String crfVersionHasClinicaldataFlag;
					
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;
}
