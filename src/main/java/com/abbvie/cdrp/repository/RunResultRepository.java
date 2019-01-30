package com.abbvie.cdrp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abbvie.cdrp.entity.RunResult;

@Repository
public interface RunResultRepository extends JpaRepository<RunResult, String>{

	List<RunResult> findAllByStudyIdIn(List<String> runResultStudyIds);

}
