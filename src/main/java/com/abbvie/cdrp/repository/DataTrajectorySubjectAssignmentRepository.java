package com.abbvie.cdrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abbvie.cdrp.entity.DataTrajectorySubjectAssignment;

@Repository
public interface DataTrajectorySubjectAssignmentRepository extends JpaRepository<DataTrajectorySubjectAssignment, Long>{

}
