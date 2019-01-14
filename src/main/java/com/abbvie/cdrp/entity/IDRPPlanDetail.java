/**
 * 
 */
package com.abbvie.cdrp.entity;

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
public class IDRPPlanDetail {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idrp_plan_detail_id")
	private String idrpPlanDetailsId;
	
	@Column(name="study_id")
	private String studyId;

	@Column(name="plan_owner")
	private String planOwner;
	
	@Column(name="plan_version")
	private String planVersion;
	
	@Column(name="created_date")
	private String createdDate;
	
	@Column(name="approval_date")
	private String approvalDate;
	
	@Column(name="last_modified_by")
	private String lastModifiedBy;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "idrpPlanDetail", orphanRemoval = true)
	private Set<DataTrajectory> dataTrajectorySet;
}
