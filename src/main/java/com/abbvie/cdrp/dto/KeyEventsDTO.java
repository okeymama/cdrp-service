/**
 * 
 */
package com.abbvie.cdrp.dto;

import java.util.Date;

import lombok.Data;

/**
 * @author cchaubey
 *
 */
@Data
public class KeyEventsDTO {

	private String eventName;
	
	private Date plannedDate;
	
	private Date actualDate;
	
}
