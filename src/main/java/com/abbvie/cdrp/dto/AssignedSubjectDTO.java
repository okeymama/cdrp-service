/**
 * 
 */
package com.abbvie.cdrp.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * @author cchaubey
 *
 */
@Data
public class AssignedSubjectDTO {

	private Long assignedSubjectId;
	
	private String subjectId;
	
	private String createdBy;
	
	private Date creationDate;
	
	private Date lastUpdatedDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private Long dataTrajectorySubjectAssignmentId;
	
}
