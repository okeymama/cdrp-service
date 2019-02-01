/**
 * 
 */
package com.abbvie.cdrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abbvie.cdrp.entity.IDRPPlanDetail;

/**
 * @author cchaubey
 *
 */
@Repository
public interface IDRPPlanDetailRepository extends JpaRepository<IDRPPlanDetail, Long> {
	
	IDRPPlanDetail findByStudyId(String studyId);
}
