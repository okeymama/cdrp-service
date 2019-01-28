/**
 * 
 */
package com.abbvie.cdrp.entity;

import java.io.Serializable;

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
@Table(name="applied_visit")
@EqualsAndHashCode(of = { "appliedVisitId" })
public class AppliedVisit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="applied_visit_id")
	private Long appliedVisitId; 
	
	@Column(name="visit_id")
	private Long visitId;
	
	@Column(name="visit_name")
	private String visitName;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = ExpectedDataCategory.class)
    @JoinColumn(name = "expected_data_category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private ExpectedDataCategory expectedDataCategory;
	
}
