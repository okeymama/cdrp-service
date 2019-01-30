/**
 * 
 */
package com.abbvie.cdrp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author cchaubey
 *
 */
@Data
@Entity
@Table(name="run_result")
@EqualsAndHashCode(of = {"recordIdentifier","comments"})
public class RunResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="study_id")
	private String studyId;
	
	@Column(name="site")
	private String site;
	
	@Column(name="subject")
	private String subject;
	
	@Id
	@Column(name="record_identifier")
	private String recordIdentifier;
	
	@Column(name="visit")
	private String visit;
	
	@Column(name="data_category")
	private String dataCategory;
	
	@Column(name="form_name")
	private String formName;
	
	@Column(name="field_name")
	private String fieldName;
	
	@Column(name="field_value")
	private String fieldValue;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="check_id")
	private String checkId;
	
	@Column(name="created_date")
	private String createdDate;
	
	@Column(name="modified_date")
	private String modifiedDate;
	
	@Column(name="query_status")
	private String queryStatus;
	
}
