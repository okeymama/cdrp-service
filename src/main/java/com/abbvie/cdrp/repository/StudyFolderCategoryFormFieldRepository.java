/**
 * 
 */
package com.abbvie.cdrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abbvie.cdrp.entity.StudyFolderCategoryFormField;
import com.abbvie.cdrp.entity.StudyFolderCategoryFormFieldId;

/**
 * @author cchaubey
 *
 */
@Repository
public interface  StudyFolderCategoryFormFieldRepository extends JpaRepository<StudyFolderCategoryFormField, StudyFolderCategoryFormFieldId>{

}
