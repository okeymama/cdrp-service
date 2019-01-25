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

/**
 * @author cchaubey
 *
 */
@Data
@Entity
@Table(name="data_trajectory")
public class DataTrajectory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="data_trajectory_id")
	private Long dataTrajectoryId;
	
	@Column(name="data_trajectory_name")
	private String dataTrajectoryName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = IDRPPlanDetail.class)
    @JoinColumn(name = "idrp_plan_detail_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private IDRPPlanDetail idrpPlanDetail;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "dataTrajectory", orphanRemoval = true)
	private Set<ExpectedDataCategory> expectedDataCategorySet;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "dataTrajectory", orphanRemoval = true)
	private Set<DataTrajectorySubjectAssignment> dataTrajectorySubjectAssignmentSet;
}
