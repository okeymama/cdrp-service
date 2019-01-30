/**
 * 
 */
package com.abbvie.cdrp.dto;

import com.abbvie.cdrp.entity.ExpectedDataCategory;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * @author cchaubey
 *
 */
@Data
public class AppliedVisitDTO {

	private Long appliedVisitId; 
	
	private Long visitId;
	
	private String visitName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private Long expectedDataCategoryId;
	
}
