/**
 * 
 */
package com.abbvie.cdrp.dto;

import com.abbvie.cdrp.entity.ExpectedDataCategory;

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
	
	private Long expectedDataCategoryId;
	
}
