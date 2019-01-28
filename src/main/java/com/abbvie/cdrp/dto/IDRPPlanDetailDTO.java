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
public class IDRPPlanDetailDTO {

	private Long idrpPlanDetailId;
	
	private String studyId;

	private String planOwner;
	
	private String planVersion;
	
	private Date createdDate;
	
	private Date approvalDate;
	
	private Date lastModifiedBy;
	
	private List<DataTrajectoryDTO> dataTrajectoryDTOList;
	
}
