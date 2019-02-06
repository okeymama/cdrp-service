/**
 * 
 */
package com.abbvie.cdrp.dto;

import lombok.Data;

/**
 * @author cchaubey
 *
 */
@Data
public class ReferenceDTO {

	private String therapeuticArea;
	
	private String compound;
	
	private String indication;
	
	private String fullProtocalTitle;
	
	private String studyStatus;
	
	private String studyPhase;
	
	private String studyType;
	
}
