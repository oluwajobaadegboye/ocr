package edu.mum.cs.cs544.ocr.service;



import edu.mum.cs.cs544.ocr.domain.Appointment;

import java.sql.Date;
import java.util.List;

public interface AppointmentService {

	List<Appointment> findAll();

	List<Appointment> findByDoctorId(long doctorId);

	List<Appointment> findByDoctorIdAndDate(Long id, Date date);

	Appointment save(Appointment appointment);

}
