package com.abbvie.cdrp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.abbvie.cdrp.entity.DataTrajectorySubjectAssignment;

@Repository
public interface DataTrajectorySubjectAssignmentRepository extends JpaRepository<DataTrajectorySubjectAssignment, Long>{
	@Query("Select dataTrajectorySubjectAssignmentId FROM DataTrajectorySubjectAssignment where dataTrajectory.dataTrajectoryId in :ids") 
    List<Long> getByTrajectoryId(@Param("ids") List<Long> ids);
	
	
	
}
