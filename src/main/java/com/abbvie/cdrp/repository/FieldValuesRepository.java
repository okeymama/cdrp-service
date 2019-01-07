/**
 * 
 */
package com.abbvie.cdrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abbvie.cdrp.entity.FieldValues;
import com.abbvie.cdrp.entity.FieldValuesId;

/**
 * @author cchaubey
 *
 */
@Repository
public interface FieldValuesRepository extends JpaRepository<FieldValues, FieldValuesId> {

}
