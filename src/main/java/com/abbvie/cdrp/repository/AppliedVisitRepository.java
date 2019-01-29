package com.abbvie.cdrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abbvie.cdrp.entity.AppliedVisit;

@Repository
public interface AppliedVisitRepository extends JpaRepository<AppliedVisit, Long> {

}
