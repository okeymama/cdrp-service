/**
 * 
 */
package com.abbvie.cdrp.dto;

import java.util.Date;

import lombok.Data;

/**
 * @author cchaubey
 *
 */
@Data
public class AssignedSubjectDTO {

	private Long assignedSubjectId;
	
	private Long subjectId;
	
	private String createdBy;
	
	private Date creationDate;
	
	private Date lastUpdatedDate;
	
}
