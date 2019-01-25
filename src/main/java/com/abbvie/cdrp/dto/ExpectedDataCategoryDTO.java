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
public class ExpectedDataCategoryDTO {

	private Long expectedDataCategoryId;
	
	private String expectedDataCategoryName;
	
	private String source;
	
	private String dataTransferFrequency;
	
	private Boolean isCriticalData;
	
	private String createdBy;
	
	private Date createdDate;
	
	private Date lastUpdatedDate;
	
	private DataTrajectoryDTO dataTrajectoryDTO;
	
	private List<IDRPCheckDTO> idrpCheckDTOList;
	
	private List<AppliedVisitDTO> appliedVisitDTOList;	
		
}
