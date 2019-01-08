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
public class FieldValuesIdDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String studyNumber;
	
	private String fieldOID;
	
	private String fieldCode;
	
}
