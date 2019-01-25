/**
 * 
 */
package com.abbvie.cdrp.dto;

import java.util.Date;
import java.util.List;

import com.abbvie.cdrp.entity.DataTrajectory;

import lombok.Data;

/**
 * @author cchaubey
 *
 */
@Data
public class IDRPPlanDetailDTO {

	private Long idrpPlanDetailsId;
	
	private String studyId;

	private String planOwner;
	
	private String planVersion;
	
	private Date createdDate;
	
	private Date approvalDate;
	
	private Date lastModifiedBy;
	
	private List<DataTrajectoryDTO> dataTrajectoryDTOList;
	
}
