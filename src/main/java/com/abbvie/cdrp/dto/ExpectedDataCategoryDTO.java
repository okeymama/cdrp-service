/**
 * 
 */
package com.abbvie.cdrp.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

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
	
	private String criticalData;
	
	private String createdBy;
	
	private Date createdDate;
	
	private Date lastUpdatedDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private Long dataTrajectoryId;
	
	private List<IDRPCheckDTO> idrpCheckDTOList;
	
	private List<AppliedVisitDTO> appliedVisitDTOList;	
		
}
