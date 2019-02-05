/**
 * 
 */
package com.abbvie.cdrp.dto;

import java.time.LocalDate;
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
	
	private LocalDate creationDate;
	
	private LocalDate lastUpdatedDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private Long dataTrajectorySubjectAssignmentId;
	
}
