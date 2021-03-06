package edu.mum.cs.cs544.ocr.repository;


import edu.mum.cs.cs544.ocr.domain.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

	@Query("SELECT p FROM Patient p WHERE p.id = :patientId")
	Optional<Patient> findById(@Param("patientId") Long patientId);
	
	@Query("SELECT p FROM Patient p WHERE p.credentials.username = :username")
	Patient getPatientByUsername(@Param("username") String username);
	
	@Query("SELECT p FROM Patient p WHERE p.emailAddress = :email")
	Patient findByEmailId(@Param("email") String email);
}
