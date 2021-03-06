package edu.mum.cs.cs544.ocr.controller;


import edu.mum.cs.cs544.ocr.domain.Category;
import edu.mum.cs.cs544.ocr.domain.Doctor;
import edu.mum.cs.cs544.ocr.domain.Timespan;
import edu.mum.cs.cs544.ocr.service.CategoryService;
import edu.mum.cs.cs544.ocr.service.DoctorService;
import edu.mum.cs.cs544.ocr.service.TimespanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Oluwajoba Adegboye
 */
@Controller
@RequestMapping("/admin/doctors")
public class AdminDoctorController {
	@Autowired
	private TimespanService timespanService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private DoctorService doctorService;
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryService.findAll();
	}
	
	@ModelAttribute("timespans")
	public List<Timespan> getTimespans() {
		return timespanService.findAll();
	}

	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listDoctors(Model model) {
		List<Doctor> doctorList = doctorService.findAll();
		model.addAttribute("doctors", doctorList);
		return "admin/doctor_list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addDoctor(@ModelAttribute("doctor") Doctor doctor, Model model) {
//		doctor.setAvailableTimespans((List<Timespan>)model.asMap().get("timespans"));
		return "admin/add_doctor";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveDoctor(@ModelAttribute("doctor") @Valid Doctor doctor, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {
		
		if (bindingResult.hasErrors()) {
			return "admin/add_doctor";
		}
		long doctorId = doctorService.save(doctor);
		MultipartFile doctorPicture = doctor.getPicture();
		if (doctorPicture != null && !doctorPicture.isEmpty()) {
			savePicture(doctorId, doctorPicture);
		}
//		Process file upload
		redirectAttributes.addFlashAttribute("doctor", doctor);
		return "redirect:details";
	}

	private void savePicture(long id, MultipartFile doctorPicture) throws IOException {
		String rootDirectory = servletContext.getRealPath("/");
		File outputfile = new File(rootDirectory + "\\data\\doctor_" + id + ".png");
		BufferedImage bufferedImage = ImageIO.read(doctorPicture.getInputStream());
		if (bufferedImage != null) {
			ImageIO.write(bufferedImage, "PNG", outputfile);
		}
	}
	
	@RequestMapping(value = "/details")
	public String showDoctorDetails() {
		return "admin/doctor_details";
	}
}
