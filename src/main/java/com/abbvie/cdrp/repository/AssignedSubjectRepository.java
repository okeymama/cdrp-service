package com.abbvie.cdrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abbvie.cdrp.entity.AssignedSubject;


@Repository
public interface AssignedSubjectRepository extends JpaRepository<AssignedSubject, Long>{

}
