/**
 * 
 */
package com.abbvie.cdrp.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
import lombok.EqualsAndHashCode;

/**
 * @author cchaubey
 *
 */
@Data
@Entity
@Table(name="idrp_plan_detail")
@EqualsAndHashCode(of = { "idrpPlanDetailId","studyId","planVersion"})
public class IDRPPlanDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idrp_plan_detail_id")
	private Long idrpPlanDetailId;
	
	@Column(name="study_id")
	private String studyId;

	@Column(name="plan_owner")
	private String planOwner;
	
	@Column(name="plan_version")
	private String planVersion;
	
	@Column(name="created_date")
	private LocalDate createdDate;
	
	@Column(name="approval_date")
	private LocalDate approvalDate;
	
	@Column(name="last_modified_by")
	private LocalDate lastModifiedBy;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "idrpPlanDetail")
	private Set<DataTrajectory> dataTrajectorySet;
}
