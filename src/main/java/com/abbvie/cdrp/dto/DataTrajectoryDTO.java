/**
 * 
 */
package com.abbvie.cdrp.dto;

import java.util.Date;
import java.util.List;

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
	
	private Date createdDate;
	
	private Date lastUpdatedDate;
	
	private IDRPPlanDetailDTO idrpPlanDetailDTO;
	
	private List<ExpectedDataCategoryDTO> expectedDataCategoryDTOList;
	
	private List<DataTrajectorySubjectAssignmentDTO> dataTrajectorySubjectAssignmentDTOList;
	
}
