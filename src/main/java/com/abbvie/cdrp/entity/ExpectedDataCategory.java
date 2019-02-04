/**
 * 
 */
package com.abbvie.cdrp.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name="expected_data_category")
@EqualsAndHashCode(of = { "expectedDataCategoryId","expectedDataCategoryName","source","dataTransferFrequency" })
public class ExpectedDataCategory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="expected_data_category_id")
	private Long expectedDataCategoryId;
	
	@Column(name="expected_data_category_name")
	private String expectedDataCategoryName;
	
	@Column(name="source")
	private String source;
	
	@Column(name="data_transfer_frequency")
	private String dataTransferFrequency;
	
	@Column(name="critical_data")
	private String criticalData;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_date")
	private LocalDate createdDate;
	
	@Column(name="last_updated_date")
	private LocalDate lastUpdatedDate;
	
	@Column(name="comment")
	private String comment;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = DataTrajectory.class)
    @JoinColumn(name = "data_trajectory_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private DataTrajectory dataTrajectory;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "expectedDataCategory")
	private Set<IDRPCheck> idrpCheckSet;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "expectedDataCategory")
	private Set<AppliedVisit> appliedVisitSet;	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "expectedDataCategory")
	private Set<BusinessRule> businessRuleSet;	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "expectedDataCategory")
	private Set<RuleAssignedSubject> ruleAssignedSubjectSet;
	
}
