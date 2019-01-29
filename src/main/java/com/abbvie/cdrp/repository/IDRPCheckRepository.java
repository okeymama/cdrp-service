package com.abbvie.cdrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abbvie.cdrp.entity.IDRPCheck;

@Repository
public interface IDRPCheckRepository extends JpaRepository<IDRPCheck, Long>{

}


