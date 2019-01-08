/**
 * 
 */
package com.abbvie.cdrp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author cchaubey
 *
 */
@Data	
@Entity
@Table(name="field_values")
public class FieldValues implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FieldValuesId id;
	
	@Column(name = "alternate_field_oid")
	private String alternateFieldOID;
	
	@Column(name = "field_values")
	private String fieldValues;
	
}
