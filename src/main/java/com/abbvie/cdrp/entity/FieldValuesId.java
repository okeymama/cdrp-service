/**
 * 
 */
package com.abbvie.cdrp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author cchaubey
 *
 */
@Data
@Embeddable
@EqualsAndHashCode
public class FieldValuesId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "study_number")
	private String StudyNumber;
	
	@Column(name = "field_oid")
	private String FieldOID;
	
	@Column(name = "field_code")
	private String FieldCode;
	
}
