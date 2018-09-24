/**
 * 
 */
package edu.mum.cs.cs544.ocr.controller;


import edu.mum.cs.cs544.ocr.domain.Authority;
import edu.mum.cs.cs544.ocr.domain.Patient;
import edu.mum.cs.cs544.ocr.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivian Samson
 *
 */

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	PatientService patientService;

//	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPatient(@ModelAttribute("patient") Patient patient, Model model) {
		model.addAttribute("patient",patient);
		return "patients/patient-registration";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveDoctor(@ModelAttribute("patient") @Valid Patient patient, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getAllErrors());
			return "patient/patient-registration";
		}

		Authority authority = new Authority();

		

		patient.getCredentials().setEnabled(true);

		authority.setUsername(patient.getCredentials().getUsername());
		authority.setAuthority("ROLE_USER");

		List<Authority> list = new ArrayList<>();
		list.add(authority);
		patient.getCredentials().setAuthority(list);

		long patientId = patientService.save(patient);
		System.out.println("Saved Patient with id: " + patientId + " and userName is: "
				+ patient.getCredentials().getUsername() + "and password is:" + patient.getCredentials().getPassword());

		redirectAttributes.addFlashAttribute("patient", patient);
		return "redirect:details";
	}

	@RequestMapping(value = "/details")
	public String showPatientDetails() {
		return "patient/patient_details";
	}
}
