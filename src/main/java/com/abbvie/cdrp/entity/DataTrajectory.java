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
public class DataTrajectory {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="data_trajectory_id")
	private String dataTrajectoryId;
	
	@Column(name="data_trajectory_name")
	private String dataTrajectoryName;
	
	@Column(name="arm_name")
	private String armName;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = IDRPPlanDetail.class)
    @JoinColumn(name = "idrp_plan_detail_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private IDRPPlanDetail idrpPlanDetail;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "dataTrajectory", orphanRemoval = true)
	private Set<ExpeactedDataCategory> expeactedDataCategory;
	
}
