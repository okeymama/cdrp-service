/**
 * 
 */
package com.abbvie.cdrp.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * @author cchaubey
 *
 */
@Data
public class DataTrajectoryDTO {

	private Long dataTrajectoryId;
	
	private String dataTrajectoryName;
	
	private String description;
	
	private String createdBy;
	
	private LocalDate createdDate;
	
	private LocalDate lastUpdatedDate;
	
	private List<ExpectedDataCategoryDTO> expectedDataCategoryDTOList;
	
	private List<DataTrajectorySubjectAssignmentDTO> dataTrajectorySubjectAssignmentDTOList;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private Long idrpPlanDetailId;

}
