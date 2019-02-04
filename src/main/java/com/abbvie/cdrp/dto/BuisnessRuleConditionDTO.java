package com.abbvie.cdrp.dto;

import java.time.LocalDate;
import java.util.Date;

import com.abbvie.cdrp.entity.BusinessRule;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
public class BuisnessRuleConditionDTO {

	private Long businessRuleConditionId;	
	
	private String visit;
	
	private String form;
	
	private String field;
	
	private String fieldValue;
	
	private String type;
	
	private String createdBy;
	
	private LocalDate createdDate;
	
	private LocalDate lastUpdatedDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long businessRuleId;
	 
	
}
