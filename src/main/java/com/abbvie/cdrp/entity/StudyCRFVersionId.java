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
public class StudyCRFVersionId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "study_number")
	private String studyNumber;
	
	@Column(name = "latest_crf_version_id")
	private String latestCRFVersionId;
	
	@Column(name = "environment")
	private String environment;
	
}
