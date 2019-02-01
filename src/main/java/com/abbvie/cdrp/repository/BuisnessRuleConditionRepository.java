package com.abbvie.cdrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abbvie.cdrp.entity.BusinessRuleCondition;

@Repository
public interface BuisnessRuleConditionRepository extends JpaRepository<BusinessRuleCondition, Long> {

}
