/**
 * 
 */
package com.abbvie.cdrp.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * @author cchaubey
 *
 */
@Data
public class IDRPPlanDetailDTO {

	private Long idrpPlanDetailId;
	
	private String studyId;

	private String planOwner;
	
	private String planVersion;
	
	private LocalDate createdDate;
	
	private LocalDate approvalDate;
	
	private LocalDate lastModifiedBy;
	
	private List<DataTrajectoryDTO> dataTrajectoryDTOList;
	
}
