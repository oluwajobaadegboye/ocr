/**
 * 
 */
package edu.mum.cs.cs425.ocr.repository;


import edu.mum.cs.cs425.ocr.domain.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Cong Khanh Tran - trancongkhanh@gmail.com
 *
 * 
 */
@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

	@Query("SELECT d FROM Doctor d WHERE doctorCategory.id = :categoryId")
    List<Doctor> findByCategoryId(@Param("categoryId") int categoryId);
	
}
