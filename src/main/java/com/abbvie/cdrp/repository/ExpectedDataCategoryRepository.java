package com.abbvie.cdrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abbvie.cdrp.entity.ExpectedDataCategory;

@Repository
public interface ExpectedDataCategoryRepository extends JpaRepository<ExpectedDataCategory, Long>{

	
}
