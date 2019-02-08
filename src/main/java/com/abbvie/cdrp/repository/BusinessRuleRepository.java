package com.abbvie.cdrp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abbvie.cdrp.entity.BusinessRule;

public interface BusinessRuleRepository  extends JpaRepository<BusinessRule, Long> {

	@Query("Select businessRuleId FROM BusinessRule where expectedDataCategory.expectedDataCategoryId in :ids") 
    List<Long> getByExpectedDataCategoryId(@Param("ids") List<Long> ids);
	
}
