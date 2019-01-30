/**
 * 
 */
package com.abbvie.cdrp.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * @author cchaubey
 *
 */
@Data
public class IDRPCheckDTO {

	private Long idrpCheckId;
	
	private String purpose;
	
	private String description;	
	
	private String visit;	
	
	private String role;
	
	private String method;
	
	private String frequency;	
	
	private String owner;	
	
	private String checkName;
	
	private String queryText;	
	
	private String source;
	
	private String createdBy;
	
	private Date createdDate;
	
	private Date lastUpdatedDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private Long expectedDataCategoryId;
	
}
