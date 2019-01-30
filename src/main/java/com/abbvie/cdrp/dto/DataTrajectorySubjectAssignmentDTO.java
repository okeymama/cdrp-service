/**
 * 
 */
package com.abbvie.cdrp.dto;

import java.util.Date;
import java.util.List;

import com.abbvie.cdrp.entity.DataTrajectory;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * @author cchaubey
 *
 */
@Data
public class DataTrajectorySubjectAssignmentDTO {

	private Long dataTrajectorySubjectAssignmentId;	
	
	private String visit;
	
	private String form;
	
	private String field;
	
	private String fieldValue;
	
	private String createdBy;
	
	private Date createdDate;
	
	private Date lastUpdatedDate;
	
	private List<AssignedSubjectDTO> assignedSubjectDTOList; 
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private Long dataTrajectoryId;
	
}
