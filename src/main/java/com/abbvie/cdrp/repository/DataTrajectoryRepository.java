package com.abbvie.cdrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abbvie.cdrp.entity.DataTrajectory;
import com.abbvie.cdrp.entity.IDRPPlanDetail;

@Repository
public interface DataTrajectoryRepository extends JpaRepository<DataTrajectory, Long>{

}
