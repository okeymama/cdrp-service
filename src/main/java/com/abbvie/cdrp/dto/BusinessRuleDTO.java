package com.abbvie.cdrp.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
public class BusinessRuleDTO {

	private Long businessRuleId;
	
	private String subjectDescription;
	
	private String form;
	
	private boolean isExpected;
	
	private String frequency;
	
	private String createdBy;
	
	private LocalDate creationDate;
	
	private LocalDate lastUpdatedDate;	
	
	private List<BuisnessRuleConditionDTO> businessRuleConditionDTOList;	
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private Long expectedDataCategoryId;

}
