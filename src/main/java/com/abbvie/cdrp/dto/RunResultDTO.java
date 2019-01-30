package com.abbvie.cdrp.dto;


import lombok.Data;

@Data
public class RunResultDTO {
	
	private String studyId;
	
	private String site;
	
	private String subject;
	
	private String recordIdentifier;
	
	private String visit;
	
	private String dataCategory;
	
	private String formName;
	
	private String fieldName;
	
	private String fieldValue;
	
	private String comments;
	
	private String checkId;
	
	private String createdDate;
	
	private String modifiedDate;
	
	private String queryStatus;
}
