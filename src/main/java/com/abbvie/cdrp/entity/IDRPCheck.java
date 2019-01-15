/**
 * 
 */
package com.abbvie.cdrp.entity;

import java.util.Set;

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

/**
 * @author cchaubey
 *
 */
@Data
@Entity
@Table(name="idrp_check")
public class IDRPCheck {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idrp_check_id")
	private Long idrpCheckId;
	
	@Column(name="purpose")
	private String purpose;
	
	@Column(name="description")
	private String description;	
	
	@Column(name="visit")
	private Long visit;	
	
	@Column(name="role")
	private String role;
	
	@Column(name="method")
	private String method;
	
	@Column(name="frequency")
	private String frequency;	
	
	@Column(name="owner")
	private String owner;	
	
	@Column(name="check_name")
	private String checkName;
	
	@Column(name="query_text")
	private String queryText;	
	
	@Column(name="source")
	private String source;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = ExpeactedDataCategory.class)
    @JoinColumn(name = "expected_data_category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private ExpeactedDataCategory expeactedDataCategory;
	
}
