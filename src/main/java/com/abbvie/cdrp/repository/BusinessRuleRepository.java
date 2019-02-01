package com.abbvie.cdrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abbvie.cdrp.entity.BusinessRule;

public interface BusinessRuleRepository  extends JpaRepository<BusinessRule, Long> {

}
