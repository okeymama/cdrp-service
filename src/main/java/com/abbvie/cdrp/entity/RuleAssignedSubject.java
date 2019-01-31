/**
 * 
 */
package com.abbvie.cdrp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author cchaubey
 *
 */
@Data
@Entity
@Table(name="rule_assigned_subject")
@EqualsAndHashCode(of = { "assignedSubjectId","subjectId" })
public class RuleAssignedSubject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="assigned_subject_id")
	private Long assignedSubjectId;
	
	@Column(name="subject_id")
	private Long subjectId;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = ExpectedDataCategory.class)
    @JoinColumn(name = "expected_data_category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private ExpectedDataCategory expectedDataCategory;
	
}
