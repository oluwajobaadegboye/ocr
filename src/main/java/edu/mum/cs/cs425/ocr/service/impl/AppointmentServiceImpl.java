package edu.mum.cs.cs425.ocr.service.impl;


import edu.mum.cs.cs425.ocr.domain.Appointment;
import edu.mum.cs.cs425.ocr.repository.AppointmentRepository;
import edu.mum.cs.cs425.ocr.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author Cong Khanh Tran - trancongkhanh@gmail.com
 *
 *
 */
@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public List<Appointment> findAll() {
		List<Appointment> list = new ArrayList<>();
		appointmentRepository.findAll().forEach((Appointment a) -> list.add(a));
		return list;
	}

	@Override
	public List<Appointment> findByDoctorId(long doctorId) {
		List<Appointment> all = findAll();
		return all.stream().filter((Appointment a) -> a.getDoctor().getId() == doctorId).collect(Collectors.toList());
	}

	@Override
	public List<Appointment> findByDoctorIdAndDate(Long doctorId, Date date) {
		return appointmentRepository.findByDoctorIdAndDate(doctorId, date);
	}

	@Override
	public Appointment save(Appointment appointment) {
		return appointmentRepository.save(appointment);
		
	}

}
