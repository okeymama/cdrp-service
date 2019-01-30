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


@Data
@Entity
@Table(name="assigned_subject")
@EqualsAndHashCode(of = { "assignedSubjectId","subjectId" })
public class AssignedSubject implements Serializable{
	
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
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = DataTrajectorySubjectAssignment.class)
    @JoinColumn(name = "data_trajectory_subject_assignment_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private DataTrajectorySubjectAssignment dataTrajectorySubjectAssignment;
	
}
