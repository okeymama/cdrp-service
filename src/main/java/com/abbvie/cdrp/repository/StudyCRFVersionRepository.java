/**
 * 
 */
package com.abbvie.cdrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abbvie.cdrp.entity.StudyCRFVersion;
import com.abbvie.cdrp.entity.StudyCRFVersionId;

/**
 * @author cchaubey
 *
 */
@Repository
public interface StudyCRFVersionRepository extends JpaRepository<StudyCRFVersion, StudyCRFVersionId> {

}
	