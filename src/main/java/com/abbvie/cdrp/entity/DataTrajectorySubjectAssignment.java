/**
 * 
 */
package com.abbvie.cdrp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="data_trajectory_subject_assignment")
@EqualsAndHashCode(of = { "dataTrajectorySubjectAssignmentId" })
public class DataTrajectorySubjectAssignment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="data_trajectory_subject_assignment_id")
	private Long dataTrajectorySubjectAssignmentId;	
	
	@Column(name="visit")
	private String visit;
	
	@Column(name="form")
	private String form;
	
	@Column(name="field")
	private String field;
	
	@Column(name="field_value")
	private String fieldValue;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = DataTrajectory.class)
    @JoinColumn(name = "data_trajectory_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private DataTrajectory dataTrajectory;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "dataTrajectorySubjectAssignment", orphanRemoval = true)
	private Set<AssignedSubject> assignedSubjectSet; 
	
}
