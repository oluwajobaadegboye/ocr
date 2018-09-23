/**
 * 
 */
package edu.mum.cs.cs425.ocr.service.impl;


import edu.mum.cs.cs425.ocr.domain.Patient;
import edu.mum.cs.cs425.ocr.repository.PatientRepository;
import edu.mum.cs.cs425.ocr.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivian Samson
 *
 */
@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;
	
//	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public long save(Patient patient) {

		String encodedPassword = passwordEncoder.encode(patient.getCredentials().getPassword());
		patient.getCredentials().setPassword(encodedPassword);
		patient.getCredentials().setVerifyPassword(encodedPassword);
		return patientRepository.save(patient).getId();
		
	}

	@Override
	public List<Patient> findAll() {
		List<Patient> patientsList = new ArrayList<>();
		patientRepository.findAll().forEach( ( Patient p ) -> patientsList.add(p) );
		return patientsList;
	}

	@Override
	public Patient findPatientById(Long patientId) {
		return patientRepository.findById(patientId).orElse(null);
	}
	
	@Override
	public Patient getPatientByUserName(String username) {
		
		return patientRepository.getPatientByUsername(username);
	}
	@Override
	public Patient getPatienByEmail(String email) {
		
		return patientRepository.findByEmailId(email);
	}

}
