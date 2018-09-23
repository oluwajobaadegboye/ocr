package edu.mum.cs.cs425.ocr.service;




import edu.mum.cs.cs425.ocr.domain.Patient;

import java.util.List;

public interface PatientService {
	long save(Patient patient);
	List<Patient> findAll();
	Patient findPatientById(Long patientId);
	Patient getPatientByUserName(String username);
	Patient getPatienByEmail(String email);
}
