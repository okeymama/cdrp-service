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
@Table(name="business_rule")
@EqualsAndHashCode(of = { "businessRuleId","subjectDescription","form","isExpected","frequency" })
public class BusinessRule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="business_rule_id")
	private Long businessRuleId;
	
	@Column(name="subject_description")
	private String subjectDescription;
	
	@Column(name="form")
	private String form;
	
	@Column(name="is_expected")
	private boolean isExpected;
	
	@Column(name="frequency")
	private String frequency;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="creation_date")
	private LocalDate creationDate;
	
	@Column(name="last_updated_date")
	private LocalDate lastUpdatedDate;	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "businessRule")
	private Set<BusinessRuleCondition> businessRuleConditionSet;	
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = ExpectedDataCategory.class)
    @JoinColumn(name = "expected_data_category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private ExpectedDataCategory expectedDataCategory;

}
