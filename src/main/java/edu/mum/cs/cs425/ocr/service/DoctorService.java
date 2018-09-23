package edu.mum.cs.cs425.ocr.service;



import edu.mum.cs.cs425.ocr.domain.Doctor;

import java.util.List;

public interface DoctorService {
	long save(Doctor doctor);
	List<Doctor> findAll();
	List<Doctor> findByCategory(int categoryId);
	Doctor findById(long id);
}
