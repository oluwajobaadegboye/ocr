package edu.mum.cs.cs425.ocr.service.impl;


import edu.mum.cs.cs425.ocr.domain.Doctor;
import edu.mum.cs.cs425.ocr.repository.DoctorRepository;
import edu.mum.cs.cs425.ocr.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Service implementation for Doctor class
 * @author Cong Khanh Tran - trancongkhanh@gmail.com
 *
 *
 */
@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepository doctorRepository;
	
	@Override
	public long save(Doctor doctor) {
		return doctorRepository.save(doctor).getId();
	}

	@Override
	public List<Doctor> findAll() {
		List<Doctor> list = new ArrayList<>();
		doctorRepository.findAll().forEach((Doctor d) -> list.add(d));
		return list;
	}

	@Override
	public List<Doctor> findByCategory(int categoryId) {
		return doctorRepository.findByCategoryId(categoryId);
	}

	@Override
	public Doctor findById(long id) {
		return doctorRepository.findById(id).orElse(null);
	}

}
