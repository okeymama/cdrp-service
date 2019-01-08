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
public class FieldValuesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private FieldValuesIdDTO id;
	
	private String alternateFieldOID;
	
	private String fieldValues;
	
}
