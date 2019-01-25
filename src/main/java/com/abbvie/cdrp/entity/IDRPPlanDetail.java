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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author cchaubey
 *
 */
@Data
@Entity
@Table(name="idrp_plan_detail")
public class IDRPPlanDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idrp_plan_detail_id")
	private Long idrpPlanDetailsId;
	
	@Column(name="study_id")
	private String studyId;

	@Column(name="plan_owner")
	private String planOwner;
	
	@Column(name="plan_version")
	private String planVersion;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="approval_date")
	private Date approvalDate;
	
	@Column(name="last_modified_by")
	private Date lastModifiedBy;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "idrpPlanDetail", orphanRemoval = true)
	private Set<DataTrajectory> dataTrajectorySet;
}
