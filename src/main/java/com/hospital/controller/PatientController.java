package com.hospital.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hospital.entity.Doctor;
import com.hospital.entity.Patient;
import com.hospital.entity.Prescription;
import com.hospital.service.PatientService;
import com.hospital.service.PrescriptionService;

@Controller
public class PatientController {
	@Autowired
	private PrescriptionService prescriptionService;

    @Autowired
    private PatientService patientServ;

    @GetMapping("/regPage")
    public String openRegPage(Model model) {
        model.addAttribute("patient", new Patient());
        return "register";
    }

    @PostMapping("/regForm")
    public String submitRegform(@ModelAttribute("patient") Patient patient, Model model) {

        boolean status = patientServ.registerpatient(patient);

        if (status) {
            return "redirect:/patients";
        } else {
            model.addAttribute("errorMsg", "Failed to register patient");
            return "register";
        }
    }

    @GetMapping("/patients")
    public String getAllPatients(Model model) {
        model.addAttribute("patients", patientServ.getAllPatients());
        return "patients";
    }

    @GetMapping("/edit/{id}")
    public String editPatient(@PathVariable Integer id, Model model) {

        Patient patient = patientServ.getPatientById(id);
        model.addAttribute("patient", patient);

        return "updatePatient";
        
    }
    @PostMapping("/updatePatient")
    public String updatePatient(@ModelAttribute("patient") Patient patient, Model model) {

        boolean status = patientServ.updatePatient(patient);

        if (status) {
            return "redirect:/patients";   // ✅ redirect to listing
        } else {
            model.addAttribute("errorMsg", "Failed to update patient");
            return "updatePatient";
        }
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable Integer id) {
        try {
            patientServ.deletePatient(id);
        } catch (Exception e) {
            System.out.println("Cannot delete patient (FK constraint)");
        }
        return "redirect:/patients";
    }
    @GetMapping("/history/{id}")
    public String patientHistory(@PathVariable Integer id, Model model) {

        Patient patient = patientServ.getPatientById(id);

        List<Prescription> prescriptions =
            prescriptionService.getPrescriptionByPatientId(id);

        model.addAttribute("patient", patient);
        model.addAttribute("prescriptions", prescriptions);
        model.addAttribute("doctor", new Doctor()); 
        return "history";
    }
    @GetMapping("/history")
    public String patientHistoryByParam(@RequestParam(required = false) Integer id, Model model) {

        if (id == null) {
            return "history";
        }

        Patient patient = patientServ.getPatientById(id);

        if (patient == null) {
            model.addAttribute("errorMsg", "Patient not found");
            return "history";
        }

        List<Prescription> prescriptions =
                prescriptionService.getPrescriptionByPatientId(id);

        model.addAttribute("patient", patient);
        model.addAttribute("prescriptions", prescriptions);

        return "history";
    }
    @GetMapping("/historyPage")
    public String openHistoryPage() {
        return "history";
    }
}
