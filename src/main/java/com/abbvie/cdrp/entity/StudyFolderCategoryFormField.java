/**
 * 
 */
package com.abbvie.cdrp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author cchaubey
 *
 */
@Data
@Entity
@Table(name="study_folder_category_form_field")
public class StudyFolderCategoryFormField implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StudyFolderCategoryFormFieldId id;
	
	@Column(name = "folder_ordinal")
	private String folderOrdinal;
	
	@Column(name = "folder_name")
	private String folderName;
	
	@Column(name = "folder_reusable_flag")
	private String folderReusableFlag;
	
	@Column(name = "folder_is_draft_flag")
	private String folderIsDraftFlag;
	
	@Column(name = "form_ordinal")
	private String formOrdinal;
	
	@Column(name = "form_name")
	private String formName;
	
	@Column(name = "form_is_signature_required_flag")
	private String formIsSignatureRequiredFlag;
	
	@Column(name = "form_is_draft_flag")
	private String formIsDraftFlag;
	
	@Column(name = "field_ordinal")
	private String fieldOrdinal;
	
	@Column(name = "field_name")
	private String fieldName;
	
	@Column(name = "field_is_visible_flag")
	private String fieldIsVisibleFlag;
	
	@Column(name = "field_is_required_flag")
	private String fieldIsRequiredFlag;
	
	@Column(name = "field_has_clinical_significance_flag")
	private String fieldHasClinicalSignificanceFlag;
	
	@Column(name = "field_is_draft_flag")
	private String fieldIsDraftFlag;

}
