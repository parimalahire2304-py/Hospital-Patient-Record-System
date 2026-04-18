package com.hospital.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.entity.Patient;
import com.hospital.entity.Prescription;
import com.hospital.repository.PatientRepository;
import com.hospital.service.PrescriptionService;






@Controller
public class PrescriptionContoller {
	@Autowired
	private PrescriptionService pressave;
	@Autowired
	private PatientRepository patientRepo;
	
	@GetMapping("/prescription")
	public String openPresciption(Model model) {
		model.addAttribute("prescription", new Prescription());
		return "prescription";
	}
	@PostMapping("/PrescriptionForm")
	public String savePrescription(@RequestParam int patientId,@ModelAttribute("prescription") Prescription pres ,Model model ) {
		Patient patient = patientRepo.findById(patientId).orElse(null);

        if (patient == null) {
            model.addAttribute("errorMsg", "Patient not found!");
            return "prescription";
        }

        pres.setPatient(patient);
	

		boolean status=pressave.savePrescription(pres);
		if (status) {
			model.addAttribute("Success", "Prescription Has Save Sucessfully!!");
		}
		else {
			model.addAttribute("errorMsg", "Failed To Save Prescription");
		}
		return "redirect:/prescription";
	
	
		
		
	}
	

}
