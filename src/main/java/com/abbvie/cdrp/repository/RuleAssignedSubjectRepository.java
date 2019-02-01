package com.abbvie.cdrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abbvie.cdrp.entity.RuleAssignedSubject;

@Repository
public interface RuleAssignedSubjectRepository extends JpaRepository<RuleAssignedSubject , Long> {

}
