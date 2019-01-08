/**
 * 
 */
package com.abbvie.cdrp.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @author cchaubey
 *
 */
@Data
public class StudyCRFVersionIdDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String studyNumber;
	
	private String latestCRFVersionId;
	
	private String environment;
	
}
