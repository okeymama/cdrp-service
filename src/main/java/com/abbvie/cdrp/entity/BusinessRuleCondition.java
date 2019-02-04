/**
 * 
 */
package com.abbvie.cdrp.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name="business_rule_condition")
@EqualsAndHashCode(of = { "businessRuleConditionId","visit","form","field","fieldValue" })
public class BusinessRuleCondition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="business_rule_condition_id")
	private Long businessRuleConditionId;	
	
	@Column(name="visit")
	private String visit;
	
	@Column(name="form")
	private String form;
	
	@Column(name="field")
	private String field;
	
	@Column(name="field_value")
	private String fieldValue;
	
	@Column(name="type")
	private String type;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_date")
	private LocalDate createdDate;
	
	@Column(name="last_updated_date")
	private LocalDate lastUpdatedDate;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = BusinessRule.class)
    @JoinColumn(name = "business_rule_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private BusinessRule businessRule;
	 
}
